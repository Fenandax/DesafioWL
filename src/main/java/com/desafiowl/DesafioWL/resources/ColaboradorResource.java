package com.desafiowl.DesafioWL.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiowl.DesafioWL.controller.ColaboradorController;
import com.desafiowl.DesafioWL.entities.Colaborador;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorResource {

	@Autowired
	private ColaboradorController controller;

	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll() {
		List<Colaborador> list = controller.listAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
		Colaborador obj = controller.getColaborador(id);
		;
		return ResponseEntity.ok().body(obj);
	}

}
