package bl;

import dao.KelompokBarangDao;
import entity.Barang;
import entity.KelompokBarang;
import lombok.SneakyThrows;
import utils.AppException;
import utils.BusinessLogic;

@BusinessLogic
public class KelompokBarangBL {

    private KelompokBarang kelompokBarang = new KelompokBarang();


    /* -- INSERT --*/
    public void postInsert(KelompokBarang pojo) {
        checkDuplicateCode(pojo.getKodeKelompokBarang());
        kelompokBarang.insert(pojo);
    }

    /* -- INSERT WITH DETAIL --*/
    public void postInsertWithDetails(KelompokBarang pojo1, Barang pojo2) {
        checkDuplicateCode(pojo1.getKodeKelompokBarang());
        pojo1.getBarang().add(pojo2);
        kelompokBarang.insert(pojo1);
    }

    /* -- UPDATE --*/
    public void postUpdate(KelompokBarang pojo) {
        checkItemById(pojo.getIdKelompokBarang());
        kelompokBarang.update(pojo);
    }

    /* -- DELETE --*/
    public void postDelete(KelompokBarang pojo) {
        checkItemById(pojo.getIdKelompokBarang());
        kelompokBarang.delete(pojo);
    }


    /* -- COUNT -- */
    public long getTotalRecord() {
        KelompokBarangDao dao = new KelompokBarangDao();
        return dao.getCount();
    }


    // --------------------------------------------------------------------------------------------------
    // # PRIVATE METHOD --
    // --------------------------------------------------------------------------------------------------
    @SneakyThrows
    private void checkDuplicateCode(String kodeKelompokBarang) {
        KelompokBarangDao kelompokBarangDao = new KelompokBarangDao();
        KelompokBarang kelompokBarang = kelompokBarangDao.getByKode(kodeKelompokBarang);
        if (kelompokBarang != null) {
            throw new AppException("kode kelompok barang sudah ada, silahkan input dengan Kode yang lain.");
        }
    }

    @SneakyThrows
    private void checkItemById(long id) {
        KelompokBarangDao kelompokBarangDao = new KelompokBarangDao();
        KelompokBarang kelompokBarang = kelompokBarangDao.getById(id);
        if (kelompokBarang == null) {
            throw new AppException("Id kelompok barang tidak ada di master, silahkan di cek kembali.");
        }
    }

    @SneakyThrows
    private void checkItemByCode(String kode) {
        KelompokBarangDao kelompokBarangDao = new KelompokBarangDao();
        KelompokBarang kelompokBarang = kelompokBarangDao.getByKode(kode);
        if (kelompokBarang != null) {
            throw new AppException("kode kelompok barang tidak ada di master, silahkan di cek kembali.");
        }
    }
}
