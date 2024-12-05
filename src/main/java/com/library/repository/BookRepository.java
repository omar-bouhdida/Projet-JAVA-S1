package com.library.repository;

import com.library.DatabaseUtil;
import com.library.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookRepository {
    public void save(Book book) {
        Transaction transaction = null;
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }
}
