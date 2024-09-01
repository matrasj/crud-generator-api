package pl.matrasj.crudgeneratorapi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import pl.matrasj.crudgeneratorapi.type.ColumnDataType;

@Entity
@Table(name = "col")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ColEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "entity_id")
    Long entityId;
    @Column(name = "column_data_type")
    @Enumerated(EnumType.STRING)
    ColumnDataType columnDataType;
    @Column(name = "foreign_key_id")
    Long foreignKeyId;
}
