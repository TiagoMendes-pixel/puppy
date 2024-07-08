package catioro.puppy.api.service;

import catioro.puppy.api.dto.CatioroDto;
import catioro.puppy.api.dto.CatioroListagemDto;

import java.util.List;

public interface CatioroService{

    void createCatioro(CatioroDto dadosDeCatioro);

    List<CatioroListagemDto> listarCatioro();

    CatioroListagemDto listarPorId(Long id);

    void deletarPorId(Long id);

    CatioroListagemDto atualizarPorId(Long id, CatioroDto dadosDeCatioro);
}
