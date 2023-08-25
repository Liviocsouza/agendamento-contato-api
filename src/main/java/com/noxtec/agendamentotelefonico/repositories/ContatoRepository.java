package com.noxtec.agendamentotelefonico.repositories;

import com.noxtec.agendamentotelefonico.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato,Long> {


     List<Contato> findByNome(String nome);

     List<Contato> findByTelefone(String telefone);

     List<Contato> findByNomeContains(String nome);
}
