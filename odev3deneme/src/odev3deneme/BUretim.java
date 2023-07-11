package odev3deneme;

import java.util.Random;

public class BUretim extends Uretim {
    public BUretim() {
        super(1);
    }
    //BUretim adında bir sınıf tanımlar ve Uretim sınıfını extends (genişletir). BUretim sınıfı, 1 parametresiyle super anahtar kelimesiyle Uretim sınıfının constructor'ını çağırır.
    
    
    @Override
    public int uretim() {
        int uretilenDeger = new Random().nextInt(10) + 1;
        return uretilenDeger;
    }
}
//BUretim sınıfı ayrıca uretim adında bir metot tanımlar. Bu metot, 1 ile 10 arasında rastgele bir değer üretir ve bu değeri döndürür. 