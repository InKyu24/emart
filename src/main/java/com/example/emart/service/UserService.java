package com.example.emart.service;

import com.example.emart.dto.UserDTO;
import com.example.emart.entity.Users;
import com.example.emart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
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

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Long id = Long.parseLong(username);
    return userRepository.getUserInfoById(id).orElseThrow();
  }

  public Users login(String email, String password) {
    Users user = getUserInfoByEmail(email);
      if (user != null && user.getPassword().equals(password)) {
        return user;
      }
    return null;
  }
}
