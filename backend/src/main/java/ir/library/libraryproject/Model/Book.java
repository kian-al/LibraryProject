package ir.library.libraryproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity{

    @NotNull(message = "{book.name.is.null}")
    private String name;

    @NotNull(message = "{book.price.is.null}")
    private long price;
}
