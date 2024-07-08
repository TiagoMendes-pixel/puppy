package catioro.puppy.api.serviceImpl;

import catioro.puppy.api.dto.CatioroDto;
import catioro.puppy.api.dto.CatioroListagemDto;
import catioro.puppy.api.entity.CatioroEntity;
import catioro.puppy.api.mapper.CatioroMapper;
import catioro.puppy.api.repository.CatioroRepository;
import catioro.puppy.api.service.CatioroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CatioroServiceImpl implements CatioroService {

    @Autowired
    private CatioroRepository catioroRepository;

    private final CatioroMapper catioroMapper = CatioroMapper.INSTANCE;

    @Override
    public void createCatioro(CatioroDto dadosDeCatioro) {

        CatioroEntity catioroEntity = catioroMapper.toEntity(dadosDeCatioro);
        catioroRepository.save(catioroEntity);
    }

    @Override
    public List<CatioroListagemDto> listarCatioro() {
        List<CatioroEntity> entities = catioroRepository.findAll();
        return catioroMapper.toListagemDtoList(entities);
    }

    @Override
    public CatioroListagemDto listarPorId(Long id) {
        Optional<CatioroEntity> catioroEntity = catioroRepository.findById(id);
        return catioroEntity.map(catioroMapper::toListagemDto).orElse(null);
    }

    @Override
    public void deletarPorId(Long id) {
        CatioroEntity catioroEntity = catioroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Catioro not found"));
        catioroRepository.delete(catioroEntity);
    }

    @Override
    public CatioroListagemDto atualizarPorId(Long id, CatioroDto dadosDeCatioro) {
        CatioroEntity catioroEntity = catioroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Catioro not found"));

        catioroMapper.updateEntityFromDto(dadosDeCatioro, catioroEntity);
        catioroRepository.save(catioroEntity);

        return catioroMapper.toListagemDto(catioroEntity);
    }



}
