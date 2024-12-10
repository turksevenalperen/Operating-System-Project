package İsletimProje1;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private final int[] buffer;
    private int sayac, giris, cikis;
    private final Lock kilit;
    private final Condition doluDegil;
    private final Condition bosDegil;

    public Buffer(int boyut) {
        buffer = new int[boyut];
        sayac = giris = cikis = 0;
        kilit = new ReentrantLock();
        doluDegil = kilit.newCondition();
        bosDegil = kilit.newCondition();
    }

    public void uret(int urun) throws InterruptedException {
        kilit.lock();
        try {
            while (sayac == buffer.length) {
                doluDegil.await();
            }
            buffer[giris] = urun;
            giris = (giris + 1) % buffer.length;
            sayac++;
            bosDegil.signal();
        } finally {
            kilit.unlock();
        }
    }

    public int tuket() throws InterruptedException {
        kilit.lock();
        try {
            while (sayac == 0) {
                bosDegil.await();
            }
            int urun = buffer[cikis];
            cikis = (cikis + 1) % buffer.length;
            sayac--;
            doluDegil.signal();
            return urun;
        } finally {
            kilit.unlock();
        }
    }
}
