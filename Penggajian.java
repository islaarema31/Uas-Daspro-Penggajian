/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;
import java.util.Scanner;
/**
 *
 * @author islaarema31
 */
class Penggajian {

    /**
     * @param args the command line arguments
     */
    
   static String nama[];
   static int [] golongan, jamkerja, lembur,gajiPokok,tunjangan,total,totalUL;
   
    //Input Data Karyawan
    static void inputData(){
        Scanner datamasukan = new Scanner(System.in);   //Input Jumlah Data Karyawan
        System.out.println("Masukkan Jumlah Data : ");  //Input Jumlah Data Karyawan
        int datamasuk = datamasukan.nextInt();          //Input Jumlah Data Karyawan
        nama = new String[datamasuk];   
        golongan = new int[datamasuk];  
        jamkerja = new int[datamasuk];
        gajiPokok = new int[datamasuk];
        tunjangan = new int[datamasuk];
        lembur = new int[datamasuk];
        total = new int [datamasuk];
        
        for (int a = 0; a <nama.length; a++) {
            System.out.println("No karyawan : " + (a+1));   //Nomer Karyawan
            Scanner masukkandata = new Scanner(System.in);
            System.out.println(+(a+1)+  " Nama : ");    //Input Nama
            nama[a]= masukkandata.nextLine();
            System.out.println("1. CEO");
            System.out.println("2. CTO");
            System.out.println("3. Programmer");
            System.out.println("4. Customer Servic");
            System.out.println("Golongan    : ");   //Input Golongan
            golongan[a] = masukkandata.nextInt();
            System.out.println("Jam Kerja   : ");   //Input Jam Kerja
            jamkerja[a] = masukkandata.nextInt();
        }   
}
    //Pencarian Pegawai
    static void caridata(){
        Scanner datakaryawan = new Scanner(System.in);
        System.out.print("Masukkan Nama Karyawan : ");    //Cari Nama Pegawai
        String datakr = datakaryawan.nextLine();
        int b;
        loop : for(b = 0; b < nama.length; b++){
            if (nama[b].equals(datakr)) {
                System.out.println("Data Karyawan Ditemukan"); //Data Ada
                tampilkandata(b);
                break loop;
            }
        }
        if (b == nama.length) {
            System.out.println("Data Karyawan Tidak Ditemukan");    // Data Kosong
        }
    }
    
    //Hasil Dari Cari Data Pegawai
    static void tampilkandata(int y){
        System.out.print("Nama Karyawan   : "+nama[y]);
        System.out.print("Golongan        : "+golongan[y]);
        System.out.print("Jam Kerja       : "+jamkerja[y]);
        System.out.print("Jam Lembur      : "+lembur[y]);
    }
    //List Data Pegawai & Laporan
    static void dataKaryawan(){
        int [] gajiTotal = hitungGaji();
        System.out.println("|No.\t |Nama Karyawan\t |Golongan\t |Jam Kerja\t |Gaji Pokok\t |Tunjangan\t |Uang Lembur\t |Total");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        for (int f = 0; f < nama.length; f++) {
            if (golongan[f]!=0) {
                System.out.println((f+1)+"\t\t "+nama[f]+"\t\t "+golongan[f]+"\t\t "+jamkerja[f]+"\t\t "+gajiPokok[f]+"\t "+tunjangan[f]+"\t\t "+(lembur[f]*50000)+"\t\t "+gajiTotal[f]+"\t\t ");
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }
            
        }
    }
    
    //Input Gaji
    static void gaji(){
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < gajiPokok.length; j++){
            System.out.print("Masukkan Gaji Pokok   " + nama[j] + " : ");   //Input Gaji Pokok
            gajiPokok[j] = sc.nextInt();
            System.out.print("Masukkan Tunjangan    " + nama[j] + " : ");   //Input Tunjangan
            tunjangan[j] = sc.nextInt();
            System.out.print("Masukkan Jam Lembur   " + nama[j] + " : ");   //Input Jam Lembur
            lembur[j] = sc.nextInt();
        }
    }
    
    //Menghitung Gaji
    static int[] hitungGaji(){
        int totalGaji = 0;
        int uangLembur = 0;
        for(int j = 0; j<gajiPokok.length; j++){
        totalGaji = gajiPokok[j] + tunjangan[j] + (lembur[j]*50000);
        total[j] = totalGaji;
    }
        return total;
}
    //Print Slip Gaji
    static void gajiKaryawan(){
        Scanner sc = new Scanner(System.in);
        int [] gajiTotal = hitungGaji();
        String namaKaryawan;
        System.out.print("Masukkan Nama Karyawan: ");
        namaKaryawan = sc.nextLine();
        int i = 0;
        System.out.println("|No.\t |Nama Karyawan\t |Golongan\t |Jam Kerja\t |Gaji Pokok\t |Tunjangan\t |Uang Lembur\t |Total");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        loop: for (i=0; i<nama.length; i++){
            if (namaKaryawan.equalsIgnoreCase(nama[i])){
            System.out.println("\t\t "+nama[i]+"\t\t "+golongan[i]+"\t\t "+jamkerja[i]+"\t\t "+gajiPokok[i]+"\t "+tunjangan[i]+"\t\t "+(lembur[i]*50000)+"\t\t "+gajiTotal[i]+"\t\t ");
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            break loop;
            }
        }
        if (i == nama.length) {
            System.out.println("Nama Salah/Nama Tidak Ditemukan");
        }
    }
    
    //Fitur Menu
    public static void main (String[] args){
       int menu;
       Penggajian data = new Penggajian();
       
       do {
           System.out.println("");
           System.out.println("1. Masukkan Data Karyawan");
           System.out.println("2. Masukkan Gaji Karyawan");
           System.out.println("3. Cari Data Karyawan");
           System.out.println("4. Print Slip Gaji Karyawan");
           System.out.println("5. List Data Karyawan");
           System.out.println("6. Laporan Data Karyawan");
           System.out.println("7. Exit");
           System.out.println("");
           Scanner pilih = new Scanner(System.in);
           System.out.println("Pilih Menu : ");
           menu = pilih.nextInt();
           switch(menu){
               case 1:{
                   System.out.println("Menu - 1. Input Data Karyawan");
                   data.inputData();
               } break;
               case 2:{
                   System.out.println("Menu - 2. Input Gaji Karyawan");
                   data.gaji();
               } break;
               case 3:{
                   System.out.println("Menu - 3. Cari Data Karyawan");
                   data.caridata();
               } break;
               case 4:{
                   System.out.println("Menu - 4. Print Slip Gaji Karyawan");
                   data.gajiKaryawan();
               } break;
               case 5:{
                   System.out.println("Menu - 5. List Data Karyawan");
                   data.dataKaryawan();
               } break;
               case 6:{
                   System.out.println("Menu - 6. Laporan Data Karyawan");
                   data.dataKaryawan();
               }
           }
       } while (menu>0 && menu<7);
                      }
            }
