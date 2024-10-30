package com.example.model;

/**
 * Authority.java
 *
 * @author QQDDTT
 * @since 0.2
 */
public class Authority {

    private String authorityId;
    private String authorityName;
    private String authorityDescription;
    public String getAuthorityId() {
        return authorityId;
    }
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }
    public String getAuthorityName() {
        return authorityName;
    }
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    public String getAuthorityDescription() {
        return authorityDescription;
    }
    public void setDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }
    @Override
    public String toString() {
        return "Authority [authorityId=" + authorityId + 
                ", authorityName=" + authorityName + 
                ", authorityDescription="
                + authorityDescription + "]";
    }
}
