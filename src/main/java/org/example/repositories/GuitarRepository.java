package org.example.repositories;

import org.example.entities.GuitarEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuitarRepository extends CrudRepository<GuitarEntity, Long> {

}