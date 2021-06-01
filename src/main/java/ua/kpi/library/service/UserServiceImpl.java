package ua.kpi.library.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.ObjectNotFoundException;
import ua.kpi.library.model.User;
import ua.kpi.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        userList.forEach(Hibernate::initialize);
        return userList;
    }

    @Override
    public void saveUser(User user) {
        user = userRepository.save(user);
        roleService.addRoleToUser(user.getId(), 1);
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User", id));
        Hibernate.initialize(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.getUser(id);
        user.getBooks()
                .forEach(book -> book.setUser(null));
        userRepository.delete(user);
    }
}
