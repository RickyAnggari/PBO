/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2209106037_Ricky_Anggari_Posttest1;
import java.util.*;
import java.io.*;
/**
 *
 * @author Nitro
 */
public class Main {
// Class Login User
 public static class User {
        private final String username;
        private final String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
        public void Akun(){
            System.out.println("Username : "+getUsername()+"\nPassword : "+getPassword());
        }
    }
//Class Negara
    public static class Negara{
        String Nama_Negara;
        String Nama_Pemimpin;
        int Jumlah_Penduduk;
        public Negara(String Nama_Negara,String Nama_Pemimpin,int Jumlah_Penduduk){
           this.Nama_Negara=Nama_Negara;
           this.Nama_Pemimpin=Nama_Pemimpin;
           this.Jumlah_Penduduk=Jumlah_Penduduk;
        }
        public void Display(){
            System.out.println("Nama Negara : "+Nama_Negara+"\nNama Pemimpin : "+Nama_Pemimpin+"\nJumlah Penduduk : "+Jumlah_Penduduk);
        }
        public static void Runtuh(){
            System.out.println("Negara Runtuh");
        }
    }
//Class Provinsi
    public static class Provinsi extends Negara{
        int Jumlah_Provinsi;
        public Provinsi(String Nama_Negara, String Nama_Pemimpin, int Jumlah_Penduduk,int Jumlah_Provinsi) {
            super(Nama_Negara, Nama_Pemimpin, Jumlah_Penduduk);
            this.Jumlah_Provinsi=Jumlah_Provinsi;
        }
        @Override
        public void Display(){
            super.Display();
            System.out.println("Jumlah Provinsi : "+Jumlah_Provinsi);
        }
    }
  
    public static void main(String[] args) {
        int choice;
        int pilihan;
      ArrayList<User> DaftarLogin = new ArrayList<>();
       ArrayList<Negara> DaftarNegara = new ArrayList<>();
        Scanner input = new Scanner(System.in);      
        boolean Terhubung = false;
        while (true) {
            try{
            if (!Terhubung) {
                System.out.println("");
                System.out.println("=====Menu Login=====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Lihat Daftar akun yang sudah register");
                System.out.println("4. Exit");
                System.out.print("Masukkan pilihan anda : ");
                choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1-> register(DaftarLogin, input);
                    case 2-> Terhubung = login(DaftarLogin, input); 
                    case 3-> Tampilkan(DaftarLogin,input); 
                    case 4 -> System.exit(0);
                    default-> System.out.println("Inputan diluar nalar");
                }
            }else{
                System.out.println("");
                System.out.println("=====MENU UTAMA=====");
                System.out.println("1. Create Negara");
                System.out.println("2. Delete Negara");
                System.out.println("3. Edit Negara");
                System.out.println("4. Show");
                System.out.println("5. Balik ke menu Login");
                System.out.println("6. Gas langsung end program");
                System.out.print("Enter your choice: ");
                pilihan = input.nextInt();
                input.nextLine(); 
                switch(pilihan){
                    case 1->Create(DaftarNegara,input);
                    case 2->Delete(DaftarNegara,input);
                    case 3->Edit(DaftarNegara,input);
                    case 4->Show(DaftarNegara,input);
                    case 5-> Terhubung = false;
                    case 6-> System.exit(0);
                    default-> System.out.println("inputan diluar nalar");
                }
                }   
            }catch (InputMismatchException e) {
                System.out.println("Masukkan yang benar");
                input.nextLine();
            }
        }
    }static void register(ArrayList<User> DaftarLogin, Scanner input) {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        User newUser = new User(username, password);
        DaftarLogin.add(newUser);
        System.out.println("Registration successful!");
    }

    static boolean login(ArrayList<User> DaftarLogin, Scanner input) {
        if(DaftarLogin.isEmpty()){
            System.out.println("Silahkan register terlebih dahulu");
            return false;
        }
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (User user : DaftarLogin) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return false;
    }
    static void Tampilkan(ArrayList<User>DaftarLogin,Scanner input){
        if(DaftarLogin.isEmpty()){
            System.out.println("Data akun kosong,silahkan register terlebih dahulu");
        }
        else{
        int index = 1;
        for(User Tampil : DaftarLogin){
        System.out.println("Data akun ke : "+index );
        Tampil.Akun();
        System.out.println();
        index++;
            }
        }
    }
    static void Create(ArrayList<Negara>DaftarNegara,Scanner input){
        String Nama_Negara;
        String Nama_Pemimpin;
        int Jumlah_Penduduk;
        int Jumlah_Provinsi;
        int berapa;
        int index = 1;
        System.out.println("Ingin seberapa banyak negara baru ? : ");
        berapa=input.nextInt();
        input.nextLine();
        for(int i=1;i<=berapa;i++){
            System.out.print("Penambahan Data ke : "+index+"\n");
            System.out.print("Masukkan nama negara : ");
            Nama_Negara=input.nextLine();
            System.out.print("Masukkan nama pemimpin nya : ");
            Nama_Pemimpin=input.nextLine();
            System.out.print("Masukkan Jumlah Penduduk : ");
            Jumlah_Penduduk=input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Jumlah Provinsi : ");
            Jumlah_Provinsi=input.nextInt();
            input.nextLine();
            Provinsi country=new Provinsi(Nama_Negara,Nama_Pemimpin,Jumlah_Penduduk,Jumlah_Provinsi);
            DaftarNegara.add(country);
            System.out.println();
            index++;
        }
    }static void Delete(ArrayList<Negara>DaftarNegara,Scanner input){
        int posisi;
        if (DaftarNegara.isEmpty()) {
            System.out.println("Kosong");
            return;
        }
        Show(DaftarNegara,input);
        System.out.println("Masukkan posisi yang ingin anda masukkan : ");
        posisi = input.nextInt();
        input.nextLine();
        if (posisi >= 1 && posisi <= DaftarNegara.size()) {
            DaftarNegara.remove(posisi-1);
            Negara.Runtuh();  
        }else{
            System.out.println("Posisi invalid");
        }
    }static void Edit(ArrayList<Negara>DaftarNegara,Scanner input){
        int posisi;
        String Nama_Baru;
        String Pemimpin_Baru;
        int Jumlah_Penduduk_Baru;
        int Jumlah_Provinsi_Baru;
        if (DaftarNegara.isEmpty()) {
            System.out.println("Kosong");
            return;
        }
            System.out.println("Masukkan nomor negara yang ingin di update : ");
            posisi=input.nextInt();
            input.nextLine();
            if(posisi>=1&&posisi<=DaftarNegara.size()){
            System.out.print("Masukkan perubahan nama negara : ");
            Nama_Baru=input.nextLine();
            System.out.print("Masukkan nama pemimpin nya : ");
            Pemimpin_Baru=input.nextLine();
            System.out.print("Masukkan Perubahan Jumlah Penduduk : ");
            Jumlah_Penduduk_Baru=input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Jumlah Provinsi : ");
            Jumlah_Provinsi_Baru=input.nextInt();
            input.nextLine();
            Provinsi Ubah=new Provinsi(Nama_Baru,Pemimpin_Baru,Jumlah_Penduduk_Baru,Jumlah_Provinsi_Baru);
            DaftarNegara.set(posisi-1,Ubah);   
            }
    } 
    static void Show(ArrayList<Negara>DaftarNegara,Scanner input) {
        if (DaftarNegara.isEmpty()) {
            System.out.println("Kosong");
            return;
        }
        int index = 1;
    for (Negara country : DaftarNegara) {
        System.out.println("");
        System.out.println("Data Negara ke : "+index );
        country.Display();
        System.out.println();
        index++;
        }
    }
    
}
