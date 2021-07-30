package com.cognizant.attendanceMarking.auth.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.model.Notifications;
import com.cognizant.attendanceMarking.auth.model.Search;
import com.cognizant.attendanceMarking.auth.model.Session;
import com.cognizant.attendanceMarking.auth.model.SessionEnrolled;
import com.cognizant.attendanceMarking.auth.model.SessionUser;
import com.cognizant.attendanceMarking.auth.model.Skill;
import com.cognizant.attendanceMarking.auth.model.SkillSession;
import com.cognizant.attendanceMarking.auth.model.Trainer;
import com.cognizant.attendanceMarking.auth.model.User;
import com.cognizant.attendanceMarking.auth.repository.SessionRepository;
import com.cognizant.attendanceMarking.auth.repository.TrainerRepository;
import com.cognizant.attendanceMarking.auth.service.AdminService;
import com.cognizant.attendanceMarking.auth.service.NotificationsService;
import com.cognizant.attendanceMarking.auth.service.SessionService;
import com.cognizant.attendanceMarking.auth.service.SessionsEnrolledService;
import com.cognizant.attendanceMarking.auth.service.SkillService;
import com.cognizant.attendanceMarking.auth.service.SkillSessionService;
import com.cognizant.attendanceMarking.auth.service.TrainerService;
import com.cognizant.attendanceMarking.auth.validator.AdminValidator;

@Controller
public class AdminController {

	static SessionUser sessionUser;
	static Notifications notification;
	static SessionEnrolled sessionEnrolled;
	static Admin admin;
	@Autowired
	private AdminService adminService;

	@Autowired
	private SessionService sessionService;

	@Autowired
	private TrainerService trainerService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private SkillSessionService skillSessionService;

	@Autowired
	private SessionsEnrolledService sessionsEnrolledService;

	@Autowired
	private AdminValidator adminValidator;

	@Autowired
	private NotificationsService notificationsService;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private TrainerRepository trainerRepository;

	@GetMapping("/admin_registration")
	public String registration(Model model) {
		model.addAttribute("adminForm", new Admin());

		return "admin_registration";
	}

	@PostMapping("/admin_registration")
	public String registration(@ModelAttribute("adminForm") Admin adminForm, BindingResult bindingResult) {
		adminValidator.validate(adminForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "admin_registration";
		}

		adminForm.setStatus("pending");

		adminService.save(adminForm);

		return "admin_registration_success";
	}

	@GetMapping("/admin_login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "admin_login";
	}

	@GetMapping("/admin_welcome")
	public String welcome(Model model) {

		return "admin_welcome";
	}

	@GetMapping("/addtrainerdetails")
	public String addTrainerDetails(@ModelAttribute("trainer") Trainer trainer) {
		return "trainer";
	}

	@PostMapping("/addtrainerdetails")
	public String postTrainerDetails(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult res,
			Model model) {
		if (res.hasErrors()) {
			return "trainer";
		}
		trainer.setIsDeleted("false");
		trainerService.create(trainer);
		model.addAttribute("message", "Added trainer details successfully");
		return "trainer";

	}

	@GetMapping("/addsessiondetails")
	public String addSessionDetails(@ModelAttribute("session") Session session) {
		return "session";
	}

	@PostMapping("/addsessiondetails")
	public String postSessionDetails(@Valid @ModelAttribute("session") Session session, BindingResult res,
			Model model) {
		if (res.hasErrors()) {
			return "session";
		}
		session.setIsDeleted("false");
		sessionService.create(session);
		model.addAttribute("message", "Added session details succesfully");
		return "session";
	}

	@PostMapping("/addskills")
	public String postSkillDetails(@Valid @ModelAttribute("skill") Skill skill, BindingResult res, Model model) {
		if (res.hasErrors()) {
			return "skill";
		}
		skillService.create(skill);
		model.addAttribute("message", "Added skills succesfully");
		return "skill";
	}

	@GetMapping("/addskills")
	public String addSkills(@ModelAttribute("skill") Skill skill) {
		return "skill";
	}

	@GetMapping("/sessionslist")
	public String listSessionDetails(Model model) {
		List<Session> sessions = sessionService.getAll();
		model.addAttribute("sessionlist", sessions);
		return "sessionslist";
	}

	@GetMapping("/trainerlist")
	public String listTrainerDetails(Model model) {
		List<Trainer> trainers = trainerService.getAll();
		model.addAttribute("trainerlist", trainers);
		return "trainerlist";
	}

	@GetMapping("/skillsessionmapping")
	public String skillSessionMapping(@ModelAttribute("skill-session") SkillSession skillsession) {

		return "skill-session";
	}

	@PostMapping("/skillsessionmapping")
	public String skillPostSessionMapping(@Valid @ModelAttribute("skill-session") SkillSession skillsession,
			BindingResult res, Model model) {
		if (res.hasErrors()) {

			return "skill-session";
		}
		skillSessionService.create(skillsession);
		model.addAttribute("message", "Your details are added successfully");

		return "skill-session";
	}

	@GetMapping("/updatesessiondetails")
	public String updateSessionDetails(@ModelAttribute("session") Session session, @RequestParam int sessionId, Model model) {
		Optional<Session> findById = sessionRepository.findById(sessionId);
		Session session1=findById.get();
		
		model.addAttribute("session1",session1);
				

		return "updatesession";
	}

	@GetMapping("/updatetrainerdetails")
	public String updateTrainerDetails(@ModelAttribute("trainer") Trainer trainer, @RequestParam int trainerId, Model model) {

		Optional<Trainer> findById = trainerRepository.findById(trainerId);
		Trainer trainer1=findById.get();
		
		model.addAttribute("trainer1",trainer1);
		return "updatetrainer";
	}

	@PostMapping("/updatesessiondetails")
	public String updatePostSessionDetails(@ModelAttribute("session") Session session, @RequestParam int sessionId) {
		sessionService.updateUser(session);
		// sessionService.updateSession(session);

		return "redirect:sessionslist";
	}

	@PostMapping("/updatetrainerdetails")
	public String updatePostTrainerDetails(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult res) {

		if (res.hasErrors()) {
			return "updatetrainer";
		}
		trainerService.updateTrainer(trainer);

		// sessionService.updateSession(session);

		return "redirect:trainerlist";
	}

	@GetMapping("/deletesessiondetails")
	public String deleteSessionDetails(@ModelAttribute("session") Session session) {

		sessionService.updateSession(session.getSessionId());

		return "redirect:sessionslist";
	}

	@GetMapping("/deletetrainerdetails")
	public String deleteTrainerDetails(@ModelAttribute("trainer") Trainer trainer) {
		trainerService.updateTrainer(trainer.getTrainerId());

		return "redirect:trainerlist";
	}

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@ModelAttribute("skilllist")
	public Set<String> getSkills() {
		List<Skill> skills = skillService.getAll();
		Set<String> skillName = new TreeSet<>();
		for (Skill skill : skills) {
			skillName.add(skill.getSkillType());
		}
		return skillName;
	}

	@GetMapping("/superUser")
	public String getSuperUser() {
		return "superuser_welcome";
	}

	@GetMapping("/approveadmins")
	public String getApproveAdmins() {
		return "adminlist";
	}
	
	@GetMapping("/adminrejected")
	public String adminRejected() {
		return "adminreject";
	}

	@GetMapping("/rejectadmins")
	public String rejectAdmins(@RequestParam int adminId) {
		adminService.rejectAdmin(adminId);
		return "redirect:approveadmins";
	}
	@ModelAttribute("adminlist")
	public List<Admin> getAdminList() {
		List<Admin> adminlist = adminService.getAll();
		adminlist.remove(0);
		adminlist.remove(100);
		return adminlist;
	}

	@GetMapping("changestatus")
	public String getChangeStatusOfAdmins(@RequestParam String adminId, Model model) {

		adminService.updateStatus(adminId);
		model.addAttribute("message", "ok");
		return "redirect:approveadmins";
	}

	@GetMapping("/enrollmentrequest")
	public String enrollmentRequest() {

		return "sessionsenrolledlist";
	}

	@GetMapping("/approveenrollment")
	public String getChangeStatusOfEnrollments(@RequestParam String id, Model model) {
		notification = new Notifications();
		sessionEnrolled = sessionsEnrolledService.getById(Integer.parseInt(id));
		System.out.println(sessionEnrolled.getSessionDesc() + " sessiondesc from session enrolled");
		sessionsEnrolledService.updateStatus(id);
		notification.setUserId(sessionEnrolled.getUserId());
		notification.setSessionId(sessionEnrolled.getSessionId());
		notification.setSessionDesc(sessionEnrolled.getSessionDesc());
		notification.setStatus(sessionEnrolled.getApprovalStatus());
		notificationsService.create(notification);
		System.out.println("added notif");
		return "redirect:enrollmentrequest";
	}
	@GetMapping("/rejectenrollmentrequest")
	public String rejectenrollmentrequest(@RequestParam int id) {
		SessionEnrolled session=sessionsEnrolledService.getById(id);
		notification =new Notifications();
		notification.setSessionId(session.getSessionId());
		notification.setUserId(session.getUserId());
		notification.setSessionDesc(session.getSessionDesc());
		notification.setStatus("rejected");
		notificationsService.create(notification);
		sessionsEnrolledService.deleteById(id);
		
		return "redirect:enrollmentrequest";
	}
	

	@GetMapping("/resetadminpassword")
	public String resetPassword(@ModelAttribute("resetPassword") Admin resetPassword) {

		return "resetadminpassword";
	}

	@PostMapping("/resetadminpassword")
	public String resetingPassword(@ModelAttribute("resetPassword") Admin resetPassword, BindingResult bindingResult,
			Model model) {

		if (adminService.findAdmin(resetPassword) == null) {

			model.addAttribute("invalidmessage", "Invalid Details");

			return "resetadminpassword";
		}

		return "redirect:passwordresetadmin?email=" + resetPassword.getEmail();
	}

	@GetMapping("/passwordresetadmin")
	public String resetadminPassword(@RequestParam String email, @ModelAttribute("passwordForm") Admin passwordForm) {
		System.out.println("email " + email);
		return "updateadminpassword";
	}

	@PostMapping("/passwordresetadmin")
	public String resetadminPassword(@ModelAttribute("passwordForm") Admin passwordForm, Model model) {

		if (adminService.updateAdmin(passwordForm) != null) {
			model.addAttribute("message", "Your password was reset successfully");
			model.addAttribute("loginlink", "Login Here");
		}

		else {
			model.addAttribute("invalidmessage", "Password didn't match");

		}
		return "updateadminpassword";

	}

	@GetMapping("/adminapprovalpending")
	public String adminApprovalPending() {

		return "adminpending";
	}
	@GetMapping("/about")
	public String returnAbout() {

		return "about";
	}


	@GetMapping("/sessionsreportsadmin")
	public String adminSessionsReport(@ModelAttribute("search") Search search,Model model) {

		List<Session> sessionlist = sessionService.getAll();

		model.addAttribute("sessionlist", sessionlist);

		return "sessionreportadmin";
	}
	@PostMapping("/sessionsreportsadmin")
	public String postadminSessionsReport(@Valid @ModelAttribute("search") Search search, BindingResult res,Model model) {

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
				return "sessionreportadmin";
			} else {
				skillSessions.add(session);
				model.addAttribute("searchedsessionlist", skillSessions);
				model.addAttribute("sessionlist", skillSessions);
				return "sessionreportadmin";
			}
		} else if (search.getOption().equals("SkillId")) {
			// sessions = sessionService.getAllBySkillId(search.getId());
			skillSessions = sessionService.getAllBySkill(search.getId());
			if (skillSessions.isEmpty() || skillSessions == null) {
				List<Session> sessions = sessionService.getAll();
				model.addAttribute("sessionlist", sessions);
				model.addAttribute("message", "No sessions with skill Id '" + search.getId() + "' found");
				return "sessionreportadmin";
			}
			model.addAttribute("sessionlist", skillSessions);
			return "sessionreportadmin";
		}
		System.out.println(skillSessions + " list");

		List<Session> sessions = sessionService.getAll();

		model.addAttribute("sessionlist", sessions);
		return "sessionreportadmin";
	}
	@GetMapping("/viewenrolledusers")
	public String viewEnrolledUsersForSession(@RequestParam int sessionId, Model model) {

		List<SessionEnrolled> enrolleduserlist = sessionsEnrolledService.getBySessionId(sessionId);
		model.addAttribute("enrolleduserlist", enrolleduserlist);

		return "viewenrolledusers";
	}



	@GetMapping("/forgotadminusername")
	public String forgotAdminUsername(@ModelAttribute("forgotUsername") Admin forgotUsername) {

		return "forgotadminusername";
	}

	@PostMapping("/forgotadminusername")
	public String forgotAdminUserName(@ModelAttribute("forgotUsername") Admin forgotUsername,
			BindingResult bindingResult, Model model) {
		Admin admin = adminService.forgotUsername(forgotUsername);

		if (adminService.forgotUsername(forgotUsername) == null) {

			model.addAttribute("invalidmessage", "Invalid Details");

		}

		else {
			model.addAttribute("message", "Your user name is **" + admin.getEmail()+"**");
		}

		return "forgotadminusername";
	}

	@GetMapping("/addfeedbackform")
	public String addFeedbackForm(@RequestParam int sessionId,
			@ModelAttribute("feedbackformdone") Session feedbackformdone) {

		return "addfeedbackform";
	}

	@PostMapping("/addfeedbackform")
	public String addFeedbackFormPost(@ModelAttribute("feedbackformdone") Session feedbackformdone, BindingResult res,
			Model model) {

		Session session = sessionService.findSessionDetails(feedbackformdone.getSessionId());

		session.setFeedbackform(feedbackformdone.getFeedbackform());
		sessionService.updateUser(session);
		model.addAttribute("message", "Successfully added feedback form");

		return "addfeedbackform";
	}

	@ModelAttribute("sessionsenrolled")
	public List<SessionEnrolled> getEnrolledSessionDetails() {
		return sessionsEnrolledService.getAll();
	}
}
