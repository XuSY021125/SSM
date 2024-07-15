package com.java.mod.pojo;


public class Mod {

    private String modid;
    private Double modversion;
    private Boolean modavailable;
    private String modinfo;


    public String getModid() {
        return modid;
    }

    public void setModid(String modid) {
        this.modid = modid;
    }

    public Double getModversion() {
        return modversion;
    }

    public void setModversion(Double modversion) {
        this.modversion = modversion;
    }

    public Boolean getModavailable() {
        return modavailable;
    }

    public void setModavailable(Boolean modavailable) {
        this.modavailable = modavailable;
    }

    public String getModinfo() {
        return modinfo;
    }

    public void setModinfo(String modinfo) {
        this.modinfo = modinfo;
    }

    @Override
    public String toString() {
        return "Mod{" +
                ", modid='" + modid + '\'' +
                ", modversion=" + modversion +
                ", modavailable=" + modavailable +
                ", modinfo='" + modinfo + '\'' +
                '}';
    }
}
