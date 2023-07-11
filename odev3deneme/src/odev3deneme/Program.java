package odev3deneme;

/**
*
* @author İsim:Beyza Selin Çilli

* 
*/

public class Program {

    public static void main(String[] args) {
    	
        int[] numbers = Oyun.getNumbers();//numbers adında bir dizin alır, bu dizi Oyun.getNumbers() metodundan döndürülen bir diziye atılır.
        Oyun.clearScreen();//Oyun.clearScreen() metodunu çağırarak ekranı temizler.
        
        if (numbers != null) {//numbers dizisi null değilse, 
            int size = numbers.length;//size adında bir değişkene numbers dizisinin uzunluğu atanır.
            Oyun oyunlar = new Oyun(size);//Oyun sınıfından oyunlar adında bir nesne oluşturulur ve size ile başlatılır.
           
            oyunlar.setKoloniSayisi(size);//oyunlar nesnesinin setKoloniSayisi metoduna size değeri verilir.
            oyunlar.kolonileriCreate(numbers, size, oyunlar);//oyunlar nesnesinin kolonileriCreate metoduna numbers, size ve oyunlar parametreleri verilerek koloniler oluşturulur.
            oyunlar.setSabitKoloniSayisi(oyunlar.getKoloniSayisi());//oyunlar nesnesinin setSabitKoloniSayisi metoduna oyunlar.getKoloniSayisi() değeri verilir.
         
            while (oyunlar.getKoloniSayisi() != 1) {//oyunlar nesnesinin getKoloniSayisi() değeri 1 olana kadar aşağıdaki adımlar tekrarlanır:
                oyunlar.ciktiVer(oyunlar.getOyunTurSayisi());//oyunlar nesnesinin ciktiVer metodunu oyunlar.getOyunTurSayisi() değeri ile çağırarak oyun durumunun çıktısını ekrana yazdırır.

                oyunlar.koloniKontrol(oyunlar, oyunlar.getOyunTurSayisi());//oyunlar nesnesinin koloniKontrol metodunu oyunlar, oyunlar.getOyunTurSayisi() değeri ile çağırarak kolonilerin kontrolünü gerçekleştirir.

                for (int i = 0; i < oyunlar.getSabitKoloniSayisi(); i++) {//İç içe döngüler kullanılarak tüm koloniler arasında savaşlar yapılır ve sonuçlar Oyun_Savas metodunda işlenir.
                    for (int j = i + 1; j < oyunlar.getSabitKoloniSayisi(); j++) {
                        if (i != j) {
                            if (oyunlar.koloniler[i].getKoloniikontrol() == 0 ||
                                    oyunlar.koloniler[j].getKoloniikontrol() == 0) {
                                continue;
                            } else {
                                oyunlar.Oyun_Savas(oyunlar.koloniler[i], i,
                                        oyunlar.koloniler[j], j, oyunlar);
                            }
                        }
                    }
                }

                oyunlar.setOyunTurSayisi(oyunlar.getOyunTurSayisi() + 1);//oyunlar nesnesinin setOyunTurSayisi metoduna oyunlar.getOyunTurSayisi() + 1 değeri verilerek oyun tur sayısı güncellenir.
            }
            
            System.out.println("\n\t\t\t\t...OYUN SONUCU:..");  //...OYUN SONUCU:.. metnini ekrana yazdırır.
            oyunlar.ciktiVer(oyunlar.getOyunTurSayisi()-1);
        }//oyunlar nesnesinin ciktiVer metodunu oyunlar.getOyunTurSayisi() - 1 değeri ile çağırarak oyunun son durumunun çıktısını ekrana yazdırır.
    }
}
