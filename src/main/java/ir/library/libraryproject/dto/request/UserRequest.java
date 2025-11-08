package ir.library.libraryproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    @NotNull
    @NotBlank
    private final String username;
    @NotNull
    @NotBlank
    private final String password;
}
