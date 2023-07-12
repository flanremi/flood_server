//package cn.bit.nss.jiaxing_flood.service.impl;
//  视图层对象定义
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.flan.demo_126.mapper.StudentMapper;
//import com.flan.demo_126.model.dto.LoginDTO;
//import com.flan.demo_126.model.entity.Result;
//import com.flan.demo_126.model.entity.Student;
//import com.flan.demo_126.model.vo.LoginVO;
//import com.flan.demo_126.service.intf.LoginService;
//import com.flan.demo_126.tools.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginServiceImpl implements LoginService {
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//
//    @Override
//    public Result login(LoginDTO loginDTO) {
//        if(StringUtils.isEmpty(loginDTO.getUsername())){
//            return new Result(400, "usernames can not be empty", "");
//        }
//        if (StringUtils.isEmpty(loginDTO.getPassword())){
//            return new Result(400,"password can not be empty","");
//        }
//        QueryWrapper<Student> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", loginDTO.getUsername());
//        Student student = studentMapper.selectOne(wrapper);
//        if (student != null && student.getPassword().equals(loginDTO.getPassword())){
//            String token = JwtUtil.createToken(student);
//            LoginVO loginVO = new LoginVO(student.getId(), token, student);
//
//            return new Result(200, "", loginVO);
//        }
//
//        return new Result(400,"error","");
//    }
//}
