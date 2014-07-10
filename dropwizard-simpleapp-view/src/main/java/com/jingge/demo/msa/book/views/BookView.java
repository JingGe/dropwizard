package com.jingge.demo.msa.book.views;

import com.jingge.demo.msa.book.representations.Book;
import io.dropwizard.views.View;

/**
 * Created with IntelliJ IDEA.
 * User: Jing
 * Date: 14-7-10
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */
public class BookView extends View {
    private Book book;

    public BookView(Book book) {
        super("book.ftl");
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
