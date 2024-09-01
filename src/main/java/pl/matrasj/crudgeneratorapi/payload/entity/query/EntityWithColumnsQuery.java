package pl.matrasj.crudgeneratorapi.payload.entity.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matrasj.crudgeneratorapi.payload.col.query.ColQuery;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityWithColumnsQuery {
    Long id;
    String name;
    String icon;
    boolean transition;
    List<ColQuery> cols;
}
