package cn.bit.nss.jiaxing_flood.controller;

import cn.bit.nss.jiaxing_flood.model.entity.Result;
import cn.bit.nss.jiaxing_flood.service.intf.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameraController {

    @Autowired
    CameraService cameraService;

    @PostMapping(value = "/get_camera_list")
    @CrossOrigin
    public Result getCameraList(){
        return cameraService.getCameraList();
    }

    @PostMapping(value = "/get_hot_circle")
    @CrossOrigin
    public Result getHotCircle(){
        return cameraService.getHotCircle();
    }



}
