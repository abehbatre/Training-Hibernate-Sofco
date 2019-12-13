package presentation;


import utils.AppException;

import java.util.Scanner;

import static utils.AppHelper.DELI;
import static utils.AppHelper.clearConsole;


public class MainMenu {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws AppException {
        new MainMenu();
    }

    /* -- MAIN MENU -- */
    public MainMenu() {
        do {
            System.out.println(DELI);
            System.out.println("-- MAIN MENU --");
            System.out.println(DELI);
            System.out.println("1. MENU KELOMPOK BARANG");
            System.out.println("2. MENU BARANG");
            System.out.println("3. MENU TRANSAKSI");
            System.out.println("\n0. Exit");
            System.out.println(DELI);
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            System.out.println(DELI);

            switch (pilihan) {
                case 1:
                    clearConsole();
                    MenuKelompokBarang menuKelompokBarang = new MenuKelompokBarang();
                    menuKelompokBarang.showMenu();
                    break;
                case 2:
                    clearConsole();
                    MenuBarang menuBarang = new MenuBarang();
                    menuBarang.showMenu();
                    break;
                case 3:
                    clearConsole();
                    MenuTransaksi menuTransaksi = new MenuTransaksi();
                    menuTransaksi.showMenu();
                    break;
                case 0:
                    clearConsole();
                    System.out.println("-- EXIT SUCCESS --");
                    System.exit(0);
                    break;
                default:
                    clearConsole();
                    break;
            }
        } while (true);
    }
}
