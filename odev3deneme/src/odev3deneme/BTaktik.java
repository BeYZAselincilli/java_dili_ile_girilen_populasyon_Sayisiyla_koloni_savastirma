package odev3deneme;

import java.util.Random;


public class BTaktik extends Taktik {
    public BTaktik() {
        super(1);
    }

    //BTaktik adında bir sınıf tanımlar ve Taktik sınıfını extends (genişletir). BTaktik sınıfı, 1 parametresiyle super anahtar kelimesiyle Taktik sınıfının constructor'ını çağırır.
    public int savas() {
        int puan = new Random().nextInt(1001);
        return puan;
    }
}
//BTaktik sınıfı ayrıca savas adında bir metot tanımlar. Bu metot, 0 ile 1000 arasında rastgele bir puan üretir ve bu puanı döndürür.