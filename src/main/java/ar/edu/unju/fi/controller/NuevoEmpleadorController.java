package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.util.ListaProvincia;

@Controller
@RequestMapping("/empleador")
public class NuevoEmpleadorController {

	@Autowired
	@Qualifier("EmpleadorServiceImp")
	private IEmpleadorService empleadorSvc;

	private static final Log LOGGER = LogFactory.getLog(NuevoEmpleadorController.class);

	@GetMapping("/nuevoemp")
	public String getFormNewEmpleadorPage(Model model) {
		model.addAttribute("empleador", new Empleador());
		ListaProvincia listaProvincia = new ListaProvincia();
		model.addAttribute("provincias", listaProvincia.getProvincias());
		return "empleadorForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador empleador,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.info("No se cumplen las validaciones");
			ModelAndView mov = new ModelAndView("empleadorForm");
			ListaProvincia listaProvincia = new ListaProvincia();
			mov.addObject("provincias", listaProvincia.getProvincias());
			return mov;

		}

		ModelAndView mov = new ModelAndView("loginEmpleador");

		empleadorSvc.saveEmpleador(empleador);
		mov.addObject("inicio");
		return mov;
	}
}