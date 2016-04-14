/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jasim
 */
@Entity
@Table(name = "followers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followers.findAll", query = "SELECT f FROM Followers f"),
    @NamedQuery(name = "Followers.findByFollowersId", query = "SELECT f FROM Followers f WHERE f.followersId = :followersId")})
public class Followers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followers_id")
    private Integer followersId;
    @JoinColumn(name = "follower_user_profile_id", referencedColumnName = "user_profiles_id")
    @ManyToOne(optional = false)
    private UserProfiles followerUserProfileId;
    @JoinColumn(name = "followee_user_profile_id", referencedColumnName = "user_profiles_id")
    @ManyToOne(optional = false)
    private UserProfiles followeeUserProfileId;

    public Followers() {
    }

    public Followers(Integer followersId) {
        this.followersId = followersId;
    }

    public Integer getFollowersId() {
        return followersId;
    }

    public void setFollowersId(Integer followersId) {
        this.followersId = followersId;
    }

    public UserProfiles getFollowerUserProfileId() {
        return followerUserProfileId;
    }

    public void setFollowerUserProfileId(UserProfiles followerUserProfileId) {
        this.followerUserProfileId = followerUserProfileId;
    }

    public UserProfiles getFolloweeUserProfileId() {
        return followeeUserProfileId;
    }

    public void setFolloweeUserProfileId(UserProfiles followeeUserProfileId) {
        this.followeeUserProfileId = followeeUserProfileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followersId != null ? followersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followers)) {
            return false;
        }
        Followers other = (Followers) object;
        if ((this.followersId == null && other.followersId != null) || (this.followersId != null && !this.followersId.equals(other.followersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Followers[ followersId=" + followersId + " ]";
    }
    
}
