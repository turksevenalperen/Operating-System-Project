package İsletimProje1;

public class Factory {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);  

        Thread Producer1 = new Thread(new Producer(buffer, "Üretici1", 500));
        Thread Producer2 = new Thread(new Producer(buffer, "Üretici2", 700));
        Thread Consumer1 = new Thread(new Consumer(buffer, "Tüketici1", 1000));
        Thread Consumer2 = new Thread(new Consumer(buffer, "Tüketici2", 900));

        Producer1.start();
        Producer2.start();
        Consumer1.start();
        Consumer2.start();

        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Producer1.interrupt();
        Producer2.interrupt();
        Consumer1.interrupt();
        Consumer2.interrupt();

        long toplamUretimSuresi = Producer.getToplamUretimSuresi();
        int toplamUretilen = Producer.getToplamUretilen();
        float toplamTuketimSuresi = Consumer.getToplamTuketimSuresi();
        int toplamTuketilen = Consumer.getToplamTuketilen();

        System.out.println("Toplam üretilen: " + toplamUretilen);
        System.out.println("Toplam tüketilen: " + toplamTuketilen);
        System.out.println("Ortalama üretim süresi: " + (toplamUretilen > 0 ? toplamUretimSuresi / toplamUretilen : 0) + " ms");
        System.out.println("Ortalama tüketim süresi: " + (toplamTuketilen > 0 ? toplamTuketimSuresi / toplamTuketilen : 0) + " ms");
    }
}