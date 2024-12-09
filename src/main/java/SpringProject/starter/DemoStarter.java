package SpringProject.starter;

import SpringProject.entity.Role;
import SpringProject.entity.User;
import SpringProject.service.RoleService;
import SpringProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
//@AllArgsConstructor
//public class DemoStarter implements CommandLineRunner {
//
//    private final RoleService roleService;
//    private final UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Create and save roles
//        Role firstRole = new Role();
//        firstRole.setName("Admin");
//        roleService.save(firstRole);
//        Role secondRole = new Role();
//        secondRole.setName("Customer");
//        roleService.save(secondRole);
//        Role updateSecondRole = new Role();
//        updateSecondRole.setName("Update_Customer");
//        roleService.update(updateSecondRole, secondRole.getId());
//
//
//        // Create and save users with roles
//        User user = new User();
//        user.setUsername("Dimo");
//        user.setPassword("1234");
//        userService.save(user);  // This will assign the "Customer" role
//
//        User user1 = new User();
//        user1.setUsername("Alex");
//        user1.setPassword("5678");
//        userService.save(user1);  // This will also assign the "Customer" role (or "Admin" if needed)
//    }
//}
