package com.agro.bsv.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agro.bsv.dao.model.EstadisticaEntity;
import com.agro.bsv.dao.model.PersonaEntity;

@Service
public interface PersonaService {
	
	
	public List<PersonaEntity> findAll();

	public PersonaEntity findById(Long id);
	
	public PersonaEntity save(PersonaEntity persona);
	
	public void deleteById(Long id);
	
    public EstadisticaEntity getEstadisticas();
    
    
	public Optional<PersonaEntity> findById2(Long id);

	public PersonaEntity update(PersonaEntity persona) ;
}
