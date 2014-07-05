package com.jingge.demo.msa.book.representations;

/**
 * Created with IntelliJ IDEA.
 * User: jing.ge
 * Date: 01.07.14
 * Time: 09:31
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    private int id;
    private String isdn;
    private String name;
    private String description;
    private int edition;

    /**
     * Important! Jersey needs it
     */
    public Book() {
    }

    public Book(int id, String isdn, String name, String description, int edition) {
        this.id = id;
        this.isdn = isdn;
        this.name = name;
        this.description = description;
        this.edition = edition;
    }

    public int getId() {
        return id;
    }

    public String getIsdn() {
        return isdn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEdition() {
        return edition;
    }
}
