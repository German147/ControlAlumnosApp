package com.escalab.myexample.controller;

import com.escalab.myexample.dto.Consulta_Lista_Llamado_de_Atencion_DTO;
import com.escalab.myexample.dto.RespuestaDTO;
import com.escalab.myexample.entity.Archivo;
import com.escalab.myexample.entity.Consulta;
import com.escalab.myexample.exceptions.ConsultaNotFoundException;
import com.escalab.myexample.service.IArchivoService;
import com.escalab.myexample.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService service;

    @Autowired
    private IArchivoService serviceArchivo;

    @GetMapping
    public ResponseEntity<List<Consulta>> findAllConsultas() {
        List<Consulta> lista = service.findAll();
        return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findbyId(@PathVariable("id") Integer id) {
        Consulta obj = service.findById(id);
        if (obj.getIdConsulta() == null) {
            throw new ConsultaNotFoundException("La consulta con el id: " + id + "No se encuentra en la base de datos.");
        }
        return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registerConsulta(@Valid @RequestBody Consulta_Lista_Llamado_de_Atencion_DTO consultaLlamadosDTO) {
        Consulta obj = service.registrarTransaccional(consultaLlamadosDTO);
        //consultas/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Consulta> updateConsulta(@Valid @RequestBody Consulta consulta, Integer id) {
        Consulta obj = service.update(consulta, id);
        return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable("id") Integer id) {
        Consulta obj = service.findById(id);
        if (obj.getIdConsulta() == null) {
            throw new ConsultaNotFoundException("la consuylta con el Id: " + id + "no se encuentra en la base de datos");
        }
        service.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping(value = "/createPDFReport/pdf")
    public @ResponseBody
    ResponseEntity<RespuestaDTO> createPDFReport(){
        byte[] data = null;
        data = service.generarReporte();
        String document = Base64.getEncoder().encodeToString(data);
        return new ResponseEntity<>(new RespuestaDTO(document), HttpStatus.OK);
    }

    @PostMapping(value = "/saveFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Integer> saveFile(@RequestParam("adjunto") MultipartFile file) throws IOException {
        int rpta = 0;
        Archivo ar = new Archivo();
        ar.setFiletype(file.getContentType());
        ar.setFilename(file.getName());
        ar.setValue(file.getBytes());

        rpta = serviceArchivo.guardar(ar);

        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

}
