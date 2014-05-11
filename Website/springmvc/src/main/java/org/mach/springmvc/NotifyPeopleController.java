package org.mach.springmvc;

import javax.validation.Valid;

import org.mach.springdao.Notice;
import org.mach.springdao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Controller
@RequestMapping("/notifyPeople.htm")
public class NotifyPeopleController {
		
		@RequestMapping(method = RequestMethod.GET)
	    public String setupForm(ModelMap model) {
			System.out.println("inside get of notify people");
			model.addAttribute("notice", new Notice());
	        return "notifyPeople"; //viewname
	    }

	    @RequestMapping(method = RequestMethod.POST)
	    public String processSubmit( @ModelAttribute("user") @Valid Notice notice, BindingResult result, SessionStatus status) {
	        if (result.hasErrors()) {
	            return "error.html";
	        }
	        System.out.println("inside post of notifying people");
	        
	        AmazonSNSClient snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());	                           
	        snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
	        String msg = notice.getMessage();
	        PublishRequest publishRequest = new PublishRequest("arn:aws:sns:us-east-1:284742219159:MyNewTopic", msg);
	        PublishResult publishResult = snsClient.publish(publishRequest);
	        //print MessageId of message published to SNS topic
	        System.out.println("MessageId - " + publishResult.getMessageId());
	        	        
	        return "redirect:/index.jsp";	
	    }
	}


