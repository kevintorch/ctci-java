package ood.jukebox;

public class CDPlayer {
    private Playlist playlist;
    private CD c;

    public CDPlayer(CD c, Playlist p) {
        this.c = c;
        this.playlist = p;
    }

    public CDPlayer(Playlist p) {
        this(null, p);
    }

    public CDPlayer(CD c) {
        this(c, null);
    }

    public void playSong(Song song) {
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public CD getC() {
        return c;
    }

    public void setC(CD c) {
        this.c = c;
    }
}
