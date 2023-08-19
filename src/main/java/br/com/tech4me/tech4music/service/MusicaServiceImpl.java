package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDTO;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repositorio;

    //CREATED
    @Override
    public Musica cadastrar(Musica musica) {
        return repositorio.save(musica);
    }
    //READ - GERAL
    @Override
    public List<MusicaDTO> listarTodas() {
        return repositorio.findAll()
                            .stream().map(m -> new MusicaDTO(m.getId(), m.getTitulo(),
                            m.getArtista(), m.getAlbum(),m.getGenero(), m.getAnoLancamento(), m.getCompositor())).toList();
    }
    //READ - POR ID
    @Override
    public Optional<Musica> listarPorId(String id) {
        return repositorio.findById(id);
    }
    //UPDATE
    @Override
    public Optional<Musica> atualizarPorId(String id, Musica musica) {
        Optional<Musica> musicaAtualizar = repositorio.findById(id);

        if (musicaAtualizar.isPresent()) {
            musica.setId(id);
            repositorio.save(musica);  
        }return musicaAtualizar;
    }
    //DELETE
    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
