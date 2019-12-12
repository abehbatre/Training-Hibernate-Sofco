package entity;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adit_master_transaksi_detail", uniqueConstraints = {@UniqueConstraint(columnNames = {"nomor_bon"})})
@Data public class TransaksiDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "nomor_bon", referencedColumnName = "nomor_bon", nullable = false, unique = true)
    private TransaksiHeader nomorBon;

    @Column(name = "kode_barang")
    private String kodeBarang;

    @Column(name = "jumlah_barang")
    private int jumlahBarang;

    @Column(name = "unit")
    private String unit;

    @Column(name = "jumlah_dalam_stok")
    private int jumlahDalamStok;

    @Column(name = "unit_stok")
    private String unitStok;

    // --------------------------------------------------------------------------------------------------
    // # C R U D  --
    // --------------------------------------------------------------------------------------------------
    public static void insertDetail(TransaksiDetail detail) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(detail);
        tx.commit();
        sessionFactory.close();
    }

    public static void updateDetail(TransaksiDetail detail) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(detail);
        tx.commit();
        sessionFactory.close();
    }

    public static void deleteDetail(TransaksiDetail detail) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(detail);
        tx.commit();
        sessionFactory.close();
    }


    // --------------------------------------------------------------------------------------------------
    // # SETTER GETTER  --
    // --------------------------------------------------------------------------------------------------
    public TransaksiHeader getNomorBon() {
        return nomorBon;
    }

    public void setNomorBon(TransaksiHeader nomorBon) {
        this.nomorBon = nomorBon;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getJumlahDalamStok() {
        return jumlahDalamStok;
    }

    public void setJumlahDalamStok(int jumlahDalamStok) {
        this.jumlahDalamStok = jumlahDalamStok;
    }

    public String getUnitStok() {
        return unitStok;
    }

    public void setUnitStok(String unitStok) {
        this.unitStok = unitStok;
    }
}
