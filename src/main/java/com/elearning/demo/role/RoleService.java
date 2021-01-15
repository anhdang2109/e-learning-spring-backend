package com.elearning.demo.role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> findAll();

    Role save(Role role);

    Optional<Role> findById(Long id);

    void remove(Long id);

    Role findRoleByRoleName(String roleName);
}
