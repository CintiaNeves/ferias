package br.com.cintia.ferias.util;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@MappedSuperclass
public class EntidadeDominio {
	
	@GenericGenerator(name="optimized-sequence", strategy="enhanced-sequence",
			parameters = {
					@Parameter(name="prefer_sequence_per_entity", value="true"),
					@Parameter(name="optimizer", value="hilo")})
	@GeneratedValue(generator="optimized-sequence")
	@Id
	private Long id;
}
