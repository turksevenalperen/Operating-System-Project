package İsletimProje1;

class Consumer implements Runnable {
    private final Buffer buffer;
    private final String isim;
    private final int hiz;
    private static float toplamTuketimSuresi = 0;
    private static int toplamTuketilen = 0;
    private static final Object kilit = new Object();

    public Consumer(Buffer buffer, String isim, int hiz) {
        this.buffer = buffer;
        this.isim = isim;
        this.hiz = hiz;
    }

    
    public void run() {
        try {
            while (true) {
                long baslangicZamani = System.nanoTime();
                int urun = buffer.tuket();
                long bitisZamani = System.nanoTime();

                synchronized (kilit) {
                    toplamTuketimSuresi += (bitisZamani - baslangicZamani);
                    toplamTuketilen++;
                }

                System.out.println(isim + " tüketti " + urun);
                Thread.sleep(hiz);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static float getToplamTuketimSuresi() {
        synchronized (kilit) {
            return toplamTuketimSuresi;
        }
    }

    public static int getToplamTuketilen() {
        synchronized (kilit) {
            return toplamTuketilen;
        }
    }
}