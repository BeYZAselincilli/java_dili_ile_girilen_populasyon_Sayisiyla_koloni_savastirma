package odev3deneme;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Oyun {
    Koloni[] koloniler;  //koloniler: Koloni sınıfından oluşan bir dizi. Oyunda bulunan kolonileri temsil eder.
    private int koloni_sayisi;  //koloni_sayisi: Oyunda bulunan koloni sayısını belirtir.
    private int elenen_koloni_sayisi; //elenen_koloni_sayisi: Elemeler sonucunda elenen koloni sayısını tutar.
    private int sabitKoloniSayisi;  //sabitKoloniSayisi: Oyuna başlangıçta belirtilen sabit koloni sayısını tutar.
    private int oyun_tur_sayisi;  //oyun_tur_sayisi: Oyunun geçtiği tur sayısını tutar.

    
    public Oyun(int koloni_sayisi) { //Oyun sınıfının bir parametreli kurucusu bulunmaktadır
        this.koloni_sayisi = koloni_sayisi;
        this.elenen_koloni_sayisi = 0;
        this.sabitKoloniSayisi = 0;
        this.oyun_tur_sayisi = 0;
        this.koloniler = new Koloni[koloni_sayisi];
    }  // Bu kurucu, başlangıçta belirtilen koloni sayısıyla bir Oyun nesnesi oluşturur ve ilgili özellikleri başlangıç değerleriyle ayarlar.
    

    public int getKoloniSayisi() {
        return koloni_sayisi;
    }//getKoloniSayisi(): koloni_sayisi özelliğinin değerini döndürür.

    public void setKoloniSayisi(int koloni_sayisi) {
        this.koloni_sayisi = koloni_sayisi;
    }//setKoloniSayisi(int koloni_sayisi): koloni_sayisi özelliğini belirtilen değere ayarlar.

    public int getElenenKoloniSayisi() {
        return elenen_koloni_sayisi;
    }//getElenenKoloniSayisi(): elenen_koloni_sayisi özelliğinin değerini döndürür.

    public void setElenenKoloniSayisi(int elenen_koloni_sayisi) {
        this.elenen_koloni_sayisi = elenen_koloni_sayisi;
    }//setElenenKoloniSayisi(int elenen_koloni_sayisi): elenen_koloni_sayisi özelliğini belirtilen değere ayarlar.

    public int getSabitKoloniSayisi() {
        return sabitKoloniSayisi;
    }//getSabitKoloniSayisi(): sabitKoloniSayisi özelliğinin değerini döndürür.

    public void setSabitKoloniSayisi(int sabitKoloniSayisi) {
        this.sabitKoloniSayisi = sabitKoloniSayisi;
    }//setSabitKoloniSayisi(int sabitKoloniSayisi): sabitKoloniSayisi özelliğini belirtilen değere ayarlar.

    public int getOyunTurSayisi() {
        return oyun_tur_sayisi;
    }//getOyunTurSayisi(): oyun_tur_sayisi özelliğinin değerini döndürür.

    public void setOyunTurSayisi(int oyun_tur_sayisi) {
        this.oyun_tur_sayisi = oyun_tur_sayisi;
    }//setOyunTurSayisi(int oyun_tur_sayisi): oyun_tur_sayisi özelliğini belirtilen değere ayarlar.

    public static int[] getNumbers() {  // getNumbers() metodu, kullanıcıdan alınan girişleri işleyerek bir dizi tam sayı döndürüyor. 
    	
        Scanner scanner = new Scanner(System.in); //Bir Scanner nesnesi oluşturuluyor ve kullanıcıdan giriş almak için System.in kullanılıyor.
       
        System.out.print("Koloniler icin populasyon girisi yapin: ");  //Kullanıcıdan "Koloniler için populasyon girisi yapin: " şeklinde bir giriş isteniyor.
       
        String input = scanner.nextLine();//Kullanıcının girdisi scanner.nextLine() ile okunuyor ve input değişkenine atanıyor.
        String[] tokens = input.split(" ");  //input dizesi, boşluk karakterine göre parçalara ayrılıyor ve tokens dizisine atanıyor.
        int count = 0;
        int[] numbers = new int[tokens.length];//Bir sayaç olan count ve numbers adında bir tam sayı dizisi oluşturuluyor. numbers dizisinin boyutu, tokens dizisinin uzunluğuna eşittir.

        for (String token : tokens) {
            if (token.matches("\\d+")) {//Eğer eleman sayısal bir değere uyuyorsa (token.matches("\\d+")), o sayı int türüne dönüştürülerek numbers dizisine ekleniyor ve count değeri bir artırılıyor.
                int number = Integer.parseInt(token);
                numbers[count] = number;
                count++;
            }
        }

        scanner.close();//Scanner nesnesi kapatılıyor.

        int[] result = new int[count];//Sonuç dizisi olan result oluşturuluyor ve numbers dizisinin sadece kullanılan kısmı, yani count kadarı result dizisine kopyalanıyor.
        System.arraycopy(numbers, 0, result, 0, count);
        return result;//result dizisi döndürülüyor.
    }
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {  //System.getProperty("os.name") ifadesi kullanılarak işletim sistemi adı alınır.
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {  //Eğer işletim sistemi adı "Windows" içeriyorsa, new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor() ifadesi çalıştırılır. Bu ifade, Windows işletim sistemlerinde komut istemcisini (cmd) başlatır ve "cls" komutunu kullanarak ekranı temizler.
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }//Eğer işletim sistemi adı "Windows" içermiyorsa (yani başka bir işletim sistemi ise), new ProcessBuilder("clear").inheritIO().start().waitFor() ifadesi çalıştırılır. Bu ifade, diğer işletim sistemlerinde "clear" komutunu kullanarak ekranı temizler.
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();//şlem sırasında oluşabilecek IOException veya InterruptedException hataları ele alınır ve hata mesajları yazdırılır.
        }
    }

    public void kolonileriCreate(int[] kolonidegerleri, int koloniSayisi, Oyun oyun) {  //kolonileriCreate() metodu, kolonileri oluşturmak için kullanılır. 
        for (int i = 0; i < koloniSayisi; i++) {  //koloniSayisi kadar bir döngü oluşturulur.
            oyun.koloniler[i] = new Koloni(kolonidegerleri[i]);  //Her bir döngü adımında, oyun.koloniler[i] ifadesiyle i indeksine sahip bir Koloni nesnesi oluşturulur ve oyun nesnesinin koloniler dizisine atanır.
            oyun.koloniler[i].setKoloniSembolu(oyun.koloniler[i].sembolUret());  //Oluşturulan koloninin sembolü, oyun.koloniler[i] nesnesinin sembolUret metodunu kullanarak belirlenir ve setKoloniSembolu metoduyla koloniye atanır.

            int rastgele_sayi = new Random().nextInt(2);  //rastgele_sayi adında bir rastgele sayı oluşturulur. Bu sayı 0 veya 1 olabilir.
            if (rastgele_sayi == 0) {  //rastgele_sayi değerine göre, rastgele_sayi 0 ise, oyun.koloniler[i] nesnesinin setKoloni_taktigi metodu ile ATaktik nesnesi atanır. Eğer 
                oyun.koloniler[i].setKoloni_taktigi(new ATaktik());
            } else if (rastgele_sayi == 1) {  //rastgele_sayi 1 ise, oyun.koloniler[i] nesnesinin setKoloni_taktigi metodu ile BTaktik nesnesi atanır.
                oyun.koloniler[i].setKoloni_taktigi(new BTaktik());
            }

            int rastgele_sayi_uretim = new Random().nextInt(2);  //rastgele_sayi_uretim adında bir rastgele sayı daha oluşturulur. Bu sayı yine 0 veya 1 olabilir.
            if (rastgele_sayi_uretim == 0) {//rastgele_sayi_uretim 0 ise, oyun.koloniler[i] nesnesinin setUretim_sekli metodu ile AUretim nesnesi atanır. 
                oyun.koloniler[i].setUretim_sekli(new AUretim());
            } else if (rastgele_sayi_uretim == 1) {  //rastgele_sayi_uretim 1 ise, oyun.koloniler[i] nesnesinin setUretim_sekli metodu ile BUretim nesnesi atanır.
                oyun.koloniler[i].setUretim_sekli(new BUretim());
            }
        }
    }

    public void Oyun_Savas(Koloni koloni1, int indexOfKoloni1, Koloni koloni2, int indexOfKoloni2, Oyun oyun) { //Oyun_Savas adlı bir metodu içermektedir. Bu metot, iki koloni arasında bir savaş simülasyonunu gerçekleştirmektedir. 
        int guc1 = koloni1.getKoloni_taktigi().savas();
        int guc2 = koloni2.getKoloni_taktigi().savas();
//koloni1 ve koloni2 nesnelerinin taktik güçleri (guc1 ve guc2) getKoloni_taktigi().savas() metodu kullanılarak hesaplanır.
        int uretim1_ekle = oyun.koloniler[indexOfKoloni1].getUretim_sekli().uretim();
        int uretim2_ekle = oyun.koloniler[indexOfKoloni2].getUretim_sekli().uretim();
//uretim1_ekle ve uretim2_ekle değişkenleri, oyun.koloniler[indexOfKoloni1] ve oyun.koloniler[indexOfKoloni2] nesnelerinin üretim şekilleri (getUretim_sekli().uretim()) kullanılarak hesaplanır.
        if (guc1 > guc2) {//guc1 değeri guc2 değerinden büyük ise:
            int fark = guc1 - guc2;//Fark (fark) hesaplanır.
            int transfer = (fark * koloni2.getYemekStogu()) / 1000;//transfer, (fark * koloni2.getYemekStogu()) / 1000 formülüyle hesaplanır.
            int azalan_populasyon = (fark * koloni2.getPopulasyon()) / 1000;//azalan_populasyon, (fark * koloni2.getPopulasyon()) / 1000 formülüyle hesaplanır.

            if (oyun.koloniler[indexOfKoloni2].getPopulasyon() == 1) {
                oyun.koloniler[indexOfKoloni2].setPopulasyon(0);
            }//Eğer oyun.koloniler[indexOfKoloni2] nesnesinin populasyonu 1 ise, populasyonu 0 olarak ayarlanır.

            oyun.koloniler[indexOfKoloni2].setPopulasyon(oyun.koloniler[indexOfKoloni2].getPopulasyon() - azalan_populasyon);//oyun.koloniler[indexOfKoloni2] nesnesinin populasyonu azalan_populasyon kadar azaltılır.
            oyun.koloniler[indexOfKoloni1].setYemekStogu(oyun.koloniler[indexOfKoloni1].getYemekStogu() + transfer);//oyun.koloniler[indexOfKoloni1] nesnesinin yemek stoğuna transfer kadar eklenir.
            oyun.koloniler[indexOfKoloni2].setYemekStogu(oyun.koloniler[indexOfKoloni2].getYemekStogu() - transfer);//oyun.koloniler[indexOfKoloni2] nesnesinin yemek stoğundan transfer kadar düşülür.

            oyun.koloniler[indexOfKoloni1].setKazanma(oyun.koloniler[indexOfKoloni1].getKazanma() + 1);//oyun.koloniler[indexOfKoloni1] nesnesinin kazanma sayısı bir artırılır.
            oyun.koloniler[indexOfKoloni2].setKaybetme(oyun.koloniler[indexOfKoloni2].getKaybetme() + 1);//oyun.koloniler[indexOfKoloni2] nesnesinin kaybetme sayısı bir artırılır
        } 
        else if (guc2 > guc1) {//Eğer guc2 değeri guc1 değerinden büyük ise:
           //koloni1 ve koloni2 nesnelerinin rolleri yer değiştirir.
        	int fark = guc2 - guc1;
            int transfer = (fark * koloni1.getYemekStogu()) / 1000;
            int azalan_populasyon = (fark * koloni1.getPopulasyon()) / 1000;

            if (oyun.koloniler[indexOfKoloni1].getPopulasyon() == 1) {
                oyun.koloniler[indexOfKoloni1].setPopulasyon(0);
            }

            oyun.koloniler[indexOfKoloni1].setPopulasyon(oyun.koloniler[indexOfKoloni1].getPopulasyon() - azalan_populasyon);
            oyun.koloniler[indexOfKoloni2].setYemekStogu(oyun.koloniler[indexOfKoloni2].getYemekStogu() + transfer);
            oyun.koloniler[indexOfKoloni1].setYemekStogu(oyun.koloniler[indexOfKoloni1].getYemekStogu() - transfer);

            oyun.koloniler[indexOfKoloni2].setKazanma(oyun.koloniler[indexOfKoloni2].getKazanma() + 1);
            oyun.koloniler[indexOfKoloni1].setKaybetme(oyun.koloniler[indexOfKoloni1].getKaybetme() + 1);
        }
        else {//Eğer guc1 ve guc2 değerleri eşit ise:
            if (oyun.koloniler[indexOfKoloni1].getPopulasyon() > oyun.koloniler[indexOfKoloni2].getPopulasyon()) {//Eğer oyun.koloniler[indexOfKoloni1] nesnesinin populasyonu oyun.koloniler[indexOfKoloni2] nesnesinin populasyonundan büyük ise:
                if (oyun.koloniler[indexOfKoloni2].getPopulasyon() == 1) {//Eğer oyun.koloniler[indexOfKoloni2] nesnesinin populasyonu 1 ise, populasyonu 0 olarak ayarlanır.
                    oyun.koloniler[indexOfKoloni2].setPopulasyon(0);
                }

                oyun.koloniler[indexOfKoloni1].setKazanma(oyun.koloniler[indexOfKoloni1].getKazanma() + 1);//oyun.koloniler[indexOfKoloni1] nesnesinin kazanma sayısı bir artırılır.
                oyun.koloniler[indexOfKoloni2].setKaybetme(oyun.koloniler[indexOfKoloni2].getKaybetme() + 1);//oyun.koloniler[indexOfKoloni2] nesnesinin kaybetme sayısı bir artırılır.
            } 
            else if (oyun.koloniler[indexOfKoloni2].getPopulasyon() > oyun.koloniler[indexOfKoloni1].getPopulasyon()) {//Eğer oyun.koloniler[indexOfKoloni2] nesnesinin populasyonu oyun.koloniler[indexOfKoloni1] nesnesinin populasyonundan büyük ise:
                if (oyun.koloniler[indexOfKoloni1].getPopulasyon() == 1) {//Eğer oyun.koloniler[indexOfKoloni1] nesnesinin populasyonu 1 ise, populasyonu 0 olarak ayarlanır.
                    oyun.koloniler[indexOfKoloni1].setPopulasyon(0);
                }

                oyun.koloniler[indexOfKoloni2].setKazanma(oyun.koloniler[indexOfKoloni2].getKazanma() + 1);//oyun.koloniler[indexOfKoloni2] nesnesinin kazanma sayısı bir artırılır.
                oyun.koloniler[indexOfKoloni1].setKaybetme(oyun.koloniler[indexOfKoloni1].getKaybetme() + 1);//oyun.koloniler[indexOfKoloni1] nesnesinin kaybetme sayısı bir artırılır.
            } 
            else {//Eğer populasyonlar eşit ise, bir rastgele sayı üretilerek hangi koloninin kazandığı belirlenir.
                int beraberlik_sayi = (int) (Math.random() * 2);
                if (beraberlik_sayi == 0) {
                    oyun.koloniler[indexOfKoloni1].setKazanma(oyun.koloniler[indexOfKoloni1].getKazanma() + 1);
                    oyun.koloniler[indexOfKoloni2].setKaybetme(oyun.koloniler[indexOfKoloni2].getKaybetme() + 1);
                } 
                else {
                    oyun.koloniler[indexOfKoloni2].setKazanma(oyun.koloniler[indexOfKoloni2].getKazanma() + 1);
                    oyun.koloniler[indexOfKoloni1].setKaybetme(oyun.koloniler[indexOfKoloni1].getKaybetme() + 1);
                }
            }
        }

        if (oyun.oyun_tur_sayisi > 0) {//Eğer oyun.oyun_tur_sayisi 0'dan büyük ise:
            int her_tur_artacak_populasyon1 = (oyun.koloniler[indexOfKoloni1].getPopulasyon() * 20) / 100;//her_tur_artacak_populasyon1, (oyun.koloniler[indexOfKoloni1].getPopulasyon() * 20) / 100 formülüyle hesaplanır.
            int her_tur_artacak_populasyon2 = (oyun.koloniler[indexOfKoloni2].getPopulasyon() * 20) / 100;//her_tur_artacak_populasyon2, (oyun.koloniler[indexOfKoloni2].getPopulasyon() * 20) / 100 formülüyle hesaplanır.
            int her_tur_azalacak_yemek_stogu1 = oyun.koloniler[indexOfKoloni1].getPopulasyon() * 2;//her_tur_azalacak_yemek_stogu1, oyun.koloniler[indexOfKoloni1].getPopulasyon() * 2 formülüyle hesaplanır.
            int her_tur_azalacak_yemek_stogu2 = oyun.koloniler[indexOfKoloni2].getPopulasyon() * 2;//her_tur_azalacak_yemek_stogu2, oyun.koloniler[indexOfKoloni2].getPopulasyon() * 2 formülüyle hesaplanır.

            oyun.koloniler[indexOfKoloni1].setPopulasyon(oyun.koloniler[indexOfKoloni1].getPopulasyon() + her_tur_artacak_populasyon1);//oyun.koloniler[indexOfKoloni1] nesnesinin populasyonuna her_tur_artacak_populasyon1 kadar eklenir.
            oyun.koloniler[indexOfKoloni2].setPopulasyon(oyun.koloniler[indexOfKoloni2].getPopulasyon() + her_tur_artacak_populasyon2);//oyun.koloniler[indexOfKoloni2] nesnesinin populasyonuna her_tur_artacak_populasyon2 kadar eklenir.
            oyun.koloniler[indexOfKoloni1].setYemekStogu(oyun.koloniler[indexOfKoloni1].getYemekStogu() - her_tur_azalacak_yemek_stogu1);//oyun.koloniler[indexOfKoloni1] nesnesinin yemek stoğundan her_tur_azalacak_yemek_stogu1 kadar düşülür.
            oyun.koloniler[indexOfKoloni2].setYemekStogu(oyun.koloniler[indexOfKoloni2].getYemekStogu() - her_tur_azalacak_yemek_stogu2);//oyun.koloniler[indexOfKoloni2] nesnesinin yemek stoğundan her_tur_azalacak_yemek_stogu2 kadar düşülür.

            oyun.koloniler[indexOfKoloni1].setYemekStogu(oyun.koloniler[indexOfKoloni1].getYemekStogu() + uretim1_ekle);//oyun.koloniler[indexOfKoloni1] nesnesinin yemek stoğuna uretim1_ekle kadar eklenir.
            oyun.koloniler[indexOfKoloni2].setYemekStogu(oyun.koloniler[indexOfKoloni2].getYemekStogu() + uretim2_ekle);//oyun.koloniler[indexOfKoloni2] nesnesinin yemek stoğuna uretim2_ekle kadar eklenir.
        }
    }
    
    
    public void koloniKontrol(Oyun oyun, int turSayisi) {
        int silinenKoloniler = 0;
        // Oyunun kolonilerini kontrol eder ve silinmesi gereken kolonileri belirler.
        for (int i = 0; i < oyun.sabitKoloniSayisi; i++) {
            if (oyun.koloniler[i].getKoloniikontrol() == 1) {
                // Eğer bir koloninin popülasyonu veya yemek stoğu sıfır veya daha küçük ise,
                if (oyun.koloniler[i].getPopulasyon() <= 0 || oyun.koloniler[i].getYemekStogu() <= 0) {
                    oyun.koloniler[i].setKoloniikontrol(0); // koloniikontrol değeri sıfıra (0) atanır ve silinenKoloniler sayacı artırılır.
                    silinenKoloniler++;
                }
            }
        }

        oyun.setKoloniSayisi(oyun.getKoloniSayisi() - silinenKoloniler);
        // silinenKoloniler değeri, oyunun toplam koloni sayısından çıkarılarak aktif koloni sayısı güncellenir.
    }
    
    public void ciktiVer(int tursayisi) {//ciktiVer metodu, oyun durumunun bir çıktısını ekrana yazdırmak için kullanılır. 
        this.oyun_tur_sayisi = tursayisi;//tursayisi parametresiyle oyun tur sayısını alır ve this.oyun_tur_sayisi değişkenine atar.

        System.out.println("____________________________________________________________________________________");//Çıktıyı biçimlendirmek için başlık satırlarını ekrana yazdırır.
        System.out.println("Tur Sayisi: " + this.oyun_tur_sayisi);
        System.out.println(String.format("%-7s  %-18s  %-18s  %-10s  %-10s", "Koloni", "Populasyon", "Yemek Stogu", "Kazanma", "Kaybetme"));//Koloni sembolünü (koloni.getKoloniSembolu()) ekrana yazdırır.

        for (int i = 0; i < this.sabitKoloniSayisi; i++) {
            Koloni koloni = this.koloniler[i];//this.koloniler dizisinden bir koloni nesnesi alır.
            System.out.printf("%-7c  ", koloni.getKoloniSembolu());//Koloni sembolünü (koloni.getKoloniSembolu()) ekrana yazdırır.

            if (koloni.getPopulasyon() <= 0 || koloni.getYemekStogu() <= 0) {//Koloninin populasyonu veya yemek stoğu sıfırdan küçük veya eşit ise, boş bir satır yazdırır.
                System.out.println(String.format("%-18s  %-18s  %-10s  %-10s",
                        "--", "--", "--", "--"));
            } else {
                System.out.println(String.format("%-18s  %-18s  %-10s  %-10s",
                        koloni.getPopulasyon(), koloni.getYemekStogu(), koloni.getKazanma(), koloni.getKaybetme()));
            }//Aksi takdirde, koloninin populasyonunu (koloni.getPopulasyon()), yemek stoğunu (koloni.getYemekStogu()), kazanma sayısını (koloni.getKazanma()) ve kaybetme sayısını (koloni.getKaybetme()) biçimlendirerek ekrana yazdırır.
        }
        System.out.println("____________________________________________________________________________________");
//Alt çizgilerle ayrılmış bir satır yazdırarak çıktıyı tamamlar.
    }
    
    
    
}

