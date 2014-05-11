package org.mach.springmvc;

import javax.validation.Valid;

import org.mach.springdao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/userLocation.htm")
public class userLocationController {
	
		@RequestMapping(method = RequestMethod.GET)
	    public String setupForm(ModelMap model) {
			System.out.println("inside get user location");
			model.addAttribute("user", new User());
	        return "userLocation"; //viewname
	    }

	  /*  @RequestMapping(method = RequestMethod.POST)
	    public ModelMap processSubmit( @ModelAttribute("user") @Valid User user21, BindingResult result, SessionStatus status) {
	        if (result.hasErrors()) {
	            return new ModelMap("report.html");
	        }
	        System.out.println("inside post");
	         User user1 = new User();
	        user1.setName("sarvagya");
	        user1.setRole("admin");
	        return new ModelMap("use", user1);
	    }*/
	}

