package pl.matrasj.crudgeneratorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.matrasj.crudgeneratorapi.entity.EntityEntity;

@Repository
public interface EntityEntityRepository extends JpaRepository<EntityEntity, Long> {
}
