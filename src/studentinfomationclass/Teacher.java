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
public class Teacher {
    private int idTcr;
    private String nameTcr;
    private String passTcr;

    public String getPassTcr() {
        return passTcr;
    }

    public void setPassTcr(String passTcr) {
        this.passTcr = passTcr;
    }

    public int getIdTcr() {
        return idTcr;
    }

    public void setIdTcr(int idTcr) {
        this.idTcr = idTcr;
    }

    public Teacher(int idTcr, String nameTcr, String passTcr) {
        this.idTcr = idTcr;
        this.nameTcr = nameTcr;
        this.passTcr = passTcr;
    }

    public String getNameTcr() {
        return nameTcr;
    }

    public void setNameTcr(String nameTcr) {
        this.nameTcr = nameTcr;
    }

    public Teacher(int idTcr, String nameTcr) {
        this.idTcr = idTcr;
        this.nameTcr = nameTcr;
    }

    public Teacher() {
    }
    
}
