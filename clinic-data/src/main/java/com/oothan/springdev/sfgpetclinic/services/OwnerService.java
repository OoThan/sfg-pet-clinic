package com.oothan.springdev.sfgpetclinic.services;

import com.oothan.springdev.sfgpetclinic.models.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
