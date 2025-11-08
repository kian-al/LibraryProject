package ir.library.libraryproject.Service.User;

import ir.library.libraryproject.Model.User;
import ir.library.libraryproject.dto.request.UserRequest;
import ir.library.libraryproject.dto.response.UserResponse;

public interface UserService {

    UserResponse save(UserRequest userRequest);
}
