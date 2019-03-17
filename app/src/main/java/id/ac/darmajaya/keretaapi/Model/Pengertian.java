package id.ac.darmajaya.keretaapi.Model;

public class Pengertian {

    private int id;
    private String pengertian;
    private String deskripsi;
    private String musik;

    public Pengertian(int id, String pengertian, String deskripsi, String musik) {
        this.id = id;
        this.pengertian = pengertian;
        this.deskripsi = deskripsi;
        this.musik = musik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPengertian() {
        return pengertian;
    }

    public void setPengertian(String pengertian) {
        this.pengertian = pengertian;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getMusik() {
        return musik;
    }

    public void setMusik(String musik) {
        this.musik = musik;
    }
}
