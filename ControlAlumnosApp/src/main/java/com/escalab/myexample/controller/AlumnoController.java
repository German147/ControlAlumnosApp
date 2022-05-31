package com.escalab.myexample.controller;

import com.escalab.myexample.entity.Alumno;
import com.escalab.myexample.service.serviceImpl.AlumnoServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alumnos")
public class AlumnoController {

    @Autowired
    final
    AlumnoServiceImpl alumnoService;

    public AlumnoController(AlumnoServiceImpl alumnoService) {
        this.alumnoService = alumnoService;
    }

    @ApiOperation(value = "Obtener todos los alumnos",
            notes = "No necesita parametros de entrada",
            responseContainer = "Alumnos")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Alumno.class, responseContainer = "List"
    )
    @ApiImplicitParams({@ApiImplicitParam(name = "Alumno", value = "List of strings", paramType = "body", dataType =
            "Alumno")})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/alumno")
    public @ResponseBody
    List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @ApiOperation(value = "Obtener todos los alumnos por su identificador",
            notes = "No necesita parametros de entrada",
            response = Alumno.class,
            responseContainer = "Alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("findStudentById/{id}")
    public Alumno findById(@PathVariable("id") Integer id) {
        return alumnoService.findById(id);
    }

    @ApiOperation(value = "Obtener todos los alumnos por su nombre",
            notes = "Necesita parametros de entrada",
            response = Alumno.class,
            responseContainer = "Alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Alumno> findAllByName(@PathVariable("nombre") String nombre) {
        return alumnoService.findAllByName(nombre);
    }

    @ApiOperation(value = "Crea un alumno con sus parametros",
            notes = "Necesita parametros de entrada",
            response = Alumno.class,
            responseContainer = "Alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping("/save")
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.create(alumno);
    }

    @ApiOperation(value = "Se actualiza el alumno por sus parametros",
            notes = "Necesita  los parametros de entrada para su modificacion y su identificacor id",
            response = Alumno.class,
            responseContainer = "Alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/updateStudent/{id}")
    public @ResponseBody
    Alumno update(@PathVariable("id") Integer id, @RequestBody Alumno alumno) {
        return alumnoService.update(alumno,id);
    }

    @ApiOperation(value = "Borra un alumno por su identificador id",
            notes = "Si necesita parametros de entrada",
            response = Alumno.class,
            responseContainer = "Alumnos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) {
        return alumnoService.deleteById(id);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Alumno>> listPageable(Pageable pageable) {
        Page<Alumno> pacientes = alumnoService.listPageable(pageable);
        return new ResponseEntity<Page<Alumno>>(pacientes, HttpStatus.OK);
    }

}
