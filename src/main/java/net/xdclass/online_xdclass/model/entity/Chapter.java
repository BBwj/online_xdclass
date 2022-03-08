package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
//章对象

@Data
@ToString

public class Chapter {
    private Integer id;
    @JsonProperty("video_id")
    private Integer videoId;
    private String title;
    private Integer ordered;
    @JsonProperty("create_times")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTimes;
    @JsonProperty("episode_list")
    private List<Episode>episodeList;


}
