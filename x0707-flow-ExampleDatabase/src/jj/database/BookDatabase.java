package jj.database;

import jj.domain.Book;
import jj.util.base.XRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

public class BookDatabase {

    private final List<Book> books = new ArrayList<>();

    {
        books.add(new Book("1111", "Java ist auch eine Insel", "Ullenbohm"));
        books.add(new Book("2222", "Sprechen Sie Java?", "M�ssenb�ck"));
        books.add(new Book("3333", "Effective Java", "Bloch"));
        books.add(new Book("4444", "Modula", "Wirth"));
        books.add(new Book("5555", "Modula-2", "Wirth"));
    }

    public void find(Subscriber<Book> subscriber, String title) {
        new Thread(() -> this.doFind(subscriber, title)).start();
    }

    private void doFind(Subscriber<Book> subscriber, String title) {
        System.out.println("doFind starts...");
        try (final SubmissionPublisher<Book> publisher = new SubmissionPublisher<>()) {
            publisher.subscribe(subscriber);
            this.books.forEach(book -> {
                if (book.title.contains(title)) {
                    XRunnable.xrun(() -> Thread.sleep(1000));
                    publisher.submit(book);
                }
            });
        }
        System.out.println("doFind terminates...");
    }
}
