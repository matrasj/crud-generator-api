package pl.matrasj.crudgeneratorapi.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.matrasj.crudgeneratorapi.mapper.EntityEntityMapper;
import pl.matrasj.crudgeneratorapi.payload.entity.command.SaveEntityCommand;
import pl.matrasj.crudgeneratorapi.payload.entity.query.EntityQuery;
import pl.matrasj.crudgeneratorapi.payload.entity.query.EntityWithColumnsQuery;
import pl.matrasj.crudgeneratorapi.repository.EntityEntityRepository;
import pl.matrasj.crudgeneratorapi.service.EntityEntityService;

import java.util.List;

@RestController
@RequestMapping("/api/entity")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin
public class EntityEntityController {
    EntityEntityService entityEntityService;
    EntityEntityRepository entityEntityRepository;

    @PostMapping
    public ResponseEntity<EntityQuery> save(@RequestBody @Valid SaveEntityCommand command) {
        return ResponseEntity.ok(entityEntityService.saveEntity(command));
    }

    @GetMapping
    public ResponseEntity<List<EntityQuery>> findAll() {
        return ResponseEntity.ok(EntityEntityMapper.toQuery(entityEntityRepository.findAll()));
    }

    @GetMapping("/{entityId}")
    public ResponseEntity<EntityWithColumnsQuery> findById(@PathVariable Long entityId) {
        return ResponseEntity.ok(EntityEntityMapper.toWithColumnsQuery(entityEntityRepository.findById(entityId)
                .orElseThrow(EntityNotFoundException::new)));
    }
}
