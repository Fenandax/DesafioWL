package com.desafiowl.DesafioWL.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafiowl.DesafioWL.entities.Colaborador;
import com.desafiowl.DesafioWL.repositories.ColaboradorRepository;

@Controller
public class ColaboradorController {

	private ColaboradorRepository repo;

	public ColaboradorController(ColaboradorRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/colaboradores")
	public String colaboradores(Model model) {
		model.addAttribute("listaColaboradores", repo.findAll());
		return "colaboradores/index";
	}

	@GetMapping("/colaboradores/cadastrar")
	public String cadastrarColaborador(@ModelAttribute("colaborador") Colaborador colaborador) {
		return "colaboradores/form";
	}

	@GetMapping("colaboradores/{id}")
	public String alterarColaborador(@PathVariable("id") long id, Model model) {
		Optional<Colaborador> colaboradorOpt = repo.findById(id);
		if (colaboradorOpt.isEmpty()) {
			throw new IllegalArgumentException("Colaborador inválido.");
		}

		model.addAttribute("colaborador", colaboradorOpt.get());
		return "colaboradores/form";
	}

	@PostMapping("/colaboradores/salvar")
	public String salvarColaborador(@ModelAttribute("colaborador") Colaborador colaborador) {
		repo.save(colaborador);
		return "colaboradores/form";
	}

	@GetMapping("/colaboradores/remover/{id}")
	public String removerColaborador(@PathVariable("id") long id) {
		Optional<Colaborador> colaboradorOpt = repo.findById(id);
		if (colaboradorOpt.isEmpty()) {
			throw new IllegalArgumentException("Colaborador inválido.");
		}

		repo.delete(colaboradorOpt.get());
		return "redirect:/colaboradores";
	}
}
