package hh.sof03.musicdb.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Artist {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Please add a name")
    private String name;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    private List<Album> albums;

    // Constructors

    public Artist() {
        this.name = null;
    }

    public Artist(String name) {
        this.name = name;
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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    // ToString

    @Override
    public String toString() {
        return "Artist [id=" + id + ", name=" + name + "]";
    }

}
