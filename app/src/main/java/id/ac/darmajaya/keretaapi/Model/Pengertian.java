package id.ac.darmajaya.keretaapi.Model;

public class Pengertian {

    private int id;
    private String pengertian;
    private String deskripsi;

    public Pengertian(int id, String pengertian, String deskripsi) {
        this.id = id;
        this.pengertian = pengertian;
        this.deskripsi = deskripsi;
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

}
