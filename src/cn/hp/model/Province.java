package cn.hp.model;

public class Province {
    private int pid;
    private String pname;

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }

    public Province(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Province() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
