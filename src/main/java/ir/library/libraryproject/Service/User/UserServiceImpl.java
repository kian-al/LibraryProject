package ir.library.libraryproject.Service.User;

import ir.library.libraryproject.Model.User;
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
    public UserResponse save(User user) {
        Optional<User> byUsername =
                userRepository.findByUsername(user.getUsername());
        if (byUsername.isPresent()){
            throw new RuleException("username.is.exist");
        }
        User saveUser= userRepository.save(user);
        return UserResponse.builder()
                .id(saveUser.getId())
                .username(saveUser.getUsername())
                .build();
    }
}
