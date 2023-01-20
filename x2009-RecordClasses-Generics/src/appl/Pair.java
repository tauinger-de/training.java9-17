package appl;

@SuppressWarnings("preview")
public record Pair<F, S>(F first, S second) {
    public static <T0, T1> Pair<T0, T1> of(T0 left, T1 right) {
        return new Pair<T0, T1>(left, right);
    }
}
