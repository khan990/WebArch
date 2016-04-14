package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Wa_twitter_Dao {

    private Session currentSession;

    private Transaction currentTransaction;

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public Wa_twitter_Dao() {
    }

    public Session openCurrentSession() {
        SessionFactory testit = getSessionFactory();
        currentSession = testit.openSession();
        return currentSession;

        /*
         currentSession = getSessionFactory().openSession();
         return currentSession;
         */
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        /*
         Configuration configuration = new Configuration().configure();
         StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
         .applySettings(configuration.getProperties());
         SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
         return sessionFactory;
         */
        /*
         Configuration configuration = new Configuration();
         configuration.configure("hibernate.cfg.xml");
         StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
         SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
         Session session = sessionFactory.openSession();
         return sessionFactory;
         */
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    /*
     public void persist(Book entity) {
     getCurrentSession().save(entity);
     }

     public void update(Book entity) {
     getCurrentSession().update(entity);
     }

     public Book findById(String id) {
     Book book = (Book) getCurrentSession().get(Book.class, id);
     return book; 
     }

     public void delete(Book entity) {
     getCurrentSession().delete(entity);
     }

     @SuppressWarnings("unchecked")
     public List<Book> findAll() {
     List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
     return books;
     }

     public void deleteAll() {
     List<Book> entityList = findAll();
     for (Book entity : entityList) {
     delete(entity);
     }
     }
     */
    
    //Hibernate Examples
    /*
        public static List<UserProfiles> getAll(){
        
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        //wa_twitter_dao.getCurrentSession().beginTransaction();
        //List<UserProfiles> users = (List<UserProfiles>) wa_twitter_dao.getCurrentSession().createQuery("SELECT u FROM model.UserProfiles u").list();
        List<UserProfiles> users = Collections.checkedList(wa_twitter_dao.getCurrentSession().createQuery("FROM model.UserProfiles").list(), UserProfiles.class);
        //wa_twitter_dao.getCurrentSession().getTransaction().commit();
        wa_twitter_dao.closeCurrentSession();
        return users;
    }
    
    public static UserProfiles AddProfile(UserProfiles profile){
        
        Wa_twitter_Dao wa_twitter_dao = new Wa_twitter_Dao();
        wa_twitter_dao.openCurrentSession();
        
        wa_twitter_dao.getCurrentSession().save(profile);
        wa_twitter_dao.getCurrentTransaction().commit();
        
        wa_twitter_dao.closeCurrentSession();
        Logging.LogMe("User has been added to profile table. ", "UserProfiles.AddProfile");
        return profile;
    }
    */
}
