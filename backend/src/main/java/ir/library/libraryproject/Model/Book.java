package ir.library.libraryproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.processing.SQL;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted is null")
@SQLDelete(sql = "update shop.book set deleted = now() where id=?")
public class Book extends BaseEntity {

    @NotNull(message = "{book.name.is.null}")
    private String name;

    @NotNull(message = "{book.price.is.null}")
    private long price;
}
