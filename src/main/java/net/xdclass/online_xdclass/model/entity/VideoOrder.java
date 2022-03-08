package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

//订单对象

@Data
@ToString
public class VideoOrder {
    private  Integer id;
    @JsonProperty("out_trade_no")
    private  String outTradeNo;
    private  Integer state;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    @JsonProperty("total_fee")
    private  Integer totalFee;
    @JsonProperty("video_id")
    private  Integer videoId;
    @JsonProperty("video_title")
    private  String videoTitle;
    @JsonProperty("video_img")
    private  String videoImg;
    @JsonProperty("user_id")
    private Integer userId;


}
