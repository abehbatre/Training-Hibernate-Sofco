package dao;

import entity.Barang;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.Dao;
import utils.HibernateUtilities;

import java.util.List;

@Dao(Barang.class)
public class BarangDao {

    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;

    public List getAllList() {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Barang");
        return (List<Barang>) query.list();
    }

    public Barang filterByName(String keyword) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE namaBarang LIKE :s")
                .setParameter("s", '%' + keyword + '%');
        return (Barang) query.uniqueResult();
    }

    public Barang getByKode(String kodeBarang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE kodeBarang = :barang")
                .setString("barang", kodeBarang);
        return (Barang) query.uniqueResult();
    }

    public Barang getById(Long idBarang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE idBarang = :barang")
                .setParameter("barang", idBarang);
        return (Barang) query.uniqueResult();
    }

    // GET COUNT
    public long getCount() {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT COUNT (id) FROM Barang");
        return (long) query.uniqueResult();
    }
}
