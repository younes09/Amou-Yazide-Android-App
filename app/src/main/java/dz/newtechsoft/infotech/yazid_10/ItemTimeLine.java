package dz.newtechsoft.infotech.yazid_10;


public class ItemTimeLine {

    private String d,m,y;
    private String time;
    private String description;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ItemTimeLine() {
    }

    public ItemTimeLine(String d, String m, String y, String time, String description,String url) {
        this.d = d;
        this.m = m;
        this.y = y;
        this.time = time;
        this.description = description;
        this.url=url;
    }

    public String getD() {
        return d;
    }

    public String getM() {
        return m;
    }

    public String getY() {
        return y;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
