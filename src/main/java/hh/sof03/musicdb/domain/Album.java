package hh.sof03.musicdb.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Album {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int releaseYear;
    @ManyToOne
    @JsonIgnoreProperties("albums")
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> songs;

    // Constructors

    public Album() {
        this.name = null;
        this.releaseYear = 0;
        this.artist = null;
    }

    public Album(String name, int releaseYear, Artist artist) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.artist = artist;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // ToString

    @Override
    public String toString() {

        if (this.artist != null) {
            return "Album [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", artist=" + artist + "]";
        } else {
            return "Album [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + "]";
        }

    }

}
