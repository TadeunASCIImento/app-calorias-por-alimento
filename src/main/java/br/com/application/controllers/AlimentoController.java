package br.com.application.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

	@Autowired
	private RestTemplate restTamplate;

	String uri = "https://caloriasporalimentoapi.herokuapp.com/api/calorias/?descricao=";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "/filtrar", method = RequestMethod.GET)
	public ModelAndView filtrar(@RequestParam(value = "descricao", required = false) String descricao) {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			ArrayList<?> response = restTamplate.getForObject(uri + descricao, ArrayList.class);
			modelAndView.addObject("alimentos", response);
		} catch (HttpClientErrorException exception) {
			return new ModelAndView("redirect:/alimentos/formulario");
		}
		return modelAndView;
	}

}
