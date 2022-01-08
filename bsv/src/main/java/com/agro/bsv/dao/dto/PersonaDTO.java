package com.agro.bsv.dao.dto;

import java.time.LocalDate;
import java.util.Set;

import com.agro.bsv.dao.model.PersonaEntity;
import com.agro.bsv.dao.model.enums.CountryCodeEnum;
import com.agro.bsv.dao.model.enums.SexoEnum;
import com.agro.bsv.dao.model.enums.TipoDocumentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming//(value = PropertyNamingStrategy.PropertyNamingStrategyBase.class)
@JsonIgnoreProperties({ "hibernate_lazy_initializer", "handler" })
public class PersonaDTO {
	private Long id;
	private String nombre;
	private String apellido;

	private TipoDocumentoEnum tipoDocumento;
	private String nroDocumento;
	private CountryCodeEnum nacionalidad;
	private SexoEnum sexo;
	private int edad;
	private LocalDate fechaNacimiento;
	private String email;
	private String nroTel;

	private PersonaEntity parent;
	private Set<PersonaEntity> children;
}
