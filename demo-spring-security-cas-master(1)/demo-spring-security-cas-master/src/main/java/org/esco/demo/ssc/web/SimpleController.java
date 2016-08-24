package org.esco.demo.ssc.web;

import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SimpleController {

	@RequestMapping("/login")
	public String login() {
		return "redirect:/";
	}

	// @RequestMapping("/j_spring_cas_security_logout")
	// public String spring_logout() {
	// return "redirect:/logout";
	// }

	// @RequestMapping("/logout")
	// public String logout() {
	// return "redirect:/";
	// }

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		model.addAttribute("user", user);

		// renders /WEB-INF/jsp/index.jsp
		return "index";
		// return "Hello World! (user: " + user + ")";
	}

	@RequestMapping(value = "/secure", method = RequestMethod.GET)
	public String secure(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		model.addAttribute("user", user);

		// renders /WEB-INF/jsp/index.jsp
		return "secure/index";
		// return "Hello World! (user: " + user + ")";
	}

	@RequestMapping(value = "/filtered", method = RequestMethod.GET)
	public String filtered(Model model) {
		System.out.println("in filtered 1");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("in filtered 2");
		
		
		CasAuthenticationToken casToken =  (CasAuthenticationToken)auth;
		System.out.print("luck....................");
		System.out.print(casToken);
		
		String user = auth.getName();
		model.addAttribute("user", user);

		// renders /WEB-INF/jsp/index.jsp
		return "secure/admin/index";
		// return "Hello World! (user: " + user + ")";
	}
}