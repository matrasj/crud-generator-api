package pl.matrasj.crudgeneratorapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.matrasj.crudgeneratorapi.entity.ColEntity;
import pl.matrasj.crudgeneratorapi.entity.EntityEntity;
import pl.matrasj.crudgeneratorapi.mapper.EntityEntityMapper;
import pl.matrasj.crudgeneratorapi.payload.entity.command.SaveEntityCommand;
import pl.matrasj.crudgeneratorapi.payload.entity.query.EntityQuery;
import pl.matrasj.crudgeneratorapi.repository.ColEntityRepository;
import pl.matrasj.crudgeneratorapi.repository.EntityEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EntityEntityService {
    EntityEntityRepository entityEntityRepository;
    ColEntityRepository colEntityRepository;

    @Transactional
    public EntityQuery saveEntity(SaveEntityCommand command) {
        EntityEntity entityEntity = command.getId() != null ? entityEntityRepository.findById(command.getId())
                .orElseThrow(EntityNotFoundException::new) : new EntityEntity();

        entityEntity.setName(command.getEntityName());
        entityEntity.setIcon(command.getIcon());
        entityEntity.setTransition(command.isTransitable());

        EntityEntity createdEntity = entityEntityRepository.save(entityEntity);
        List<ColEntity> savedCols = colEntityRepository.saveAll(command.getCols().stream().map(col -> ColEntity.builder()
                .id(col.getId())
                .name(col.getName())
                .entityId(createdEntity.getId())
                .columnDataType(col.getColumnDataType())
                .foreignKeyId(col.getForeignKeyId())
                .build()).collect(Collectors.toList()));
        entityEntity.setCols(savedCols);
        return EntityEntityMapper.toQuery(entityEntity);
    }
}
