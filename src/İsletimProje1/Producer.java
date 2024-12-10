package İsletimProje1;

class Producer implements Runnable {
    private final Buffer buffer;
    private final String isim;
    private final int hiz;
    private static long toplamUretimSuresi = 0;
    private static int toplamUretilen = 0;
    private static final Object kilit = new Object();

    public Producer(Buffer buffer, String isim, int hiz) {
        this.buffer = buffer;
        this.isim = isim;
        this.hiz = hiz;
    }

   
    public void run() {
        try {
            int urun = 0;
            while (true) {
                long baslangicZamani = System.nanoTime();
                buffer.uret(urun);
                long bitisZamani = System.nanoTime();

                synchronized (kilit) {
                    toplamUretimSuresi += (bitisZamani - baslangicZamani);
                    toplamUretilen++;
                }

                System.out.println(isim + " üretti " + urun);
                urun++;
                Thread.sleep(hiz);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static long getToplamUretimSuresi() {
        synchronized (kilit) {
            return toplamUretimSuresi;
        }
    }

    public static int getToplamUretilen() {
        synchronized (kilit) {
            return toplamUretilen;
        }
    }
}