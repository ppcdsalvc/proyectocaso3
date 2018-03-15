package co.quindio.sena.ejemplosqlite.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 17/06/2017.
 */

public class Medicamento implements Serializable {

    private Integer idPaciente;
    private Integer idMedicamento;
    private String nombreMedicamento;
    private String padecimiento;

    public Medicamento(){

    }

    public Medicamento(Integer idPaciente, Integer idMedicamento, String nombreMedicamento,String padecimiento) {
        this.idPaciente = idPaciente;
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.padecimiento = padecimiento;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }
    public void setIdMedicamento(Integer idMedicamento) {this.idMedicamento = idMedicamento;}

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }
    public void setNombreMedicamento(String nombreMedicamento) {this.nombreMedicamento = nombreMedicamento;}

    public String getPadecimiento() {
        return padecimiento;
    }
    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }
}
