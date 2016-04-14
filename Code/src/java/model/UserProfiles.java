/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jasim
 */
@Entity
@Table(name = "user_profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfiles.findAll", query = "SELECT u FROM UserProfiles u"),
    @NamedQuery(name = "UserProfiles.findByUserProfilesId", query = "SELECT u FROM UserProfiles u WHERE u.userProfilesId = :userProfilesId"),
    @NamedQuery(name = "UserProfiles.findByScreenName", query = "SELECT u FROM UserProfiles u WHERE u.screenName = :screenName"),
    @NamedQuery(name = "UserProfiles.findByEmail", query = "SELECT u FROM UserProfiles u WHERE u.email = :email"),
    @NamedQuery(name = "UserProfiles.findByPassword", query = "SELECT u FROM UserProfiles u WHERE u.password = :password"),
    @NamedQuery(name = "UserProfiles.findByFname", query = "SELECT u FROM UserProfiles u WHERE u.fname = :fname"),
    @NamedQuery(name = "UserProfiles.findByLname", query = "SELECT u FROM UserProfiles u WHERE u.lname = :lname"),
    @NamedQuery(name = "UserProfiles.findByGender", query = "SELECT u FROM UserProfiles u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserProfiles.findByProfileImageUrl", query = "SELECT u FROM UserProfiles u WHERE u.profileImageUrl = :profileImageUrl"),
    @NamedQuery(name = "UserProfiles.findByCountry", query = "SELECT u FROM UserProfiles u WHERE u.country = :country"),
    @NamedQuery(name = "UserProfiles.findByCity", query = "SELECT u FROM UserProfiles u WHERE u.city = :city"),
    @NamedQuery(name = "UserProfiles.findByAddress", query = "SELECT u FROM UserProfiles u WHERE u.address = :address"),
    @NamedQuery(name = "UserProfiles.findByGeoLat", query = "SELECT u FROM UserProfiles u WHERE u.geoLat = :geoLat"),
    @NamedQuery(name = "UserProfiles.findByGeoLong", query = "SELECT u FROM UserProfiles u WHERE u.geoLong = :geoLong"),
    @NamedQuery(name = "UserProfiles.findByWebUrl", query = "SELECT u FROM UserProfiles u WHERE u.webUrl = :webUrl"),
    @NamedQuery(name = "UserProfiles.findByDescription", query = "SELECT u FROM UserProfiles u WHERE u.description = :description"),
    @NamedQuery(name = "UserProfiles.findByCreatedAt", query = "SELECT u FROM UserProfiles u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "UserProfiles.findByTimeZone", query = "SELECT u FROM UserProfiles u WHERE u.timeZone = :timeZone"),
    @NamedQuery(name = "UserProfiles.findByLastUpdate", query = "SELECT u FROM UserProfiles u WHERE u.lastUpdate = :lastUpdate")})
public class UserProfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_profiles_id")
    private Integer userProfilesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "screen_name")
    private String screenName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lname")
    private String lname;
    @Size(max = 45)
    @Column(name = "gender")
    private String gender;
    @Size(max = 200)
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "geo_lat")
    private String geoLat;
    @Size(max = 45)
    @Column(name = "geo_long")
    private String geoLong;
    @Size(max = 200)
    @Column(name = "web_url")
    private String webUrl;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Size(max = 45)
    @Column(name = "time_zone")
    private String timeZone;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetUserProfileId")
    private Collection<TweetMentions> tweetMentionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceUserProfileId")
    private Collection<TweetMentions> tweetMentionsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followerUserProfileId")
    private Collection<Followers> followersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followeeUserProfileId")
    private Collection<Followers> followersCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userProfileId")
    private Collection<Tweets> tweetsCollection;

    public UserProfiles() {
    }

    public UserProfiles(Integer userProfilesId) {
        this.userProfilesId = userProfilesId;
    }

    public UserProfiles(Integer userProfilesId, String screenName, String email, String password, String fname, String lname) {
        this.userProfilesId = userProfilesId;
        this.screenName = screenName;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    public Integer getUserProfilesId() {
        return userProfilesId;
    }

    public void setUserProfilesId(Integer userProfilesId) {
        this.userProfilesId = userProfilesId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<TweetMentions> getTweetMentionsCollection() {
        return tweetMentionsCollection;
    }

    public void setTweetMentionsCollection(Collection<TweetMentions> tweetMentionsCollection) {
        this.tweetMentionsCollection = tweetMentionsCollection;
    }

    @XmlTransient
    public Collection<TweetMentions> getTweetMentionsCollection1() {
        return tweetMentionsCollection1;
    }

    public void setTweetMentionsCollection1(Collection<TweetMentions> tweetMentionsCollection1) {
        this.tweetMentionsCollection1 = tweetMentionsCollection1;
    }

    @XmlTransient
    public Collection<Followers> getFollowersCollection() {
        return followersCollection;
    }

    public void setFollowersCollection(Collection<Followers> followersCollection) {
        this.followersCollection = followersCollection;
    }

    @XmlTransient
    public Collection<Followers> getFollowersCollection1() {
        return followersCollection1;
    }

    public void setFollowersCollection1(Collection<Followers> followersCollection1) {
        this.followersCollection1 = followersCollection1;
    }

    @XmlTransient
    public Collection<Tweets> getTweetsCollection() {
        return tweetsCollection;
    }

    public void setTweetsCollection(Collection<Tweets> tweetsCollection) {
        this.tweetsCollection = tweetsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userProfilesId != null ? userProfilesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfiles)) {
            return false;
        }
        UserProfiles other = (UserProfiles) object;
        if ((this.userProfilesId == null && other.userProfilesId != null) || (this.userProfilesId != null && !this.userProfilesId.equals(other.userProfilesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UserProfiles[ userProfilesId=" + userProfilesId + " ]";
    }
    
}
