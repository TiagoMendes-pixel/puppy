package catioro.puppy.api.repository;

import catioro.puppy.api.entity.CatioroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatioroRepository  extends JpaRepository<CatioroEntity, Long> {

}
