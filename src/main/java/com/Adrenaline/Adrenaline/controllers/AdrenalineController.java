package com.Adrenaline.Adrenaline.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Adrenaline.Adrenaline.models.Adrenaline;
import com.Adrenaline.Adrenaline.repository.AdrenalineRepository;

@Controller
public class AdrenalineController {

	@Autowired
	private AdrenalineRepository ar;

	// GET que chama o form para cadastrar funcionários
	@RequestMapping("/cadastrarJogo")
	public String form() {
		return "adrenaline/form-jogo";
	}

	// POST que cadastra funcionários
	@RequestMapping(value = "/cadastrarJogo", method = RequestMethod.POST)
	public String form(@Valid Adrenaline jogo, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarJogo";
		}

		ar.save(jogo);
		attributes.addFlashAttribute("mensagem", "Jogo cadastrado com sucesso!");
		return "redirect:/cadastrarJogo";
	}

	// GET que lista funcionários
	@RequestMapping("/jogos")
	public ModelAndView listaJogos() {
		ModelAndView mv = new ModelAndView("adrenaline/lista-jogo");
		Iterable<Adrenaline> jogos = ar.findAll();
		mv.addObject("jogos", jogos);
		return mv;
	}

	// GET que lista detalhes dos funcionário
	@RequestMapping("/detalhes-jogo/{id}")
	public ModelAndView detalhesJogo(@PathVariable("id") long id) {
		Adrenaline jogo = ar.findById(id);
		ModelAndView mv = new ModelAndView("adrenaline/detalhes-jogo");
		mv.addObject("jogos", jogo);
		return mv;
	}
	

	//GET que deleta funcionário
	@RequestMapping("/deletarJogo")
	public String deletarJogo(long id) {
		Adrenaline jogo = ar.findById(id);
		ar.delete(jogo);
		return "redirect:/jogos";
		
	}
	
	// Métodos que atualizam funcionário
	// GET que chama o FORM de edição do funcionário
	@RequestMapping("/editar-jogo")
	public ModelAndView editarJogo(long id) {
		Adrenaline jogo = ar.findById(id);
		ModelAndView mv = new ModelAndView("adrenaline/update-jogo");
		mv.addObject("jogo", jogo);
		return mv;
	}
	
	// POST que atualiza o funcionário
	@RequestMapping(value = "/editar-jogo", method = RequestMethod.POST)
	public String updateJogo(@Valid Adrenaline jogo,  BindingResult result, RedirectAttributes attributes){
		
		ar.save(jogo);
		attributes.addFlashAttribute("success", "Jogo alterado com sucesso!");
		
		long idLong = jogo.getId();
		String id = "" + idLong;
		return "redirect:/detalhes-jogo/" + id;
		
	}
	
}