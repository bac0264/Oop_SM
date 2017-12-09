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
public class CreditStudent extends Student {
    private int soTC;
    private int soTCMax;

    public int getSoTCMax() {
        return soTCMax;
    }

    public void setSoTCMax(int soTCMax) {
        this.soTCMax = soTCMax;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public CreditStudent(int soTCMax) {
        this.soTC = 0;
        this.soTCMax = soTCMax;
    }
    public CreditStudent(){
    
    }

    public boolean themMonHoc(Subject su) {
        if(this.soTC + su.getNumOfCre() <= soTCMax){
            this.soTC += su.getNumOfCre();
            super.getSub().add(su);
            return true;
        }
        return false;
            
    }
}   
