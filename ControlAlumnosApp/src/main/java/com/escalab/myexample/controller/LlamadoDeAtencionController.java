package com.escalab.myexample.controller;

import com.escalab.myexample.entity.LlamadosDeAtencion;
import com.escalab.myexample.service.serviceImpl.LLamadoAtencionServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/llamado_atencion")
public class LlamadoDeAtencionController {

    @Autowired
    final
    LLamadoAtencionServiceImpl lLamadoAtencionService;

    public LlamadoDeAtencionController(LLamadoAtencionServiceImpl lLamadoAtencionService) {
        this.lLamadoAtencionService = lLamadoAtencionService;
    }

    @ApiOperation(value = "Obtener todos los llamados de atencion",
            notes = "No necesita parametros de entrada",
            responseContainer = "Llamados de atencion")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = LlamadosDeAtencion.class, responseContainer = "List"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "LlamadoDeAtencion", value = "List of strings", paramType = "body", dataType =
            "LlamadoAtencion")})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron llamados de atencion en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/llamadosDeAtencion")
    public @ResponseBody
    List<LlamadosDeAtencion> findAllLlamadosDeatencion(){
        return lLamadoAtencionService.findAll();
    }

    @ApiOperation(value = "Obtener todos los llamados de atencion por su identificador",
            notes = "No necesita parametros de entrada",
            response = LlamadosDeAtencion.class,
            responseContainer = "Llamados_de_Atencions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron llamados de atencion en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/find_LlamadadoDeAtencionById")
    public LlamadosDeAtencion findbyId(@PathVariable("id") Integer id){
        return lLamadoAtencionService.findById(id);
    }

    @ApiOperation(value = "Crea un llamado de atencion con sus parametros",
            notes = "Necesita parametros de entrada",
            response = LlamadosDeAtencion.class,
            responseContainer = "Llamados_de_Atencions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping("/save")
    public LlamadosDeAtencion create(@RequestBody LlamadosDeAtencion llamadoDeAtencion) {
        return lLamadoAtencionService.create(llamadoDeAtencion);
    }

    @ApiOperation(value = "Se actualiza el llamado de atencion por sus parametros",
            notes = "Necesita  los parametros de entrada para su modificacion y su identificacor id",
            response = LlamadosDeAtencion.class,
            responseContainer = "Llamados_de_Atencions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron llamados de atencion en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/update_llamadoDeAtencion/{id}")
    public @ResponseBody
    LlamadosDeAtencion update(@PathVariable("id") Integer id, @RequestBody LlamadosDeAtencion llamadoDeAtencion) {
        return lLamadoAtencionService.update(llamadoDeAtencion,id);
    }
    @ApiOperation(value = "Borra un llamado de atencion por su identificador id",
            notes = "Si necesita parametros de entrada",
            response = LlamadosDeAtencion.class,
            responseContainer = "LlamadosDeAtencion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron llamados de atencion en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/delete_llamadoAtencion/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        return lLamadoAtencionService.deleteById(id);
    }

    @ApiOperation(value = "Elabora una lista de llamados de atencion por su identificador id",
            notes = "No necesita parametros de entrada",
            response = LlamadosDeAtencion.class,
            responseContainer = "LlamadosDeAtencion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron llamados de atencion en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/pageable")
    public ResponseEntity<Page<LlamadosDeAtencion>> listPageable(Pageable pageable) {
        Page<LlamadosDeAtencion> llamaAtencion = lLamadoAtencionService.listLlamadoAtencionPageable(pageable);
        return new ResponseEntity<Page<LlamadosDeAtencion>>(llamaAtencion, HttpStatus.OK);
    }

}
