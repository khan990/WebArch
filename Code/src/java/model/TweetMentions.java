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
@Table(name = "tweet_mentions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TweetMentions.findAll", query = "SELECT t FROM TweetMentions t"),
    @NamedQuery(name = "TweetMentions.findByTweetMentionsId", query = "SELECT t FROM TweetMentions t WHERE t.tweetMentionsId = :tweetMentionsId")})
public class TweetMentions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tweet_mentions_id")
    private Integer tweetMentionsId;
    @JoinColumn(name = "target_user_profile_id", referencedColumnName = "user_profiles_id")
    @ManyToOne(optional = false)
    private UserProfiles targetUserProfileId;
    @JoinColumn(name = "source_user_profile_id", referencedColumnName = "user_profiles_id")
    @ManyToOne(optional = false)
    private UserProfiles sourceUserProfileId;
    @JoinColumn(name = "tweet_id", referencedColumnName = "tweet_id")
    @ManyToOne(optional = false)
    private Tweets tweetId;

    public TweetMentions() {
    }

    public TweetMentions(Integer tweetMentionsId) {
        this.tweetMentionsId = tweetMentionsId;
    }

    public Integer getTweetMentionsId() {
        return tweetMentionsId;
    }

    public void setTweetMentionsId(Integer tweetMentionsId) {
        this.tweetMentionsId = tweetMentionsId;
    }

    public UserProfiles getTargetUserProfileId() {
        return targetUserProfileId;
    }

    public void setTargetUserProfileId(UserProfiles targetUserProfileId) {
        this.targetUserProfileId = targetUserProfileId;
    }

    public UserProfiles getSourceUserProfileId() {
        return sourceUserProfileId;
    }

    public void setSourceUserProfileId(UserProfiles sourceUserProfileId) {
        this.sourceUserProfileId = sourceUserProfileId;
    }

    public Tweets getTweetId() {
        return tweetId;
    }

    public void setTweetId(Tweets tweetId) {
        this.tweetId = tweetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tweetMentionsId != null ? tweetMentionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TweetMentions)) {
            return false;
        }
        TweetMentions other = (TweetMentions) object;
        if ((this.tweetMentionsId == null && other.tweetMentionsId != null) || (this.tweetMentionsId != null && !this.tweetMentionsId.equals(other.tweetMentionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TweetMentions[ tweetMentionsId=" + tweetMentionsId + " ]";
    }
    
}
