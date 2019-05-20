package com.car.controler;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.model.user;

@Controller
public class mainControler {
	
	@RequestMapping("/")
	  public String welcome(Model model) {
		model.addAttribute("user", new user()); 
	    return "index";
	  }
	@RequestMapping(value = {"/test2" })
    public String index(Model model) {
		model.addAttribute("user", new user()); 
        return "test2";
    }
	
	@PostMapping("/user/submit")
	public String save(@Valid user user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "test";
		}
		user rs = new user();
		rs= user;
		
		redirect.addFlashAttribute("success", rs.getPhoneNumber());
		return "/admin";
	}
	
	@RequestMapping("/admin")
	  public String admin(Model model) {
		model.addAttribute("user", new user()); 
	    return "admin";
	  }
}
