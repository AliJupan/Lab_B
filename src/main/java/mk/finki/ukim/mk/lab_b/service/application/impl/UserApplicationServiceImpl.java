package mk.finki.ukim.mk.lab_b.service.application.impl;

import mk.finki.ukim.mk.lab_b.dto.CreateUserDto;
import mk.finki.ukim.mk.lab_b.dto.DisplayUserDto;
import mk.finki.ukim.mk.lab_b.dto.LoginUserDto;
import mk.finki.ukim.mk.lab_b.model.domain.User;
import mk.finki.ukim.mk.lab_b.service.application.UserApplicationService;
import mk.finki.ukim.mk.lab_b.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.confirmPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));

    }

    @Override
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));

    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }
}
