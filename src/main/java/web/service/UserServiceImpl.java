package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {return userDao.getAllUsers();}

    @Transactional(readOnly = true)
    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {userDao.saveUser(user);}

    @Transactional
    @Override
    public void updateUserById(int id, User updatedUser) {
        userDao.updateUserById(id, updatedUser);
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
