package appl;

public class Watch {
    private final long start = System.nanoTime();
    private final String name;

    public Watch(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final long stop = System.nanoTime();
        return this.name + " : " + ((stop - this.start) / 1_000_000);
    }
}
