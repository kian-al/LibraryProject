package ir.library.libraryproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class ShopingCard extends BaseEntity{

    private Long count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;

}
