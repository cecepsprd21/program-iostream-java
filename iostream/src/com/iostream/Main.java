package com.iostream;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        createWriteFile("data3.txt");
        printKeConsole("data.txt");
        transferIsiFile("data.txt","data2.txt");
        printKeConsole("data2.txt");

    }

    // Method untuk print dari file ke console
    public static void printKeConsole(String namaFile) throws IOException{
        try( FileInputStream fileInput = new FileInputStream(namaFile)) {
            int printData1 = fileInput.read();
            while( printData1 != -1 ){
                System.out.print((char) printData1 );
                printData1 = fileInput.read();
            }
        }
    }

    // Method untuk Memindah isi suatu file ke file lain
    public static void transferIsiFile(String fileSatu, String fileDua) throws IOException{
        try ( FileInputStream fileIn  = new FileInputStream(fileSatu);
              FileOutputStream fileOut = new FileOutputStream(fileDua) ){
                int isiFile = fileIn.read();
                while ( isiFile != -1 ){
                fileOut.write((char) isiFile);
                isiFile = fileIn.read();
             }
        }
    }

    // Membuat dan menulis file melalui Scanner
    public static void createWriteFile(String namaFile) throws IOException {
        Scanner scan = new Scanner(System.in);
            String kata = scan.nextLine();
            FileWriter fileWriter = new FileWriter(namaFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(kata,0,kata.length());
            bufferedWriter.flush();
    }
}
