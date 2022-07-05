package com.oothan.springdev.sfgpetclinic.services.springdatajpa;

import com.oothan.springdev.sfgpetclinic.models.Visit;
import com.oothan.springdev.sfgpetclinic.repositories.VisitRepository;
import com.oothan.springdev.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By oothan on Jul, 2022
 */
@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

 private final VisitRepository visitRepository;

 public VisitSDJpaService(VisitRepository visitRepository) {
  this.visitRepository = visitRepository;
 }

 @Override
 public Set<Visit> findAll() {
  Set<Visit> visits = new HashSet<>();
  visitRepository.findAll().forEach(visits::add);
  return visits;
 }

 @Override
 public Visit findById(Long aLong) {
  return visitRepository.findById(aLong).orElse(null);
 }

 @Override
 public Visit save(Visit object) {
  return visitRepository.save(object);
 }

 @Override
 public void delete(Visit object) {
  visitRepository.delete(object);
 }

 @Override
 public void deleteById(Long aLong) {
  visitRepository.deleteById(aLong);
 }
}
