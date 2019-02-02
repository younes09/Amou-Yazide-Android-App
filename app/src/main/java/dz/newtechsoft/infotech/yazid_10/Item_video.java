package dz.newtechsoft.infotech.yazid_10;

public class Item_video {
    private String titel, url, bg, category;


    public Item_video(String titel, String url, String bg, String category) {
        this.titel = titel;
        this.url = url;
        this.bg = bg;
        this.category = category;
    }

    public Item_video() {

    }


    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getTitel() {
        return titel;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBg() {
        return bg;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

