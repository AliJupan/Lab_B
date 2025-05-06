package mk.finki.ukim.mk.lab_b.service.application;

import mk.finki.ukim.mk.lab_b.dto.create.CreateUserDto;
import mk.finki.ukim.mk.lab_b.dto.display.DisplayUserDto;
import mk.finki.ukim.mk.lab_b.dto.login.LoginResponseDto;
import mk.finki.ukim.mk.lab_b.dto.login.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
