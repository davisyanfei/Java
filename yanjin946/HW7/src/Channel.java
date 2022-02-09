/**
 * Homework 7 - Channel
 * <p>
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 */
public class Channel {

    private final java.lang.String channelName;

    private int channelSubscribers;

    private int numUploads;

    private Video[] videos;

    public Channel(java.lang.String channelName) {
        this.videos  = 100 ;
        this.channelSubscribers = 0 ;
        this.numUploads = 0 ;
        this.channelName = channelName;
    }

    public Channel(java.lang.String channelName, int channelSubscribers, int numUploads, Video[] videos) {
        this.channelName = channelName;
        this.channelSubscribers = channelSubscribers;
        this.numUploads = numUploads;
        this.videos = videos;
    }

    public void addChannelSubscribers() {
        this.channelSubscribers = channelSubscribers + 1 ;
    }

    public Video findVideo(java.lang.String videoName) {
        for (int i = 0; i < numUploads; i++) {
            if (videos[i].equals(videoName)) {
                return videos[i];
            } else {
                return null;
            }
            }
        }


    public java.lang.String getChannelName() {
        return channelName;
    }

    public int getChannelSubscribers() {
        return channelSubscribers;
    }

    public int getNumUploads() {
        return numUploads;
    }

    public int getTotalViews() {
        return Video.getViews();
    }

    public Video[] getVideos() {
        return videos ;
    }

    public void setChannelSubscribers(int channelSubscribers) {
        this.channelSubscribers = channelSubscribers;
    }

    public void setVideos(Video[] videos, int numUploads) {
        this.videos = videos;
        this.numUploads = numUploads;
    }

    public java.lang.String toString() {
        String format = "Channel[%.2s, %.2d, %.2d]";
        return String.format (format, channelName, channelSubscribers, numUploads);
    }

    public boolean uploadVideo(Video video) {
        if (videos.length >= 100) {
            return false;
        }
        for (int i = 0 ; i < numUploads; i++) {
            if ( videos[i] == null ) {
                videos[i] = video;
                numUploads++;
            }
        }
        }

    }

