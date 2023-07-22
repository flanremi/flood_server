package cn.bit.nss.jiaxing_flood.service.impl;

import cn.bit.nss.jiaxing_flood.MyUtils;
import cn.bit.nss.jiaxing_flood.mapper.CameraMapper;
import cn.bit.nss.jiaxing_flood.mapper.HotCircleMapper;
import cn.bit.nss.jiaxing_flood.model.dto.CameraDTO;
import cn.bit.nss.jiaxing_flood.model.dto.StreamInDTO;
import cn.bit.nss.jiaxing_flood.model.dto.StreamPlayDTO;
import cn.bit.nss.jiaxing_flood.model.entity.Camera;
import cn.bit.nss.jiaxing_flood.model.entity.HotCircle;
import cn.bit.nss.jiaxing_flood.model.entity.Result;
import cn.bit.nss.jiaxing_flood.model.vo.CameraVO;
import cn.bit.nss.jiaxing_flood.model.vo.HotCircleVO;
import cn.bit.nss.jiaxing_flood.service.intf.CameraService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CameraServiceImpl implements CameraService {

    @Resource
    private CameraMapper cameraMapper;
    @Resource
    private HotCircleMapper hotCircleMapper;


    @Override
    public Result getStream(StreamInDTO in) {
        String url = MyUtils.hostAPi + "/play/forcePlay/" + in.getDeviceId() + "/" + in.getChannelId();
        RestTemplate restTemplate = new RestTemplate();

        // restTemplate是同步的请求方式
        try {
            StreamPlayDTO play = restTemplate.getForObject(url, StreamPlayDTO.class);
            return new Result(200,"ok", play.getData());
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500, "channelid或deviceid找不到目标:" + e.getMessage(), null);
        }
//        return new Result(200, "ok", new Random().nextInt(0,100) > 50? "":"http://192.168.23.128:8080/live/test1.flv");

    }

    @Override
    public Result getCameraList(CameraDTO cameraDTO) {
        QueryWrapper<Camera> wrapper = new QueryWrapper<>();
        wrapper.gt("lat", cameraDTO.getLeftLat())
        .gt("lng", cameraDTO.getLeftLng())
        .lt("lat", cameraDTO.getRightLat())
        .lt("lng", cameraDTO.getRightLng());
        List<Camera> cameras = cameraMapper.selectList(wrapper);
        if (cameras != null){
            List<CameraVO> cameraVOs = new ArrayList<>();
            for (int i = 0; i < cameras.size(); i++) {
                Camera camera = cameras.get(i);
                CameraVO cameraVO = new CameraVO(camera.getId(),camera.getCode(),camera.getAlertLevel(),camera.getLat()
                        ,camera.getLng(),camera.getAddress(),camera.getStream());
//                String channelId = camera.getStream().split("_")[0];
//                String deviceId = camera.getStream().split("_")[1];
//                String url = MyUtils.hostAPi + "/play/forcePlay/" + channelId + "/" + deviceId;
//                RestTemplate restTemplate = new RestTemplate();
//                StreamPlay play = restTemplate.getForObject(url, StreamPlay.class);
//                cameraVO.setStream(play.getData().getFlv());
                cameraVOs.add(cameraVO);
            }
            return new Result(200, "ok", cameraVOs);
        }

        return new Result(400,"error","");
    }

    @Override
    public Result getHotCircle() {
        QueryWrapper<HotCircle> wrapper = new QueryWrapper<>();
        List<HotCircle> hotCircles = hotCircleMapper.selectList(wrapper);
        if (hotCircles != null){
            List<HotCircleVO> hotCircleVOs = new ArrayList<>();
            for (int i = 0; i < hotCircles.size(); i++) {
                HotCircle hotCircle = hotCircles.get(i);
                HotCircleVO hotCircleVO = new HotCircleVO(hotCircle);
                String[] strCameras = hotCircle.getCameras().substring(1, hotCircle.getCameras().length() - 1).split(",");
                QueryWrapper<Camera> cameraQueryWrapper = new QueryWrapper<>();
                for (int j = 0; j < strCameras.length; j++) {
                    if(j < strCameras.length - 1){
                        cameraQueryWrapper.eq("id", strCameras[j]).or();
                    }else {
                        cameraQueryWrapper.eq("id", strCameras[j]);
                    }
                }
                List<Camera> cameras = cameraMapper.selectList(cameraQueryWrapper);
                hotCircleVO.setCameras(cameras);
                for (int j = 0; j < cameras.size(); j++) {
                    hotCircleVO.setAlertLevel(hotCircleVO.getAlertLevel() + cameras.get(j).getAlertLevel());
                }
                hotCircleVOs.add(hotCircleVO);
            }
            return new Result(200, "ok", hotCircleVOs);
        }

        return new Result(400,"error","");
    }
}
