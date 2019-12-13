package bl;

import dao.BarangDao;
import entity.Barang;
import lombok.SneakyThrows;
import utils.AppException;
import utils.BusinessLogic;

@BusinessLogic
public class BarangBL {

    private Barang barang = new Barang();

    /* -- INSERT --*/
    public void postInsert(Barang pojo) {
        checkDuplicateId(pojo.getIdBarang());
        barang.insert(pojo);
    }

    /* -- UPDATE --*/
    public void postUpdate(Barang pojo) {
        checkItemById(pojo.getIdBarang());
        barang.update(pojo);
    }

    /* -- DELETE --*/
    public void postDelete(Barang pojo) {
        checkItemById(pojo.getIdBarang());
        barang.delete(pojo);
    }

    /* -- COUNT -- */
    public long getTotalRecord() {
        BarangDao barangDao = new BarangDao();
        return barangDao.getCount();
    }


    // --------------------------------------------------------------------------------------------------
    // # PRIVATE METHOD --
    // --------------------------------------------------------------------------------------------------
    @SneakyThrows
    private void checkDuplicateId(long id) {
        BarangDao barangDao = new BarangDao();
        Barang barang = barangDao.getById(id);
        if (barang != null) {
            throw new AppException("kode barang sudah ada, silahkan input dengan Kode yang lain.");
        }
    }

    @SneakyThrows
    private void checkActiveFlag(long id) {
        BarangDao barangDao = new BarangDao();
        Barang barang = barangDao.getById(id);
        String status = barang.getActiveFlag();
        if (status.equalsIgnoreCase("Y")) {
            throw new AppException("Status barang aktif, tidak dapat di hapus.");
        }
    }

    @SneakyThrows
    private void checkItemById(long id) {
        BarangDao barangDao = new BarangDao();
        Barang barang = barangDao.getById(id);
        if (barang == null) {
            throw new AppException("Id barang tidak ada di master, silahkan di cek kembali.");
        }
    }
}
