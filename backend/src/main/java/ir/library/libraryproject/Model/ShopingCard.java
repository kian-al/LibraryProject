package ir.library.libraryproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopingCard extends BaseEntity{

    private Long count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;

}
