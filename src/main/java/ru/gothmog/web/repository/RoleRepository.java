package ru.gothmog.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.web.model.Role;

/**
 * @author gothmog on 26.05.2017.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
