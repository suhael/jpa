package com.suhael.jpa.entities.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "calendar")
public class Calendar implements Serializable {

    @Id
    @GeneratedValue
    private int calendarId;
    private Date mondayStart;
    private Date mondayFinish;
    private Date tuesdayStart;
    private Date tuesdayFinish;

    public Calendar(){}

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public Date getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(Date mondayStart) {
        this.mondayStart = mondayStart;
    }

    public Date getMondayFinish() {
        return mondayFinish;
    }

    public void setMondayFinish(Date mondayFinish) {
        this.mondayFinish = mondayFinish;
    }

    public Date getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(Date tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public Date getTuesdayFinish() {
        return tuesdayFinish;
    }

    public void setTuesdayFinish(Date tuesdayFinish) {
        this.tuesdayFinish = tuesdayFinish;
    }
}
