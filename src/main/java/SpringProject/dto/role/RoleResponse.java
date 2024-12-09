package SpringProject.dto.role;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleResponse {
    private String name;
    private Long id;


}
