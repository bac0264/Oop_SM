/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfomationclass;

import java.util.ArrayList;



/**
 *
 * @author Bac
 */
public abstract class Student {
    private int idStu;
    private String nameStu;
    private String addresStu;
    private String course; // khoá học
    private String birthday;
    private String passStu;
    private String trainningSys;
    private Department dpm;
    private ArrayList<Subject> sub;
    
    public abstract boolean themMonHoc(Subject su);
    
    public ArrayList getSub(){
        return this.sub;
    }
        
    public void setSub(ArrayList<Subject> sub){
        this.sub = sub;
    }
    public int getIdStu() {
        return idStu;
    }

    public void setIdStu(int idStu) {
        this.idStu = idStu;
    }

    public String getNameStu() {
        return nameStu;
    }

    public void setNameStu(String nameStu) {
        this.nameStu = nameStu;
    }

    public String getAddresStu() {
        return addresStu;
    }

    public void setAddresStu(String addresStu) {
        this.addresStu = addresStu;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassStu() {
        return passStu;
    }

    public void setPassStu(String passStu) {
        this.passStu = passStu;
    }

    public String getTrainningSys() {
        return trainningSys;
    }

    public void setTrainningSys(String trainningSys) {
        this.trainningSys = trainningSys;
    }

    public Department getDpm() {
        return dpm;
    }

    public void setDpm(Department dpm) {
        this.dpm = dpm;
    }

    public Student(int idStu, String nameStu, String addresStu, String course, String birthday, String passStu, String trainningSys, Department dpm) {
        this.idStu = idStu;
        this.nameStu = nameStu;
        this.addresStu = addresStu;
        this.course = course;
        this.birthday = birthday;
        this.passStu = passStu;
        this.trainningSys = trainningSys;
        this.dpm = dpm;
    }

    public Student() {
    }
    
}
