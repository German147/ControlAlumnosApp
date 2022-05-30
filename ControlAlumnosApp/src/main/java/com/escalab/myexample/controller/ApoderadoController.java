package com.escalab.myexample.controller;

import com.escalab.myexample.entity.Apoderado;
import com.escalab.myexample.service.serviceImpl.ApoderadoServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apoderados")
public class ApoderadoController {

    @Autowired
    final
    ApoderadoServiceImpl apoderadoService;

    public ApoderadoController(ApoderadoServiceImpl apoderadoService) {
        this.apoderadoService = apoderadoService;
    }


    @ApiOperation(value = "Obtener todos los apoderados",
            notes = "No necesita parametros de entrada",
            responseContainer = "Apoderados")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Apoderado.class, responseContainer = "List"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "Apoderado", value = "List of strings", paramType = "body", dataType =
            "Apoderado")})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron apoderados en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/apoderado")
    public @ResponseBody
    List<Apoderado> findAll() {
        return apoderadoService.findAll();
    }

    @ApiOperation(value = "Obtener todos los apoderados por su identificador",
            notes = "No necesita parametros de entrada",
            response = Apoderado.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron apoderados en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("findApoderadoById/{id}")
    public Apoderado findById(@PathVariable("id") Integer id) {
        return apoderadoService.findById(id);
    }

    @ApiOperation(value = "Obtener todos los apoderados por su nombre",
            notes = "Necesita parametros de entrada",
            response = Apoderado.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron apoderados en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Apoderado> findAllByName(@PathVariable("nombre") String nombre) {
        return apoderadoService.findAllByName(nombre);
    }

    @ApiOperation(value = "Crea un apoderado con sus parametros",
            notes = "Necesita parametros de entrada",
            response = Apoderado.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping("/save")
    public Apoderado create(@RequestBody Apoderado apoderado) {
        return apoderadoService.create(apoderado);
    }

    @ApiOperation(value = "Se actualiza el apoderado por sus parametros",
            notes = "Necesita  los parametros de entrada para su modificacion y su identificacor id",
            response = Apoderado.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron apoderados en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("updateApoderado/{id}")
    public @ResponseBody
    Apoderado update(@PathVariable("id") Integer id, @RequestBody Apoderado apoderado) {
        return apoderadoService.update(apoderado,id);
    }

    @ApiOperation(value = "Borra un apoderado por su identificador id",
            notes = "Si necesita parametros de entrada",
            response = Apoderado.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron apoderados en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        return apoderadoService.deleteApoderado(id);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Apoderado>> listPageable(Pageable pageable) {
        Page<Apoderado> pacientes = apoderadoService.listPageable(pageable);
        return new ResponseEntity<Page<Apoderado>>(pacientes, HttpStatus.OK);
    }

}
