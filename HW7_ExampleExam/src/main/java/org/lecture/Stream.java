package org.lecture;

public class Stream {
    //Genre;Trackid;Interpret;Album;Song;Stream-Counter
    private Genre genre;
    private int trackID;
    private String interpret, album, song;
    private int streamCounter;

    public Stream(Genre genre, int trackID, String interpret, String album, String song, int streamCounter) {
        this.genre = genre;
        this.trackID = trackID;
        this.interpret = interpret;
        this.album = album;
        this.song = song;
        this.streamCounter = streamCounter;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        interpret = interpret;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        song = song;
    }

    public int getStreamCounter() {
        return streamCounter;
    }

    public void setStreamCounter(int streamCounter) {
        this.streamCounter = streamCounter;
    }

    /*
    (alles links bündig)
    Interpret: 35 Zeichen, Album: 75 Zeichen, Track-ID: 2 Zeichen, Song: 55 Zeichen, Genre: Wie es ist
    Cyndi Lauper                        | She's So Unusual                                                            |#19: Girls Just Want to Have Fun                            		(POP
     */
  @Override
    public String toString() {
        return String.format("%-35s | %-75s |#%-2d: %-55s (%s)", interpret, album, trackID, song, genre);
    }

    public String formatWithoutGenres() {
        return String.format("%-35s | %-75s |#%-2d: %-55s", interpret, album, trackID, song);
    }
   public String formatMinStreaming(){
      return String.format("%s (on '%s'): %s (Streaming-Counter: %d)" , interpret, album, song, streamCounter);
   }
}
