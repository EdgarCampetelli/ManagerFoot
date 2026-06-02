package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.request.LoginRequest;
import dev.estudo.managerFoot.Controller.response.LoginResponse;
import dev.estudo.managerFoot.Entity.Scope;
import dev.estudo.managerFoot.Entity.User;
import dev.estudo.managerFoot.Repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    public LoginResponse login(LoginRequest request){
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if (optionalUser.isEmpty() || !isPasswordCorrect(request.getPassword(), optionalUser.get().getPassword())){
            throw new BadCredentialsException("User or password invalid!");
        }
        User savedUser = optionalUser.get();
        List<String> scopes = savedUser.getScopeList().stream()
                .map(Scope::getName).toList();
        long expiresIn = 600L;

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("managerFoot")
                .subject(savedUser.getName())
                .issuedAt(Instant.now().plusSeconds(expiresIn))
                .claim("email",savedUser.getEmail())
                .claim("scope",scopes).build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();
        return LoginResponse.builder()
                .accessToken(token)
                .expiresIn(expiresIn)
                .build();
    }

    private boolean isPasswordCorrect(String password, String savedPassword){
        return passwordEncoder.matches(password,savedPassword);
    }
}
