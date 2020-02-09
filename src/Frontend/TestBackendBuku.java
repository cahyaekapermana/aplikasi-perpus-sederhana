/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;
import Backend.Buku;
import Backend.Kategori;
import backend.*;
/**
 *
 * @author Rossy
 */
public class TestBackendBuku {
    public static void main(String[] args){
        Kategori novel = new Kategori().getById(27);
        Kategori referensi = new Kategori().getById(28);
        
        Buku buku1 = new Buku(novel, "Bawang Merah", "Bambang", "Sudajo");
        Buku buku2 = new Buku(referensi, "Aljabar", "Supri", "Alex Brandon");
        Buku buku3 = new Buku(novel, "Tenda Biru", "Ardyansyah", "Budi Laksono");
        
        buku1.save();
        buku2.save();
       
        buku2.setJudul("Bawang Merah");
        buku2.save();
      
        buku3.delete();
        
        for(Buku b : new Buku().getAll()){
            System.out.println("Kategori: " + b.getKategori().getNama() + ", Judul: " + b.getJudul());
        }
        // test search
        for(Buku b : new Buku().search("timun")){
            System.out.println("Kategori: " + b.getKategori().getNama() + ", Judul: " + b.getJudul());
        }
    }
}
