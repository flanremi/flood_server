package cn.bit.nss.jiaxing_flood.service.impl;

import cn.bit.nss.jiaxing_flood.mapper.CameraMapper;
import cn.bit.nss.jiaxing_flood.mapper.HotCircleMapper;
import cn.bit.nss.jiaxing_flood.model.entity.Camera;
import cn.bit.nss.jiaxing_flood.model.entity.HotCircle;
import cn.bit.nss.jiaxing_flood.model.entity.Result;
import cn.bit.nss.jiaxing_flood.model.vo.CameraVO;
import cn.bit.nss.jiaxing_flood.model.vo.HotCircleVO;
import cn.bit.nss.jiaxing_flood.service.intf.CameraService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Resource
    private CameraMapper cameraMapper;
    @Resource
    private HotCircleMapper hotCircleMapper;

    @Override
    public Result getCameraList() {
        QueryWrapper<Camera> wrapper = new QueryWrapper<>();
        List<Camera> cameras = cameraMapper.selectList(wrapper);
        if (cameras != null){
            List<CameraVO> cameraVOs = new ArrayList<>();
            for (int i = 0; i < cameras.size(); i++) {
                Camera camera = cameras.get(i);
                CameraVO cameraVO = new CameraVO(camera.getId(),camera.getCode(),camera.getAlertLevel(),camera.getLat()
                        ,camera.getLng(),camera.getAddress(),camera.getStream());
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
                hotCircleVO.setColor("#33ff000000");
                hotCircleVO.setRadius(200.0);
                String[] strCameras = hotCircle.getCameras().split(",");
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
                hotCircleVOs.add(hotCircleVO);
            }
            return new Result(200, "ok", hotCircleVOs);
        }

        return new Result(400,"error","");
    }
}
