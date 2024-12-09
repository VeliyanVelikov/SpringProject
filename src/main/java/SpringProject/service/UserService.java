package SpringProject.service;

import SpringProject.entity.Role;
import SpringProject.entity.User;
import SpringProject.exception.DuplicateRecordException;
import SpringProject.repository.RoleRepository;
import SpringProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user){
        // Make sure the role is set to either "Customer" or "Admin"
        try{
            Role role = roleService.findByName("Admin");  // Or "Admin", depending on your need
            user.setRole(role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(
                    String.format("Username %s already exists", user.getUsername()));
        }
    }
    public Set<User> findAll(){
        return new HashSet<>(userRepository.findAll());
    }
}
