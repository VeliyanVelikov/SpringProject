package SpringProject.repository;

import SpringProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {



    Optional<Role> findByName(String name);// Select * from rolls where roll name = name

    void deleteByName(String name);

}
