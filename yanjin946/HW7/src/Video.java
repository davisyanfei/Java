/**
 * Homework 7 - Video
 * <p>
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 */
public class Video {
    private final Channel channel;
    private final int duration;
    private int numViews;
    private final java.lang.String videoName;

    public Video (java.lang.String videoName, Channel channel, int minutes, int seconds ) {
        this.videoName = videoName;
        this.channel = channel;
        this.duration = duration;
        this.numViews = numViews;
    }

    public void addView() {
        this.numViews = numViews + 1 ;
    }

    public Channel getChannel() {
        return channel;
    }

    public java.lang.String getDuration() {
        int minutes = duration / 60 ;
        int seconds = duration % 60 ;
        String durationFinal = minutes + ":" + seconds;
        return durationFinal;
    }

    public java.lang.String getVideoName() {
        return videoName;
    }

    public int getViews() {
        return numViews;
    }

    public void setViews(int numViews) {
        this.numViews = numViews;
    }

    public java.lang.String toString() {
        String format = "Video[%.2s, %.2s, %.2s, %.2d]";
        return String.format(format, videoName, channel, getDuration(),numViews);
    }


}

