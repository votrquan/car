package com.car.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainControler {
	
	@RequestMapping("/")
	  public String welcome() {
	    return "index";
	  }
	@RequestMapping(value = {"/test" })
    public String index() {
        return "test";
    }
}
