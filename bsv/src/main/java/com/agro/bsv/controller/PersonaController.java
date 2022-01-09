package com.agro.bsv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.bsv.dao.dto.PersonaDTO;
import com.agro.bsv.dao.model.EstadisticaEntity;
import com.agro.bsv.dao.model.PersonaEntity;
import com.agro.bsv.dao.service.PersonaService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/persona")
@Log4j2
public class PersonaController {

	@Autowired
	PersonaService personaService;

	/**
	 * Devuelve lista de Personas
	 * @return
	 */
	@GetMapping("/getHolaMundo")
	private ResponseEntity<String> getHolaMundo() {
		log.info("getHolaMundo");
		return new ResponseEntity<String>("Hola Mundo", HttpStatus.OK);
	}
	
	/**
	 * Devuelve lista de Personas
	 * @return
	 */
	@GetMapping("")
	private ResponseEntity<List<PersonaDTO>> getPersonas() {
		log.info("getPersonas");
		return new ResponseEntity<List<PersonaDTO>>(getPersonDTO(personaService.findAll()), HttpStatus.OK);
	}

	/**
	 * Devuelve una persona por ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	private ResponseEntity<PersonaDTO> getPersonaById(@PathVariable("id") Long id) {
		log.info("getPersonaById Id: "+id);
		return new ResponseEntity<PersonaDTO>(getPersonDTO(personaService.findById(id)), HttpStatus.OK);
	}

	/**
	 * Borra una persona por ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deletePersona(@PathVariable("id") Long id) {
		log.info("deletePersona Id: "+id);

		personaService.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/**
	 * Graba una persona
	 * @param persona
	 * @return
	 * @throws ContactoPersonaNoDefinidoException
	 */
	@PostMapping("")
	private ResponseEntity<Long> save(@RequestBody PersonaDTO persona){
		log.info("save "+persona);

		PersonaEntity personaEntity = personaService.save(getPersonEntity(persona) );
		return new ResponseEntity<Long>(personaEntity.getId(), HttpStatus.OK);
	}

	/**
	 * Actualiza una persona. Si no existe da error
	 * @param persona
	 * @return
	 * @throws ContactoPersonaNoDefinidoException
	 * @throws NoExistePersonaException 
	 */
	@PutMapping("")
	private ResponseEntity<PersonaDTO> update(@RequestBody PersonaDTO persona){
		log.info("Update "+persona);

		return new ResponseEntity<PersonaDTO>( getPersonDTO(personaService.update(getPersonEntity(persona) )), HttpStatus.OK);
	}

	/**
	 * Devuelve las estadísticas
	 * @return
	 */
	@GetMapping("/estadisticas")
	private ResponseEntity<EstadisticaEntity> getEstadisticas() {
		log.info("getEstadisticas");

		return new ResponseEntity<EstadisticaEntity>(personaService.getEstadisticas(), HttpStatus.OK);
	}
	
	
	
	

	//@GetMapping("v2/{id}")
	@SuppressWarnings("unused")
	private ResponseEntity<PersonaDTO> getPersonas(@PathVariable("id") Long id) {
		log.info("getPersonas Prueba Punto 3");

		return personaService.findById2(id).map(mapToPersonDTO).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
	}
	
	
	

	/**
	 * Convierte una personaEntity en PersonaDTO
	 * @param personas
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<PersonaEntity> getPersonEntity(List<PersonaDTO> personas) {
		List<PersonaEntity> lp = new ArrayList<PersonaEntity>();

		for (PersonaDTO p : personas) {
			PersonaEntity pEntity = getPersonEntity(p);
			lp.add(pEntity);
		}

		return lp;
	}
	private PersonaEntity getPersonEntity (PersonaDTO p) {
		return PersonaEntity.builder()
				.id(p.getId())
				.nombre(p.getNombre())
				.apellido(p.getApellido())
				.tipoDocumento(p.getTipoDocumento())
				.nroDocumento(p.getNroDocumento())
				.nacionalidad(p.getNacionalidad())
				.sexo(p.getSexo())
				.fechaNacimiento(p.getFechaNacimiento())
				.email(p.getEmail())
				.nroTel(p.getNroTel())
			.build();
	}
	
	/**
	 * Convierte una personaEntity en PersonaDTO
	 * @param personas
	 * @return
	 */
	private List<PersonaDTO> getPersonDTO(List<PersonaEntity> personas) {
		List<PersonaDTO> lp = new ArrayList<PersonaDTO>();

		for (PersonaEntity p : personas) {
			PersonaDTO pDto = getPersonDTO(p);
			lp.add(pDto);
		}

		return lp;
	}
	private PersonaDTO getPersonDTO (PersonaEntity p) {
		return PersonaDTO.builder()
				.id(p.getId())
				.nombre(p.getNombre())
				.apellido(p.getApellido())
				.tipoDocumento(p.getTipoDocumento())
				.nroDocumento(p.getNroDocumento())
				.nacionalidad(p.getNacionalidad())
				.sexo(p.getSexo())
				.edad(p.getEdad())
				.fechaNacimiento(p.getFechaNacimiento())
				.email(p.getEmail())
				.nroTel(p.getNroTel())
			.build();
	}

    private Function<PersonaEntity, PersonaDTO> mapToPersonDTO = 
    		p -> PersonaDTO.builder()
    				.id(p.getId())
    				.nombre(p.getNombre())
    				.apellido(p.getApellido())
    				.tipoDocumento(p.getTipoDocumento())
    				.nroDocumento(p.getNroDocumento())
    				.nacionalidad(p.getNacionalidad())
    				.sexo(p.getSexo())
    				.edad(p.getEdad())
    				.fechaNacimiento(p.getFechaNacimiento())
    				.email(p.getEmail())
    				.nroTel(p.getNroTel())
    				
    				.parent(p.getParent())
    				.children(p.getChildren())
    			.build();

}
