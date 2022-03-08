package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VidoeController {
//视频列表
    @Autowired
    private VideoService videoService;
@RequestMapping("list")
    public Object listVideo(){
    List<Video> videoList=videoService.listVideo();
       return JsonDate.buildSuccess(videoList);
  }
  //轮播图列表
  @GetMapping("list_banner")
  public JsonDate indexBanner(){
List<VideoBanner> baneerList =videoService.listBanner();

return JsonDate.buildSuccess(baneerList);
  }
  //视频信息
    @GetMapping("find_detail_by_id")
    public  JsonDate findDetailById(@RequestParam(value="video_id",required =true/*默认是true*/) int videoId ){
    Video video=videoService.findDetailById(videoId);

return JsonDate.buildSuccess(video);
    }
}
