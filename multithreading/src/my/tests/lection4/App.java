package my.tests.lection4;

public class App {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Object ref0 = new Object();
        Object ref1 = new Object();
        synchronized (ref0) {     // Захват монитора одного и того же объекта несколько раз не имеет смысла и аналогичен захвату 1 раз
            synchronized (ref0) { //reentrant
                ref0.notify();
            }
        }
    }

    private static void test2() {
        Object ref0 = new Object();
        Object ref1 = new Object();
        synchronized (ref0) {
            synchronized (ref1) {
                ref0.notify(); //both are okay
                ref1.notify();
            }
        }
    }
}
