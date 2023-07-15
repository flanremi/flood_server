package cn.bit.nss.jiaxing_flood.model.vo;

import cn.bit.nss.jiaxing_flood.model.entity.Camera;
import cn.bit.nss.jiaxing_flood.model.entity.HotCircle;

import java.util.List;

public class HotCircleVO {

    private Integer id;
    private Double lat;
    private Double lng;
    private Double radius;
    private int alertLevel;
    private List<Camera> cameras;

    public HotCircleVO(HotCircle hotCircle){
        this.id = hotCircle.getId();
        this.lat = hotCircle.getLat();
        this.lng = hotCircle.getLng();
        this.radius = hotCircle.getRadius();
    }

    public HotCircleVO(Integer id, Double lat, Double lng, Double radius, int alertLevel, List<Camera> cameras) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.alertLevel = alertLevel;
        this.radius = radius;
        this.cameras = cameras;
    }

    public HotCircleVO() {
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public int getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(int alertLevel) {
        this.alertLevel = alertLevel;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }
}
