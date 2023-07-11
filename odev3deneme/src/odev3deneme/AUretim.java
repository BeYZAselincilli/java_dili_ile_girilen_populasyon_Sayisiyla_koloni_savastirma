package odev3deneme;

import java.util.Random;

public class AUretim extends Uretim {
    public AUretim() {
        super(0);
    }

    
    //AUretim adında bir sınıf tanımlar ve Uretim sınıfını extends (genişletir). AUretim sınıfı, 0 parametresiyle super anahtar kelimesiyle Uretim sınıfının constructor'ını çağırır.
    
    
    @Override
    public int uretim() {
        int uretilenDeger = new Random().nextInt(10) + 1;
        return uretilenDeger;
    }
}
//AUretim sınıfı ayrıca uretim adında bir metot tanımlar. Bu metot, 1 ile 10 arasında rastgele bir değer üretir ve bu değeri döndürür.