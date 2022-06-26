package com.oothan.springdev.sfgpetclinic.repositories;

import com.oothan.springdev.sfgpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By oothan on Jun, 2022
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
