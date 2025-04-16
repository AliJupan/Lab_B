package mk.finki.ukim.mk.lab_b.service.domain;

import mk.finki.ukim.mk.lab_b.model.domain.User;
import mk.finki.ukim.mk.lab_b.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}

