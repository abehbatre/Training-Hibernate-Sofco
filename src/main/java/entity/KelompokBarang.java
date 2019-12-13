package entity;

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
public class KelompokBarang extends Crud<KelompokBarang> implements Serializable {

    @Id
    @GenericGenerator(name = "auto", strategy = "increment")
    @GeneratedValue(generator = "auto")
    @Column(name = "id_kelompok", nullable = false, unique = true)
    private long idKelompokBarang;

    @OneToMany(mappedBy = "kelompokBarang", cascade = {CascadeType.ALL})
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
    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;

    @Override
    public void insert(KelompokBarang entity) {
        session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        // sessionFactory.close();
    }

    @Override
    public void update(KelompokBarang entity) {
        session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        // sessionFactory.close();
    }

    @Override
    public void delete(KelompokBarang entity) {
        session = sessionFactory.openSession();
        Transaction tx;

        tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        // sessionFactory.close();
    }


    // --------------------------------------------------------------------------------------------------
    // # SETTER GETTER --
    // --------------------------------------------------------------------------------------------------
    public long getIdKelompokBarang() {
        return idKelompokBarang;
    }

    public void setIdKelompokBarang(long idKelompokBarang) {
        this.idKelompokBarang = idKelompokBarang;
    }

    public Set<Barang> getBarang() {
        return barang;
    }

    public void setBarang(Set<Barang> barang) {
        this.barang = barang;
    }

    public String getKodeKelompokBarang() {
        return kodeKelompokBarang;
    }

    public void setKodeKelompokBarang(String kodeKelompokBarang) {
        this.kodeKelompokBarang = kodeKelompokBarang;
    }

    public String getNamaKelompokBarang() {
        return namaKelompokBarang;
    }

    public void setNamaKelompokBarang(String namaKelompokBarang) {
        this.namaKelompokBarang = namaKelompokBarang;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
