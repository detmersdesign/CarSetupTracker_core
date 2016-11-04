package design.detmers.carsetuptracker;

/**
 * Class for storing each track session
 * Created by mdetm on 11/1/2016.
 */

public class Ses_Logs {
    private int id;
    private int[] LF;
    private int[] RF;
    private int[] LR;
    private int[] RR;
    private String note;

    public Ses_Logs(int id, int T_LFI, int T_LFM, int T_LFO, int T_RFI, int T_RFM, int T_RFO, int T_LRI, int T_LRM, int T_LRO, int T_RRI, int T_RRM, int T_RRO, int P_LF, int P_RF, int P_LR, int P_RR, String note)
    {
        this.id=id;
        this.LF[0]=T_LFI;
        this.LF[1]=T_LFM;
        this.LF[2]=T_LFO;
        this.LF[3]=P_LF;

        this.RF[0]=T_RFI;
        this.RF[1]=T_RFM;
        this.RF[2]=T_RFO;
        this.RF[3]=P_RF;

        this.LR[0]=T_LRI;
        this.LR[1]=T_LRM;
        this.LR[2]=T_LRO;
        this.LR[3]=P_LR;

        this.RR[0]=T_RRI;
        this.RR[1]=T_RRM;
        this.RR[2]=T_RRO;
        this.RR[3]=P_RR;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLF(int T_LFI,int T_LFM,int T_LFO,int P_LF) {
        this.LF[0] = T_LFI;
        this.LF[1] = T_LFM;
        this.LF[2] = T_LFO;
        this.LF[3] = P_LF;
    }
    public void setRF(int T_RFI,int T_RFM,int T_RFO,int P_RF) {
        this.RF[0] = T_RFI;
        this.RF[1] = T_RFM;
        this.RF[2] = T_RFO;
        this.RF[3] = P_RF;
    }
    public void setLR(int T_LRI,int T_LRM,int T_LRO,int P_LR) {
        this.LR[0] = T_LRI;
        this.LR[1] = T_LRM;
        this.LR[2] = T_LRO;
        this.LR[3] = P_LR;
    }
    public void setRR(int T_RRI,int T_RRM,int T_RRO,int P_RR) {
        this.RR[0] = T_RRI;
        this.RR[1] = T_RRM;
        this.RR[2] = T_RRO;
        this.RR[3] = P_RR;
    }

    public int getId() {
        return id;
    }
    public int[] getLF() {
        return LF;
    }
    public int[] getRF() {
        return RF;
    }
    public int[] getLR() {
        return LR;
    }
    public int[] getRR() {
        return RR;
    }
    public String getNote() {
        return note;
    }
}
