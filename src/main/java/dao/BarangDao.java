package dao;

import entity.Barang;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;
import utils.Repository;

import java.util.List;

@Repository(Barang.class)
public class BarangDao {

    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;


    // GET ALL LIST
    public List getAllList() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Barang");
        return (List<Barang>) query.list();
    }


    // GET BY NAME
    public Barang getByName(String keyword) {
        session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE namaBarang LIKE :s")
                .setParameter("s", '%' + keyword + '%');
        return (Barang) query.uniqueResult();
    }

    public Barang getByKode(String kodeBarang) {
        session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE kodeBarang = :barang")
                .setString("barang", kodeBarang);
        return (Barang) query.uniqueResult();
    }


    // GET BY ID
    public Barang getById(Long idBarang) {
        session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM Barang WHERE idBarang = :barang")
                .setParameter("barang", idBarang);
        return (Barang) query.uniqueResult();
    }

    // GET COUNT
    public long getCount() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT COUNT (id) FROM Barang");
        return (long) query.uniqueResult();
    }
}
