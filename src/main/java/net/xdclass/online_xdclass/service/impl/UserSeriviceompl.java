package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.ConmmonUtils;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserSeriviceompl  implements UserService {
     @Autowired
    private UserMapper userMapper;
     @Transactional
    @Override
    public int save(Map<String, String> uerInfo) {
        User user = parseToUser(uerInfo);
        if (user != null) {
            userMapper.save(user);
            return 1;
        } else {
            return -1;
        }
    }
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {

        User user=   userMapper.findByPhoneAndpwd(phone,ConmmonUtils.MD5(pwd));

        if(user==null){
            return null;
        }
        else {
            String token = JWTUtils.geneJsonWebToken(user);
            System.out.println(token);
            return  token;
        }
    }

    @Override
    public User findByUserId(int userId) {
      User user=userMapper.findByUserId(userId);

      return  user;
    }


    private User parseToUser(Map<String, String> uerInfo) {
        if (uerInfo.containsKey("phone") && uerInfo.containsKey("pwd") && uerInfo.containsKey("name")) {
            User user = new User();
            user.setName(uerInfo.get("name"));
            user.setHeadImg(getRandomImg());//随机头像
            
            user.setCreateTime(new Date());
            user.setPhone(uerInfo.get("phone"));
            String pwd = uerInfo.get("pwd");
            user.setPwd(ConmmonUtils.MD5(pwd));
            System.out.println(user);
            return user;
        } else {
            return null;
        }
    }
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };
    private String getRandomImg(){
        int size=headImg.length;
        Random random= new Random();
       int index= random.nextInt(size);
        return headImg[index];

    }

}
