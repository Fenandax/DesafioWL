package com.desafiowl.DesafioWL.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafiowl.DesafioWL.entities.Lanche;
import com.desafiowl.DesafioWL.repositories.LancheRepository;

@Controller
public class LancheController {

	@Autowired
	private LancheRepository repo;

	public LancheController(LancheRepository repo) {
		this.repo = repo;
	}
	
	public List<Lanche> listAll(){
		return (List<Lanche>) this.repo.findAll();
	}
	
	public void salvar(@ModelAttribute("lanche") Lanche lanche) {
		this.repo.save(lanche);
	}
	
	public Lanche getLanche(Long id) {
		return this.repo.findById(id).get();
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}

	//mapeamento da URL
	@GetMapping("/lanches")
	public String lanches(Model model) {
		model.addAttribute("listaLanches", repo.findAll());
		return "colaboradores/index";
	}

	//cadastro de lanche
	@GetMapping("/lanches/cadastrar")
	public String cadastrarLanche(@ModelAttribute("lanche") Lanche lanche) {
		return "colaboradores/form";
	}

	//encontrar por ID
	@GetMapping("lanches/{id}")
	public String alterarLanche(@PathVariable("id") long id, Model model) {
		Optional<Lanche> lancheOpt = repo.findById(id);
		if (lancheOpt.isEmpty()) {
			throw new IllegalArgumentException("Lanche inválido.");
		}

		model.addAttribute("lanche", lancheOpt.get());
		return "colaboradores/form";
	}

	//salvar novo lanche
	@PostMapping("/lanches/salvar")
	public String salvarLanche(@ModelAttribute("lanche") Lanche lanche) {
		repo.save(lanche);
		return "colaboradores/form";
	}

	//remover lanche
	@GetMapping("/lanches/remover/{id}")
	public String removerLanche(@PathVariable("id") long id) {
		Optional<Lanche> lancheOpt = repo.findById(id);
		if (lancheOpt.isEmpty()) {
			throw new IllegalArgumentException("Lanche inválido.");
		}

		repo.delete(lancheOpt.get());
		return "redirect:/lanches";
	}
}
