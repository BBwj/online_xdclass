package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);


    User findByPhoneAndpwd(  @Param("phone") String phone, @Param("pwd")String pwd);

    User findByUserId(@Param("user_id") Integer userId);
}
