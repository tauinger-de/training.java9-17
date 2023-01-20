package appl;

import util.ClassInspector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {
    public static void main(String[] args) {
        final CFoo cfoo = serializeDeserialize(new CFoo(42, "Hello"));
        System.out.println(cfoo);

        System.out.println();

        final RFoo rfoo = serializeDeserialize(new RFoo(42, "Hello"));
        System.out.println(rfoo);
        ClassInspector.inspect(RFoo.class);
    }

    @SuppressWarnings("unchecked")
    private static <T> T serializeDeserialize(T obj) {
        try {
            System.out.println("--- serializing ---");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(obj);
            oos.close();
            System.out.println("-- deserializing --");
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(in);
            return (T) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
