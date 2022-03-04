package ood.jukebox;

import java.util.Set;

public class Jukebox {
    private final CDPlayer cdPlayer;
    private final Set<CD> cdCollection;
    private final SongSelector songSelector;
    private User user;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector songSelector) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.songSelector = songSelector;
    }

    public Song getCurrentSong() {
        return songSelector.getCurrentSong();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
