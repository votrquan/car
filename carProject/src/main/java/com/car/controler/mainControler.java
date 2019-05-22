package com.car.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.dao.carDAO;
import com.car.entity.userEntity;
import com.car.model.user;

@Controller
public class mainControler {
	
	@Autowired
	private carDAO carDAO;
	
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
			return "form";
		}
		userEntity us = new userEntity();
		us.setAge(user.getAge());
		us.setName(user.getName());
		us.setPhone(user.getPhoneNumber());
		carDAO.insertUser(us);
		return "redirect:/";
	}
	
	
	@RequestMapping("/admin")
	  public String admin(Model model) {
		List<user> list  =  carDAO.listCarInfo();
		model.addAttribute("userList", list); 
	    return "admin";
	  }
}
