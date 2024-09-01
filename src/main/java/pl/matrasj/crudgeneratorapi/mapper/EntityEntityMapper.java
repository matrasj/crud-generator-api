package pl.matrasj.crudgeneratorapi.mapper;

import pl.matrasj.crudgeneratorapi.entity.EntityEntity;
import pl.matrasj.crudgeneratorapi.payload.entity.query.EntityQuery;
import pl.matrasj.crudgeneratorapi.payload.entity.query.EntityWithColumnsQuery;

import java.util.List;
import java.util.stream.Collectors;

public class EntityEntityMapper {
    public static EntityQuery toQuery(final EntityEntity entity) {
        return EntityQuery.builder()
                .id(entity.getId())
                .name(entity.getName())
                .icon(entity.getIcon())
                .transition(entity.isTransition())
                .build();
    }

    public static List<EntityQuery> toQuery(final List<EntityEntity> entities) {
        return entities.stream().map(EntityEntityMapper::toQuery).collect(Collectors.toList());
    }

    public static EntityWithColumnsQuery toWithColumnsQuery(final EntityEntity entity) {
        return EntityWithColumnsQuery.builder()
                .id(entity.getId())
                .name(entity.getName())
                .icon(entity.getIcon())
                .transition(entity.isTransition())
                .cols(ColEntityMapper.toQuery(entity.getCols()))
                .build();
    }
}
