package org.klozevitz.test_menu.model.dao.user;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.users.Role;
import org.klozevitz.test_menu.model.entities.users.User;
import org.klozevitz.test_menu.security.PBFDK2Encoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User saveEmployee(User user, String role){
        user.setPassword(encoder.encode(user.getPassword()));
        if(role.equalsIgnoreCase("Manager")) {
            user.setRole(Role.MANAGER);
        } else if(role.equalsIgnoreCase("Chef")) {
            user.setRole(Role.CHEF);
        } else if(role.equalsIgnoreCase("HEAD_BARTENDER")){
            user.setRole(Role.HEAD_BARTENDER);
        } else if(role.equalsIgnoreCase("Waiter")){
            user.setRole(Role.WAITER);
        } else if(role.equalsIgnoreCase("COOK")){
            user.setRole(Role.COOK);
        } else if(role.equalsIgnoreCase("BARTENDER")){
            user.setRole(Role.BARTENDER);
        }
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
    public Optional<User> findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findUserByUsername(String name){
        return userRepository.findUserByUsername(name);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(user.getPassword());
        user.setRole(Role.MANAGER);
        userRepository.save(user);
    }
}
