package com.example.panduansholat;

public class DoaModel {
    private String nama;
    private String terjemahan;

    private String arabic;
    private String latin;


    public DoaModel(String id, String name, String arabic, String latin, String terjemahan, String image) {
        this.nama = name;
        this.terjemahan = terjemahan;
        this.arabic = arabic;
        this.latin = latin;
    }

    // Getter methods
    public String getName() { return nama; }
    public String getTerjemahan() { return terjemahan; }
    public String getArabic() { return arabic; }
    public String getLatin() { return latin; }
}
