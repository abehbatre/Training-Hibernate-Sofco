package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.Crud;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adit_master_transaksi_header", uniqueConstraints = {@UniqueConstraint(columnNames = {"nomor_bon"})})
public class TransaksiHeader extends Crud<TransaksiHeader> implements Serializable {

    @Id
    @Column(name = "nomor_bon", nullable = false, unique = true)
    private int nomorBon;

    @Column(name = "tanggal_bon")
    private String tanggalBon;

    @Column(name = "bagian")
    private String bagianPeminta;

    @Column(name = "keterangan")
    private String keterangan;

    @OneToMany(mappedBy = "nomorBon", cascade = {CascadeType.ALL})
    private Set<TransaksiDetail> detail = new HashSet<>();


    // --------------------------------------------------------------------------------------------------
    // # C R U D  --
    // --------------------------------------------------------------------------------------------------
    @Override
    public void insert(TransaksiHeader entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void update(TransaksiHeader entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void delete(TransaksiHeader entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        sessionFactory.close();
    }



    // --------------------------------------------------------------------------------------------------
    // # SETTER GETTER --
    // --------------------------------------------------------------------------------------------------
    public int getNomorBon() {
        return nomorBon;
    }

    public void setNomorBon(int nomorBon) {
        this.nomorBon = nomorBon;
    }

    public String getTanggalBon() {
        return tanggalBon;
    }

    public void setTanggalBon(String tanggalBon) {
        this.tanggalBon = tanggalBon;
    }

    public String getBagianPeminta() {
        return bagianPeminta;
    }

    public void setBagianPeminta(String bagianPeminta) {
        this.bagianPeminta = bagianPeminta;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Set<TransaksiDetail> getDetail() {
        return detail;
    }

    public void setDetail(Set<TransaksiDetail> detail) {
        this.detail = detail;
    }
}
