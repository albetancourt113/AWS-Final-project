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

import com.example.demo.Model.AlumnoModel;
import com.example.demo.Service.AlumnoService;

@RestController
public class AlumnoController {

    @GetMapping(path = "/alumnos", produces = "application/json;charset=UTF-8")
	public List<AlumnoModel> getAllAlumnos() {
		return AlumnoService.getAlumnos();
	}

    @GetMapping(path =  "/alumnos/{id}",  produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findAlumnoById(@PathVariable Long id) {       
        if (AlumnoService.getAlumnoById(id)!= null) {
            return new ResponseEntity<>(AlumnoService.getAlumnoById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }        
    }
    
    @PostMapping(path = "/alumnos", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> crearAlumno(@RequestBody AlumnoModel alumno){
        if (alumno.getNombre().equals("") || alumno.getApellidos().equals(null)
                || alumno.getMatricula().matches("[+-]?\\d*(\\.\\d+)?") || alumno.getPromedio() < 0) {                    
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(AlumnoService.saveAlumno(alumno), HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/alumnos/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> updateAlumno(@PathVariable Long id, @RequestBody AlumnoModel alumno) {
       if (alumno.getNombre() == null || alumno.getMatricula().matches("[+-]?\\d*(\\.\\d+)?")) {
          return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(AlumnoService.updateAlumno(id, alumno), HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/alumnos/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> deleteAlumno(@PathVariable Long id) {
        if (AlumnoService.getAlumnoById(id)!= null) {
            return new ResponseEntity<>(AlumnoService.deleteAlumno(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }
    }
}
