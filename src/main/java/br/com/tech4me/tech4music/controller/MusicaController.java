package br.com.tech4me.tech4music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDTO;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    
    @Autowired
    private MusicaService servico;

    // CREATED
    @PostMapping
    private ResponseEntity<Musica> cadastrarMusica(@RequestBody Musica musica){
       return new ResponseEntity<>(servico.cadastrar(musica), HttpStatus.CREATED); 
    }
    //READ - GERAL
    @GetMapping
    private ResponseEntity<List<MusicaDTO>> listarMusica(){
        return new ResponseEntity<>(servico.listarTodas(), HttpStatus.OK);
    }
    //READ - POR ID
    @GetMapping("/{id}")
    private ResponseEntity<Musica> listarMusicaPorId(@PathVariable String id){
        if (servico.listarPorId(id).isPresent()) {
            return new ResponseEntity<>(servico.listarPorId(id).get(), HttpStatus.OK);
        } return new ResponseEntity<Musica>(HttpStatus.NOT_FOUND);
    }
    //UPDATE 
    @PutMapping("/{id}")
    private ResponseEntity<Musica> atualizarMusica(@PathVariable String id,
                                                    @RequestBody Musica musica){
        Optional<Musica> musicaAtualizar = servico.atualizarPorId(id, musica);

        if (musicaAtualizar.isPresent()) {
            return new ResponseEntity<>(musicaAtualizar.get(), HttpStatus.OK);           
        }return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     //DELETE
     @DeleteMapping("/{id}")
     private ResponseEntity<Void> excluirMusicaPorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
