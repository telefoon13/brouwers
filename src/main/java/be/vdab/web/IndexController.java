package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class IndexController {

	private static final String VIEW = "index";

	@GetMapping
	ModelAndView index(){
		String begroeting = "";
		int huidigUur = LocalDateTime.now().getHour();
		if (huidigUur >= 0 && huidigUur <= 5){
			begroeting = "goedenacht";
		} else if (huidigUur >= 6 && huidigUur <= 11){
			begroeting= "goedemorgen";
		} else if (huidigUur >= 12 && huidigUur <= 17){
			begroeting= "goedemiddag";
		} else if (huidigUur >= 18 && huidigUur <= 23){
			begroeting= "goedeavond";
		}
		return new ModelAndView(VIEW, "tekst",begroeting);
	}
}
