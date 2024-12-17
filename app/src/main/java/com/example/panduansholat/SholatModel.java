package com.example.panduansholat;

public class SholatModel {
    private String id;
    private String name;
    private String terjemahan;

    private String arabic;
    private String latin;

    private String image;

    public SholatModel(String id, String name, String arabic, String latin, String terjemahan, String image) {
        this.id = id;
        this.name = name;
        this.terjemahan = terjemahan;
        this.arabic = arabic;
        this.latin = latin;
        this.image = image;
    }

    // Getter methods
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTerjemahan() { return terjemahan; }
    public String getArabic() { return arabic; }
    public String getLatin() { return latin; }
    public String getImage() { return image; }
}