package com.example.demo.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ProfesorModel;
import com.example.demo.Service.ProfesorService;

@RestController
public class ProfesorController {
    @GetMapping(path = "/profesores", produces = "application/json;charset=UTF-8")
	public List<ProfesorModel> getAllProfesores() {
		return ProfesorService.getProfesores();
	}

    @GetMapping(path =  "/profesores/{id}",  produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findProfesorById(@PathVariable Long id) {       
        if (ProfesorService.getProfesorById(id)!= null) {
            return new ResponseEntity<>(ProfesorService.getProfesorById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }        
    }
    
    @PostMapping(path = "/profesores", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> crearProfesor(@RequestBody ProfesorModel profesor){
        if (profesor.getNombre().equals("") || profesor.getApellidos().equals(null)
                || profesor.getHorasClase() < 0) {                    
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ProfesorService.saveProfesor(profesor), HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/profesores/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> updateProfesor(@PathVariable Long id, @RequestBody ProfesorModel profesor) {
       if (profesor.getNombre() == null || profesor.getHorasClase() < 0) {
          return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ProfesorService.updateProfesor(id, profesor), HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/profesores/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> deleteProfesor(@PathVariable Long id) {
        if (ProfesorService.getProfesorById(id)!= null) {
            return new ResponseEntity<>(ProfesorService.deleteProfesor(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }
    }
}
