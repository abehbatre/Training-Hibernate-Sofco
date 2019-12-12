package presentation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtilities;

import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


class MenuBarang {
    private static final String TAG = "-- MASTER BARANG --";
    private static final Scanner input = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);

    private SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    private Session session;


    void showMenu() {
        while (true) {
            System.out.println(DELI);
            System.out.println("Menu: " + TAG);
            System.out.println(DELI);
            System.out.println("1. Show List");
            System.out.println("2. Insert");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println(DELI);
            System.out.println("\n0. Back");
            System.out.println(DELI);
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
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

    }

    /* -- SHOW BY ID -- */
    private void showById(long i) {

    }

    /* -- INSERT -- */
    private void insert() {

    }

    /* -- UPDATE --*/
    private void update() {

    }

    /* -- DELETE --*/
    private void delete() {

    }

}
