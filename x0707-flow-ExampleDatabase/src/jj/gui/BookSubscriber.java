package jj.gui;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

import jj.domain.Book;

public class BookSubscriber implements Flow.Subscriber<Book> {

	private final DefaultListModel<Book> listModel;
	private Subscription subscription;

	public BookSubscriber(DefaultListModel<Book> listModel) {
		this.listModel = listModel;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		// this.subscription.request(1);
		this.subscription.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(Book book) {
		System.out.println("onNext(" + book + ")");
		SwingUtilities.invokeLater(() -> this.listModel.addElement(book));
		// this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("onError");
	}

	@Override
	public void onComplete() {
		System.out.println("onComplete");
	}
}
