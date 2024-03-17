/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package posttest2;
import java.util.*;
import java.io.*;
/**
 *
 * @author Nitro
 */
public class Posttest2 {

  public static class User {
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
        public void Akun(){
            System.out.println("Username : "+GetUsername()+"\nPassword : "+GetPassword());
        }
    }
//Class Negara
    public static class Negara{
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
        public void Display(){
            System.out.println("Nama Negara : "+GetNama()+"\nNama Pemimpin : "+GetPemimpin()+"\nJumlah Penduduk : "+GetPenduduk());
        }
        public static void Runtuh(){
            System.out.println("Negara Runtuh");
        }
        public static void Nol(){
            System.out.println("Tidak boleh 0");
        }
    }
//Class Provinsi
    public static class Provinsi extends Negara{
        public int Jumlah_Provinsi;
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
    public static class Kota extends Provinsi{
        int Jumlah_Kota;

        public Kota(String Nama_Negara, String Nama_Pemimpin, int Jumlah_Penduduk, int Jumlah_Provinsi,int Jumlah_Kota) {
            super(Nama_Negara, Nama_Pemimpin, Jumlah_Penduduk, Jumlah_Provinsi);
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
            }
            else{
                System.out.println("");
                System.out.println("=====MENU UTAMA=====");
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
                    case 4->{
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
            catch (InputMismatchException e) {
                System.out.println("Masukkan yang benar");
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
        int Jumlah_Kota;
        int index = 1;
        Kota kota=new Kota("","",0,0,0);
        System.out.println("Ingin seberapa banyak negara baru ? : ");
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
            System.out.print("Masukkan Jumlah Kota : ");
            Jumlah_Kota=input.nextInt();
            input.nextLine();
              if(Jumlah_Kota==0){
                Negara.Nol();
                return;
            }
            Kota City=new Kota(Nama_Negara,Nama_Pemimpin,Jumlah_Penduduk,Jumlah_Provinsi,Jumlah_Kota);
            DaftarNegara.add(City);
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
        System.out.println("Masukkan posisi yang ingin anda Hapus : ");
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
        int Jumlah_Kota_Baru;
        Kota kota=new Kota("","",0,0,0);
        if (DaftarNegara.isEmpty()) {
            System.out.println("Kosong");
            return;
        }
        Show(DaftarNegara, input);
            System.out.println("Masukkan nomor negara yang ingin di update : ");
            posisi=input.nextInt();
            input.nextLine();
            if(posisi>=1&&posisi<=DaftarNegara.size()){
            System.out.print("Masukkan perubahan nama negara : ");
            Nama_Baru=input.nextLine();
            kota.SetNama(Nama_Baru);
            System.out.print("Masukkan nama pemimpin nya : ");
            Pemimpin_Baru=input.nextLine();
            kota.SetPemimpin(Nama_Baru);
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
            System.out.print("Masukkan Jumlah Kota : ");
            Jumlah_Kota_Baru=input.nextInt();
            input.nextLine();
              if(Jumlah_Kota_Baru==0){
              Negara.Nol();
               return;
            }  
            Kota Ubah=new Kota(Nama_Baru,Pemimpin_Baru,Jumlah_Penduduk_Baru,Jumlah_Provinsi_Baru,Jumlah_Kota_Baru);
            DaftarNegara.set(posisi-1,Ubah);   
            }
    }
static void Edit(ArrayList<Negara> DaftarNegara, Scanner input,String Nama_Baru) {
    int posisi;
    String Pemimpin_Baru;
    int Jumlah_Penduduk_Baru;
    Kota kota = new Kota("", "", 0, 0, 0);
    if (DaftarNegara.isEmpty()) {
        System.out.println("Kosong");
        return;
    }
    Show(DaftarNegara, input);
    System.out.println("Masukkan nomor negara yang ingin di update : ");
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
        if (negara instanceof Provinsi provinsi) {
            kota.SetNama(Nama_Baru);
            kota.SetPemimpin(Pemimpin_Baru);
            kota.SetPenduduk(Jumlah_Penduduk_Baru);
            kota.Jumlah_Provinsi = provinsi.Jumlah_Provinsi; 
            kota.Jumlah_Kota = ((Kota) negara).Jumlah_Kota; 
            DaftarNegara.set(posisi - 1, kota);
        } else {
            Negara Ubah = new Negara(Nama_Baru, Pemimpin_Baru, Jumlah_Penduduk_Baru);
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
        country.Display();
        System.out.println();
        index++;
        }
    }        
    
}
