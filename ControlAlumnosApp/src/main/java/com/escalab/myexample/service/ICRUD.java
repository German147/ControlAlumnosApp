package com.escalab.myexample.service;

import java.util.List;

public interface ICRUD<T> {

    T create(T object);

    T update(T object,Integer id);

    List<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);

}
