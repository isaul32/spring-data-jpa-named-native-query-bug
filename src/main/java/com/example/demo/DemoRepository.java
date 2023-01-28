package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoRepository extends CrudRepository<Demo, Long> {

  List<DemoPojo> findAllCustom();
}
