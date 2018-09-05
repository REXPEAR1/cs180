/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shen212
 */
public class Graduate extends Student{
    private String major;
    private boolean thesis;
    private String msphd;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean getThesis() {
        return thesis;
    }

    public void setThesis(boolean thesis) {
        this.thesis = thesis;
    }

    public String getMsphd() {
        return msphd;
    }

    public void setMsphd(String msphd) {
        this.msphd = msphd;
    }
    
    
}
