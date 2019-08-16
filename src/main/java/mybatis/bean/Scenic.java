package mybatis.bean;

public class Scenic {
    private String country;
    private String origin;
    private String path;
    private int interval;
    private String stime;
    private String atprice;
    private String ctprice;
    private String url;
    private String id;
    private  String type;
    private String groupp;
    private  String title;

    @Override
    public String toString() {
        return "Scenic{" +
                "country='" + country + '\'' +
                ", origin='" + origin + '\'' +
                ", path='" + path + '\'' +
                ", interval=" + interval +
                ", stime='" + stime + '\'' +
                ", atprice='" + atprice + '\'' +
                ", ctprice='" + ctprice + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", groupp='" + groupp + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getAtprice() {
        return atprice;
    }

    public void setAtprice(String atprice) {
        this.atprice = atprice;
    }

    public String getCtprice() {
        return ctprice;
    }

    public void setCtprice(String ctprice) {
        this.ctprice = ctprice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupp() {
        return groupp;
    }

    public void setGroupp(String groupp) {
        this.groupp = groupp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
