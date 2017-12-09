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
public class LearningCondition {
    private int idCdt_1;
    private int idCdt_2;

    public int getIdCdt_1() {
        return idCdt_1;
    }

    public void setIdCdt_1(int idCdt_1) {
        this.idCdt_1 = idCdt_1;
    }

    public int getIdCdt_2() {
        return idCdt_2;
    }

    public void setIdCdt_2(int idCdt_2) {
        this.idCdt_2 = idCdt_2;
    }

    public LearningCondition(int idCdt_1, int idCdt_2) {
        this.idCdt_1 = idCdt_1;
        this.idCdt_2 = idCdt_2;
    }

    public LearningCondition() {
    }
    
}
