package hh.sof03.musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.musicdb.domain.User;
import hh.sof03.musicdb.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User("test user", "test password", "test@email.com", "USER");
        userRepository.save(user);

        assertThat(userRepository.findById(user.getId())).isNotNull();
    }

    @Test
    public void testFindUserByUsername() {
        User user = new User("test user", "test password", "test@email.com", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername(user.getUsername());
        assertThat(foundUser).isEqualTo(user);
    }

}
