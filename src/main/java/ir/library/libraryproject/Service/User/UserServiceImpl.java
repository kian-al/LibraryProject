package ir.library.libraryproject.Service.User;

import ir.library.libraryproject.Model.User;
import ir.library.libraryproject.dto.request.UserRequest;
import ir.library.libraryproject.dto.response.UserResponse;
import ir.library.libraryproject.execption.RuleException;
import ir.library.libraryproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername =
                userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent()){
            throw new RuleException("username.is.exist");
        }

        return createUserResponse(userRepository.save(createUser(userRequest)));
    }
    private UserResponse createUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
    private User createUser(UserRequest userRequest){
        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
