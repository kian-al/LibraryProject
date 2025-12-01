package ir.library.libraryproject.Service.User;

import ir.library.libraryproject.Model.User;
import ir.library.libraryproject.dto.request.UserRequest;
import ir.library.libraryproject.dto.request.UserSinginRequest;
import ir.library.libraryproject.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse save(UserRequest userRequest);

    void singin( UserSinginRequest userSinginRequest);

    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);
}
