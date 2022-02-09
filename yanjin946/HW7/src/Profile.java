/**
 * Homework 7 - Profile
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 */
public class Profile {

    private final java.lang.String username;

    private Channel[] subscribed;

    private int numSubscribed;

    public Profile (java.lang.String username) {
        this.username = username;
        this.numSubscribed = 0;
        this.subscribed = Channel[100];
    }

    public java.lang.String getUsername() {
        return username;
    }

    public Channel[] getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Channel[] subscribed, int numSubscribed) {
        this.subscribed = subscribed;
        this.numSubscribed = numSubscribed;
    }

    public boolean subscribeToChannel (Channel channel) {
        if (subscribed.length >= 100) {
            return false;
        }
        for (int i = 0 ; i < numSubscribed; i++) {
            if ( subscribed[i] == null ) {
                channel[i] = channel;
                numSubscribed++;
            }
        }

    }

    public Channel findChannel (java.lang.String channelName) {
        for (int i = 0; i < numSubscribed; i++) {
            if (subscribed[i].equals(username)) {
                return subscribed[i];
            } else {
                return null;
            }
        }


    }

    public java.lang.String toString() {
        String format = "Profile[%.2s]";
        return String.format(format, username);
    }


}

