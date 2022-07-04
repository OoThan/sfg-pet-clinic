package com.oothan.springdev.sfgpetclinic.repositories;

import com.oothan.springdev.sfgpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By oothan on Jun, 2022
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
