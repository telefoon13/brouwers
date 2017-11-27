package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.BeginNaamForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/brouwers")
public class BrouwersController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String ALFABET_VIEW = "brouwers/opalfabet";
	private static final String BEGIN_NAAM_VIEW = "brouwers/beginnaam";
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/";
	private final char[] alfabet = new char['Z' - 'A' + 1];
	private final BrouwerService brouwerService;

	BrouwersController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}

	@GetMapping
	ModelAndView findAll(){
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}

	@GetMapping("beginnaam")
	ModelAndView beginNaamForm() {
		return new ModelAndView(BEGIN_NAAM_VIEW).addObject(new BeginNaamForm());
	}
	@GetMapping(params = "beginnaam")
	ModelAndView beginNaam(@Valid BeginNaamForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BEGIN_NAAM_VIEW);
		if ( ! bindingResult.hasErrors()) {
			modelAndView.addObject("brouwers", brouwerService.findByNaam(form.getBeginnaam()));
		}
		return modelAndView;
	}

	@GetMapping("opalfabet")
	ModelAndView opAlfabetForm() {
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
	}

	@GetMapping(params = "letter")
	ModelAndView opAlfabet(@RequestParam char letter) {
		return new ModelAndView(ALFABET_VIEW)
				.addObject("alfabet", alfabet)
				.addObject("brouwers", brouwerService.findByNaam(String.valueOf(letter)));
	}

	@GetMapping("toevoegen")
	ModelAndView toevoegen() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}

	@PostMapping
	String toevoegen(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}

	@InitBinder("brouwer")
	void initBinderPostcodeReeks(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
