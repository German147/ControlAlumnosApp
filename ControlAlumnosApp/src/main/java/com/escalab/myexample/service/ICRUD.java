package com.escalab.myexample.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICRUD<T> {

    T create(T object);

    T update(T object,Integer id);

    List<T> findAll();

    T findById(Integer id);

    ResponseEntity<Object> deleteById(Integer id);


}
