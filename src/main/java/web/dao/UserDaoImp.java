package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

//    protected EntityManager getEntityManager() {
//        return entityManager.createEntityManager();
//    }



    public void add(User user) {
        entityManager.persist(user);
    }



    public List<User> getAllUsers() {
        List<User> allUsers;
        allUsers = entityManager.createQuery("SELECT p from User p", User.class).getResultList();
        return allUsers;
    }
}
