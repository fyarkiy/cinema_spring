package com.cinema.dao.impl;

import com.cinema.dao.RoleDao;
import com.cinema.exception.DataProcessingException;
import com.cinema.model.Role;
import com.cinema.model.RoleName;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            logger.info("Role " + role + " was created.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create role " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(RoleName name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> roleQuery =
                    session.createQuery("from Role where roleName = :rolename", Role.class);
            roleQuery.setParameter("rolename", name);
            return roleQuery.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Exception while getting role with role name "
                    + name, e);
        }
    }
}
