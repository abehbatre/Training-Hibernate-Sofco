package presentation;

import bl.TransaksiBL;
import dao.TransaksiDao;
import entity.TransaksiDetail;
import entity.TransaksiHeader;

import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


class MenuTransaksi {

    private static final String TAG = "-- MASTER TRANSAKSI --";
    private static final Scanner input = new Scanner(System.in);

    private TransaksiHeader transaksiHeader;
    private TransaksiDetail transaksiDetail;
    private TransaksiBL transaksiBL;
    private TransaksiDao transaksiDao;


    void showMenu() {
        while (true) {
            System.out.println(DELI);
            System.out.println("Menu: " + TAG);
            System.out.println(DELI);
            System.out.println("-- TRANSAKSI HEADER");
            System.out.println("1. Show List Header");
            System.out.println("2. Input transaksi header");
            System.out.println("3. Update transaksi header");
            System.out.println("4. Hapus transaksi header");
            System.out.println(DELI);
            System.out.println("-- TRANSAKSI DETAIL");
            System.out.println("5. Show List Detail");
            System.out.println("6. Input transaksi detail");
            System.out.println("7. Update transaksi detail");
            System.out.println("8. Hapus transaksi detail");
            System.out.println(DELI);
            System.out.println("\n0. Back");
            System.out.println(DELI);
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            System.out.println(DELI);

            switch (pilihan) {
                case 1:
                    clearConsole();
                    showListHeader();
                    break;
                case 2:
                    clearConsole();
                    insertHeader();
                    break;
                case 3:
                    clearConsole();
                    updateHeader();
                    break;
                case 4:
                    clearConsole();
                    deleteHeader();
                    break;
                case 5:
                    clearConsole();
                    showListDetail();
                    break;
                case 6:
                    clearConsole();
                    insertDetail();
                    break;
                case 7:
                    clearConsole();
                    updateDetail();
                    break;
                case 8:
                    clearConsole();
                    deleteDetail();
                    break;
                case 0:
                    clearConsole();
                    new MainMenu();
                    break;
            }
        }
    }


    // ---------------------------------------------------------------------------
    /* -- HEADER -- */
    // ---------------------------------------------------------------------------
    private void showListHeader() {

    }

    /* -- SHOW BY ID -- */
    private void showByIdHeader(long i) {

    }

    /* -- INSERT -- */
    private void insertHeader() {
        transaksiHeader = new TransaksiHeader();
        transaksiDetail = new TransaksiDetail();
        transaksiBL = new TransaksiBL();

        System.out.println("");
        System.out.println("Input Transaksi Header");
        System.out.println("----------------------");
        System.out.print("Nomor bon      : ");
        transaksiHeader.setNomorBon(input.nextInt());
        System.out.print("Bagian Peminta : ");
        transaksiHeader.setBagianPeminta(input.next());
        System.out.print("Keterangan     : ");
        transaksiHeader.setKeterangan(input.next());
        System.out.print("Apakah ingin menginput transaksi detailnya? [Y/T] : ");
        String pilih = input.next();

        if (pilih.equalsIgnoreCase("Y")) {
            System.out.println(DELI);
            System.out.println("# INSERT");
            System.out.println(DELI);
            System.out.print("Kode barang   : ");
            transaksiDetail.setKodeBarang(input.next());
            System.out.print("Jumlah barang : ");
            transaksiDetail.setJumlahBarang(input.nextInt());
            System.out.print("Unit          : ");
            transaksiDetail.setUnit(input.next());
            transaksiDetail.setNomorBon(transaksiHeader);

            transaksiBL.postInsertHeaderWithDetail(transaksiHeader, transaksiDetail);

        } else if (pilih.equalsIgnoreCase("T")) {
            transaksiBL.postInsertHeader(transaksiHeader);

        } else {
            System.out.println("Input tidak dikenali, kembali ke halaman Menu Utama..");
            new MainMenu();
        }

    }

    /* -- UPDATE --*/
    private void updateHeader() {
        transaksiHeader = new TransaksiHeader();
        transaksiBL = new TransaksiBL();

        System.out.println(DELI);
        System.out.println("# UPDATE");
        System.out.println(DELI);
        System.out.print("Nomor bon yang akan diubah : ");
        transaksiHeader.setNomorBon(input.nextInt());
        System.out.print("Bagian Peminta : ");
        transaksiHeader.setBagianPeminta(input.next());
        System.out.print("Keterangan     : ");
        transaksiHeader.setKeterangan(input.next());

        transaksiBL.updateHeader(transaksiHeader);
    }

    /* -- DELETE --*/
    private void deleteHeader() {
        transaksiHeader = new TransaksiHeader();
        transaksiBL = new TransaksiBL();

        System.out.println(DELI);
        System.out.println("# DELETE");
        System.out.println(DELI);
        System.out.print("Nomor bon yang akan dihapus : ");
        transaksiHeader.setNomorBon(input.nextInt());

        transaksiBL.deleteHeader(transaksiHeader);
    }

    // ---------------------------------------------------------------------------
    /* -- DETAIL -- */
    // ---------------------------------------------------------------------------
    private void showListDetail() {
        transaksiDao = new TransaksiDao();

        System.out.println(DELI);
        System.out.print("Transaksi untuk nomor bon : ");
        System.out.println(DELI);
        int nomorBon = input.nextInt();

        transaksiDao.getByNomorBon(nomorBon);
    }

    /* -- SHOW BY ID -- */
    private void showByIdDetail(long i) {

    }

    /* -- INSERT -- */
    private void insertDetail() {
        transaksiDetail = new TransaksiDetail();
        transaksiBL = new TransaksiBL();

        System.out.println(DELI);
        System.out.println("# INSERT");
        System.out.println(DELI);
        System.out.print("Nomor bon     : ");
        int nmrBon = input.nextInt();
        System.out.print("Kode barang   : ");
        transaksiDetail.setKodeBarang(input.next());
        System.out.print("Jumlah barang : ");
        transaksiDetail.setJumlahBarang(input.nextInt());
        System.out.print("Unit          : ");
        transaksiDetail.setUnit(input.next());

        transaksiBL.postInsertDetail(transaksiDetail, nmrBon);
    }

    /* -- UPDATE --*/
    private void updateDetail() {
        transaksiDetail = new TransaksiDetail();
        transaksiBL = new TransaksiBL();
        System.out.println(DELI);
        System.out.println("# UPDATE");
        System.out.println(DELI);
        System.out.print("Nomor bon yang ingin diubah : ");
        int nmrBon = input.nextInt();
        System.out.print("Kode barang   : ");
        transaksiDetail.setKodeBarang(input.next());
        System.out.print("Jumlah barang : ");
        transaksiDetail.setJumlahBarang(input.nextInt());
        System.out.print("Unit          : ");
        transaksiDetail.setUnit(input.next());

        transaksiBL.setNomorBonDiDetail(transaksiDetail, nmrBon);
        transaksiBL.updateDetail(transaksiDetail);
    }

    /* -- DELETE --*/
    private void deleteDetail() {
        System.out.println(DELI);
        System.out.println("# DELETE");
        System.out.println(DELI);
        System.out.print("Nomor bon yang ingin dihapus : ");
        int nmrBon = input.nextInt();

        transaksiBL.setNomorBonDiDetail(transaksiDetail, nmrBon);
        transaksiBL.deleteDetail(transaksiDetail);
    }
}
