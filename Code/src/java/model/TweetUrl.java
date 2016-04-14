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
@Table(name = "tweet_url")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TweetUrl.findAll", query = "SELECT t FROM TweetUrl t"),
    @NamedQuery(name = "TweetUrl.findByTweetUrlId", query = "SELECT t FROM TweetUrl t WHERE t.tweetUrlId = :tweetUrlId"),
    @NamedQuery(name = "TweetUrl.findByUrl", query = "SELECT t FROM TweetUrl t WHERE t.url = :url")})
public class TweetUrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tweet_url_id")
    private Integer tweetUrlId;
    @Size(max = 45)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "tweet_id", referencedColumnName = "tweet_id")
    @ManyToOne(optional = false)
    private Tweets tweetId;

    public TweetUrl() {
    }

    public TweetUrl(Integer tweetUrlId) {
        this.tweetUrlId = tweetUrlId;
    }

    public Integer getTweetUrlId() {
        return tweetUrlId;
    }

    public void setTweetUrlId(Integer tweetUrlId) {
        this.tweetUrlId = tweetUrlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        hash += (tweetUrlId != null ? tweetUrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TweetUrl)) {
            return false;
        }
        TweetUrl other = (TweetUrl) object;
        if ((this.tweetUrlId == null && other.tweetUrlId != null) || (this.tweetUrlId != null && !this.tweetUrlId.equals(other.tweetUrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TweetUrl[ tweetUrlId=" + tweetUrlId + " ]";
    }
    
}
