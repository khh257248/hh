package cn.hp.model;

public class Street {
    private int sid;
    private String sname;
    private int cid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Street(int sid, String sname, int cid) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
    }

    public Street() {
    }
}
