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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jasim
 */
@Entity
@Table(name = "tweet_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TweetTag.findAll", query = "SELECT t FROM TweetTag t"),
    @NamedQuery(name = "TweetTag.findByTweetTagId", query = "SELECT t FROM TweetTag t WHERE t.tweetTagId = :tweetTagId"),
    @NamedQuery(name = "TweetTag.findByTag", query = "SELECT t FROM TweetTag t WHERE t.tag = :tag")})
public class TweetTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tweet_tag_id")
    private Integer tweetTagId;
    @Size(max = 45)
    @Column(name = "tag")
    private String tag;
    @JoinColumn(name = "tweet_id", referencedColumnName = "tweet_id")
    @ManyToOne(optional = false)
    private Tweets tweetId;

    public TweetTag() {
    }

    public TweetTag(Integer tweetTagId) {
        this.tweetTagId = tweetTagId;
    }

    public Integer getTweetTagId() {
        return tweetTagId;
    }

    public void setTweetTagId(Integer tweetTagId) {
        this.tweetTagId = tweetTagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        hash += (tweetTagId != null ? tweetTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TweetTag)) {
            return false;
        }
        TweetTag other = (TweetTag) object;
        if ((this.tweetTagId == null && other.tweetTagId != null) || (this.tweetTagId != null && !this.tweetTagId.equals(other.tweetTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TweetTag[ tweetTagId=" + tweetTagId + " ]";
    }
    
}
