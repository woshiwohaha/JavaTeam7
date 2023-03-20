package com.javateam.po;

public class Students {
    private int sid;
    private int classid;
    private String sname;
    private String unmae;
    private  int password;

    public String getUnmae() {
        return unmae;
    }

    public void setUnmae(String unmae) {
        this.unmae = unmae;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
