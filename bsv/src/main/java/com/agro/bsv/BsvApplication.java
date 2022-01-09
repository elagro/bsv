package com.agro.bsv;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableJpaAuditing
@EntityScan({ "com.agro.*" })
@ComponentScan({ "com.agro.*" })
//@Log4j2
public class BsvApplication //implements CommandLineRunner 
{

	@Autowired(required = true)
	//private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(BsvApplication.class, args);

	}

	/*@Override
	public void run(String... args) throws ContactoPersonaNoDefinidoException {

		log.info("Inicio");

		Boolean noUsar = false;
		Boolean noUsar2 = false;

		if (noUsar) {
			PersonaEntity p1 = new PersonaEntity();

			p1.setNombre("Lucas");
			p1.setApellido("Agro");
			p1.setTipoDocumento(TipoDocumentoEnum.DU);
			p1.setNroDocumento("30555999");
			p1.setNacionalidad(CountryCodeEnum.AR);
			// p1.setNacionalidadEnum(NacionalidadEnum.REPUBICA_DEMOCRATICA_DEL_CONGO);
			p1.setSexo(SexoEnum.M);
			p1.setFechaNacimiento(LocalDate.of(1983, 10, 28));
			p1.setNroTel("15333999888");
			p1.setEmail("Pepegril@agro.com.ar");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Lucas");
			p1.setApellido("Agro");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("23304479876");
			p1.setNacionalidad(CountryCodeEnum.AR);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 10, 28));
			p1.setNroTel("15333999888");
			p1.setEmail("pepe@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Alfredo");
			p1.setApellido("Membrillo");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("239874562");
			p1.setNacionalidad(CountryCodeEnum.AR);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 10, 28));
			p1.setNroTel("157894512");
			p1.setEmail("qwerty@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Lucas");
			p1.setApellido("Agro");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("211234565");
			p1.setNacionalidad(CountryCodeEnum.AR);
			p1.setSexo(SexoEnum.M);
			p1.setFechaNacimiento(LocalDate.of(1998, 10, 28));
			p1.setNroTel("15333999888");
			p1.setEmail("pepe@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Lucas");
			p1.setApellido("Agro");
			p1.setTipoDocumento(TipoDocumentoEnum.DU);
			p1.setNroDocumento("23456788");
			p1.setNacionalidad(CountryCodeEnum.BR);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 1, 28));
			p1.setNroTel("789451");
			p1.setEmail("zxcvb@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Cris");
			p1.setApellido("Tian");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("205558879");
			p1.setNacionalidad(CountryCodeEnum.CL);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 10, 28));
			p1.setNroTel("4545454");
			p1.setEmail("poiuy@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Este");
			p1.setApellido("O'Este");
			p1.setTipoDocumento(TipoDocumentoEnum.NIF);
			p1.setNroDocumento("A-467852");
			p1.setNacionalidad(CountryCodeEnum.ES);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 10, 28));
			p1.setNroTel("15333999888");
			p1.setEmail("pepe@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("pepe");
			p1.setApellido("lepú");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("12332133");
			p1.setNacionalidad(CountryCodeEnum.AR);
			p1.setSexo(SexoEnum.M);
			p1.setFechaNacimiento(LocalDate.of(1952, 2, 1));
			p1.setNroTel("15458754");
			p1.setEmail("zorri@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Rin");
			p1.setApellido("TinTin");
			p1.setTipoDocumento(TipoDocumentoEnum.CL);
			p1.setNroDocumento("22115544");
			p1.setNacionalidad(CountryCodeEnum.AR);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(2000, 10, 28));
			p1.setNroTel("+5411 11445489");
			p1.setEmail("Rin@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Ron");
			p1.setApellido("Con Coca");
			p1.setTipoDocumento(TipoDocumentoEnum.CT);
			p1.setNroDocumento("2330457221");
			p1.setNacionalidad(CountryCodeEnum.FR);
			p1.setSexo(SexoEnum.F);
			p1.setFechaNacimiento(LocalDate.of(1954, 05, 15));
			p1.setNroTel("46-467-447");
			p1.setEmail("Hola@grillo.com");

			personaService.save(p1);

			/////////////////
			p1 = new PersonaEntity();
			p1.setNombre("Charly");
			p1.setApellido("W");
			p1.setTipoDocumento(TipoDocumentoEnum.NIF);
			p1.setNroDocumento("N1233213");
			p1.setNacionalidad(CountryCodeEnum.UY);
			p1.setSexo(SexoEnum.M);
			p1.setFechaNacimiento(LocalDate.of(1999, 9, 5));
			p1.setNroTel("47025487");
			p1.setEmail("poodosoad@grillo.com");

			personaService.save(p1);
		}


		if (noUsar2) {
			////////////////////////////////////////////////////////////////////////////////////
	
			PersonaEntity p2;
	
			////////////////////////////////////////////////////////////
			p2 = new PersonaEntity();
			p2.setNombre("Lucas");
			p2.setApellido("Agro");
			p2.setTipoDocumento(TipoDocumentoEnum.DU);
			p2.setNroDocumento("30333333");
			p2.setNacionalidad(CountryCodeEnum.AR);
			p2.setSexo(SexoEnum.M);
			p2.setFechaNacimiento(LocalDate.of(1983, 10, 28));
			p2.setNroTel("3333333333");
			p2.setEmail("lucas@agro.com.ar");
			PersonaEntity persLucas = personaService.save(p2);
	
			////////////////////////////////////////////////////////////
			p2 = new PersonaEntity();
			p2.setNombre("Euge");
			p2.setApellido("Agro");
			p2.setTipoDocumento(TipoDocumentoEnum.DU);
			p2.setNroDocumento("28333333");
			p2.setNacionalidad(CountryCodeEnum.AR);
			p2.setSexo(SexoEnum.F);
			p2.setFechaNacimiento(LocalDate.of(1979, 03, 04));
			p2.setNroTel("4444444444");
			p2.setEmail("euge@agro.com.ar");
			PersonaEntity persEuge = personaService.save(p2);
	
			////////////////////////////////////////////////////////////
			p2 = new PersonaEntity();
			p2.setNombre("Antonio");
			p2.setApellido("Agro");
			p2.setTipoDocumento(TipoDocumentoEnum.DU);
			p2.setNroDocumento("90111111");
			p2.setNacionalidad(CountryCodeEnum.ES);
			p2.setSexo(SexoEnum.M);
			p2.setFechaNacimiento(LocalDate.of(1950, 4, 9));
			p2.setNroTel("1111111111");
			p2.setEmail("anto@agro.com.ar");
			PersonaEntity persAnto = personaService.save(p2);
	
			////////////////////////////////////////////////////////////
			p2 = new PersonaEntity();
			p2.setNombre("Bety");
			p2.setApellido("Gamp");
			p2.setTipoDocumento(TipoDocumentoEnum.DU);
			p2.setNroDocumento("05222222");
			p2.setNacionalidad(CountryCodeEnum.AR);
			p2.setSexo(SexoEnum.F);
			p2.setFechaNacimiento(LocalDate.of(1947, 9, 11));
			p2.setNroTel("2222222222");
			p2.setEmail("bety@gamp.com.ar");
			PersonaEntity persBety = personaService.save(p2);
	
			Set<PersonaEntity> hijosBetyAnto = new HashSet<PersonaEntity>();
			hijosBetyAnto.add(persLucas);
			hijosBetyAnto.add(persEuge);
			persAnto.setChildren(hijosBetyAnto);
			persBety.setChildren(hijosBetyAnto);
	
			persLucas.setParent(persBety);
			persEuge.setParent(persBety);
	
			personaService.save(persEuge);
			personaService.save(persLucas);
			personaService.save(persAnto);
			personaService.save(persBety);
	
			// p1.setNroTel("1111");
			// personaService.save(p1);
			// personaService.deleteById(1L);
			// log.info(personaService.findById(2L));
		}
	}
*/
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.failOnEmptyBeans(false);
		b.failOnUnknownProperties(false);
		b.dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		return b;
	}

}
