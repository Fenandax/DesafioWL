package com.desafiowl.DesafioWL.controller;

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

	//mapeamento da URL
	@GetMapping("/lanches")
	public String lanches(Model model) {
		model.addAttribute("listaLanches", repo.findAll());
		return "lanches/index";
	}

	//cadastro de lanche
	@GetMapping("/lanches/cadastrar")
	public String cadastrarLanche(@ModelAttribute("lanche") Lanche lanche) {
		return "lanches/form";
	}

	//encontrar por ID
	@GetMapping("lanches/{id}")
	public String alterarLanche(@PathVariable("id") long id, Model model) {
		Optional<Lanche> lancheOpt = repo.findById(id);
		if (lancheOpt.isEmpty()) {
			throw new IllegalArgumentException("Lanche inválido.");
		}

		model.addAttribute("lanche", lancheOpt.get());
		return "lanches/form";
	}

	//salvar novo lanche
	@PostMapping("/lanches/salvar")
	public String salvarLanche(@ModelAttribute("lanche") Lanche lanche) {
		repo.save(lanche);
		return "lanches/form";
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
