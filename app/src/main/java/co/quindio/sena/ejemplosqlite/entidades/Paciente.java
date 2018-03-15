package co.quindio.sena.ejemplosqlite.entidades;

import java.io.Serializable;


public class Paciente implements  Serializable{

    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String fecha;


    public Paciente(Integer id, String nombre, String telefono,String direccion, String email, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.fecha = fecha;
    }

    public Paciente(){

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() { return telefono;}
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() { return direccion;}
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() { return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha() { return fecha;}
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
