package cn.bit.nss.jiaxing_flood.model.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

public class HotCircle {

    private Integer id;
    private String cameras;
    private Double lat;
    private Double lng;
    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public HotCircle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCameras() {
        return cameras;
    }

    public void setCameras(String cameras) {
        this.cameras = cameras;
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

    public HotCircle(Integer id, String cameras, Double lat, Double lng, Double radius) {
        this.id = id;
        this.cameras = cameras;
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
    }
}
