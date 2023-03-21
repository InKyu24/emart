package com.example.emart.controller;

import com.example.emart.config.JwtProvider;
import com.example.emart.dto.UserDTO;
import com.example.emart.entity.Users;
import com.example.emart.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(tags = {"사용자 API"})
public class UsersController {
  private final UserService userService;
  private final JwtProvider jwtProvider;

  @PostMapping("/add")
  @ApiOperation(value = "회원가입")
  public Users addUser(@Valid @RequestBody UserDTO userDTO) {
    return userService.addUser(userDTO);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Id를 통한 사용자 조회")
  public Users getUserInfoById(@PathVariable Long id) {
    return userService.getUserInfoById(id);
  }

  @GetMapping("")
  @ApiOperation(value = "Email을 통한 사용자 조회")
  public Users getUserInfoByEmail(@RequestParam String email) {
    return userService.getUserInfoByEmail(email);
  }

  @PatchMapping("/{id}")
  @ApiOperation(value = "Id를 통한 사용자 정보 변경")
  public Users changeUserInfo(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
    return userService.changeUserInfo(userDTO, id);
  }

  @PostMapping("/login")
  @ApiOperation(value = "로그인")
  public String login(@RequestBody UserDTO userDTO) {
    Users user = userService.login(userDTO.getEmail(), userDTO.getPassword());
    if (user == null) {
      return null;
    }
    String token = jwtProvider.createToken(String.valueOf(user.getId()), Collections.singletonList("ROLE_USER"));
    return token;
  }
}
