package com.example.panduansholat;

public class NiatSholatModel {
    private String nama;
    private String arabic;
    private String latin;
    private String terjemahan;

    public NiatSholatModel(String name, String arabic, String latin, String terjemahan) {
        this.nama = name;
        this.arabic = arabic;
        this.latin = latin;
        this.terjemahan = terjemahan;
    }

    public String getName() {
        return nama;
    }

    public String getArabic() {
        return arabic;
    }

    public String getLatin() {
        return latin;
    }

    public String getTerjemahan() {
        return terjemahan;
    }
}
