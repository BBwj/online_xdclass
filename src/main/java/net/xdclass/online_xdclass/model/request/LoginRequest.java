package net.xdclass.online_xdclass.model.request;

import lombok.Data;
import lombok.ToString;

//登录对象
@Data
@ToString
public class LoginRequest {
    private  String phone;
    private  String pwd;

}
