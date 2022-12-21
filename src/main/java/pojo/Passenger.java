package pojo;

public class Passenger {
    int pid;//身份证号
    String pName;//姓名

    public Passenger(int pid, String pName) {
        this.pid = pid;
        this.pName = pName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                '}';
    }
}
