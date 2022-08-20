package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final IRoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, IRoleService roleService){
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public User addUser(User user) {
        if (isNull(user)) {
            throw new EntityNotFoundException("User is empty");
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User userUpdate(User user) {
        if (isNull(user)) {
            throw new EntityNotFoundException("Requested update is empty");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.getUser(userId);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty())
            throw new EntityNotFoundException("No users found in DB");
        return allUsers;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = userRepository.findUserByLogin(login);
        if (isNull(user)) {
            throw new EntityNotFoundException("No matches found in DB");
        }
        return user;
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        List<User> users = userRepository.findUserByFirstName(firstName);
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users by that first name found in DB");
        }
        return users;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        List<User> users = userRepository.findUserByLastName(lastName);
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users by that last name found in DB");
        }
        return users;
    }

    @Override
    public User setUserAsExpert(Long userId){
        User user = this.getUser(userId);
        user.setRole(roleService.getRoleByName("Expert"));
        return user;
    }

    @Override
    public List<User> getUsersByRole(Role role){
        return userRepository.findAllByRole(role);
    }


}
