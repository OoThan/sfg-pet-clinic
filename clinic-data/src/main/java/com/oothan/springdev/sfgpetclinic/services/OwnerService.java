package com.oothan.springdev.sfgpetclinic.services;

import com.oothan.springdev.sfgpetclinic.models.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
