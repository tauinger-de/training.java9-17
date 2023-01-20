package jj.appl;

import jj.database.BookDatabase;
import jj.gui.BookFrame;

public class Application {
    public static void main(String[] args) {
        final BookDatabase bookDatabase = new BookDatabase();
        new BookFrame(bookDatabase);
    }
}