package br.com.portfolio.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enviaremail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotNull(message = "Campo nome obrigatório!")
	@Size(min = 6, max = 50)
	private String nome;
	
	@NotNull(message = "Campo celular obrigatório!")
	private String celular;
	
	@NotNull(message = "Campo email obrigatório!")
	private String email;
	
	@NotNull
	private String mensagem;
	
	private LocalDate dataEnviado;
}
