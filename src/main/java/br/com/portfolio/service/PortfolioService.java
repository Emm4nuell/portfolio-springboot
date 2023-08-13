package br.com.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portfolio.dto.EnviarEmailDto;
import br.com.portfolio.entity.Enviaremail;
import br.com.portfolio.repository.EnviarEmailRepository;

@Service
public class PortfolioService {
	
	@Autowired
	private EnviarEmailRepository repository;
	
	@Transactional
	public Enviaremail save(EnviarEmailDto dto) {
		EnviarEmailDto emaildto = new EnviarEmailDto();
		Enviaremail entity = emaildto.toEnviarEmail(dto);
		return repository.save(entity);
	}
	
	/* Listar todas as visitas */
	public  List<EnviarEmailDto> findAll(){
		 List<Enviaremail> entity = repository.findAll();
		 List<EnviarEmailDto> dto = entity.stream().map(list -> new EnviarEmailDto(list)).collect(Collectors.toList());
		 return dto;
	}

	/* Faz uma pesquisa por id */
	public EnviarEmailDto findById(Long id) {
		Enviaremail entity = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", null));
		EnviarEmailDto dto = new EnviarEmailDto(entity);
		return dto;
	}

}
