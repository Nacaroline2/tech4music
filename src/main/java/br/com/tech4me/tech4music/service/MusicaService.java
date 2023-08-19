package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.shared.MusicaDTO;

public interface MusicaService {

    List<MusicaDTO> listarTodas();
    Optional<Musica> listarPorId(String id);
    Musica cadastrar (Musica musica);
    Optional<Musica> atualizarPorId(String id, Musica musica);
    void excluirPorId(String id);
    
}
