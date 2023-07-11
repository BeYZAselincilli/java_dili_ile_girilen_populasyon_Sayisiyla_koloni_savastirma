package odev3deneme;

import java.util.HashSet; 
import java.util.Random;
import java.util.Set;

public class Koloni {
    private Taktik koloni_taktigi; //koloni_taktigi: Taktik tipinde bir değişken, koloninin taktiğini tutar.
    private Uretim uretim_sekli; //uretim_sekli: Uretim tipinde bir değişken, koloninin üretim şeklini tutar.
    private int yemekStogu; //yemekStogu: Koloninin yemek stokunu temsil eden bir tamsayı.
    private int populasyon;  //populasyon: Koloninin başlangıç populasyonunu temsil eden bir tamsayı.
    private int azalan_populasyon;  //azalan_populasyon: Savaş sonucunda azalan populasyon miktarını tutan bir tamsayı.
    private int kazanma;  //kazanma: Koloninin kazandığı savaş sayısını temsil eden bir tamsayı.
    private int kaybetme;  //kaybetme: Koloninin kaybettiği savaş sayısını temsil eden bir tamsayı.
    private int koloniikontrol;  //koloniikontrol: Koloninin kontrol durumunu temsil eden bir tamsayı.
    private char koloniSembolu;  //koloniSembolu: Koloninin sembolünü temsil eden bir karakter.
    private int koloni_uretim_yemek;  //koloni_uretim_yemek: Koloninin üretimden aldığı yemek miktarını temsil eden bir tamsayı.
    private static final int KUCUK_SAYI = 33;
    private static final int BUYUK_SAYI = 126;

    private Set<Character> kullanilanSemboller = new HashSet<>();  //kullanilanSemboller: Koloninin kullandığı sembolleri takip eden bir karakter kümesi.

    public Koloni(int populasyon) {  //Bu sınıfın kurucusu, başlangıç populasyonunu parametre olarak alır. 
        this.populasyon = populasyon;// Kurucu, koloninin özelliklerini başlangıç değerleriyle initialize eder. 
        this.yemekStogu = populasyon * populasyon;// Yemek stoku, populasyonun karesi olarak belirlenir.
        this.kaybetme = 0;//Kazanma ve kaybetme sayıları sıfıra eşitlenir,
        this.kazanma = 0;
        this.koloniikontrol = 1; // kontrol durumu 1 olarak atanır
        this.koloniSembolu = sembolUret();  //koloni sembolü üretilir.
    }

    public char sembolUret() {
        char smbl; //sayi_rast adında bir değişken oluşturulur

        do {
            int sayi_rast = new Random().nextInt(BUYUK_SAYI - KUCUK_SAYI + 1) + KUCUK_SAYI;  //Random.nextInt() yöntemi kullanılarak, BUYUK_SAYI ve KUCUK_SAYI arasında rastgele bir tamsayı elde edilir.
            smbl = (char) sayi_rast;  //Elde edilen tamsayı, char türüne dönüştürülerek smbl değişkenine atanır.
        } while (kullanilanSemboller.contains(smbl));
//Oluşturulan sembol (smbl), daha önce kullanılan sembollerin bulunduğu kullanilanSemboller kümesinde mevcut olup olmadığı kontrol edilir.
        kullanilanSemboller.add(smbl);  //Eğer sembol kullanilanSemboller kümesinde bulunuyorsa, döngü tekrarlanır ve yeni bir sembol üretimi için adımlar tekrarlanır.
        return smbl;  //üretilen sembol (smbl) döndürülür.
    }

    @FunctionalInterface
    interface SembolUret {
        char sembolUret();
    }

    // Getters and Setters

    public Taktik getKoloni_taktigi() {
        return koloni_taktigi;
    }//koloni_taktigi: Taktik türünden bir nesneyi temsil eder. Bu özellik, bir koloninin sahip olduğu taktiği belirtir.


    public void setKoloni_taktigi(Taktik koloni_taktigi) {
        this.koloni_taktigi = koloni_taktigi;
    }

    public Uretim getUretim_sekli() {
        return uretim_sekli;
    }//uretim_sekli: Uretim türünden bir nesneyi temsil eder. Bu özellik, bir koloninin sahip olduğu üretim şeklini belirtir.


    public void setUretim_sekli(Uretim uretim_sekli) {
        this.uretim_sekli = uretim_sekli;
    }

    public int getYemekStogu() {
        return yemekStogu;
    }//yemekStogu: Bir koloninin yemek stokunu temsil eder.

    public void setYemekStogu(int yemekStogu) {
        this.yemekStogu = yemekStogu;
    }

    public int getPopulasyon() {
        return populasyon;
    }//populasyon: Bir koloninin populasyonunu temsil eder.

    public void setPopulasyon(int populasyon) {
        this.populasyon = populasyon;
    }

    public int getAzalan_populasyon() {
        return azalan_populasyon;
    }//azalan_populasyon: Bir koloninin azalan populasyonunu temsil eder.

    public void setAzalan_populasyon(int azalan_populasyon) {
        this.azalan_populasyon = azalan_populasyon;
    }

    public int getKazanma() {
        return kazanma;//kazanma: Bir koloninin kazanma sayısını temsil eder.
    }

    public void setKazanma(int kazanma) {
        this.kazanma = kazanma;
    }

    public int getKaybetme() {
        return kaybetme;
    }//kaybetme: Bir koloninin kaybetme sayısını temsil eder.

    public void setKaybetme(int kaybetme) {
        this.kaybetme = kaybetme;
    }

    public int getKoloniikontrol() {
        return koloniikontrol;
    }//koloniikontrol: Bir koloninin kontrol durumunu temsil eder.

    public void setKoloniikontrol(int koloniikontrol) {
        this.koloniikontrol = koloniikontrol;
    }

    public char getKoloniSembolu() {
        return koloniSembolu;//koloniSembolu: Bir koloninin sembolünü temsil eder.
    }

    public void setKoloniSembolu(char koloniSembolu) {
        this.koloniSembolu = koloniSembolu;
    }

    public int getKoloni_uretim_yemek() {
        return koloni_uretim_yemek;//koloni_uretim_yemek: Bir koloninin ürettiği yemek miktarını temsil eder.
    }

    public void setKoloni_uretim_yemek(int koloni_uretim_yemek) {
        this.koloni_uretim_yemek = koloni_uretim_yemek;
    }
    
}
