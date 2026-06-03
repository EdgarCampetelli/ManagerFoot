package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.exception.ResourceAlreadyEsistsException;
import dev.estudo.managerFoot.Controller.request.UserRequest;
import dev.estudo.managerFoot.Controller.response.UserResponse;
import dev.estudo.managerFoot.Entity.Scope;
import dev.estudo.managerFoot.Entity.User;
import dev.estudo.managerFoot.Mapper.UserMapper;
import dev.estudo.managerFoot.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ScopeService scopeService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, ScopeService scopeService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.scopeService = scopeService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(UserRequest request){
        if (!userRepository.existsByEmail(request.getEmail())){

            List<Scope> scopes = request.getScopes().stream()
                    .map(scopeService::findById)
                    .toList();

            User user = userMapper.toUser(request);
            user.setScopeList(scopes);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);

            return userMapper.toUserResponder(user);
        }
        throw new ResourceAlreadyEsistsException("Email already in use !");
    }
}
