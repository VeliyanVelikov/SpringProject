package SpringProject.dto.role;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleSaveRequest {

    @NotNull (message = "Role should not be null")
    private String name;
    private Long id;
}
