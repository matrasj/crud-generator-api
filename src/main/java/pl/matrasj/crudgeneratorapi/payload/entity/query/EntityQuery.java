package pl.matrasj.crudgeneratorapi.payload.entity.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityQuery {
    Long id;
    String name;
    String icon;
    boolean transition;
}
