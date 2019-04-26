package ProjektZamianaZnakow;


import java.io.*;

public class program {

    public static void main(String[] args) {
        DataInputStream baza = null;
        DataInputStream strumieńWejściowy = null;
        DataOutputStream strumieńWyjściowy = null;

        try {
            baza = new DataInputStream(new FileInputStream("baza.txt"));
            strumieńWejściowy = new DataInputStream(new FileInputStream("plik.txt"));
            strumieńWyjściowy = new DataOutputStream(new FileOutputStream("plik.txt"));

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono takiego pliku");
        }

        byte[] bufor = new byte[1024];

        try {
            baza.read(bufor);
            strumieńWyjściowy.write(bufor);

        } catch (IOException e) {
            System.out.println("Bład wejścia-wyjścia");
        }

        try {
            if (baza != null) baza.close();
            if (strumieńWejściowy != null) strumieńWejściowy.close();
            if (strumieńWyjściowy != null) strumieńWyjściowy.close();
        } catch (IOException e) {
            System.out.println("Błąd zamykania strumieni");
        }
        System.out.println("PLIK NADPISANO");
    }
}
