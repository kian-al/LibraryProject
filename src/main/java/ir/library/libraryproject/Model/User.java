package ir.library.libraryproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor //for @Builder needed
@NoArgsConstructor //for hibernate needed
public class User extends BaseEntity{

    private String username;

    private String password;


}
