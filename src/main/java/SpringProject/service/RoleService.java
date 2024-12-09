package SpringProject.service;

import SpringProject.entity.Role;
import SpringProject.exception.DuplicateRecordException;
import SpringProject.exception.RecordNotFoundException;
import SpringProject.repository.RoleRepository;
import SpringProject.repository.UserRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor

public class RoleService {

    private final RoleRepository roleRepository;


    public Set<Role> findAll(){

        return new HashSet<>(roleRepository.findAll());
    }

    public Role findById (Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role with Id: %s not found", id)
                ));
    }

    @Transactional
    public Role update(Role updatedRole,@NonNull Long id){
        Role dbRole = findById(id);
        dbRole.setName(updatedRole.getName());
        return dbRole;
    }


    public Role findByName(String name){
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role %s already exists", name)
                ));
    }

    public Role save(Role role){
        try {
            return roleRepository.save(role);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(
                    String.format("Role %s already exists", role.getName()));
        }
    }
    public void delete(Long id){
        roleRepository.deleteById(id);
    }
    public void delete(String name){
        roleRepository.deleteByName(name);
    }

}