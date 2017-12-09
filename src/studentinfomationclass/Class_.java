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
public class Class_ {
    private int idClass;
    private Teacher tcr;
    private Subject sbj;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public Teacher getTcr() {
        return tcr;
    }

    public void setTcr(Teacher tcr) {
        this.tcr = tcr;
    }

    public Subject getSbj() {
        return sbj;
    }

    public void setSbj(Subject sbj) {
        this.sbj = sbj;
    }

    public Class_(int idClass, Teacher tcr, Subject sbj) {
        this.idClass = idClass;
        this.tcr = tcr;
        this.sbj = sbj;
    }

    public Class_() {
    }
    
}
