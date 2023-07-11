package odev3deneme;

import java.util.Random;

public abstract class Taktik { //Taktik adında soyut bir sınıfı tanımlar. Taktik sınıfı, farklı taktikleri temsil eden alt sınıfların soyut bir temelini oluşturur.
    private int taktikId;
    private static Random random = new Random();//random: Random sınıfından oluşturulan bir nesnedir ve rastgele sayı üretmek için kullanılır.

    public Taktik(int taktikId) {
        this.taktikId = taktikId; //taktikId: Bir taktiğin benzersiz kimliğini temsil eder. Her taktik nesnesi, farklı bir taktikId değerine sahip olabilir.
    }

    public static Taktik new_Taktik(int taktikId) { //
        return new Taktik(taktikId) {
            @Override
            public int savas() { //Taktik sınıfından kalıtım alan anonim bir alt sınıf oluşturur ve bu alt sınıfın savas metodu üzerinden rastgele bir puan üretir.
                int puan = random.nextInt(1001);
                return puan;
            }
        };
    }

    public abstract int savas();
//Getter metodu olan getTaktikId ise taktikId özelliğinin değerini elde etmek için kullanılır.
    public int getTaktikId() {
        return taktikId;
    }
}