package com.bookcdstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cd")
public class CD extends Item {

    // ======================================
    // =             Attributes             =
    // ======================================
	
    private String musicCompany;
    private Integer numberOfCDs;
    private Float totalDuration;
    private String gender;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="art_cd", joinColumns = @JoinColumn(name ="cd_fk"), inverseJoinColumns = @JoinColumn(name="artist_fk"))
    private List<Artist> createdByArtists;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="cd")
	private List<Track> tracks;

    // ======================================
    // =            Constructors            =
    // ======================================
	public CD() {
    }

    public CD(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String gender) {
        super(title, price, description);
        this.musicCompany = musicCompany;
        this.numberOfCDs = numberOfCDs;
        this.totalDuration = totalDuration;
        this.gender = gender;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
		public List<Artist> getCreatedByArtists() {
        return createdByArtists;
    }

    public void setCreatedByArtists(List<Artist> createdByArtists) {
        this.createdByArtists = createdByArtists;
    }

    public void createdBy(Artist artist) {
        if (createdByArtists == null)
            createdByArtists = new ArrayList<Artist>();
        createdByArtists.add(artist);
    }
    
    public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}