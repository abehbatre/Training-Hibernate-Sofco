package bl;

import dao.KelompokBarangDao;
import entity.Barang;
import entity.KelompokBarang;
import lombok.SneakyThrows;
import utils.AppException;
import utils.BusinessLogic;

@BusinessLogic
public class KelompokBarangBL {

    /* -- INSERT --*/
    public void postInsert(KelompokBarang kelompokBarang) {
        checkDuplicateCode(kelompokBarang.getKodeKelompokBarang());
        KelompokBarang.insertKelompokBarang(kelompokBarang);
    }

    /* -- INSERT WITH DETAIL --*/
    public void postInsertWithDetails(KelompokBarang kelompokBarang, Barang barang) {
        checkDuplicateCode(kelompokBarang.getKodeKelompokBarang());
        kelompokBarang.getBarang().add(barang);
        KelompokBarang.insertKelompokBarang(kelompokBarang);
    }

    /* -- UPDATE --*/
    public void postUpdate(KelompokBarang kelompokBarang) {
        checkItemById(kelompokBarang.getIdKelompokBarang());
        KelompokBarang.updateKelompokBarang(kelompokBarang);
    }

    /* -- DELETE --*/
    public void postDelete(KelompokBarang kelompokBarang) {
        checkItemById(kelompokBarang.getIdKelompokBarang());
        KelompokBarang.deleteKelompokBarang(kelompokBarang);
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
        if (kelompokBarang != null) {
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
