package com.bookcdstore.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class Track {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Float duration;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] wav;
    private String description;
    @ManyToOne
    @JoinColumn(name = "cd_fk")
    private CD cd;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "artist_fk")
    private Artist artist;

	// ======================================
    // =            Constructors            =
    // ======================================
	public Track() {
    }

    public Track(String title, Float duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public byte[] getWav() {
        return wav;
    }

    public void setWav(byte[] wav) {
        this.wav = wav;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}
	
    public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}