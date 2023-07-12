package cn.bit.nss.jiaxing_flood.model.vo;

import cn.bit.nss.jiaxing_flood.model.entity.Camera;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Calendar;

public class CameraVO extends Camera {
    public CameraVO() {
    }

    public CameraVO(Integer id, String code, Integer alertLevel, Double lat, Double lng, String address, String stream) {
        super(id, code, alertLevel, lat, lng, address, stream);
    }
}
