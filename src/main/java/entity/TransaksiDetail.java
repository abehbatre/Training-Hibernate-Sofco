package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.Crud;
import utils.HibernateUtilities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adit_master_transaksi_detail", uniqueConstraints = {@UniqueConstraint(columnNames = {"nomor_bon"})})
public class TransaksiDetail extends Crud<TransaksiDetail> implements Serializable {
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
    @Override
    public void insert(TransaksiDetail entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void update(TransaksiDetail entity) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        sessionFactory.close();
    }

    @Override
    public void delete(TransaksiDetail entity) {
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
