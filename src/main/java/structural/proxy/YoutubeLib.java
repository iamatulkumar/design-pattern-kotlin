package structural.proxy;

import java.util.HashMap;

public interface YoutubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
