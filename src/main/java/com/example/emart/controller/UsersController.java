package com.example.emart.controller;

import com.example.emart.dto.UserDTO;
import com.example.emart.entity.Users;
import com.example.emart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
  private final UserService userService;

  // 회원가입
  @PostMapping("/add")
  public Users addUser(@Valid @RequestBody UserDTO userDTO) {
    return userService.addUser(userDTO);
  }

  // 아이디 번호를 이용한 사용자 정보 조회
  @GetMapping("/{id}")
  public Users getUserInfoById(@PathVariable Long id) {
    return userService.getUserInfoById(id);
  }

  // 이메일을 이용한 사용자 정보 조회
  @GetMapping("")
  public Users getUserInfoByEmail(@RequestParam String email) {
    return userService.getUserInfoByEmail(email);
  }

  // 회원정보 변경
  @PutMapping("/{id}")
  public Users changeUserInfo(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
    return userService.changeUserInfo(userDTO, id);
  }
}
