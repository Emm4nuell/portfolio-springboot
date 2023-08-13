package br.com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portfolio.entity.Enviaremail;

@Repository
public interface EnviarEmailRepository extends JpaRepository<Enviaremail, Long> {

}
