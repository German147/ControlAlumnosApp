package com.escalab.myexample.controller;

import com.escalab.myexample.entity.Profesor;
import com.escalab.myexample.service.serviceImpl.ProfesorServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profesores")
public class ProfesorController {

    @Autowired
    final
    ProfesorServiceImpl profesorService;

    public ProfesorController(ProfesorServiceImpl profesorService) {
        this.profesorService = profesorService;
    }

    @ApiOperation(value = "Obtener todos los profesores",
            notes = "No necesita parametros de entrada",
            responseContainer = "Profesores")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Profesor.class, responseContainer = "List"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "Profesor", value = "List of strings", paramType = "body", dataType =
            "Profesor")})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/profesor")
    public @ResponseBody
    List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @ApiOperation(value = "Obtener todos los profesores por su identificador",
            notes = "No necesita parametros de entrada",
            response = Profesor.class,
            responseContainer = "Profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("findProfesorById/{id}")
    public Profesor findById(@PathVariable("id") Integer id) {
        return profesorService.findById(id);
    }

    @ApiOperation(value = "Obtener todos los profesores por su nombre",
            notes = "Necesita parametros de entrada",
            response = Profesor.class,
            responseContainer = "Profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Profesor> findAllByName(@PathVariable("nombre") String nombre) {
        return profesorService.findAllByName(nombre);
    }

    @ApiOperation(value = "Crea un profesor con sus parametros",
            notes = "Necesita parametros de entrada",
            response = Profesor.class,
            responseContainer = "Profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping("/save")
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.create(profesor);
    }

    @ApiOperation(value = "Se actualiza el profesor por sus parametros",
            notes = "Necesita  los parametros de entrada para su modificacion y su identificacor id",
            response = Profesor.class,
            responseContainer = "Profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/updateProfesor/{id}")
    public @ResponseBody
    Profesor update(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(profesor, id);
    }

    @ApiOperation(value = "Borra un profesor por su identificador id",
            notes = "Si necesita parametros de entrada",
            response = Profesor.class,
            responseContainer = "Profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        return profesorService.deleteById(id);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Profesor>> listPageable(Pageable pageable) {
        Page<Profesor> pacientes = profesorService.listPageable(pageable);
        return new ResponseEntity<Page<Profesor>>(pacientes, HttpStatus.OK);
    }

}
