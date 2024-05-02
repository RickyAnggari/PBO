/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package posttest6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nitro
 */
public class Posttest6 {

    /**
     * @param args the command line arguments
     */
public interface Salah {
    void salah();
    void Berhasil();
}
public static abstract class Authentication {
        public abstract boolean login(Scanner input);
        public abstract void DisplayWithoutPassword();
    }
 public static class User extends Authentication implements Salah{
        private final String username;
        private final String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String GetUsername() {
            return username;
        }

        public String GetPassword() {
            return password;
        }

        public void Akun() {
            System.out.println("Username : " + GetUsername() + "\nPassword : " + GetPassword());
        }

        @Override
        public boolean login(Scanner input) {
            System.out.print("Enter username: ");
            String enteredUsername = input.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
        }
        @Override
        public void DisplayWithoutPassword() {
        System.out.println("Username : " + GetUsername());
    }
        @Override 
        public void salah(){
            System.out.println("Username atau Password salah,silahkan coba lagi");
        }
        @Override
        public void Berhasil(){
            System.out.println("Login successful");
        }
    }
//Class Negara
    public static abstract class Negara{
        private String Nama_Negara;
        private String Nama_Pemimpin;
        protected int Jumlah_Penduduk;
        public Negara(String Nama_Negara,String Nama_Pemimpin,int Jumlah_Penduduk){
           this.Nama_Negara=Nama_Negara;
           this.Nama_Pemimpin=Nama_Pemimpin;
           this.Jumlah_Penduduk=Jumlah_Penduduk;
        }
        public void SetNama(String Nama_Negara){
            this.Nama_Negara=Nama_Negara;
        }
        public void SetPemimpin(String Nama_Pemimpin){
            this.Nama_Pemimpin=Nama_Pemimpin;
        }
        public void SetPenduduk(int Jumlah_Penduduk){
            this.Jumlah_Penduduk=Jumlah_Penduduk;
        }
        public String GetNama(){
            return Nama_Negara;
        }
        public String GetPemimpin(){
            return Nama_Pemimpin;
        }
        public int GetPenduduk(){
            return Jumlah_Penduduk;
        }
        public abstract void Display();
        public static final void Runtuh(){
            System.out.println("Negara Runtuh");
        }
        public static void Nol(){
            System.out.println("Tidak boleh 0");
        }
    }
//Class Provinsi
    public static class Provinsi extends Negara{
        private int Jumlah_Provinsi;
        public Provinsi(String Nama_Negara, String Nama_Pemimpin, int Jumlah_Penduduk,int Jumlah_Provinsi) {
            super(Nama_Negara, Nama_Pemimpin, Jumlah_Penduduk);
            this.Jumlah_Provinsi=Jumlah_Provinsi;
        }
        public int GetJumlahProvinsi() {
        return Jumlah_Provinsi;
        }

        public void SetJumlahProvinsi(int jumlah_Provinsi) {
            Jumlah_Provinsi = jumlah_Provinsi;
        }
        @Override
        public void Display(){
            System.out.println("Nama Negara : "+GetNama()+"\nNama Pemimpin : "+GetPemimpin()+"\nJumlah Penduduk : "+GetPenduduk()+"\nJumlah Provinsi : "+Jumlah_Provinsi);
        }
    }
    public static class Ibukota extends Provinsi{
        String Nama_Ibukota;
        public Ibukota(String Nama_Negara, String Nama_Pemimpin, int Jumlah_Penduduk, int Jumlah_Provinsi,String Nama_Ibukota) {
            super(Nama_Negara, Nama_Pemimpin, Jumlah_Penduduk, Jumlah_Provinsi);
            this.Nama_Ibukota=Nama_Ibukota;
        }
        
        @Override
        public void Display(){
            super.Display();
            System.out.println("Nama Ibukota : "+Nama_Ibukota);
        }
    }
    public static final class Kota extends Ibukota{
        int Jumlah_Kota;

        public Kota(String Nama_Negara, String Nama_Pemimpin, int Jumlah_Penduduk, int Jumlah_Provinsi,String Nama_Ibukota,int Jumlah_Kota) {
            super(Nama_Negara, Nama_Pemimpin, Jumlah_Penduduk, Jumlah_Provinsi,Nama_Ibukota);
            this.Jumlah_Kota=Jumlah_Kota;
        }
        @Override
        public void Display(){
            super.Display();
            System.out.println("Jumlah_Kota : "+Jumlah_Kota);
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
                System.out.println("========== Menu Login ==========");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Lihat Daftar akun yang sudah register");
                System.out.println("4. Lupa Password ? Masuk ke sini hubungi Admin");
                System.out.println("5. Exit");
                System.out.print("Masukkan pilihan anda : ");
                choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1-> register(DaftarLogin, input);
                    case 2-> Terhubung = login(DaftarLogin, input); 
                    case 3-> Tampilkan(DaftarLogin,input); 
                    case 4-> Searching(DaftarLogin,input);
                    case 5 -> System.exit(0);
                    default-> System.out.println("Inputan diluar nalar");
                }
            }
            else{
                System.out.println("");
                System.out.println("=============== MENU UTAMA ===============");
                System.out.println("1. Create Negara");
                System.out.println("2. Delete Negara");
                System.out.println("3. Edit Negara");
                System.out.println("4. Edit khusus Nama negara ,Pemimpin dan jumlah penduduk saja");
                System.out.println("5. Show");
                System.out.println("6. Balik ke menu Login");
                System.out.println("7. Gas langsung end program");
                System.out.print("Enter your choice: ");
                pilihan = input.nextInt();
                input.nextLine(); 
                switch(pilihan){
                    case 1->Create(DaftarNegara,input);
                    case 2->Delete(DaftarNegara,input);
                    case 3->Edit(DaftarNegara,input);
                    case 4->{//Overloading karena Edit dengan parameter berbeda
                        String Nama_Baru=new String();
                        Edit(DaftarNegara,input,Nama_Baru);
                    }
                    case 5->Show(DaftarNegara,input);
                    case 6-> Terhubung = false;
                    case 7-> System.exit(0);
                    default-> System.out.println("inputan diluar nalar");
                }
                }   
            }
            catch (InputMismatchException e ) {
                System.out.println("Tolong input dengan benar");
                input.nextLine();
            }
        }
    }
    static void register(ArrayList<User> DaftarLogin, Scanner input) {
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
            if (user.GetUsername().equals(username) && user.GetPassword().equals(password)) {
               user.Berhasil();
                return true;
            }
            else{
                user.salah();
            }
        }
        return false;
    }
    static void Tampilkan(ArrayList<User> DaftarLogin, Scanner input) {
    if (DaftarLogin.isEmpty()) {
        System.out.println("Data akun kosong, silahkan register terlebih dahulu");
    } else {
        int index = 1;
        for (User user : DaftarLogin) {
            System.out.println("Data akun ke : " + index);
            user.DisplayWithoutPassword();
            System.out.println();
            index++;
        }
    }
}
    static void Searching(ArrayList<User> DaftarLogin, Scanner input) {
    String kode;
    if(DaftarLogin.isEmpty()){
        System.out.println("Data user masih kosong");
        return;
    }
    System.out.println("======= Lupa Password =======");
    System.out.print("Masukkan kode Admin : ");
    kode=input.nextLine();
    if(kode.equals("Admin")){
    System.out.print("Masukkan username Anda : ");
    String cari = input.nextLine();
    boolean found = false;
    int index=1;
    for (User user : DaftarLogin) {
        if (user.GetUsername().equals(cari)) {
            System.out.println("Data akun : "+index);
            System.out.println("Username: " + user.GetUsername());
            System.out.println("Password: " + user.GetPassword());
            found = true;
            System.out.println();
            index++;
            
        }
    }
    if (!found) {
        System.out.println("Username tidak ditemukan.");
    }
    }else{
        System.out.println("Kode admin salah");
    }
}

    static void Create(ArrayList<Negara>DaftarNegara,Scanner input){
        String Nama_Negara;
        String Nama_Pemimpin;
        int Jumlah_Penduduk;
        int Jumlah_Provinsi;
        String Nama_Ibukota;
        int berapa;
        int Jumlah_Kota;
        int index = 1;
        Kota kota=new Kota("","",0,0,"",0);
        System.out.print("Ingin seberapa banyak negara baru ? : ");
        berapa=input.nextInt();
        input.nextLine();
        for(int i=1;i<=berapa;i++){
            System.out.print("Penambahan Data ke : "+index+"\n");
            System.out.print("Masukkan nama negara : ");
            Nama_Negara=input.nextLine();
            kota.SetNama(Nama_Negara);
            System.out.print("Masukkan nama pemimpin nya : ");
            Nama_Pemimpin=input.nextLine();
            kota.SetPemimpin(Nama_Pemimpin);
            System.out.print("Masukkan Jumlah Penduduk : ");
            Jumlah_Penduduk=input.nextInt();
            input.nextLine();
            if(Jumlah_Penduduk==0){
              Negara.Nol();
                return;
            }
            kota.SetPenduduk(Jumlah_Penduduk);
            System.out.print("Masukkan Jumlah Provinsi : ");
            Jumlah_Provinsi=input.nextInt();
            input.nextLine();
              if(Jumlah_Provinsi==0){
                Negara.Nol();
                return;
            }
            System.out.print("Masukkan Nama Ibukota : ");
            Nama_Ibukota=input.nextLine();
            System.out.print("Masukkan Jumlah Kota : ");
            Jumlah_Kota=input.nextInt();
            input.nextLine();
              if(Jumlah_Kota==0){
                Negara.Nol();
                return;
            }
            Kota City=new Kota(Nama_Negara,Nama_Pemimpin,Jumlah_Penduduk,Jumlah_Provinsi,Nama_Ibukota,Jumlah_Kota);
            DaftarNegara.add(City);
            System.out.println();
            index++;
        }
    }
    static void Delete(ArrayList<Negara>DaftarNegara,Scanner input){
        int posisi;
        if (DaftarNegara.isEmpty()) {
            System.out.println("Data masih kosong");
            return;
        }
        Show(DaftarNegara,input);
        System.out.print("Masukkan posisi yang ingin anda Hapus : ");
        posisi = input.nextInt();
        input.nextLine();
        if (posisi >= 1 && posisi <= DaftarNegara.size()) {
            DaftarNegara.remove(posisi-1);
            Negara.Runtuh();  
        }else{
            System.out.println("Posisi invalid");
        }
    }
    static void Edit(ArrayList<Negara>DaftarNegara,Scanner input){
        int posisi;
        String Nama_Baru;
        String Pemimpin_Baru;
        int Jumlah_Penduduk_Baru;
        int Jumlah_Provinsi_Baru;
        String Ibukota_Baru;
        int Jumlah_Kota_Baru;
        Kota kota=new Kota("","",0,0,"",0);
        if (DaftarNegara.isEmpty()) {
            System.out.println("Kosong");
            return;
        }
        Show(DaftarNegara, input);
            System.out.print("Masukkan nomor negara yang ingin di update : ");
            posisi=input.nextInt();
            input.nextLine();
            if(posisi>=1&&posisi<=DaftarNegara.size()){
            System.out.print("Masukkan perubahan nama negara : ");
            Nama_Baru=input.nextLine();
            kota.SetNama(Nama_Baru);
            System.out.print("Masukkan nama pemimpin nya : ");
            Pemimpin_Baru=input.nextLine();
            kota.SetPemimpin(Pemimpin_Baru);
            System.out.print("Masukkan Perubahan Jumlah Penduduk : ");
            Jumlah_Penduduk_Baru=input.nextInt();
            input.nextLine();
              if(Jumlah_Penduduk_Baru==0){
              Negara.Nol();
                return;
            }
            kota.SetPenduduk(Jumlah_Penduduk_Baru);
            System.out.print("Masukkan Jumlah Provinsi : ");
            Jumlah_Provinsi_Baru=input.nextInt();
            input.nextLine();
              if(Jumlah_Provinsi_Baru==0){
              Negara.Nol();
               return;
            }
            System.out.print("Masukan Ibukota Baru : ");
            Ibukota_Baru=input.nextLine();    
            System.out.print("Masukkan Jumlah Kota : ");
            Jumlah_Kota_Baru=input.nextInt();
            input.nextLine();
              if(Jumlah_Kota_Baru==0){
              Negara.Nol();
               return;
            }  
            Kota Ubah=new Kota(Nama_Baru,Pemimpin_Baru,Jumlah_Penduduk_Baru,Jumlah_Provinsi_Baru,Ibukota_Baru,Jumlah_Kota_Baru);
            DaftarNegara.set(posisi-1,Ubah);   
            }
    }
    static void Edit(ArrayList<Negara> DaftarNegara, Scanner input,String Nama_Baru) {
    //Overloading
    int posisi;
    String Pemimpin_Baru;
    int Jumlah_Penduduk_Baru;
    int Jumlah_Provinsi_Baru;
    Kota kota = new Kota("", "", 0, 0,"", 0);
    if (DaftarNegara.isEmpty()) {
        System.out.println("Kosong");
        return;
    }
    Show(DaftarNegara, input);
    System.out.print("Masukkan nomor negara yang ingin di update : ");
    posisi = input.nextInt();
    input.nextLine();
    if (posisi >= 1 && posisi <= DaftarNegara.size()) {
        Negara negara = DaftarNegara.get(posisi - 1);
        System.out.print("Masukkan perubahan nama negara : ");
        Nama_Baru = input.nextLine();
        System.out.print("Masukkan perubahan nama pemimpin : ");
        Pemimpin_Baru = input.nextLine();
        System.out.print("Masukkan perubahan jumlah penduduk : ");
        Jumlah_Penduduk_Baru = input.nextInt();
        input.nextLine();
        if (Jumlah_Penduduk_Baru == 0) {
            Negara.Nol();
            return;
        }
        System.out.print("Masukkan Junmlah Provinsi Baru : ");
        Jumlah_Provinsi_Baru=input.nextInt();
        input.nextLine();
        if (Jumlah_Provinsi_Baru == 0) {
            Negara.Nol();
            return;
        }

        if (negara instanceof Provinsi provinsi) {
            provinsi.SetNama(Nama_Baru);
            provinsi.SetPemimpin(Pemimpin_Baru);
            provinsi.SetPenduduk(Jumlah_Penduduk_Baru);
            provinsi.SetJumlahProvinsi(Jumlah_Provinsi_Baru);
            DaftarNegara.set(posisi - 1, provinsi);
        } else {
            Provinsi Ubah = new Provinsi(Nama_Baru, Pemimpin_Baru, Jumlah_Penduduk_Baru,Jumlah_Provinsi_Baru);
            DaftarNegara.set(posisi - 1, Ubah);
        }
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
        System.out.println("");
        country.Display();
        System.out.println();
        index++;
        }
    }   
    
}
