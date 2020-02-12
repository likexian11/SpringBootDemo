package com.example.demo.pojo;

import javax.persistence.*;

public class City {
    @Column(name = "cityName")
    private String cityname;

    @Column(name = "confirmedCount")
    private String confirmedcount;

    @Column(name = "suspectedCount")
    private String suspectedcount;

    @Column(name = "curedCount")
    private String curedcount;

    @Column(name = "deadCount")
    private String deadcount;

    @Column(name = "provinceName")
    private String provincename;

    @Column(name = "modifyTime")
    private Integer modifytime;

    /**
     * @return cityName
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * @param cityname
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * @return confirmedCount
     */
    public String getConfirmedcount() {
        return confirmedcount;
    }

    /**
     * @param confirmedcount
     */
    public void setConfirmedcount(String confirmedcount) {
        this.confirmedcount = confirmedcount;
    }

    /**
     * @return suspectedCount
     */
    public String getSuspectedcount() {
        return suspectedcount;
    }

    /**
     * @param suspectedcount
     */
    public void setSuspectedcount(String suspectedcount) {
        this.suspectedcount = suspectedcount;
    }

    /**
     * @return curedCount
     */
    public String getCuredcount() {
        return curedcount;
    }

    /**
     * @param curedcount
     */
    public void setCuredcount(String curedcount) {
        this.curedcount = curedcount;
    }

    /**
     * @return deadCount
     */
    public String getDeadcount() {
        return deadcount;
    }

    /**
     * @param deadcount
     */
    public void setDeadcount(String deadcount) {
        this.deadcount = deadcount;
    }

    /**
     * @return provinceName
     */
    public String getProvincename() {
        return provincename;
    }

    /**
     * @param provincename
     */
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    /**
     * @return modifyTime
     */
    public Integer getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Integer modifytime) {
        this.modifytime = modifytime;
    }
}