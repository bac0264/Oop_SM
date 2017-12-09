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
public class AYearStudent extends Student{
    private int semester;
    
    public boolean themMonHoc(Subject su){
        if(su.getSemester() == this.semester){
            super.getSub().add(su);
            return true;
        }
        return false;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public AYearStudent(int semester) {
        this.semester = semester;
    }

    public AYearStudent() {
    }
    public void Signup(){
    }
}
