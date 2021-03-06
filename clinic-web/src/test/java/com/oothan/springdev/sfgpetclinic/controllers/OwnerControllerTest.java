package com.oothan.springdev.sfgpetclinic.controllers;

import com.oothan.springdev.sfgpetclinic.models.Owner;
import com.oothan.springdev.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created By oothan on Jul, 2022
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

   @Mock
   OwnerService ownerService;

   @InjectMocks
   OwnerController controller;

   Set<Owner> owners;

   MockMvc mockMvc;

    @BeforeEach
    void setUp() {
       owners = new HashSet<>();
       owners.add(Owner.builder().id(1L).build());
       owners.add(Owner.builder().id(2L).build());

       mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
       when(ownerService.findAll()).thenReturn(owners);

       mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/index"))
               .andExpect(model().attribute("owners", hasSize(2)));
    }

   @Test
   void listOwnersByIndex() throws Exception {
      when(ownerService.findAll()).thenReturn(owners);

      mockMvc.perform(get("/owners/index"))
              .andExpect(status().isOk())
              .andExpect(view().name("owners/index"))
              .andExpect(model().attribute("owners", hasSize(2)));
   }

    @Test
    void findOwners() throws Exception {
       mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("not-implement"));
       verifyNoInteractions(ownerService);
    }

    @Test
    void displayOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/owner-details"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }
}