package entity;

import lombok.Data;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import utils.HibernateUtilities;

import javax.persistence.*;


@Entity
@Table(name = "adit_master_barang", uniqueConstraints = {@UniqueConstraint(columnNames = {"kode_barang"})})
@Data public class Barang {


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
    public static void insertBarang(Barang barang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(barang);
        tx.commit();
        sessionFactory.close();
    }

    public static void updateBarang(Barang barang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(barang);
        tx.commit();
        sessionFactory.close();
    }

    public static void deleteBarang(Barang barang) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(barang);
        tx.commit();
        sessionFactory.close();
    }


    // --------------------------------------------------------------------------------------------------
    // # SETTER GETTER  --
    // --------------------------------------------------------------------------------------------------
    public long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(long idBarang) {
        this.idBarang = idBarang;
    }

    public KelompokBarang getIdKelompokBarang() {
        return idKelompokBarang;
    }

    public void setIdKelompokBarang(KelompokBarang idKelompokBarang) {
        this.idKelompokBarang = idKelompokBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public int getConvertUnit1To2() {
        return convertUnit1To2;
    }

    public void setConvertUnit1To2(int convertUnit1To2) {
        this.convertUnit1To2 = convertUnit1To2;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public int getConvertUnit2ToStock() {
        return convertUnit2ToStock;
    }

    public void setConvertUnit2ToStock(int convertUnit2ToStock) {
        this.convertUnit2ToStock = convertUnit2ToStock;
    }

    public String getUnitStok() {
        return unitStok;
    }

    public void setUnitStok(String unitStok) {
        this.unitStok = unitStok;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
}

