package appl;

@SuppressWarnings("preview")
public record MinMax(int min, int max) {
    public static MinMax of(int... values) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value < min)
                min = value;
            else if (value > max)
                max = value;
        }
        return new MinMax(min, max);
    }
}
