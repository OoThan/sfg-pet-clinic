package com.oothan.springdev.sfgpetclinic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created By oothan on Jun, 2022
 */
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
