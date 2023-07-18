package cn.bit.nss.jiaxing_flood.service.intf;

import cn.bit.nss.jiaxing_flood.model.dto.CameraDTO;
import cn.bit.nss.jiaxing_flood.model.dto.StreamInDTO;
import cn.bit.nss.jiaxing_flood.model.entity.Result;

import java.util.List;

public interface CameraService {

    Result getCameraList(CameraDTO cameraDTO);

    Result getHotCircle();

    Result getStream(StreamInDTO in);

}
