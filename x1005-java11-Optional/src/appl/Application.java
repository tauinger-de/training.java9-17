package appl;

import java.io.IOException;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws IOException {
        Optional<String> s = Optional.empty();
        if (!s.isPresent())
            System.out.println("empty");
        if (s.isEmpty())
            System.out.println("empty");
    }
}
