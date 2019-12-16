package bl;

import dao.BarangDao;
import dao.TransaksiDao;
import entity.Barang;
import entity.TransaksiDetail;
import entity.TransaksiHeader;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.AppException;
import utils.HibernateUtilities;

import java.time.LocalDate;

public class TransaksiBL {

    private TransaksiHeader headers = new TransaksiHeader();
    private TransaksiDetail details = new TransaksiDetail();

    // -- HEADER AREA --
    public void postInsertHeader(TransaksiHeader pojo) {
        checkDuplicateNomorBon(pojo.getNomorBon());
        setTanggalBon(pojo);
        headers.insert(pojo);
    }

    public void postInsertHeaderWithDetail(TransaksiHeader pojo1, TransaksiDetail pojo2) {
        checkDuplicateNomorBon(pojo1.getNomorBon());
        setTanggalBon(pojo1);
        setAtributDiDetail(pojo2);
        headers.insert(pojo1);
        details.insert(pojo2);
    }

    public void updateHeader(TransaksiHeader pojo) {
        checkItemByNomorBon(pojo.getNomorBon());
        headers.update(pojo);
    }

    public void deleteHeader(TransaksiHeader pojo) {
        checkItemByNomorBon(pojo.getNomorBon());
        headers.delete(pojo);
    }


    // -- DETAIL AREA
    public void postInsertDetail(TransaksiDetail pojo, int nomorBon) {
        setNomorBonDiDetail(pojo, nomorBon);
        setAtributDiDetail(pojo);
        details.insert(pojo);
    }

    public void updateDetail(TransaksiDetail pojo) {
        setAtributDiDetail(pojo);
        details.update(pojo);
    }

    public void deleteDetail(TransaksiDetail pojo) {
        details.delete(pojo);
    }


    ///////////////////////////////////////////////////////////////////////////
    // PRIVATE METHOD
    ///////////////////////////////////////////////////////////////////////////
    @SneakyThrows
    private void checkDuplicateNomorBon(int nomorBon) {
        TransaksiDao transaksiDao = new TransaksiDao();
        TransaksiHeader transaksiHeader = transaksiDao.getByNomborBon(nomorBon);
        if (transaksiHeader != null) {
            throw new AppException("Nomor bon sudah ada, silahkan input dengan Kode yang lain.");
        }
    }
    @SneakyThrows
    private void checkItemByNomorBon(int nomorBon) {
        TransaksiDao transaksiDao = new TransaksiDao();
        TransaksiHeader transaksiHeader = transaksiDao.getByNomborBon(nomorBon);
        if (transaksiHeader == null) {
            throw new AppException("Nomor bon tidak ada di master, silahkan di cek kembali.");
        }
    }
    private void setTanggalBon(TransaksiHeader header) {
        String tanggal = LocalDate.now().toString();
        header.setTanggalBon(tanggal);
    }

    private void setAtributDiDetail(TransaksiDetail detail) {
        setJumlahDalamStokDiDetail(detail);
        setUnitStokDiDetail(detail);
    }

    private void setJumlahDalamStokDiDetail(TransaksiDetail detail) {
        String kodeBarang = detail.getKodeBarang();
        String unit = detail.getUnit();
        int jumlah = detail.getJumlahBarang();

        BarangDao barangDao = new BarangDao();
        Barang barang = barangDao.getByKode(kodeBarang);

        int total;
        int konversi1Ke2 = barang.getConvertUnit1To2();
        int konversi2KeStok = barang.getConvertUnit2ToStock();

        switch (unit) {
            case "unit1": total = jumlah * konversi1Ke2 * konversi2KeStok; break;
            case "unit2": total = jumlah * konversi2KeStok; break;
            default: total = jumlah;
        }
        detail.setJumlahDalamStok(total);
    }

    public void setNomorBonDiDetail(TransaksiDetail detail, int nomorBon) {
        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();

        detail.setNomorBon((TransaksiHeader) session.load(TransaksiHeader.class, nomorBon));
    }

    private void setUnitStokDiDetail(TransaksiDetail detail) {
        String kodeBarang = detail.getKodeBarang();

        BarangDao barangDao = new BarangDao();
        Barang barang = barangDao.getByKode(kodeBarang);
        String unitStok = barang.getUnitStok();

        detail.setUnitStok(unitStok);
    }

}
