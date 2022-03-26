package com.Adrenaline.Adrenaline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Adrenaline.Adrenaline.models.Adrenaline;

import com.Adrenaline.Adrenaline.repository.AdrenalineRepository;

@Controller
public class BuscaController {
	
	@Autowired
	private AdrenalineRepository ar;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar,@RequestParam("nome")String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da Busca por "+buscar;
		
		if(nome.equals("nomejogo")) {
			mv.addObject("jogos",ar.findByNomes(buscar));
		}else{
			mv.addObject("jogos",ar.findByNomes(buscar));
		}
		
		mv.addObject("mensagem",mensagem);
		return mv;
		
	}
}
