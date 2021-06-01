package ua.kpi.library.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library.exception.ObjectNotFoundException;
import ua.kpi.library.model.Role;
import ua.kpi.library.model.User;
import ua.kpi.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRolesOfUser(Integer userId) {
        User user = userService.getUser(userId);
        List<Role> roles = user.getRoles();
        roles.forEach(Hibernate::initialize);
        return roles;
    }

    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ObjectNotFoundException("Role", roleId));
        User user = userService.getUser(userId);
        if (!user.getRoles().contains(role))
            role.addUser(user);
        roleRepository.save(role);
    }

    @Override
    public void removeRoleFromUser(Integer userId, Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ObjectNotFoundException("Role", roleId));
        role.removeUser(userService.getUser(userId));
        roleRepository.save(role);
    }
}
