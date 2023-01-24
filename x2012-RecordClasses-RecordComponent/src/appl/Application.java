package appl;

import util.ClassInspector;

import java.lang.reflect.RecordComponent;

public class Application {
    public static void main(String[] args) {
        final Foo foo = new Foo(42, "Hello");
        System.out.println("isRecord: " + Foo.class.isRecord());
        System.out.println("recordComponents:");
        for (RecordComponent component : Foo.class.getRecordComponents()) {
            try {
                final Object value = component.getAccessor().invoke(foo);
                System.out.println("\t" + component.getName() + " = " + value);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
