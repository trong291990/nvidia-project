/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.util.*;

import DAL.*;
import EL.*;

/**
 *
 * @author Administrator
 */
public class BookBLO {
    /* fields */
    private BookDAO bookDAO = new BookDAO();

    /* business methods */
    public List<Book> getAll() throws Exception {
        return bookDAO.selectAll();
    }
    public Book getByCode(int code) throws Exception {
        return bookDAO.selectByCode(code);
    }
    public List<Book> getByName(String name) throws Exception {
        return bookDAO.selectByName(name);
    }
    public List<Book> getByAuthor(String author) throws Exception {
        return bookDAO.selectByAuthor(author);
    }

    public boolean add(Book book) throws Exception {
        if (book.getPrice() < 0 || book.getPrice() > Integer.MAX_VALUE)
            return false;
        return bookDAO.insert(book);
    }
    public boolean edit(Book book) throws Exception {
        if (book.getPrice() < 0 || book.getPrice() > Integer.MAX_VALUE)
            return false;
        return bookDAO.update(book);
    }
    public boolean remove(int code) throws Exception {
        return bookDAO.delete(code);
    }
}
