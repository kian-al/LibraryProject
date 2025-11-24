package ir.library.libraryproject.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "{book.name.is.blank}")
    @NotNull(message = "{book.name.is.null}")
    private final String name;

    @NotNull(message = "{book.price.is.null}")
    @Min(value = 0,message = "{book.price.is.min}")
    private final Long price;

}
