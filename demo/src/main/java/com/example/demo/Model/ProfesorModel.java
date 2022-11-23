package com.example.demo.Model;

public class ProfesorModel {
    public Long id;
    public int numeroEmpleado;
    public String nombres;
    public String apellidos;
    public int horasClase;
    
    public ProfesorModel() {
    }
    
    public ProfesorModel(Long id, int numeroEmpleado, String nombres, String apellidos, int horasClase) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumEmpleado() {
        return numeroEmpleado;
    }
    public void setNumEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
    public String getNombre() {
        return nombres;
    }
    public void setNombre(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getHorasClase() {
        return horasClase;
    }
    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }
    
}
