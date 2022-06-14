package com.escalab.myexample.controller;

import com.escalab.myexample.entity.Menu;
import com.escalab.myexample.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService iMenuService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> listarMenu() {
        List<Menu> menues = new ArrayList<>();
        menues = iMenuService.findAll();
        return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
    }

@PostMapping(value = "/menuPorUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> listarPorUsuario(@RequestBody String name) {
        List<Menu> menues = new ArrayList<>();
        menues = iMenuService.listarElMenuDeUsuarioPorNombre(name);
        return new ResponseEntity<List<Menu>>(menues,HttpStatus.OK);
    }
}
