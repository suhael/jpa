package com.bookcdstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agentSiteLocationMapping")
public class AgentSiteLocationMapping {

    @Id
    private Long agentSiteId;

    private String externalId;
    private String externalType;

    public Long getAgentSiteId() {
        return agentSiteId;
    }

    public void setAgentSiteId(Long agentSiteId) {
        this.agentSiteId = agentSiteId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalType() {
        return externalType;
    }

    public void setExternalType(String externalType) {
        this.externalType = externalType;
    }

    @Override
    public String toString() {
        return "AgentSiteLocationMapping{" +
                "agentSiteId=" + agentSiteId +
                ", externalId='" + externalId + '\'' +
                ", externalType='" + externalType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentSiteLocationMapping that = (AgentSiteLocationMapping) o;

        if (agentSiteId != null ? !agentSiteId.equals(that.agentSiteId) : that.agentSiteId != null) return false;
        if (externalId != null ? !externalId.equals(that.externalId) : that.externalId != null) return false;
        if (externalType != null ? !externalType.equals(that.externalType) : that.externalType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = agentSiteId != null ? agentSiteId.hashCode() : 0;
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        result = 31 * result + (externalType != null ? externalType.hashCode() : 0);
        return result;
    }
}
