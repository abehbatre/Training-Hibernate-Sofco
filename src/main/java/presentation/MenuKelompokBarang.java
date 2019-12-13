package presentation;

import bl.KelompokBarangBL;
import dao.KelompokBarangDao;
import entity.Barang;
import entity.KelompokBarang;

import java.util.List;
import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


class MenuKelompokBarang {

    private static final String TAG = "KELOMPOK BARANG";
    private static final Scanner input = new Scanner(System.in);

    private KelompokBarang kelompokBarang;
    private KelompokBarangBL kelompokBarangBL;
    private KelompokBarangDao kelompokBarangDao;
    private Barang barang;

    void showMenu() {
        kelompokBarangBL = new KelompokBarangBL();
        while (true) {
            System.out.println(DELI);
            System.out.println("MENU: " + TAG);
            System.out.println("TOTAL RECORD: " + kelompokBarangBL.getTotalRecord());
            System.out.println(DELI);
            System.out.println("1. Show List");
            System.out.println("2. Insert");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println(DELI);
            System.out.println("\n0. Back");
            System.out.println(DELI);
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            System.out.println(DELI);

            switch (pilihan) {
                case 1:
                    clearConsole();
                    showList();
                    break;
                case 2:
                    clearConsole();
                    insert();
                    break;
                case 3:
                    clearConsole();
                    update();
                    break;
                case 4:
                    clearConsole();
                    delete();
                    break;
                case 0:
                    clearConsole();
                    new MainMenu();
                    break;
            }
        }
    }


    /* -- SHOW ALL LIST -- */
    private void showList() {
        kelompokBarangDao = new KelompokBarangDao();
        List<KelompokBarang> kelompokBarangList = kelompokBarangDao.getAllList();

        for (KelompokBarang kelompokBarang : kelompokBarangList) {
            System.out.println(DELI);
            System.out.println("ID      : " + kelompokBarang.getIdKelompokBarang());
            System.out.println("Kode    : " + kelompokBarang.getKodeKelompokBarang());
            System.out.println("Nama    : " + kelompokBarang.getNamaKelompokBarang());
        }

        System.out.print("Input ID kelompok barang untuk cari kelompok barang : ");
        long i = input.nextLong();
        showById(i);
    }

    /* -- SHOW BY ID -- */
    private void showById(long i) {
        kelompokBarangDao = new KelompokBarangDao();
        KelompokBarang kelompokBarang = kelompokBarangDao.getById(i);
        if (kelompokBarang != null) {
            System.out.println(DELI);
            System.out.println("ID Kelompok Barang   : " + kelompokBarang.getIdKelompokBarang());
            System.out.println("Kode Kelompok Barang : " + kelompokBarang.getKodeKelompokBarang());
            System.out.println("Nama Kelompok Barang : " + kelompokBarang.getNamaKelompokBarang());
        } else {
            clearConsole();
            System.out.println("-- NO DATA --");
            input.next();
        }

    }

    /* -- INSERT -- */
    private void insert() {
        kelompokBarangBL = new KelompokBarangBL();
        kelompokBarang = new KelompokBarang();
        barang = new Barang();

        System.out.println(DELI);
        System.out.println("# INPUT " + TAG);
        System.out.println(DELI);
        System.out.print("Kode kelompok Barang : ");
        kelompokBarang.setKodeKelompokBarang(input.next());
        System.out.print("Nama kelompok Barang : ");
        kelompokBarang.setNamaKelompokBarang(input.next());
        System.out.print("Apakah ingin menginput data barang? [Y/T] : ");
        String pilih = input.next();

        if (pilih.equalsIgnoreCase("Y")) {
            System.out.println(DELI);
            System.out.println("# INPUT BARANG");
            System.out.println(DELI);
            System.out.print("Kode barang        : ");
            barang.setKodeBarang(input.next());
            System.out.print("Nama barang        : ");
            barang.setNamaBarang(input.next());
            System.out.print("Unit 1             : ");
            barang.setUnit1(input.next());
            System.out.print("Konversi 1 ke 2    : ");
            barang.setConvertUnit1To2(input.nextInt());
            System.out.print("Unit 2             : ");
            barang.setUnit2(input.next());
            System.out.print("Konversi 2 ke Stok : ");
            barang.setConvertUnit2ToStock(input.nextInt());
            System.out.print("Unit stok          : ");
            barang.setUnitStok(input.next());
            System.out.print("Status aktif       : ");
            barang.setActiveFlag(input.next());
            barang.setKelompokBarang(kelompokBarang);

            kelompokBarangBL.postInsertWithDetails(kelompokBarang, barang);

        } else if (pilih.equalsIgnoreCase("T")) {
            kelompokBarangBL.postInsert(kelompokBarang);
        } else {
            System.out.println("Input tidak dikenali, kembali ke halaman Menu Utama..");
            new MainMenu();
        }


    }

    /* -- UPDATE --*/
    private void update() {
        kelompokBarangBL = new KelompokBarangBL();
        kelompokBarang = new KelompokBarang();

        System.out.println(DELI);
        System.out.println("Update Kelompok Barang");
        System.out.println(DELI);
        System.out.print("ID kelompok Barang yang akan diubah : ");
        kelompokBarang.setIdKelompokBarang(input.nextLong());
        System.out.print("Kode kelompok Barang : ");
        kelompokBarang.setKodeKelompokBarang(input.next());
        System.out.print("Nama kelompok Barang : ");
        kelompokBarang.setNamaKelompokBarang(input.next());

        kelompokBarangBL.postUpdate(kelompokBarang);
    }

    /* -- DELETE --*/
    private void delete() {
        kelompokBarangBL = new KelompokBarangBL();
        kelompokBarang = new KelompokBarang();

        System.out.println(DELI);
        System.out.println("Delete Kelompok Barang");
        System.out.println(DELI);
        System.out.print("ID kelompok Barang yang akan dihapus : ");
        kelompokBarang.setIdKelompokBarang(input.nextLong());

        kelompokBarangBL.postDelete(kelompokBarang);
    }
}
