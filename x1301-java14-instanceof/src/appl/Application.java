package appl;

import jj.util.log.Log;


class Alpha {
    int a;

    public Alpha(int a) {
        this.a = a;
    }

}

class Beta extends Alpha {
    int b;

    public Beta(int a, int b) {
        super(a);
        this.b = b;
    }
}

class Gamma extends Beta {
    int c;

    public Gamma(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
}

public class Application {
    public static void main(String[] args) {
        demoOldFashion();
        demoNewFashion();
    }

    static void demoOldFashion() {
        Log.logMethodCall();
        Alpha alpha = new Gamma(1, 2, 3);
        if (alpha instanceof Gamma) {
            Gamma gamma = (Gamma) alpha;
            System.out.println(gamma.a + " " + gamma.b + " " + gamma.c);
        } else if (alpha instanceof Beta) {
            Beta beta = (Beta) alpha;
            System.out.println(beta.a + " " + beta.b);
        } else if (alpha instanceof Alpha) {
            System.out.println(alpha.a);
        }
    }

    static void demoNewFashion() {
        Log.logMethodCall();
        Alpha alpha = new Gamma(1, 2, 3);
        if (alpha instanceof Gamma gamma) {
            System.out.println(gamma.a + " " + gamma.b + " " + gamma.c);
        } else if (alpha instanceof Beta beta) {
            System.out.println(beta.a + " " + beta.b);
        } else if (alpha instanceof Alpha) {
            System.out.println(alpha.a);
        }
    }
}
