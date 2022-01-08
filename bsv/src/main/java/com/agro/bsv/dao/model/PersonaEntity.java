package com.agro.bsv.dao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.agro.bsv.dao.model.enums.CountryCodeEnum;
import com.agro.bsv.dao.model.enums.SexoEnum;
import com.agro.bsv.dao.model.enums.TipoDocumentoEnum;
import com.agro.bsv.dao.model.validation.ValidateEdad;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "personas",
			uniqueConstraints=
			@UniqueConstraint(columnNames = {"tipoDocumento", "nroDocumento","sexo","nacionalidad"}))
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PersonaEntity extends AuditModel 
implements Serializable 
{
	
	private static final long serialVersionUID = 212999738980047714L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@NotBlank @Size(max = 100)
	private String nombre;
	
	@NotBlank @Size(max = 100)
	private String apellido;

	
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private TipoDocumentoEnum tipoDocumento;
	
	@NotBlank @Size(max = 30)
	private String nroDocumento;

	
	@NotNull 
	@Enumerated(value = EnumType.STRING)
	private CountryCodeEnum nacionalidad;
	
	
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private SexoEnum sexo;
	
	
	//@NotBlank
	//private int edad;
	@JsonAlias ("edad")
    public Integer getEdad() {
    	
		LocalDate curDate = LocalDate.now();  
		  
		if ((this.fechaNacimiento != null) && (curDate != null)){  
			return Period.between(this.fechaNacimiento, curDate).getYears();
		}
		return null;
    }
	
	@NotNull(message = "Ingrese la fecha de nacimiento") 
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@ValidateEdad(18)
	@Past
	private LocalDate fechaNacimiento;

	
	@NotBlank @Size(max = 100)
	@Email
    private String email;
	

	@NotBlank @Size(max = 50)
    private String nroTel;
    
	


	@ManyToOne(fetch = FetchType.LAZY)
	private PersonaEntity parent;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Setter @Getter
	private Set<PersonaEntity> children;
	

    /*
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
     */
}
