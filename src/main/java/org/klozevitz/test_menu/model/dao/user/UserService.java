package org.klozevitz.test_menu.model.dao.user;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.role.Role;
import org.klozevitz.test_menu.model.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IDaoDB<User>, IDaoUser {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if(userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User delete(Integer id) {
        User user = findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(user.getPassword());
        user.setRole(Role.MANAGER);
        userRepository.save(user);
    }

    @Override
    public User addRole(Integer userId, String role) {
        return null;
    }
}
