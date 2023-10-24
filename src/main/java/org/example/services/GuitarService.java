package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.GuitarEntity;
import org.example.repositories.GuitarRepository;

/*
    Missed bean service
 */
@RequiredArgsConstructor
public class GuitarService {

    private final GuitarRepository repository;

    public void saveGuitar(GuitarEntity guitar) {
        repository.save(guitar);
    }

    public long getGuitarCount() {
        return repository.count();
    }
}
