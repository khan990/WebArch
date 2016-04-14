/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jasim
 */
@Entity
@Table(name = "tweets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tweets.findAll", query = "SELECT t FROM Tweets t"),
    @NamedQuery(name = "Tweets.findByTweetId", query = "SELECT t FROM Tweets t WHERE t.tweetId = :tweetId"),
    @NamedQuery(name = "Tweets.findByTweetText", query = "SELECT t FROM Tweets t WHERE t.tweetText = :tweetText"),
    @NamedQuery(name = "Tweets.findByCreatedAt", query = "SELECT t FROM Tweets t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Tweets.findByGeoLat", query = "SELECT t FROM Tweets t WHERE t.geoLat = :geoLat"),
    @NamedQuery(name = "Tweets.findByGeoLong", query = "SELECT t FROM Tweets t WHERE t.geoLong = :geoLong")})
public class Tweets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tweet_id")
    private Integer tweetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tweet_text")
    private String tweetText;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "created_at")
    private String createdAt;
    @Size(max = 45)
    @Column(name = "geo_lat")
    private String geoLat;
    @Size(max = 45)
    @Column(name = "geo_long")
    private String geoLong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweetId")
    private Collection<TweetMentions> tweetMentionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweetId")
    private Collection<TweetUrl> tweetUrlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweetId")
    private Collection<TweetTag> tweetTagCollection;
    @JoinColumn(name = "user_profile_id", referencedColumnName = "user_profiles_id")
    @ManyToOne(optional = false)
    private UserProfiles userProfileId;

    public Tweets() {
    }

    public Tweets(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public Tweets(Integer tweetId, String tweetText, String createdAt) {
        this.tweetId = tweetId;
        this.tweetText = tweetText;
        this.createdAt = createdAt;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    public String getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(String geoLong) {
        this.geoLong = geoLong;
    }

    @XmlTransient
    public Collection<TweetMentions> getTweetMentionsCollection() {
        return tweetMentionsCollection;
    }

    public void setTweetMentionsCollection(Collection<TweetMentions> tweetMentionsCollection) {
        this.tweetMentionsCollection = tweetMentionsCollection;
    }

    @XmlTransient
    public Collection<TweetUrl> getTweetUrlCollection() {
        return tweetUrlCollection;
    }

    public void setTweetUrlCollection(Collection<TweetUrl> tweetUrlCollection) {
        this.tweetUrlCollection = tweetUrlCollection;
    }

    @XmlTransient
    public Collection<TweetTag> getTweetTagCollection() {
        return tweetTagCollection;
    }

    public void setTweetTagCollection(Collection<TweetTag> tweetTagCollection) {
        this.tweetTagCollection = tweetTagCollection;
    }

    public UserProfiles getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UserProfiles userProfileId) {
        this.userProfileId = userProfileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tweetId != null ? tweetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tweets)) {
            return false;
        }
        Tweets other = (Tweets) object;
        if ((this.tweetId == null && other.tweetId != null) || (this.tweetId != null && !this.tweetId.equals(other.tweetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tweets[ tweetId=" + tweetId + " ]";
    }
    
}
