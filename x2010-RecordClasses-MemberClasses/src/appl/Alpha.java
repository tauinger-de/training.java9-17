package appl;

public record Alpha(int a) {

    public void work() {
        System.out.println(this.a);
        new CBeta();
        new RBeta();
        new CGamma();
        new RGamma();
    }

    public static class CBeta {
        public CBeta() {
            System.out.println("CBeta");
        }
    }

    public static record RBeta() {
        public RBeta {
            System.out.println("RBeta");
        }
    }

    public class CGamma {
        public CGamma() {
            System.out.println("CGamma");
        }
    }

    public record RGamma() {
        public RGamma {
            System.out.println("RGamma");
        }
    }
}
