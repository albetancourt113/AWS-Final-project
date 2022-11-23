package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Model.AlumnoModel;

public class AlumnoService {
    private static Map<Long, AlumnoModel> alumnos = new HashMap<>();

    public static List<AlumnoModel> getAlumnos() {
        return new ArrayList<>(alumnos.values());
    }

    public static AlumnoModel getAlumnoById(Long id) {
        return alumnos.get(id);
    }

    public static AlumnoModel saveAlumno(AlumnoModel alumno) {    
        alumnos.put(alumno.getId(), alumno);
        return alumno;
    }

    public static AlumnoModel updateAlumno(Long id, AlumnoModel alumno) {
        alumno.setId(id);
        alumnos.put(id, alumno);
        return alumno;
    }

    public static AlumnoModel deleteAlumno(Long id) {
        return alumnos.remove(id);
    }
    
}
