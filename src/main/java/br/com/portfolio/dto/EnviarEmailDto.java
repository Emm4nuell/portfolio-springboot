package br.com.portfolio.dto;

import java.time.LocalDate;

import br.com.portfolio.entity.Enviaremail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnviarEmailDto {

	private Long id;
	private String nome;
	private String celular;
	private String email;
	private String mensagem;
	
	public Enviaremail toEnviarEmail(EnviarEmailDto dto) {
		Enviaremail entity = new Enviaremail(
				null, 
				dto.nome, 
				dto.celular, 
				dto.email, 
				dto.mensagem, 
				LocalDate.now());
		return entity;
	}
	
	public EnviarEmailDto(Enviaremail entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.celular = entity.getCelular();
		this.email = entity.getEmail();
		this.mensagem = entity.getMensagem();
	}
}
