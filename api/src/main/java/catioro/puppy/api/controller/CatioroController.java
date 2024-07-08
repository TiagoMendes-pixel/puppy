package catioro.puppy.api.controller;

import catioro.puppy.api.dto.CatioroDto;
import catioro.puppy.api.dto.CatioroListagemDto;
import catioro.puppy.api.entity.CatioroEntity;
import catioro.puppy.api.repository.CatioroRepository;
import catioro.puppy.api.service.CatioroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dogs")
public class CatioroController {

    @Autowired
    private CatioroRepository catioroRepository;

    CatioroService catioroService;


    @PostMapping
    @Transactional
    public void createCatioro(@RequestBody CatioroDto dadosDeCatioro) {
       catioroService.createCatioro(dadosDeCatioro);
    }


    @GetMapping
    public List<CatioroListagemDto> listar() {
        return catioroService.listarCatioro();
    }

    @GetMapping("/{id}")
    public CatioroListagemDto listarPorId(@PathVariable Long id) {
        return catioroService.listarPorId(id);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPorId(@PathVariable Long id) {
        catioroService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public CatioroListagemDto atualizarPorId(@PathVariable Long id, @RequestBody CatioroDto dadosDeCatioro) {

        return catioroService.atualizarPorId(id, dadosDeCatioro);
    }

}
