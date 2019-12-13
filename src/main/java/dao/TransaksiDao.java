package dao;

import entity.TransaksiDetail;
import entity.TransaksiHeader;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;
import utils.Repository;

import java.util.List;

@Repository({TransaksiHeader.class, TransaksiDetail.class})
public class TransaksiDao {

    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session = sessionFactory.openSession();

    public void getByNomorBon(int nomorBon) {
        session = sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery("" +
                "SELECT " +
                "   h.*, d.kode_barang, d.jumlah_barang,  d.unit, d.jumlah_dalam_stok, d.unit_stok" +
                "FROM " +
                "   adit_master_transaksi_header h" +
                "INNER JOIN " +
                "   adit_master_transaksi_detail d  " +
                "ON " +
                "   h.nomor_bon = d.nomor_bon" +
                "WHERE " +
                "   h.nomor_bon = :bon");
        query.setParameter("bon", nomorBon);

        List<TransaksiHeader> headers = query.list();
        List<TransaksiDetail> details = query.list();

        // header
        for (TransaksiHeader header : headers) {
            System.out.println("");
            System.out.println("Nomor Bon      : " + header.getNomorBon());
            System.out.println("Tanggal Bon    : " + header.getTanggalBon());
            System.out.println("Bagian Peminta : " + header.getNomorBon());
            System.out.println("Keterangan     : " + header.getKeterangan());

            // detail
            for (TransaksiDetail detail : details) {
                System.out.println("Kode barang     : " + detail.getKodeBarang());
                System.out.println("Jumlah barang   : " + detail.getJumlahBarang());
                System.out.println("Unit            : " + detail.getUnit());
                System.out.println("Jumlah dlm stok : " + detail.getJumlahDalamStok());
                System.out.println("Unit stok       : " + detail.getUnitStok());
            }

        }
    }


    // GET BY Nomor Bon
    public TransaksiHeader getByNomborBon(int nomorBon) {
        session = sessionFactory.openSession();
        Query query = session
                .createQuery("FROM TransaksiHeader WHERE nomorBon = :nomorBon")
                .setParameter("nomorBon", nomorBon);

        return (TransaksiHeader) query.uniqueResult();
    }
}
