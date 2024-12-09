package SpringProject.converter;

import SpringProject.dto.role.RoleResponse;
import SpringProject.dto.user.UserResponse;
import SpringProject.dto.user.UserSaveRequest;
import SpringProject.entity.Role;
import SpringProject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverter {

    private final RoleConverter roleConverter;

    public User convert (UserSaveRequest userSaveRequest){
        return User.builder()
                .username(userSaveRequest.getUsername())
                .password(userSaveRequest.getPassword())
                .build();
    }

    public UserResponse convert(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roleResponse(roleConverter.convert(user.getRole()))
                .build();
    }
}
