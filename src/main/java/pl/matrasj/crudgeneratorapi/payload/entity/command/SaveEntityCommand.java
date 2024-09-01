package pl.matrasj.crudgeneratorapi.payload.entity.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matrasj.crudgeneratorapi.payload.col.command.SaveColCommand;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveEntityCommand {
    Long id;
    @NotBlank String entityName;
    String icon;
    boolean transitable;
    @NotNull List<SaveColCommand> cols;
}
