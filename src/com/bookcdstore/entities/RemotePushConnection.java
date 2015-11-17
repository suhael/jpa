package com.bookcdstore.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(catalog="netdespatch", name="remotePushConnection")
public class RemotePushConnection {


    @EmbeddedId
    private RemotePushConnectionPK pk;
    private String label;
    private String pushServerAddress;
    private String lastConnectionTime;

    public RemotePushConnectionPK getPk() {
        return pk;
    }

    public void setPk(RemotePushConnectionPK pk) {
        this.pk = pk;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPushServerAddress() {
        return pushServerAddress;
    }

    public void setPushServerAddress(String pushServerAddress) {
        this.pushServerAddress = pushServerAddress;
    }

    public String getLastConnectionTime() {
        return lastConnectionTime;
    }

    public void setLastConnectionTime(String lastConnectionTime) {
        this.lastConnectionTime = lastConnectionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemotePushConnection that = (RemotePushConnection) o;

        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (lastConnectionTime != null ? !lastConnectionTime.equals(that.lastConnectionTime) : that.lastConnectionTime != null) return false;
        if (pk != null ? !pk.equals(that.pk) : that.pk != null) return false;
        if (pushServerAddress != null ? !pushServerAddress.equals(that.pushServerAddress) : that.pushServerAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pk != null ? pk.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (pushServerAddress != null ? pushServerAddress.hashCode() : 0);
        result = 31 * result + (lastConnectionTime != null ? lastConnectionTime.hashCode() : 0);
        return result;
    }
}
