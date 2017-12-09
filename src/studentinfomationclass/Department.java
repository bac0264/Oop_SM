/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfomationclass;

/**
 *
 * @author Bac
 */
public class Department {
    private int idDpm;
    private String nameDpm;

    public int getIdDpm() {
        return idDpm;
    }

    public void setIdDpm(int idDpm) {
        this.idDpm = idDpm;
    }

    public String getNameDpm() {
        return nameDpm;
    }

    public void setNameDpm(String nameDpm) {
        this.nameDpm = nameDpm;
    }

    public Department(int idDpm, String nameDpm) {
        this.idDpm = idDpm;
        this.nameDpm = nameDpm;
    }

    public Department() {
    }
    
}
