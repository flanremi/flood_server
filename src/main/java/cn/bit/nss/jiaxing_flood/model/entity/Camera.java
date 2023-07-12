package cn.bit.nss.jiaxing_flood.model.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Camera {

    private Integer id;
    private String code;
    @JsonAlias("alert_level")
    private Integer alertLevel;
    private Double lat;
    private Double lng;
    private String address;
    private String stream;

    public Camera(Integer id, String code, Integer alertLevel, Double lat, Double lng, String address, String stream) {
        this.id = id;
        this.code = code;
        this.alertLevel = alertLevel;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.stream = stream;
    }

    public Camera() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(Integer alertLevel) {
        this.alertLevel = alertLevel;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
