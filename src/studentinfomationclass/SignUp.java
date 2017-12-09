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
public class SignUp {

    private double midPoint;
    private double endPoint;
    private double averPoint;
    private CreditStudent std;
    private Class_ cl;
    private String type;
    public double getMidPoint() {
        return midPoint;
    }

    public CreditStudent getStd() {
        return std;
    }

    public void setStd(CreditStudent std) {
        this.std = std;
    }

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

    public Student getCreStd() {
        return std;
    }

    public void setCreStd(CreditStudent std) {
        this.std = std;
    }

    public Class_ getCl() {
        return cl;
    }

    public void setCl(Class_ cl) {
        this.cl = cl;
    }

    public SignUp(double midPoint, double endPoint, double averPoint, CreditStudent std, Class_ cl, String type ) {
        this.midPoint = midPoint;
        this.endPoint = endPoint;
        this.averPoint = averPoint;
        this.std = std;
        this.cl = cl;
        this.type = type;
    }

    public SignUp( CreditStudent std, Class_ cl) {
        this.std = std;
        this.cl = cl;
    }

    public SignUp() {
    }

}
