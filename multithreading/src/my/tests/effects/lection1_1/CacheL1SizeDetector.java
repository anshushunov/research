package my.tests.effects.lection1_1;

/*
Обнаружение кеша L1, который обычно равен 32 килобайтам
От 8кб увеличиваем на 8 кб, после 32 видим что начинает медленее работать из-за cache pollution.

len:8192, dT: 9000, 10*dT/len: 10
len:16384, dT: 17100, 10*dT/len: 10
len:24576, dT: 26300, 10*dT/len: 10
len:32768, dT: 33300, 10*dT/len: 10
len:40960, dT: 71800, 10*dT/len: 17
len:49152, dT: 98200, 10*dT/len: 19
len:57344, dT: 113400, 10*dT/len: 19
len:65536, dT: 127300, 10*dT/len: 19

(не всегда работает, может понадобиться несколько запусков) Но работает!
 */
public class CacheL1SizeDetector {
    public static void main(String[] args) {
        byte[] array = new byte[64 * 1024];

        for (int testIndex = 0; testIndex < 10; testIndex++) {
            testFunction(array);
            System.out.println("---");
        }
    }

    private static void testFunction(byte[] array) {
        for (int len = 8192; len <= array.length; len += 8192) {
            long t0 = System.nanoTime();
            for (int n = 0; n < 100; n++) {
                for (int index = 0; index < len; index += 64) {
                    array[index] = 1;
                }
            }
            long dT = System.nanoTime() - t0;

            System.out.println("len:" + len + ", dT: " + dT + ", 10*dT/len: " + (10 * dT) / len);
        }
    }
}
