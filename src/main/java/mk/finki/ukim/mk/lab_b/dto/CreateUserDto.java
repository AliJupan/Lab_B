package mk.finki.ukim.mk.lab_b.dto;

import mk.finki.ukim.mk.lab_b.model.domain.User;
import mk.finki.ukim.mk.lab_b.model.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String confirmPassword,
        String name,
        String surname,
        Role role) {

    public User toUser() {
        return new User(username,password,name,surname,role);
    }
}
