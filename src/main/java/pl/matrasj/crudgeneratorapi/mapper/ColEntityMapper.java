package pl.matrasj.crudgeneratorapi.mapper;

import pl.matrasj.crudgeneratorapi.entity.ColEntity;
import pl.matrasj.crudgeneratorapi.payload.col.query.ColQuery;

import java.util.List;
import java.util.stream.Collectors;

public class ColEntityMapper {
    public static ColQuery toQuery(final ColEntity colEntity) {
        return ColQuery.builder()
                .id(colEntity.getId())
                .name(colEntity.getName())
                .columnDataType(colEntity.getColumnDataType())
                .entityId(colEntity.getEntityId())
                .foreignKeyId(colEntity.getForeignKeyId())
                .build();
    }

    public static List<ColQuery> toQuery(final List<ColEntity> colEntityList) {
        return colEntityList.stream().map(ColEntityMapper::toQuery).collect(Collectors.toList());
    }
}
