package hh.sof03.musicdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String length;
    @ManyToOne
    @JsonIgnoreProperties("songs")
    @JoinColumn(name = "album_id")
    private Album album;
    private String youtubeQuery;

    // Constructors

    public Song() {
        this.name = null;
        this.length = null;
        this.album = null;
        this.youtubeQuery = null;
    }

    public Song(String name, String length, Album album) {
        this.name = name;
        this.length = length;
        this.album = album;
        this.youtubeQuery = name.replace(' ', '+').concat("+" + album.getArtist().getName().replace(' ', '+'));
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.youtubeQuery = name.replace(' ', '+');
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
        this.youtubeQuery += "+" + album.getArtist().getName().replace(' ', '+'); // Not working, maybe not used with crud?
    }

    public String getYoutubeQuery() {
        return youtubeQuery;
    }

    // ToString

    @Override
    public String toString() {

        if (this.album != null) {
            return "Song [id=" + id + ", name=" + name + ", length=" + length + ", album=" + album + "]";
        } else {
            return "Song [id=" + id + ", name=" + name + ", length=" + length + "]";
        }

    }

}
