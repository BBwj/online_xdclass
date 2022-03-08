package net.xdclass.online_xdclass.controller;


import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.model.request.LoginRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.service.impl.UserSeriviceompl;
import net.xdclass.online_xdclass.utils.JsonDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
      private UserService userService;
    //注册
    @PostMapping("register")
    public JsonDate register(@RequestBody Map<String,String> useInfo){
        System.out.println(useInfo);
               int rows= userService.save(useInfo);

            return rows==1?JsonDate.buildSuccess(rows):JsonDate.buildSError("注册失败");


    }
//    登录接口
//
    @PostMapping("login")
    public  JsonDate login(@RequestBody LoginRequest loginRequest){
      String token=  userService.findByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());
        return  token==null?JsonDate.buildSError("登录失败，账号密码错误"):JsonDate.buildSuccess(token);
    }
    @GetMapping("find_by_token")
    public JsonDate  findUserInfoByToken(HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");

        if(userId == null){
            return JsonDate.buildSError("查询失败");
        }

        User user =  userService.findByUserId(userId);

        return JsonDate.buildSuccess(user);

    }
}
