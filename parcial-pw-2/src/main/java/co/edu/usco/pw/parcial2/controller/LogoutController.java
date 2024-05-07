package co.edu.usco.pw.parcial2.controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response,
					authentication);
		}

		return "redirect:/";
	}
}
