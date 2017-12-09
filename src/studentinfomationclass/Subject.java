/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfomationclass;

import java.util.logging.Logger;

/**
 *
 * @author Bac
 */
public class Subject {
    private int idSbj;
    private String nameSbj;
    private int numOfCre;
    private int semester;
    private Department dpm;
    private double midPoint;
    private double endPoint;
    private double averPoint;
    private String type;
    private Class_ cl;
    private int ispassed;

    public int getIdSbj() {
        return idSbj;
    }

    public void setIdSbj(int idSbj) {
        this.idSbj = idSbj;
    }

    public String getNameSbj() {
        return nameSbj;
    }

    public void setNameSbj(String nameSbj) {
        this.nameSbj = nameSbj;
    }

    public int getNumOfCre() {
        return numOfCre;
    }

    public void setNumOfCre(int numOfCre) {
        this.numOfCre = numOfCre;
    }

    public int getSemester() {
        return semester;
    }

    public int getIspassed() {
        return ispassed;
    }

    public void setIspassed(int ispassed) {
        this.ispassed = ispassed;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Department getDpm() {
        return dpm;
    }

    public void setDpm(Department dpm) {
        this.dpm = dpm;
    }

    public Subject(int idSbj, String nameSbj, int numOfCre, int semester, Department dpm, double midPoint, double endPoint, double averPoint, String type, Class_ cl, int ispassed) {
        this.idSbj = idSbj;
        this.nameSbj = nameSbj;
        this.numOfCre = numOfCre;
        this.semester = semester;
        this.dpm = dpm;
        this.midPoint = midPoint;
        this.endPoint = endPoint;
        this.averPoint = averPoint;
        this.type = type;
        this.cl = cl;
        this.ispassed = ispassed;
    }
    
    public Subject(int idSbj, String nameSbj, int numOfCre, int semester, Department dpm) {
        this.idSbj = idSbj;
        this.nameSbj = nameSbj;
        this.numOfCre = numOfCre;
        this.semester = semester;
        this.dpm = dpm;
        this.midPoint = 0;
        this.endPoint = 0;
        this.averPoint = 0;
        this.type = "";
        this.cl = null;
    }
    
    public Subject() {
    }
    
    public double getMidPoint() {
        return midPoint;
    }
    private static final Logger LOG = Logger.getLogger(Subject.class.getName());


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMidPoint(double midPoint) {
        this.midPoint = midPoint;
    }

    public double getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(double endPoint) {
        this.endPoint = endPoint;
    }

    public double getAverPoint() {
        return averPoint;
    }

    public void setAverPoint(double averPoint) {
        this.averPoint = averPoint;
    }


    public Class_ getCl() {
        return cl;
    }

    public void setCl(Class_ cl) {
        this.cl = cl;
    }
}
