package pl.matrasj.crudgeneratorapi.payload.col.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matrasj.crudgeneratorapi.type.ColumnDataType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColQuery {
    Long id;
    String name;
    Long entityId;
    ColumnDataType columnDataType;
    Long foreignKeyId;
}
