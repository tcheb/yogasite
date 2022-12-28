package com.croissantyoga.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.croissantyoga.app.entity.Group;
import com.croissantyoga.app.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired private IUserRepository repo;

    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("nam2020");

        Group admin = new Group();
        admin.setId(1L);
        User newUser = new User();
        newUser.setEmail("a@test.com");
        newUser.setFirstName("Testy");
        newUser.setLastName("McTest");
        newUser.setGroup(admin);
        newUser.setPassword(password);
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
