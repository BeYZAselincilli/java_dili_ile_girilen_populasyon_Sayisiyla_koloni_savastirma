package odev3deneme;


import java.util.Random;


public class ATaktik extends Taktik {
    public ATaktik() {
        super(0);
    }
//ATaktik adında bir sınıf tanımlar ve Taktik sınıfını extends (genişletir). ATaktik sınıfı, 0 parametresiyle super anahtar kelimesiyle Taktik sınıfının constructor'ını çağırır.
   
    public int savas() {
        int puan = new Random().nextInt(1001);
        return puan;
    }
}
//savas adında bir metot tanımlar. Bu metot, 0 ile 1000 arasında rastgele bir puan üretir ve bu puanı döndürür. 