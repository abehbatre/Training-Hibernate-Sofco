package entity;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import utils.AppHelper;
import utils.Crud;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "adit_master_kelompok_barang", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_kelompok"})})
@Data public class KelompokBarang extends Crud<KelompokBarang> implements Serializable {

    @Id
    @GenericGenerator(name = "auto", strategy = "increment")
    @GeneratedValue(generator = "auto")
    @Column(name = "id_kelompok", nullable = false, unique = true)
    private long idKelompokBarang;

    @OneToMany(mappedBy = "idKelompokBarang", cascade = {CascadeType.ALL})
    private Set<Barang> barang = new HashSet<>();

    @Column(name = "kode_kelompok")
    private String kodeKelompokBarang;

    @Column(name = "nama_kelompok")
    private String namaKelompokBarang;

    @Column(name = "create_at")
    private String createAt;

    @Column(name = "update_at")
    private String updateAt;


    // Initialize object
    {
        createAt = AppHelper.getCurrentDateTime();
    }


    // --------------------------------------------------------------------------------------------------
    // # C R U D  --
    // --------------------------------------------------------------------------------------------------
    @Override
    public void insert(KelompokBarang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        // sessionFactory.close();
    }

    @Override
    public void update(KelompokBarang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        // sessionFactory.close();
    }

    @Override
    public void delete(KelompokBarang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        // sessionFactory.close();
    }

}
