package com.desafiowl.DesafioWL;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafiowl.DesafioWL.entities.Colaborador;
import com.desafiowl.DesafioWL.entities.Lanche;
import com.desafiowl.DesafioWL.entities.Pedido;
import com.desafiowl.DesafioWL.repositories.ColaboradorRepository;
import com.desafiowl.DesafioWL.repositories.LancheRepository;
import com.desafiowl.DesafioWL.repositories.PedidoRepository;

@Component
@Transactional
public class Insertion implements CommandLineRunner {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private LancheRepository lancheRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Lanche l1 = new Lanche(null, "Sanduíche");
		Lanche l2 = new Lanche(null, "Café");
		Lanche l3 = new Lanche(null, "Bolo");
		Lanche l4 = new Lanche(null, "Torrada");
		Lanche l5 = new Lanche(null, "Chá");

		lancheRepository.save(l1);
		lancheRepository.save(l2);
		lancheRepository.save(l3);
		lancheRepository.save(l4);
		lancheRepository.save(l5);

		Colaborador c1 = new Colaborador(null, "Fernanda", "4545666687", l1);
		Colaborador c2 = new Colaborador(null, "Júlia", "62353473", l2);
		Colaborador c3 = new Colaborador(null, "Carolina", "93156465", l3);
		Colaborador c4 = new Colaborador(null, "Nicolas", "56218964", l4);
		Colaborador c5 = new Colaborador(null, "João", "645068823", l5);

		colaboradorRepository.save(c1);
		colaboradorRepository.save(c2);
		colaboradorRepository.save(c3);
		colaboradorRepository.save(c4);
		colaboradorRepository.save(c5);

		Pedido p1 = new Pedido(c1, l1);
		Pedido p2 = new Pedido(c1, l2);
		Pedido p3 = new Pedido(c1, l3);
		Pedido p4 = new Pedido(c2, l4);
		Pedido p5 = new Pedido(c3, l5);

		pedidoRepository.save(p1);
		pedidoRepository.save(p2);
		pedidoRepository.save(p3);
		pedidoRepository.save(p4);
		pedidoRepository.save(p5);
	}

}
