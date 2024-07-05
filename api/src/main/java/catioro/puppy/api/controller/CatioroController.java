package catioro.puppy.api.controller;

import catioro.puppy.api.dto.CatioroDto;
import catioro.puppy.api.dto.CatioroListagemDto;
import catioro.puppy.api.entity.CatioroEntity;
import catioro.puppy.api.repository.CatioroRepository;
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


    @PostMapping
    @Transactional
    public void createCatioro(@RequestBody CatioroDto dadosDeCatioro) {
        catioroRepository.save(new CatioroEntity(dadosDeCatioro));
    }


    @GetMapping
    public List<CatioroListagemDto> listar() {
        return catioroRepository.findAll().stream().map(CatioroListagemDto::new).toList();
    }

    @GetMapping("/{id}")
    public CatioroListagemDto listarPorId(@PathVariable Long id) {
        Optional<CatioroEntity> catioroEntity = catioroRepository.findById(id);
        return catioroEntity.map(CatioroListagemDto::new).orElse(null);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPorId(@PathVariable Long id) {
        CatioroEntity catioroEntity = catioroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Catioro not found"));
        catioroRepository.delete(catioroEntity);
    }

    @PutMapping("/{id}")
    @Transactional
    public CatioroListagemDto atualizarPorId(@PathVariable Long id, @RequestBody CatioroDto dadosDeCatioro) {
        CatioroEntity catioroEntity = catioroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Catioro not found"));

        catioroEntity.setName(dadosDeCatioro.getName());
        catioroEntity.setEmail(dadosDeCatioro.getEmail());
        catioroEntity.setPassword(dadosDeCatioro.getPassword());

        return new CatioroListagemDto(catioroEntity);
    }

}
