package presentation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;

import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


class MenuTransaksi {

    private static final String TAG = "-- MASTER TRANSAKSI --";
    private static final Scanner input = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);

    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;

    void showMenu() {
        while (true) {
            System.out.println(DELI);
            System.out.println("Menu: " + TAG);
            System.out.println(DELI);
            System.out.println("-- TRANSAKSI HEADER");
            System.out.println("1. Show List Header");
            System.out.println("1. Input transaksi header");
            System.out.println("2. Update transaksi header");
            System.out.println("3. Hapus transaksi header");
            System.out.println(DELI);
            System.out.println("-- TRANSAKSI DETAIL");
            System.out.println("4. Show List Detail");
            System.out.println("5. Input transaksi detail");
            System.out.println("6. Update transaksi detail");
            System.out.println("7. Hapus transaksi detail");
            System.out.println(DELI);
            System.out.println("\n0. Back");
            System.out.println(DELI);
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
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
                    break;
                case 6:
                    break;
                case 7:
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

    }

    /* -- UPDATE --*/
    private void updateHeader() {

    }

    /* -- DELETE --*/
    private void deleteHeader() {

    }

    // ---------------------------------------------------------------------------
    /* -- DETAIL -- */
    // ---------------------------------------------------------------------------

}
