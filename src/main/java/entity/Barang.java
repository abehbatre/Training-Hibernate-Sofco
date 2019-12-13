package entity;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import utils.Crud;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "adit_master_barang", uniqueConstraints = {@UniqueConstraint(columnNames = {"kode_barang"})})
@Data public class Barang extends Crud<Barang> implements Serializable {


    @Id
    @GenericGenerator(name = "auto", strategy = "increment")
    @GeneratedValue(generator = "auto")
    @Column(name = "id_barang", nullable = false, unique = true, length = 20)
    private long idBarang;

    @ManyToOne
    @JoinColumn(name = "id_kelompok_barang", referencedColumnName = "id_kelompok")
    private KelompokBarang idKelompokBarang;

    @Column(name = "kode_barang", unique = true, length = 20)
    private String kodeBarang;

    @Column(name = "nama_barang", length = 20)
    private String namaBarang;

    @Column(name = "unit1", length = 5)
    private String unit1;

    @Column(name = "convert_unit_1_to_2", length = 2)
    private int convertUnit1To2;

    @Column(name = "unit2", length = 5)
    private String unit2;

    @Column(name = "convert_unit_2_to_stock", length = 2)
    private int convertUnit2ToStock;

    @Column(name = "unit_stok", length = 5)
    private String unitStok;

    @Column(name = "active_flag", length = 1)
    private String activeFlag;


    // --------------------------------------------------------------------------------------------------
    // # C R U D  --
    // --------------------------------------------------------------------------------------------------
    @Override
    public void insert(Barang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void update(Barang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void delete(Barang entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        sessionFactory.close();
    }
}

