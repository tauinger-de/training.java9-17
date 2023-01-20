package jj.appl;

import jj.domain.Book;
import jj.reflection.Mapper;

public class Application {

    public static void main(String[] args) {
        // System.setSecurityManager(new SecurityManager());
        Book book = new Book("1111", "Pascal", 1970, "N. Wirth");
        Mapper.map(book).forEach((name, value) -> System.out.println(name + " = " + value));
    }
}
