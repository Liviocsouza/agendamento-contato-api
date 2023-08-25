package com.noxtec.agendamentotelefonico.controllers.service;

import com.noxtec.agendamentotelefonico.controllers.exceptionhandler.ContatoNotFoundException;
import com.noxtec.agendamentotelefonico.controllers.exceptionhandler.FavoritoExcpetion;
import com.noxtec.agendamentotelefonico.entities.Contato;
import com.noxtec.agendamentotelefonico.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ContatoService {

    @Autowired private ContatoRepository contatoRepository;


    public List<Contato> findAll(){
//        contatoRepository.findAll(Sort.by(Sort.Direction.DESC,"favorito"));
        return contatoRepository.findAll(Sort.by(Sort.Direction.DESC,"favorito"));
    }

    public Contato save(Contato contato) {
        contato.setData_cadastro(new Date());
        return contatoRepository.save(contato);
    }

    public Optional<Contato> findById(Long id) {
       return contatoRepository.findById(id);
    }

    public void delete(Contato contato) {
        contatoRepository.delete(contato);
    }

    public List<Contato> findByNome(String nome) {
        return contatoRepository.findByNomeContains(nome);
    }

    public List<Contato> findByTelefone(String telefone) {
        return contatoRepository.findByTelefone(telefone);
    }

    public Contato inativarAtivarContato(Long id, boolean status) {
        Optional<Contato>contatoOpcional = contatoRepository.findById(id);
        if(!contatoOpcional.isEmpty()){
            Contato contato = contatoOpcional.get();
            contato.setAtivo(status);
            contatoRepository.save(contato);
            return contato;
        }
        throw new ContatoNotFoundException();

    }

    public Contato favoritarContato(Long id) {
        List<Contato> allContatos = contatoRepository.findAll();
        if(allContatos.size() > 0){
            for(Contato contato: allContatos){
                if(contato.isFavorito()){
                    contato.setFavorito(false);
                    contatoRepository.save(contato);
                }
            }
            Optional<Contato>contatoOpcional = contatoRepository.findById(id);
            if(!contatoOpcional.isEmpty()){
                Contato contato = contatoOpcional.get();
                contato.setFavorito(true);
                contatoRepository.save(contato);
                return contato;
            }

        }
        throw new ContatoNotFoundException();

    }
}
