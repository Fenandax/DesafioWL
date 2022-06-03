package com.desafiowl.DesafioWL.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiowl.DesafioWL.entities.Lanche;

@Repository
public interface LancheRepository extends JpaRepository <Lanche, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO TB_LANCHE (NOME) VALUES (?)", nativeQuery = true)
	Lanche insert(Lanche lanche);
	
	@Query(value = "SELECT * FROM TB_LANCHE", nativeQuery = true)
	List<Lanche> listAll();

	@Query(value = "SELECT * FROM TB_LANCHE i WHERE i.ID = ?", nativeQuery = true)
	Lanche getLanche(Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE TB_LANCHE SET NOME = ?2 WHERE ID = ?1", nativeQuery = true)
	Lanche update(Long nome, Lanche obj);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM TB_LANCHE WHERE ID = ? ", nativeQuery = true)
	void delete(Long id);
}