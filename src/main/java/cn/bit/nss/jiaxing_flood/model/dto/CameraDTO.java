package cn.bit.nss.jiaxing_flood.model.dto;

public class CameraDTO {
    private Double leftLat;
    private Double leftLng;
    private Double rightLat;
    private Double rightLng;

    public CameraDTO() {
    }

    public CameraDTO(Double leftLat, Double leftLng, Double rightLat, Double rightLng) {
        this.leftLat = leftLat;
        this.leftLng = leftLng;
        this.rightLat = rightLat;
        this.rightLng = rightLng;
    }

    public Double getLeftLat() {
        return leftLat;
    }

    public void setLeftLat(Double leftLat) {
        this.leftLat = leftLat;
    }

    public Double getLeftLng() {
        return leftLng;
    }

    public void setLeftLng(Double leftLng) {
        this.leftLng = leftLng;
    }

    public Double getRightLat() {
        return rightLat;
    }

    public void setRightLat(Double rightLat) {
        this.rightLat = rightLat;
    }

    public Double getRightLng() {
        return rightLng;
    }

    public void setRightLng(Double rightLng) {
        this.rightLng = rightLng;
    }
}
