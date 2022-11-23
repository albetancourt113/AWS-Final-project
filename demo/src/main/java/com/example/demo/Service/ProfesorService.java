package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Model.ProfesorModel;

public class ProfesorService {
    private static Map<Long, ProfesorModel> alumnos = new HashMap<>();

    public static List<ProfesorModel> getProfesores() {
        return new ArrayList<>(alumnos.values());
    }

    public static ProfesorModel getProfesorById(Long id) {
        return alumnos.get(id);
    }

    public static ProfesorModel saveProfesor(ProfesorModel alumno) {    
        alumnos.put(alumno.getId(), alumno);
        return alumno;
    }

    public static ProfesorModel updateProfesor(Long id, ProfesorModel alumno) {
        alumno.setId(id);
        alumnos.put(id, alumno);
        return alumno;
    }

    public static ProfesorModel deleteProfesor(Long id) {
        return alumnos.remove(id);
    }
}
