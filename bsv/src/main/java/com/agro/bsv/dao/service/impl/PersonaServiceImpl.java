package com.agro.bsv.dao.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agro.bsv.dao.exception.ContactoPersonaNoDefinidoException;
import com.agro.bsv.dao.exception.IdPersonaEsNuloException;
import com.agro.bsv.dao.exception.NoExistePersonaException;
import com.agro.bsv.dao.model.EstadisticaEntity;
import com.agro.bsv.dao.model.PersonaEntity;
import com.agro.bsv.dao.repository.PersonaRepository;
import com.agro.bsv.dao.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	/**
	 * Elimina un registro por ID
	 * @param id
	 */
	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}

	
	/**
	 * Obtiene todas las personas
	 */
	public List<PersonaEntity> findAll() {
		return (List<PersonaEntity>) personaRepository.findAll();
	}

	
	/**
	 * Obtiene una persona por ID
	 */
	public PersonaEntity findById(Long id) {

		Optional<PersonaEntity> persona = personaRepository.findById(id);
		
		return persona.get();
	}

	
	/**
	 * Persiste una persona
	 * @return 
	 */
	@Override
	@Transactional
	public PersonaEntity save(PersonaEntity persona)  {
		/*
		 * • No puede haber personas repetidas (las personas se identifican por Tipo de
		 * documento, número de documento, país y sexo). Contraint a nivel de tabla
		 * Table (name = "personas", uniqueConstraints=
		 * 
		 * @UniqueConstraint(columnNames = {"tipoDocumento",
		 * "nroDocumento","sexo","pais"}))
		 * 
		 * • Las personas deben tener al menos un dato de contacto. Validación en
		 * PersonaServiceImpl
		 * 
		 * • No pueden crearse personas menores a 18 años. Validación con anotation en
		 * la entidad entidad
		 * 
		 * • Pueden tener cualquier nacionalidad.
		 * 
		 */

		// Las personas deben tener al menos un dato de contacto.
		if (StringUtils.isBlank(persona.getEmail()) || StringUtils.isBlank(persona.getNroTel())) {
			throw new ContactoPersonaNoDefinidoException();
		}

		return personaRepository.save(persona);
	}


	@Override
	public PersonaEntity update(PersonaEntity persona) throws ContactoPersonaNoDefinidoException, NoExistePersonaException {
		
		if (persona.getId() == null) {
			throw new IdPersonaEsNuloException();
		}
		else if (! personaRepository.existsById(persona.getId())) {
			throw new NoExistePersonaException(persona.getId());
		}
		
		return save(persona);

	}

	
	/**
	 * Obtiene una persona por ID
	 */
	public Optional<PersonaEntity> findById2(Long id) {

		return personaRepository.findById(id);
		
	}

	
	
	@Override
	public EstadisticaEntity getEstadisticas() {
		EstadisticaEntity estadisticaEntity = new EstadisticaEntity();
		List<Object[]> o = personaRepository.getEstadisticas();
		
		estadisticaEntity.setCantidadMujeres (Long.parseLong(o.get(0)[0].toString()));
		estadisticaEntity.setCantidadHombres (Long.parseLong(o.get(0)[1].toString()));
		estadisticaEntity.setPorcentajeArgentinos (Float.parseFloat(o.get(0)[2].toString()));
		
		
		return estadisticaEntity;
		
	}


}
