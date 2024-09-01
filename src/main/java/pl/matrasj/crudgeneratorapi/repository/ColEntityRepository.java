package pl.matrasj.crudgeneratorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.matrasj.crudgeneratorapi.entity.ColEntity;

@Repository
public interface ColEntityRepository extends JpaRepository<ColEntity, Long> {
}
