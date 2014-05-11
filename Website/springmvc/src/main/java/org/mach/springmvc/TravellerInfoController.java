package org.mach.springmvc;

import javax.validation.Valid;

import org.mach.springdao.Traveller;
import org.mach.springdao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/travellerInfo.htm")
public class TravellerInfoController {

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap model) {
		System.out.println("inside get");
		model.addAttribute("traveller", new Traveller());
		return "travellerInfo"; // viewname
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("traveller") @Valid Traveller user21,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "error.html";
		}
		System.out.println("saved");
		return "travellerInfo";
	}
}
