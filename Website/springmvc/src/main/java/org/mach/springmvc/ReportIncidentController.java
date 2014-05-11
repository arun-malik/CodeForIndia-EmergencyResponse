package org.mach.springmvc;

import javax.validation.Valid;

import org.mach.springdao.ReportIncidence;
import org.mach.springdao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/reportIncident.htm")
public class ReportIncidentController {


		@RequestMapping(method = RequestMethod.GET)
		public String setupForm(ModelMap model) {
			System.out.println("inside get of report incidient citing");
			model.addAttribute("incidence", new ReportIncidence());
			return "report"; // viewname
		}

		@RequestMapping(method = RequestMethod.POST)
		public String processSubmit(@ModelAttribute("incidence") @Valid ReportIncidence user21,
				BindingResult result, SessionStatus status) {
			if (result.hasErrors()) {
				return "error.html";
			}
			System.out.println("saved");
			return "report";
		}
	}

