package ood.jukebox;

import java.util.Queue;

public class Playlist {
    private final Song song;
    private final Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song song) {
        queue.add(song);
    }
}
