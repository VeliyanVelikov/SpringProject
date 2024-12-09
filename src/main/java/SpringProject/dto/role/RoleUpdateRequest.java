package SpringProject.dto.role;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class RoleUpdateRequest {

    @NotNull(message = "id should not be null.")
    private Long id;
    @NotNull(message = "name should not be null.")
    private String name;
}
