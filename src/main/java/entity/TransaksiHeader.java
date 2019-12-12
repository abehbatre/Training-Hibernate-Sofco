package entity;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adit_master_transaksi_header", uniqueConstraints = {@UniqueConstraint(columnNames = {"nomor_bon"})})
@Data public class TransaksiHeader {

    @Id
    @Column(name = "nomor_bon", nullable = false, unique = true)
    private int nomorBon;

    @Column(name = "tanggal_bon")
    private String tanngalBon;

    @Column(name = "bagian")
    private String bagianPeminta;

    @Column(name = "keterangan")
    private String keterangan;

    @OneToMany(mappedBy = "nomorBon", cascade = {CascadeType.ALL})
    private Set<TransaksiDetail> detail = new HashSet<>();


    // --------------------------------------------------------------------------------------------------
    // # C R U D  --
    // --------------------------------------------------------------------------------------------------
    public static void insertHeader(TransaksiHeader header) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(header);
        tx.commit();
        sessionFactory.close();
    }

    public static void updateHeader(TransaksiHeader header) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(header);
        tx.commit();
        sessionFactory.close();
    }

    public static void deleteHeader(TransaksiHeader header) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(header);
        tx.commit();
        sessionFactory.close();
    }

    // --------------------------------------------------------------------------------------------------
    // # SETTER GETTER  --
    // --------------------------------------------------------------------------------------------------
    public int getNomorBon() {
        return nomorBon;
    }

    public void setNomorBon(int nomorBon) {
        this.nomorBon = nomorBon;
    }

    public String getTanngalBon() {
        return tanngalBon;
    }

    public void setTanngalBon(String tanngalBon) {
        this.tanngalBon = tanngalBon;
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
