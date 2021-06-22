package com.example.quranapplication.index_surahs;

public class juz {
    private String juz_num ;
    private String juz_description ;
    private int icon ;

    public juz() {
    }

    public juz(String juz_num, String juz_description, int icon) {
        this.juz_num = juz_num;
        this.juz_description = juz_description;
        this.icon = icon;
    }

    public String getJuz_num() {
        return juz_num;
    }

    public void setJuz_num(String juz_num) {
        this.juz_num = juz_num;
    }

    public String getJuz_description() {
        return juz_description;
    }

    public void setJuz_description(String juz_description) {
        this.juz_description = juz_description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
