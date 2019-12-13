package utils;


import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AppHelper {
    public static final String DELI = "--------------------------";

    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n\n\n\n\n\n");
        }
    }

    public static String getCurrentDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }


    public static String formatDateYMD(String tanggal) {
        DateFormat dateFormat = new SimpleDateFormat(tanggal);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static boolean isValidDateFormat(String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public static int generateNomorBon() {
        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return Integer.parseInt(sb.toString());
    }
}
