package com.agro.bsv.dao.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EstadisticaEntity 
{
	
	@JsonAlias("cantidad_mujeres")
	private Long cantidadMujeres;

	@JsonAlias("cantidad_hombres")
	private Long cantidadHombres;
	

	@JsonAlias("porcentaje_argentinos")
	private Float porcentajeArgentinos;
	
	
}
