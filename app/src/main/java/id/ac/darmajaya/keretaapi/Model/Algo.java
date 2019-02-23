package id.ac.darmajaya.keretaapi.Model;

public class Algo {
    private String singkatan;
    private String panjanghuruf;
    private String startposisi;
    private String endpos;


    public Algo(String singkatan, String panjanghuruf, String startposisi, String endpos) {
        this.singkatan = singkatan;
        this.panjanghuruf = panjanghuruf;
        this.startposisi = startposisi;
        this.endpos = endpos;
    }

    public String getSingkatan() {
        return singkatan;
    }

    public void setSingkatan(String singkatan) {
        this.singkatan = singkatan;
    }

    public String getPanjanghuruf() {
        return panjanghuruf;
    }

    public void setPanjanghuruf(String panjanghuruf) {
        this.panjanghuruf = panjanghuruf;
    }

    public String getStartposisi() {
        return startposisi;
    }

    public void setStartposisi(String startposisi) {
        this.startposisi = startposisi;
    }

    public String getEndpos() {
        return endpos;
    }

    public void setEndpos(String endpos) {
        this.endpos = endpos;
    }



}