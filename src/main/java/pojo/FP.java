package pojo;

public class FP {//乘客航班关系
    int pid;
    String fid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "FP{" +
                "pid=" + pid +
                ", fid='" + fid + '\'' +
                '}';
    }
}
