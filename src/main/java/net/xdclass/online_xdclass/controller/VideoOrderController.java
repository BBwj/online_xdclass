package net.xdclass.online_xdclass.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.service.VideoOrderService;
import net.xdclass.online_xdclass.utils.JsonDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;
    @RequestMapping("save")
    public JsonDate saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId= (Integer) request.getAttribute("user_id");

      int rows=  videoOrderService.save(userId,videoOrderRequest.getVideoId());


       return rows==0?JsonDate.buildSError("失败"):JsonDate.buildSuccess();

    }
    @GetMapping("list")
    public  JsonDate listOrder(HttpServletRequest request){
        Integer userId= (Integer) request.getAttribute("user_id");
        List<VideoOrder> videoOrderList= videoOrderService.listOrderByUserId(userId);
        return JsonDate.buildSuccess(videoOrderList);

    }

}
