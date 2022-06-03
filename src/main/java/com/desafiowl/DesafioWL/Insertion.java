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

		Lanche l1 = new Lanche(null, "Sanduíche");
		Lanche l2 = new Lanche(null, "Café");
		Lanche l3 = new Lanche(null, "Bolo");
		Lanche l4 = new Lanche(null, "Torrada");
		Lanche l5 = new Lanche(null, "Chá");		
		Lanche l6 = new Lanche(null, "Bolacha");

		lancheRepository.save(l1);
		lancheRepository.save(l2);
		lancheRepository.save(l3);
		lancheRepository.save(l4);
		lancheRepository.save(l5);
		lancheRepository.save(l6);

		Colaborador c1 = new Colaborador(null, "Fernanda", "20795788656", l1);
		Colaborador c2 = new Colaborador(null, "Júlia", "60084575936", l2);
		Colaborador c3 = new Colaborador(null, "Carolina", "08622428486", l3);
		Colaborador c4 = new Colaborador(null, "Nicolas", "82727776510", l4);
		Colaborador c5 = new Colaborador(null, "João", "60305808592", l5);

		colaboradorRepository.save(c1);
		colaboradorRepository.save(c2);
		colaboradorRepository.save(c3);
		colaboradorRepository.save(c4);
		colaboradorRepository.save(c5);
	}

}
