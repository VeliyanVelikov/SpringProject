package SpringProject.converter;


import SpringProject.dto.role.RoleResponse;
import SpringProject.dto.role.RoleSaveRequest;
import SpringProject.dto.role.RoleUpdateRequest;
import SpringProject.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role convert(RoleSaveRequest roleSaveRequest){
        return Role.builder()
                .name(roleSaveRequest.getName())
                .build();

    }

    public RoleResponse convert(Role role){
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role convert (RoleUpdateRequest roleUpdateRequest) {
        return Role.builder()
                .id(roleUpdateRequest.getId())
                .name(roleUpdateRequest.getName())
                .build();
    }
}
