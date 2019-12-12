package entity;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import utils.AppHelper;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "adit_master_kelompok_barang", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_kelompok"})})
@Data public class KelompokBarang {

    @Id
    @GenericGenerator(name = "auto", strategy = "increment")
    @GeneratedValue(generator = "auto")
    @Column(name = "id_kelompok", nullable = false, unique = true)
    private int idKelompokBarang;

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
    public static void insertKelompokBarang(KelompokBarang kelompokBarang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(kelompokBarang);
        tx.commit();
        // sessionFactory.close();
    }

    public static void updateKelompokBarang(KelompokBarang kelompokBarang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(kelompokBarang);
        tx.commit();
        // sessionFactory.close();
    }

    public static void deleteKelompokBarang(KelompokBarang kelompokBarang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(kelompokBarang);
        tx.commit();
        // sessionFactory.close();
    }


}
