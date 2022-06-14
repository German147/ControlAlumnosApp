package com.escalab.myexample.service;

import com.escalab.myexample.entity.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu>{

    List<Menu> listarElMenuDeUsuarioPorNombre(String name);
}
