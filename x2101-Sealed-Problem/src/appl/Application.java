package appl;

public class Application {
    //@SuppressWarnings("preview")
    public static void main(String[] args) {
        final Statement s = new Loop();
        if (s instanceof Assignment a) {
            System.out.println(a);
        } else if (s instanceof Loop l) {
            System.out.println(l);
        } else if (s instanceof Choice c) {
            System.out.println(c);
        } else if (s instanceof Call c) {
            System.out.println(c);
        } else
            throw new RuntimeException("this should never happen!");

        if (Statement.class.getPermittedSubclasses() != null) {
            for (final Class<?> cls : Statement.class.getPermittedSubclasses()) {
                System.out.println(cls.getName());
            }
        }
    }
}
