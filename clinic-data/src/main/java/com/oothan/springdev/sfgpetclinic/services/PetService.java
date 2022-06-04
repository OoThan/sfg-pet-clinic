package com.oothan.springdev.sfgpetclinic.services;

import com.oothan.springdev.sfgpetclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
