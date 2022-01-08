package com.agro.bsv.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agro.bsv.dao.model.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{

	@Query(value = 
			  " select sum(case p.sexo when 'F' then 1 else 0 end) cantidad_mujeres, "
			+ "        sum(case p.sexo when 'M' then 1 else 0 end) cantidad_hombres, "
			+ "	       sum(case p.nacionalidad when 'AR' then 1 else 0 end)*100/count(1) porcentaje_argentinos "
			+ " from personas p", nativeQuery = true)
	List<Object[]> getEstadisticas();
}
