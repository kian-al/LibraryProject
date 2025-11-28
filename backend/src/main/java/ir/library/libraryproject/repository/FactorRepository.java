package ir.library.libraryproject.repository;

import ir.library.libraryproject.Model.Factor;
import ir.library.libraryproject.Model.Payed;
import ir.library.libraryproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor,Long> {

    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
