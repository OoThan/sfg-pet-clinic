package com.oothan.springdev.sfgpetclinic.models;

/**
 * Created By oothan on Jun, 2022
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
