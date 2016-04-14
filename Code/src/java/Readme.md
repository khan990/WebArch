Jboss

Username = khan990/afridi990
Password = khocha990
--------------------------------------------
Problems faced
--------------------------------------------
1. Problem
    jboss 7 compatibility problems
Solution
    used jboss 6
--------------------------------------------
2. Problem
    Datasource configuration
Solution
    followed http://www.mastertheboss.com/jboss-server/jboss-datasource/how-to-configure-a-datasource-with-jboss-7
    installed http://dev.mysql.com/downloads/connector/j/

--------------------------------------------
3. Problem
    standalone.xml settings
Solution
    <subsystem xmlns="urn:jboss:domain:datasources:1.2">
        <datasources>
            <datasource jta="true" jndi-name="java:/wa_twitter" pool-name="wa_twitter" enabled="true" use-java-context="true" use-ccm="true">
                <connection-url>jdbc:mysql://localhost:3306/wa_twitter</connection-url>
                <driver>MySQL</driver>
                <pool>
                    <min-pool-size>10</min-pool-size>
                    <max-pool-size>30</max-pool-size>
                </pool>
                <security>
                    <user-name>root</user-name>
                    <password>root</password>
                </security>
                <statement>
                    <prepared-statement-cache-size>100</prepared-statement-cache-size>
                    <share-prepared-statements>true</share-prepared-statements>
                </statement>
            </datasource>
            <drivers>
                <driver name="MySQL" module="com.mysql">
                    <driver-class>com.mysql.jdbc.Driver</driver-class>
                </driver>
                <driver name="h2" module="com.h2database.h2">
                    <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                </driver>
            </drivers>
        </datasources>
    </subsystem>
--------------------------------------------
4. Problem
    module.xml
Solution
    <?xml version="1.0" encoding="UTF-8"?>
 
    <module xmlns="urn:jboss:module:1.0" name="com.mysql">
      <resources>
        <resource-root path="mysql-connector-java-5.1.33-bin.jar"/>
      </resources>
      <dependencies>
        <module name="javax.api"/>
      </dependencies>
    </module>
--------------------------------------------
5. Problem
    Generation of Entity classes
Solution
    turns out, certain tags needed to be repeatedly told
    e.g. <driver-class>

        <subsystem xmlns="urn:jboss:domain:datasources:1.2">
            <datasources>
                <datasource jta="true" jndi-name="java:/wa_twitter" pool-name="wa_twitter" enabled="true" use-java-context="true" use-ccm="true">
                    <connection-url>jdbc:mysql://localhost:3306/wa_twitter</connection-url>
                    <driver>MySQL</driver>
					<driver-class>com.mysql.jdbc.Driver</driver-class>
					<transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>10</min-pool-size>
                        <max-pool-size>40</max-pool-size>
                    </pool>
                    <security>
                        <user-name>root</user-name>
                        <password>root</password>
                    </security>
					<validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <validate-on-match>
                            false
                        </validate-on-match>
                        <background-validation>
                            false
                        </background-validation>
                        <use-fast-fail>
                            false
                        </use-fast-fail>
                    </validation>
                    <timeout>
                        <blocking-timeout-millis>
                            5000
                        </blocking-timeout-millis>
                    </timeout>
                    <statement>
                        <prepared-statement-cache-size>100</prepared-statement-cache-size>
                        <share-prepared-statements>true</share-prepared-statements>
                    </statement>
                </datasource>
                <drivers>
                    <driver name="MySQL" module="com.mysql">
                        <driver-class>com.mysql.jdbc.Driver</driver-class>
                    </driver>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                </drivers>
            </datasources>
        </subsystem>
--------------------------------------------
6. Problem
    Problem because of depricated libraries from hibernation...
Solution
    http://stackoverflow.com/questions/15228392/buildsessionfactory-method-that-return-hibernate-sessionfactory-object-is-depr

--------------------------------------------
7. Problem
    Couldnt fetch data from mysql.
Solution
    problem with automatic generation of code by netbeans

    <mapping class="model.Followers" />
    <mapping class="model.TweetMentions" />
    <mapping class="model.TweetTag" />
    <mapping class="model.TweetUrl" />
    <mapping class="model.Tweets" />
    <mapping class="model.UserProfiles" />
--------------------------------------------
8. Problem
    scriplets create problems.
    problem faced during request value read
Solution
    Scriptlets should be avoided.
    JSTL or EL are prefered.
--------------------------------------------
9. Problem
    Login method
Solution
    Session will be used.

    urls are insecure
    cookies might be disabled in browsers
    cookies are of no utility in this architecture
--------------------------------------------
10. Problem
    How to login using session
Solution
    http://javaknowledge.info/login-and-registration-example-in-jsp-with-session/
--------------------------------------------
11. Problem
    Upload display picture
Solution
    <input type="file"/>
    but used servlet http://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
--------------------------------------------
12. Problem
    Picture saving problem
Solution
    seems like, jboss folders are write protected. 
    saved it in other folders.
    will look into it during deployment **********************
--------------------------------------------
13. Problem
    Persistance cannot save data to table.
Solution
    Auto increment should be ON @id
--------------------------------------------
14. Problem
    Accessing sessionbean in servlet
Solution
    http://www.coderanch.com/t/349099/Servlets/java/invoke-bean-servlet
--------------------------------------------
15. Problem
    Accessing mapped tables
Solution
    //Being Followed (Third Column)
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "followerUserProfileId", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followerUserProfileId")
    //@LazyCollection(LazyCollectionOption.FALSE)
    //@Fetch(FetchMode.SELECT)
    private Collection<Followers> followersCollection;
    
    //Following (2nd Column)
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "followeeUserProfileId", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followeeUserProfileId")
    //@LazyCollection(LazyCollectionOption.FALSE)
    //@Fetch(FetchMode.SELECT)
    private Collection<Followers> followersCollection1;
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------
--------------------------------------------