package SpringProject.dto.user;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserSaveRequest {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
