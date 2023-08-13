package br.com.portfolio.controller;

import java.net.URI;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.portfolio.dto.EnviarEmailDto;
import br.com.portfolio.service.PortfolioService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RestController
public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;

	@GetMapping("status")
	public String status(){
		return "Status API Portfólio";
	}
	
	@PostMapping
	public ResponseEntity<EnviarEmailDto> save(@RequestBody EnviarEmailDto dto){
		
		portfolioService.save(dto);
//		URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("nome={nome}")
//				.buildAndExpand(dto.getNome()).toUri();
		System.out.println(dto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<EnviarEmailDto>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(portfolioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnviarEmailDto> findById(@PathVariable("id") Long id) throws AccountNotFoundException{
		return ResponseEntity.ok().body(portfolioService.findById(id));	
	}
	
}
