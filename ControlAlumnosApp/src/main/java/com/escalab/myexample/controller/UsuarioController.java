package com.escalab.myexample.controller;

import com.escalab.myexample.entity.Usuario;

import com.escalab.myexample.service.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario")
    public @ResponseBody
    List<Usuario> finfAllUuarios(){
        return usuarioService.findAll();
    }

    @GetMapping("/findUsuarioById")
    public Usuario findUsuarioById(@PathVariable("id") Integer id){
        return usuarioService.findById(id);
    }

    @PostMapping("/saveUsuario")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @PutMapping("/updateUsuario/{id}")
    public @ResponseBody
    Usuario update(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        return usuarioService.update(usuario, id);
    }
}
