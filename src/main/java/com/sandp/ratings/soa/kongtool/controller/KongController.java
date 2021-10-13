package com.sandp.ratings.soa.kongtool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.form.APIOnBoardForm;
import com.sandp.ratings.soa.kongtool.service.CmdService;
import com.sandp.ratings.soa.kongtool.util.DataHelper;


@Controller
public class KongController {
    
    @Autowired
    private CmdService commandService; 
    
    /*
    @Autowired
    private CodeRepoService codeRepoService;
    
    @Autowired
    private EmailService emailService;
    */
    @RequestMapping(value = "/login")
    public String login() {
	return "signin";
    }
    
    @GetMapping(value = "/home")
    public String home() {
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	//System.out.println("username: " + auth.getName()); 
        return "index";
    }
    
    @GetMapping(value = "/protected/apionboardform")
    public String apiOnBoardingForm(Model model) {
	model.addAttribute("apionboardform", new APIOnBoardForm());
	return "apionboardform";
    }
    
    @PostMapping("/protected/processapionboardform")
    public String saveInvoice(@Valid@ModelAttribute("apionboardform") APIOnBoardForm apiOnboardingForm, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    return "apionboardform";
	}
	//TODO: anything need admin right ? 
	API api = DataHelper.copyDataToEntityObject(apiOnboardingForm);
	commandService.getCommand(api);
	// codeRepoService.checkInCode();
	// emailService.sendEmail();
	// trackerService.update()
	model.addAttribute("message", "hello");
        return "apionboardform";
    }
    
    @RequestMapping(value = "/")
    public String home1() {
        return "index";
    }
    
    @RequestMapping(value = "/addApi", method = RequestMethod.POST)
    public String submit(@ModelAttribute("APIDetail") APIOnBoardForm apidetail) {
        // Code that uses the employee object

        return "employeeView";
    }
}
