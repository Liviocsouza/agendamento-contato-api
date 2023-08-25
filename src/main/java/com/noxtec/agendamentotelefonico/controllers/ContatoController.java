package com.noxtec.agendamentotelefonico.controllers;

import com.noxtec.agendamentotelefonico.entities.Contato;
import com.noxtec.agendamentotelefonico.controllers.service.ContatoService;
import com.noxtec.agendamentotelefonico.controllers.exceptionhandler.ContatoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/all-contatos")
    public List<Contato> getAllContatos(){
        return contatoService.findAll();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contato cadastrar(@RequestBody Contato contato) {
            Contato contatoCriado = contatoService.save(contato);
            return contatoCriado;
    }
    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id) {
        Optional<Contato> contatoOptional = contatoService.findById(id);
        return contatoOptional.orElseThrow(() -> new ContatoNotFoundException());

    }
    @GetMapping("/buscar/nome")
    public List<Contato> buscarPorNome(@RequestParam String nome) {
        List<Contato> contatoOptional = contatoService.findByNome(nome);
        if(contatoOptional.size()== 0){
            throw new ContatoNotFoundException();
        }
        return contatoOptional;

    }
    @GetMapping("/buscar")
    public List<Contato> buscarPorTelefone(@RequestParam String telefone) {
        List<Contato> contatoOptional = contatoService.findByTelefone(telefone);
        if(contatoOptional.size()== 0){
            throw new ContatoNotFoundException();
        }
        return contatoOptional;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        Optional<Contato> contatoOptional = contatoService.findById(id);
        if (contatoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        contatoService.delete(contatoOptional.get());
    }

    @PutMapping("/{id}")
    public Contato atualizarPorId(@PathVariable Long id, @RequestBody Contato contato) {
        Optional<Contato> contatoOptional = contatoService.findById(id);
        if (contatoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        contato.setId(id);

        return contatoService.save(contato);
    }

    @PutMapping("/status/{id}")
    public Contato statusContato(@PathVariable Long id, @RequestParam boolean status) {
        Contato contato = contatoService.inativarAtivarContato(id,status);
        return contato;
    }
    @PutMapping("/favoritar/{id}")
    public Contato favoritarContato(@PathVariable Long id) {
        Contato contato = contatoService.favoritarContato(id);
        return contato;
    }

}
