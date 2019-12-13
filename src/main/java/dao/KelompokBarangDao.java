package dao;

import entity.KelompokBarang;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;

import java.util.List;

public class KelompokBarangDao {
    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;

    // GET ALL LIST
    public List<KelompokBarang> getAllList() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("FROM KelompokBarang");
        return (List<KelompokBarang>) query.list();
    }


    // GET BY ID
    public KelompokBarang getById(long id) {
        session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM KelompokBarang WHERE id = :id")
                .setParameter("id", id);

        return (KelompokBarang) query.uniqueResult();
    }


    // GET BY KODE
    public KelompokBarang getByKode(String kode) {
        session = sessionFactory.openSession();
        Query query = session.createQuery("FROM KelompokBarang WHERE kodeKelompokBarang = :kode");
        query.setString("kode", kode);
        return (KelompokBarang) query.uniqueResult();
    }


    // GET COUNT
    public long getCount() {
        session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT COUNT (id) FROM KelompokBarang");
        return (long) query.uniqueResult();
    }

}
