package catioro.puppy.api.mapper;

import catioro.puppy.api.dto.CatioroDto;
import catioro.puppy.api.dto.CatioroListagemDto;
import catioro.puppy.api.entity.CatioroEntity;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CatioroMapper {


    CatioroMapper INSTANCE = Mappers.getMapper(CatioroMapper.class);

    CatioroDto toDto(CatioroEntity entity);

    CatioroEntity toEntity(CatioroDto dto);

    CatioroListagemDto toListagemDto(CatioroEntity entity);

    List<CatioroListagemDto> toListagemDtoList(List<CatioroEntity> entities);

    void updateEntityFromDto(CatioroDto dto, @MappingTarget CatioroEntity entity);
}
