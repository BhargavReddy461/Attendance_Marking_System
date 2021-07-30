package com.cognizant.attendanceMarking.auth.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.model.Notifications;
import com.cognizant.attendanceMarking.auth.model.Search;
import com.cognizant.attendanceMarking.auth.model.Session;
import com.cognizant.attendanceMarking.auth.model.SessionEnrolled;
import com.cognizant.attendanceMarking.auth.model.SessionUser;
import com.cognizant.attendanceMarking.auth.model.User;
import com.cognizant.attendanceMarking.auth.service.NotificationsService;
import com.cognizant.attendanceMarking.auth.service.SessionService;
import com.cognizant.attendanceMarking.auth.service.SessionUserService;
import com.cognizant.attendanceMarking.auth.service.SessionsEnrolledService;
import com.cognizant.attendanceMarking.auth.service.UserService;
import com.cognizant.attendanceMarking.auth.validator.UserValidator;

@Controller
public class UserController {
	static SessionUser sessionUser;
	static Notifications notification;
	static SessionEnrolled sessionEnrolled;
	static int count=0;
	static String username = new String();
	@Autowired
	private UserService userService;

	@Autowired
	private SessionService sessionService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private SessionUserService sessionUserService;
	@Autowired
	private NotificationsService notificationsService;

	@Autowired
	private SessionsEnrolledService sessionsEnrolledService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@GetMapping("/")
	public String viewHomePage() {
		return "home";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		return "registration_success";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping("/welcome")
	public String welcome(@ModelAttribute("search") Search search, BindingResult res, Model model) {

		User user = getCurrentUser();
		username = user.getEmail();
		notification = new Notifications();
		sessionEnrolled = new SessionEnrolled();
		System.out.println(userService.findByEmail(username).getId() + " uid" + sessionEnrolled);
		List<SessionEnrolled> sessionsEnrolled = sessionsEnrolledService
				.getByUserId(userService.findByEmail(username).getId());
		// List<Session> sessions=sessionService.findAllSessionsTime();
		System.out.println(sessionsEnrolled);
		if(count==0) {
		for (SessionEnrolled session : sessionsEnrolled) {
			System.out.println("timer check "+sessionService.sessionTime(session.getSessionId())+" "+session.getSessionDesc());
			if (sessionService.sessionTime(session.getSessionId()) == -2
					&& session.getApprovalStatus().equals("active")) {
				notification.setUserId(session.getUserId());
				notification.setSessionId(session.getSessionId());
				notification.setSessionDesc(session.getSessionDesc() + " is in 2 days");
				notification.setStatus("active");
				notificationsService.create(notification);
				count++;
			}
		}
		}
		return "welcome";
	}

	@GetMapping("/viewsessiondetails")
	public String viewSessionDetails(@ModelAttribute("search") Search search, Model model) {
		List<Session> sessions = sessionService.getAll();
		model.addAttribute("sessionlist", sessions);
		return "usersessionslist";
	}

	@GetMapping("/displaysessiondetails")
	public String viewSessionDetailsWithId(@RequestParam int sessionId, Model model) {
		Session sessions = sessionService.findSessionDetails(sessionId);
		model.addAttribute("session", sessions);
		return "sessiondetails";
	}

	@PostMapping("/viewsessiondetails")
	public String viewSessionBasedOnIdPost(@Valid @ModelAttribute("search") Search search, BindingResult res,
			Model model) {
		if (res.hasErrors()) {
			System.out.println("res");
			return "usersessionslist";
		}
		List<Session> skillSessions = new ArrayList<>();
		if (search.getOption().equals("SessionId")) {
			Session session = null;
			try {
				session = sessionService.findSessionDetails(Integer.parseInt(search.getId()));
			} catch (Exception e) {

				model.addAttribute("message", "It should be a number");

			}
			if (session == null) {
				List<Session> sessions = sessionService.getAll();
				model.addAttribute("message", "No sessions with session Id '" + search.getId() + "' found");
				model.addAttribute("sessionlist", sessions);
				return "usersessionslist";
			} else {
				skillSessions.add(session);
				model.addAttribute("searchedsessionlist", skillSessions);
				model.addAttribute("sessionlist", skillSessions);
				return "usersessionslist";
			}
		} else if (search.getOption().equals("SkillId")) {
			// sessions = sessionService.getAllBySkillId(search.getId());
			skillSessions = sessionService.getAllBySkill(search.getId());
			if (skillSessions.isEmpty() || skillSessions == null) {
				List<Session> sessions = sessionService.getAll();
				model.addAttribute("sessionlist", sessions);
				model.addAttribute("message", "No sessions with skill Id '" + search.getId() + "' found");
				return "usersessionslist";
			}
			model.addAttribute("sessionlist", skillSessions);
			return "usersessionslist";
		}
		System.out.println(skillSessions + " list");

		List<Session> sessions = sessionService.getAll();

		model.addAttribute("sessionlist", sessions);
		return "usersessionslist";
	}


	@PostMapping("/welcome")
	public String postuserHomePage(@Valid @ModelAttribute("search") Search search, BindingResult res, Model model) {
		System.out.println(res + "  l");
		if (res.hasErrors()) {
			System.out.println("res");
			return "welcome";
		}
		List<Session> sessions = new ArrayList<>();
		if (search.getOption().equals("sessionId")) {
			Session session = sessionService.findSessionDetails(Integer.parseInt(search.getId()));
			if (session == null) {
				model.addAttribute("message", "No sessions with session Id " + search.getId() + " found");
				return "welcome";
			} else {
				sessions.add(session);
				model.addAttribute("sessionlist", sessions);

			}
		} else if (search.getOption().equals("skillId")) {
			//sessions = sessionService.getAllBySkillId(search.getId());
			sessions = sessionService.getAllBySkill(search.getId());
			
			if (sessions == null) {
				model.addAttribute("message", "No sessions with skill Id " + search.getId() + " found");
			}
		}
		System.out.println(sessions + " list");
		model.addAttribute("one", "session Id");
		model.addAttribute("two", "session Description");
		model.addAttribute("three", "Skill set");
		model.addAttribute("four", "session time");
		model.addAttribute("five", "session date");
		model.addAttribute("six", "Available slots");
		model.addAttribute("sessionlist", sessions);
		return "welcome";
	}

	@GetMapping("/enroll")
	public String enroll(@RequestParam int sessionId, Model model) {
		sessionUser = new SessionUser();
		notification = new Notifications();
		sessionEnrolled = new SessionEnrolled();
		Session sessions = sessionService.findSessionDetails(sessionId);
		sessions.setAvailableSlots(sessions.getAvailableSlots()-1);
		sessionService.updateUser(sessions);
		sessionUser.setSessionId(sessionId);
		User user1 = getCurrentUser();
		sessionUser.setUserId((int) user1.getId());
		if (sessionUserService.searchIfEnrolled((int) user1.getId(), sessionId) == null) {
			SessionUser user = sessionUserService.create(sessionUser);
			Session session = sessionService.findSessionDetails(user.getSessionId());
			notification.setUserId(user.getUserId());
			notification.setSessionId(user.getSessionId());
			notification.setSessionDesc(session.getSessionDesc());
			notification.setStatus("pending");
			notificationsService.create(notification);
			sessionEnrolled.setSessionId(user.getSessionId());
			sessionEnrolled.setApprovalStatus("pending");
			sessionEnrolled.setFeedback("Yet to be submitted");
			sessionEnrolled.setAttendance("No");
			sessionEnrolled.setUserId((int)user1.getId());
			sessionEnrolled.setRemainder("false");
			sessionEnrolled.setSessionDesc(sessionService.findSessionDetails(sessionId).getSessionDesc());
			sessionsEnrolledService.create(sessionEnrolled);
			model.addAttribute("message", "Successfully enrolled for this session.");
		} else {
			model.addAttribute("alreadymessage", "You are already enrolled to this session");
		}
		model.addAttribute("session", sessions);
		return "sessiondetails";
	}


	@GetMapping("/usernotification")
	public String getUserNotifications(Model model) {
		User user = getCurrentUser();
		List<Notifications> notifs = notificationsService.getByUserId(user.getId());
		System.out.println(notifs + " check notifs");
		if (notifs == null || notifs.isEmpty() || notifs.size() == 0) {
			model.addAttribute("message", "No notifications");
		}
		model.addAttribute("notifs", notifs);
		return "notifications";
	}

	@GetMapping("/deletenotifs")
	public String deleteNotifications(@RequestParam int id, Model model) {
		notification = notificationsService.getById(id);
		notificationsService.deleteById(notification.getId());
		List<Notifications> notifs = notificationsService.getByUserId(notification.getUserId());
		model.addAttribute("notifs", notifs);
		return "notifications";
	}

	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null) {
			username = ((UserDetails) principal).getUsername();
		}
		User user = userService.findByEmail(username);
		return user;
	}

	@GetMapping("/resetuserpassword")
	public String resetPassword(@ModelAttribute("resetPassword") User resetPassword) {

		return "resetuserpassword";
	}

	@PostMapping("/resetuserpassword")
	public String resetingPassword(@ModelAttribute("resetPassword") User resetPassword, BindingResult bindingResult,
			Model model) {

		if (userService.findUser(resetPassword) == null) {

			model.addAttribute("invalidmessage", "Invalid Details");

			return "resetuserpassword";
		}

		return "redirect:passwordresetuser?email=" + resetPassword.getEmail();
	}

	@GetMapping("/passwordresetuser")
	public String resetuserPassword(@RequestParam String email, @ModelAttribute("passwordForm") User passwordForm) {
		System.out.println("email " + email);
		return "updateuserpassword";
	}

	@PostMapping("/passwordresetuser")
	public String resetuserPassword(@ModelAttribute("passwordForm") User passwordForm, Model model) {

		if (userService.updateUser(passwordForm) != null) {
			model.addAttribute("message", "Your password was reset successfully");
			model.addAttribute("loginlink", "Login Here");
		}

		else {
			model.addAttribute("invalidmessage", "Password didn't match");

		}
		return "updateuserpassword";

	}

	@GetMapping("/viewsessionreportsuser")
	public String userEnrolledSessions(Model model) {
		User currentUser = getCurrentUser();
		List<SessionEnrolled> usersessionlist = sessionsEnrolledService.getByUser(currentUser.getId());

		model.addAttribute("usersessionlist", usersessionlist);
		return "userenrolledlist";
	}

	@GetMapping("/forgotuserusername")
	public String forgotUserUsername(@ModelAttribute("forgotUserUsername") User forgotUserUsername) {

		return "forgotuserusername";
	}

	@PostMapping("/forgotuserusername")
	public String forgotAdminUserName(@ModelAttribute("forgotUserUsername") User forgotUserUsername,
			BindingResult bindingResult, Model model) {
		User user = userService.forgotUsername(forgotUserUsername);

		if (userService.forgotUsername(forgotUserUsername) == null) {

			model.addAttribute("invalidmessage", "Invalid Details");

		}

		else {
			model.addAttribute("message", "Your user name is **" + user.getEmail()+"**");
		}

		return "forgotuserusername";
	}

	@GetMapping("/viewenrolledsessions")
	public String viewEnrolledSessions(Model model) {
		User user = getCurrentUser();
		List<SessionEnrolled> sessions = sessionsEnrolledService
				.getByUserId(userService.findByEmail(user.getEmail()).getId());
		model.addAttribute("sessions", sessions);
		return "viewenrolledsessionsuser";
	}

	@GetMapping("/markattendance")
	public String markattendance(@RequestParam int id, @ModelAttribute("addfeedback") SessionEnrolled addfeedback,
			BindingResult bindingResult, Model model) {
		SessionEnrolled sessionenrolled = sessionsEnrolledService.getById(id);
		if (sessionenrolled.getAttendance().equals("Yes")) {
			
			model.addAttribute("yesmessage","You are already marked attendance for this session.");
			User user = getCurrentUser();
			List<SessionEnrolled> sessions = sessionsEnrolledService
					.getByUserId(userService.findByEmail(user.getEmail()).getId());
			model.addAttribute("sessions", sessions);

			return "viewenrolledsessionsuser";

		} else {

			if (sessionService.sessionTime(sessionenrolled.getSessionId()) == 0&&sessionenrolled.getApprovalStatus().equals("active")) {

				sessionenrolled.setAttendance("Yes");
				sessionsEnrolledService.updateAttendance(sessionenrolled);

				model.addAttribute("session", sessionService.findSessionDetails(sessionenrolled.getSessionId()));

				return "attendancefeedbackform";
			}

			else {
				
				model.addAttribute("nomessage","You can't mark attendance for this session today.");
				User user = getCurrentUser();
				List<SessionEnrolled> sessions = sessionsEnrolledService
						.getByUserId(userService.findByEmail(user.getEmail()).getId());
				model.addAttribute("sessions", sessions);

				return "viewenrolledsessionsuser";
			}
		}

	}

	@PostMapping("/markattendance")
	public String markattendanceuser(@ModelAttribute("addfeedback") SessionEnrolled addfeedback,
			BindingResult bindingResult) {
		SessionEnrolled sessionenrolled = sessionsEnrolledService.getById(addfeedback.getId());
		sessionenrolled.setFeedback(addfeedback.getFeedback());
		sessionsEnrolledService.updateAttendance(sessionenrolled);
		return "redirect:viewenrolledsessions";
	}
}
