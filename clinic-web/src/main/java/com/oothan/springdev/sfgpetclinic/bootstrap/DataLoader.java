package com.oothan.springdev.sfgpetclinic.bootstrap;

import com.oothan.springdev.sfgpetclinic.models.Owner;
import com.oothan.springdev.sfgpetclinic.models.Pet;
import com.oothan.springdev.sfgpetclinic.models.PetType;
import com.oothan.springdev.sfgpetclinic.models.Vet;
import com.oothan.springdev.sfgpetclinic.services.OwnerService;
import com.oothan.springdev.sfgpetclinic.services.PetTypeService;
import com.oothan.springdev.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Khine");
        owner1.setLastName("Khine");
        owner1.setAddress("123 Lanmataw");
        owner1.setCity("Sittwe");
        owner1.setTelephone("1234555553");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Meow Meow");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Hla");
        owner2.setLastName("Hla");
        owner2.setAddress("123 Lanmataw");
        owner2.setCity("Sittwe");
        owner2.setTelephone("1234555553");

        Pet fionasCat = new Pet();
        fionasCat.setName("Cattie");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jim");
        vet2.setLastName("Jackie");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
