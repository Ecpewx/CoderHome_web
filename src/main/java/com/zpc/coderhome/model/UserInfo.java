package com.zpc.coderhome.model;

public class UserInfo {
    private Integer id;

    private String name;

    private String portiImage;

    private String intro;

    private Integer userAcid;

    private String eMail;
    private String history;
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortiImage() {
        return portiImage;
    }

    public void setPortiImage(String portiImage) {
        this.portiImage = portiImage;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getUserAcid() {
        return userAcid;
    }

    public void setUserAcid(Integer userAcid) {
        this.userAcid = userAcid;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}