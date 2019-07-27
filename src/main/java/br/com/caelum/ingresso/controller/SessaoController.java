package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

@Controller
public class SessaoController {

	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private FilmeDao filmeDao;
	
	@GetMapping("/adm/sessao")
	public ModelAndView form( @RequestParam("ID") Integer id ) {
		
		ModelAndView mv = new ModelAndView("sessao/sessao");
		
		mv.addObject("sala", salaDao.findOne(id));
		mv.addObject("Filmes", filmeDao.findAll());
		
		return mv;
		
	}
}
