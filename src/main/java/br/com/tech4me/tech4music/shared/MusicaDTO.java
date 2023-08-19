package br.com.tech4me.tech4music.shared;

public record MusicaDTO (String id,
                            String titulo,
                                String artista,
                                    String album,
                                        String genero,
                                            String anoLancamento,
                                                String compositor) {
    
}
