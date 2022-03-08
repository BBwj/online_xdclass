package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
//视频轮播图
@Data
@ToString
public class VideoBanner {
    private  int id;
    private String url;

    private String img;
    @JsonProperty("create_times")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTimes;
    private int weight;


}
