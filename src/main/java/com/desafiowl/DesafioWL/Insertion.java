package com.desafiowl.DesafioWL;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafiowl.DesafioWL.entities.Colaborador;
import com.desafiowl.DesafioWL.entities.Lanche;
import com.desafiowl.DesafioWL.repositories.ColaboradorRepository;
import com.desafiowl.DesafioWL.repositories.LancheRepository;

@Component
@Transactional
public class Insertion implements CommandLineRunner {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private LancheRepository lancheRepository;

	@Override
	public void run(String... args) throws Exception {

		Colaborador c1 = new Colaborador(null, "Fernanda", "4545666687");
		Colaborador c2 = new Colaborador(null, "Nicolas", "56218964");
		Colaborador c3 = new Colaborador(null, "João", "645068823");

		colaboradorRepository.save(c1);
		colaboradorRepository.save(c2);
		colaboradorRepository.save(c3);

		Lanche l1 = new Lanche(null, "Sanduíche", c1);
		Lanche l2 = new Lanche(null, "Café", c1);
		Lanche l3 = new Lanche(null, "Bolo", c1);
		Lanche l4 = new Lanche(null, "Torrada", c2);
		Lanche l5 = new Lanche(null, "Chá", c3);

		lancheRepository.save(l1);
		lancheRepository.save(l2);
		lancheRepository.save(l3);
		lancheRepository.save(l4);
		lancheRepository.save(l5);
	}

}
