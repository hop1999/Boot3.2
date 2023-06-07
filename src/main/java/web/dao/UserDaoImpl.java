package web.dao;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.model.User;

import java.util.List;

// Hope dies last

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User showUserById(int id) {
        return em.find(User.class, id);
    }

    public void saveUser(User user) {
        em.persist(user);
    }

    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void deleteUserById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}