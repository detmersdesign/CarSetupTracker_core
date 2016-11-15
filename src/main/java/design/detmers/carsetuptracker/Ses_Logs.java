package design.detmers.carsetuptracker;

/**
 * Class for storing each track session
 * Created by mdetm on 11/1/2016.
 */

public class Ses_Logs {
    private int id;
    private String date;
    private int[] LF = new int[4];
    private int[] RF = new int[4];
    private int[] LR = new int[4];
    private int[] RR = new int[4];
    private int[] item = new int[4];
    private String note;

    public Ses_Logs(int id, String date, int T_LFI, int T_LFM, int T_LFO, int T_RFI, int T_RFM, int T_RFO, int T_LRI, int T_LRM, int T_LRO, int T_RRI, int T_RRM, int T_RRO, int P_LF, int P_RF, int P_LR, int P_RR, String note)
    {
        this.id=id;
        this.date=date;
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

        this.note=note;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
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
    public String getDate() {
        return date;
    }
    public int[] getLF() {
        item[0] = this.LF[0];
        item[1] = this.LF[1];
        item[2] = this.LF[2];
        item[3] = this.LF[3];
        return item;
    }
    public int[] getRF() {
        item[0] = this.RF[0];
        item[1] = this.RF[1];
        item[2] = this.RF[2];
        item[3] = this.RF[3];
        return item;
    }
    public int[] getLR() {
        item[0] = this.LR[0];
        item[1] = this.LR[1];
        item[2] = this.LR[2];
        item[3] = this.LR[3];
        return item;
    }
    public int[] getRR() {
        item[0] = this.RR[0];
        item[1] = this.RR[1];
        item[2] = this.RR[2];
        item[3] = this.RR[3];
        return item;
    }
    public String getNote() {
        return note;
    }
}
