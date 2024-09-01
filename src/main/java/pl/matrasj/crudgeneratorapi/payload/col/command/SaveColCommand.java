package pl.matrasj.crudgeneratorapi.payload.col.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matrasj.crudgeneratorapi.type.ColumnDataType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveColCommand {
    Long id;
    @NotBlank String name;
    @NotNull
    ColumnDataType columnDataType;
    @NotNull Long entityId;
    Long foreignKeyId;
}
