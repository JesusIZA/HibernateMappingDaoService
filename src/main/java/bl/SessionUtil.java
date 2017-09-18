package bl;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Jesus on 19.09.2017.
 */
public class SessionUtil {

    private Session session;
    private Transaction transaction;

    public Session getSession(){
        return session;
    }

    public Transaction getTransaction(){
        return transaction;
    }

    public Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransactionSession() {
        transaction.commit();
        closeSession();
    }
}
