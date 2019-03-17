package id.ac.darmajaya.keretaapi.Model;

public class Semboyan {

    private int id;
    private String singkatan;
    private String penjelasan;
    private String kategori;
    private String gambar;
    private String musik;
    private String musik2;

    public Semboyan(int id, String singkatan, String penjelasan, String kategori, String gambar, String musik, String musik2) {
        this.id = id;
        this.singkatan = singkatan;
        this.penjelasan = penjelasan;
        this.kategori = kategori;
        this.gambar = gambar;
        this.musik = musik;
        this.musik2 = musik2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingkatan() {
        return singkatan;
    }

    public void setSingkatan(String singkatan) {
        this.singkatan = singkatan;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMusik() {
        return musik;
    }

    public void setMusik(String musik) {
        this.musik = musik;
    }

    public String getMusik2() {
        return musik2;
    }

    public void setMusik2(String musik2) {
        this.musik2 = musik2;
    }
}
