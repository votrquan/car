package com.car.controler;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.model.user;

@Controller
public class userController {

	@PostMapping("/user/submit")
	public String save(@Valid user user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		user rs = new user();
		rs= user;
		
		redirect.addFlashAttribute("success", rs.getPhoneNumer());
		return "test";
	}

}
