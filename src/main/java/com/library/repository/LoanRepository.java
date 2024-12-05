package com.library.repository;

import com.library.DatabaseUtil;
import com.library.model.Loan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LoanRepository {
    public void save(Loan loan) {
        Transaction transaction = null;
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Loan> getAllLoans() {
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Loan", Loan.class).list();
        }
    }
}
