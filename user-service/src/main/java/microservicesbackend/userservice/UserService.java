package microservicesbackend.userservice;

import javassist.NotFoundException;

import microservicesbackend.userservice.feignProxy.AccountInterface;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountInterface accountInterface;

    public User findUserById(Long idUser) throws NotFoundException {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isEmpty()) throw new NotFoundException("There is no user with this id");
        return user.get();
    }

    public User findUser(String email) throws NotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) throw new NotFoundException("There is no user with this email");
        return user.get();
    }


    public User register(User user) throws IllegalStateException {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException();
        User savedUser = userRepository.save(user);
        accountInterface.createInvisibleAccount(savedUser.getId());
        return savedUser;
    }

    public User changeUser(User user, String currentPassword) throws NotFoundException, IllegalStateException {
        Optional<User> currentUser = userRepository.findById(user.getId());

        if (currentUser.isEmpty()) throw new NotFoundException("There is no user with this ID");
        if (currentUser.get().getPassword().equals(currentPassword))
            return userRepository.save(user);
        else
            throw new IllegalStateException("Current password is wrong");

    }


    public void deleteUser(Long idUser, String currentPassword) throws NotFoundException,IllegalStateException
    {
        Optional<User> currentUser = userRepository.findById(idUser);
        if (currentUser.isEmpty()) throw new NotFoundException("There is no user with this id");
        if (currentUser.get().getPassword().equals(currentPassword))
            userRepository.deleteById(idUser);
        else
            throw new IllegalStateException("Current password is wrong");
    }

}
