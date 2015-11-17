package com.bookcdstore.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RemotePushConnectionPK implements Serializable {

    private static final long serialVersionUID = 68L;

    private String clientApplication;
    private String clientRequest;
    private String clientName;

    public String getClientApplication() {
        return clientApplication;
    }

    public void setClientApplication(String clientApplication) {
        this.clientApplication = clientApplication;
    }

    public String getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(String clientRequest) {
        this.clientRequest = clientRequest;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((clientApplication == null) ? 0 : clientApplication
						.hashCode());
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result
				+ ((clientRequest == null) ? 0 : clientRequest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemotePushConnectionPK other = (RemotePushConnectionPK) obj;
		if (clientApplication == null) {
			if (other.clientApplication != null)
				return false;
		} else if (!clientApplication.equals(other.clientApplication))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (clientRequest == null) {
			if (other.clientRequest != null)
				return false;
		} else if (!clientRequest.equals(other.clientRequest))
			return false;
		return true;
	}
    
    
}