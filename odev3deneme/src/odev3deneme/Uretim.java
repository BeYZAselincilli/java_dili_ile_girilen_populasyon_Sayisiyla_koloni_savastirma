package odev3deneme;

import java.util.Random;

public abstract class Uretim {  //Uretim adında soyut bir sınıfı tanımlar. Uretim sınıfı, farklı üretim şekillerini temsil eden alt sınıfların soyut bir temelini oluşturur.
    private int urunId;
    private static Random random = new Random();  //random: Random sınıfından oluşturulan bir nesnedir ve rastgele sayı üretmek için kullanılır.

    public Uretim(int urunId) { //urunId: Bir üretim şeklinin benzersiz kimliğini temsil eder.
        this.urunId = urunId;
    }

    public static Uretim new_Uretim(int urunId) {  //parametre olarak aldığı urunId değerine göre bir üretim nesnesi oluşturur. new_Uretim metodu, Uretim sınıfından kalıtım alan anonim bir alt sınıf oluşturur
        return new Uretim(urunId) {
            @Override
            public int uretim() {  //uretim metodu üzerinden rastgele bir üretim değeri üretir. 
                int uretilenDeger = random.nextInt(10) + 1;
                return uretilenDeger;
            }
        };
    }

    public abstract int uretim();

    public int getUrunId() {
        return urunId;
    }//Getter metodu olan getUrunId ise urunId özelliğinin değerini elde etmek için kullanılır.
}
