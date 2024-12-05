package com.library.repository;

import com.library.DatabaseUtil;
import com.library.model.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MemberRepository {
    public void save(Member member) {
        Transaction transaction = null;
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Member", Member.class).list();
        }
    }
}
