package SpringProject.dto.user;

import SpringProject.dto.role.RoleResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    @JsonProperty(value = "role")
    private RoleResponse roleResponse;



}
