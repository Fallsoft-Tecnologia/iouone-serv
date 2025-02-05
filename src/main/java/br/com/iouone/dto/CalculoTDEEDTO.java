package br.com.iouone.dto;

public class CalculoTDEEDTO {

    private String objetivo;
    private String biotipo;

    private String tdee;
    private String caloriasDiarias;

    public CalculoTDEEDTO(String objetivo, String biotipo, String tdee, String caloriasDiarias) {
        this.objetivo = objetivo;
        this.biotipo = biotipo;
        this.tdee = tdee;
        this.caloriasDiarias = caloriasDiarias;
    }

    public CalculoTDEEDTO() {
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public String getTdee() {
        return tdee;
    }

    public void setTdee(String tdee) {
        this.tdee = tdee;
    }

    public String getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(String caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }
}
