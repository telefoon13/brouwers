package be.vdab.web;

import be.vdab.exceptions.KanTemperatuurNietLezenException;
import be.vdab.services.WeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("weer")
public class WeerController {

	private static final String VIEW = "weer/temperatuur";
	private final WeerService weerService;

	WeerController(WeerService weerService) {
		this.weerService = weerService;
	}

	@GetMapping("{plaats}/temperatuur")
	ModelAndView temperatuur(@PathVariable String plaats) {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		try {
			modelAndView.addObject("temperatuur", weerService.getTemperatuur(plaats));
		} catch (KanTemperatuurNietLezenException ex) {
			modelAndView.addObject("fout", "kan temperatuur niet lezen");
		}
		return modelAndView;
	}
}
