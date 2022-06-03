package com.desafiowl.DesafioWL.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiowl.DesafioWL.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository <Colaborador, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO TB_COLABORADOR (NOME, CPF, ITEM) VALUES (?)", nativeQuery = true)
	Colaborador insert(Colaborador colaborador);

	@Query(value = "SELECT * FROM TB_COLABORADOR ORDER BY ID", nativeQuery = true)
	List<Colaborador> findAll();

	@Query(value = "SELECT * FROM TB_COLABORADOR u WHERE u.ID = ?", nativeQuery = true)
	Colaborador getColaborador(Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE TB_COLABORADOR SET NOME = ?2, CPF = ?3 WHERE ID = ?1", nativeQuery = true)
	Colaborador update(Long id, Colaborador obj);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM TB_COLABORADOR WHERE ID = ?", nativeQuery = true)
	void delete(Long id);
}