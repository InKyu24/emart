package com.example.emart.service;

import com.example.emart.dto.UserDTO;
import com.example.emart.entity.Users;
import com.example.emart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  @Transactional
  public Users addUser(UserDTO userDTO) {
    Users user = new Users();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    userRepository.save(user);
    return user;
  }

  public Users getUserInfoById(Long id) {
    return userRepository.getUserInfoById(id).orElse(null);
  }

  public Users getUserInfoByEmail(String email) {
    return userRepository.getUserInfoByEmail(email).orElse(null);
  }

  @Transactional
  public Users changeUserInfo(UserDTO userDTO, Long id) {
    Users user = userRepository.getUserInfoById(id).orElse(null);
    if(user != null) {
      user.setName(userDTO.getName());
      user.setEmail(userDTO.getEmail());
      user.setPassword(userDTO.getPassword());
      userRepository.save(user);
    }
    return user;
  }
}
