/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EL;

/**
 *
 * @author Administrator
 */
public class Book {
    /* fields */
    private int code;
    private String name;
    private String author;
    private int price;

    /* constructor methods */
    public Book() {}
    public Book(int code, String name, String author, int price) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    /* accessor methods */
    public int getCode() { return this.code; }
    public void setCode(int value) { this.code = value; }
    public String getName() { return this.name; }
    public void setName(String value) { this.name = value; }
    public String getAuthor() { return this.author; }
    public void setAuthor(String value) { this.author = value; }
    public int getPrice() { return this.price; }
    public void setPrice(int value) { this.price = value; }
}
