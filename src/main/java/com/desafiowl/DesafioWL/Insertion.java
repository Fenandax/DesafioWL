package com.desafiowl.DesafioWL;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafiowl.DesafioWL.repositories.ColaboradorRepository;

@Component
@Transactional
public class Insertion implements CommandLineRunner {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

	
}
