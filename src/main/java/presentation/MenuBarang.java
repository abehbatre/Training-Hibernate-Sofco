package presentation;

import bl.BarangBL;
import dao.BarangDao;
import entity.Barang;
import entity.KelompokBarang;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;

import java.util.List;
import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


class MenuBarang {
    private static final String TAG = "-- MASTER BARANG --";
    private static final Scanner input = new Scanner(System.in);

    private BarangBL barangBL;
    private BarangDao barangDao;
    private Barang barang;

    void showMenu() {
        barangBL = new BarangBL();
        while (true) {
            System.out.println(DELI);
            System.out.println("Menu: " + TAG);
            System.out.println("TOTAL RECORD: " + barangBL.getTotalRecord());
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
        barangDao = new BarangDao();
        List<Barang> barangs = barangDao.getAllList();

        for (Barang barang : barangs) {
            System.out.println(DELI);
            System.out.println("ID Barang :                 " + barang.getIdBarang());
            System.out.println("ID Kelompok Barang :        " + barang.getKelompokBarang().getIdKelompokBarang());
            System.out.println("Kode Barang :               " + barang.getKodeBarang());
            System.out.println("Nama Barang :               " + barang.getNamaBarang());
            System.out.println("Unit 1 :                    " + barang.getUnit1());
            System.out.println("Convert 1 ke 2 :            " + barang.getConvertUnit1To2());
            System.out.println("Unit 2 :                    " + barang.getUnit2());
            System.out.println("Convert 2 ke Stok :         " + barang.getConvertUnit2ToStock());
            System.out.println("Unit Stok :                 " + barang.getUnitStok());
        }

        System.out.println("Input Nama Barang untuk cari Barang Tertentu : ");
        String s = input.next();
        showByName(s);
    }

    /* -- SHOW BY NAME -- */
    private void showByName(String s) {
        barangDao = new BarangDao();
        barang = barangDao.getByName(s);

        System.out.println(DELI);
        System.out.println("ID Barang :                 " + barang.getIdBarang());
        System.out.println("ID Kelompok Barang :        " + barang.getKelompokBarang());
        System.out.println("Kode Barang :               " + barang.getKodeBarang());
        System.out.println("Nama Barang :               " + barang.getNamaBarang());
        System.out.println("Unit 1 :                    " + barang.getUnit1());
        System.out.println("Convert 1 ke 2 :            " + barang.getConvertUnit1To2());
        System.out.println("Unit 2 :                    " + barang.getUnit2());
        System.out.println("Convert 2 ke Stok :         " + barang.getConvertUnit2ToStock());
        System.out.println("Unit Stok :                 " + barang.getUnitStok());
    }

    /* -- INSERT -- */
    private void insert() {
        barang = new Barang();
        barangBL = new BarangBL();

        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(DELI);
        System.out.println("# INPUT BARANG");
        System.out.println(DELI);
        System.out.print("Kode barang        : ");
        barang.setKodeBarang(input.next());
        System.out.print("Nama barang        : ");
        barang.setNamaBarang(input.next());
        System.out.print("Id kelompok barang : ");
        barang.setKelompokBarang((KelompokBarang) session.load(KelompokBarang.class, input.nextLong()));
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

        barangBL.postInsert(barang);
    }

    /* -- UPDATE --*/
    private void update() {
        barang = new Barang();
        barangBL = new BarangBL();

        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(DELI);
        System.out.println("# UPDATE BARANG");
        System.out.println(DELI);
        System.out.print("ID barang          : ");
        barang.setIdBarang(input.nextLong());
        System.out.print("Kode barang        : ");
        barang.setKodeBarang(input.next());
        System.out.print("Nama barang        : ");
        barang.setNamaBarang(input.next());
        System.out.print("Id kelompok barang : ");
        barang.setKelompokBarang((KelompokBarang) session.load(KelompokBarang.class, input.nextLong()));
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

        barangBL.postUpdate(barang);
    }

    /* -- DELETE --*/
    private void delete() {
        barang = new Barang();
        barangBL = new BarangBL();

        System.out.println(DELI);
        System.out.println("# DELETE BARANG");
        System.out.println(DELI);
        System.out.print("ID Barang : ");
        barang.setIdBarang(input.nextLong());

        barangBL.postDelete(barang);
    }

}
