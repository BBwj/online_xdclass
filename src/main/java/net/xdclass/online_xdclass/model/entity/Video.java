package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

//视频对象
@Data
@ToString
public class Video {
    private  int id;
    private  String title;

    private  String summary;
@JsonProperty("cover_id")
    private  String coverImg;
    private  int price;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    private Double point;
    @JsonProperty("chapter_list")
    private List<Chapter>chapterList;

}
