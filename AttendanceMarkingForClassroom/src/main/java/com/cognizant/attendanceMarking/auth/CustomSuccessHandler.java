package com.cognizant.attendanceMarking.auth;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.repository.AdminRepository;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Autowired
    private AdminRepository adminRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("role " + grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("USER")) {
				redirectUrl = "/welcome";
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				System.out.println((authentication));
				if(authentication.getName().equals("superuser@gmail.com")) {
					
					redirectUrl="/superUser";
				}
				else {
					Admin admin= adminRepository.findByEmail(authentication.getName());
					System.out.println(admin);
					String status= admin.getStatus();
					System.out.println(status);
					if(status.equals("pending")) {
						redirectUrl = "/adminapprovalpending";
					}
					else if(status.equals("rejected")){
						redirectUrl="/adminrejected";
					}
					else {
						redirectUrl = "/admin_welcome";
					}
					
					
				}
				
				break;
			}
		}
		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}