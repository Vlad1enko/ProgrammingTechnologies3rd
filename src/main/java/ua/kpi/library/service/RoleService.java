package ua.kpi.library.service;

import ua.kpi.library.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRolesOfUser(Integer userId);

    void addRoleToUser(Integer userId, Integer roleId);

    void removeRoleFromUser(Integer userId, Integer roleId);

}