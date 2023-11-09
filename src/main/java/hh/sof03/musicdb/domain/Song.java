package hh.sof03.musicdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Song {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Please add a name")
    private String name;

    private String length;

    @ManyToOne
    @JsonIgnoreProperties("songs")
    @JoinColumn(name = "album_id")
    private Album album;

    // Constructors

    public Song() {
        this.name = null;
        this.length = null;
        this.album = null;
    }

    public Song(String name, String length, Album album) {
        this.name = name;
        this.length = length;
        this.album = album;
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
    }

    public String getYoutubeQuery() {
        String youtubeQueryStr = this.name;
        if (album != null) {
            youtubeQueryStr = youtubeQueryStr.replace(' ', '+')
                    .concat("+" + this.album.getArtist().getName().replace(' ', '+'));
        } else {
            youtubeQueryStr = youtubeQueryStr.replace(' ', '+');
        }
        return youtubeQueryStr;
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