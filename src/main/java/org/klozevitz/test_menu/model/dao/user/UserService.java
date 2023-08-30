package org.klozevitz.test_menu.model.dao.user;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.users.Role;
import org.klozevitz.test_menu.model.entities.users.User;
import org.klozevitz.test_menu.security.PBFDK2Encoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements IDaoUser {

    private final UserRepository userRepository;
    private final PBFDK2Encoder encoder;

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
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.COMPANY);
        return userRepository.save(user);
    }

    @Override
    public User saveEmployee(User user, String role) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (Role.stream().anyMatch(r -> r.toString().equalsIgnoreCase(role))) {
            user.setRole(Role.stream()
                    .filter(r -> r.toString().equalsIgnoreCase(role))
                    .findFirst()
                    .get());
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
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
    public Optional<User> findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findUserByUsername(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
