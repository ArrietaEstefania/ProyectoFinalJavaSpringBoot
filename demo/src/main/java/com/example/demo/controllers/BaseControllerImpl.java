package com.example.demo.controllers;

import com.example.demo.entities.Base;
import com.example.demo.entities.Persona;
import com.example.demo.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
    @Autowired
    protected S service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E persona){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.save(persona));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E persona){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, persona));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error, por favor intente mas tarde\"}");
        }
    }
}
