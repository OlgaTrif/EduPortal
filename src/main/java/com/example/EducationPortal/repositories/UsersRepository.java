package com.example.EducationPortal.repositories;

mport org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> { List<User> findAllByFirstName(String firstName);
    Optional<User> findById(Long id); Optional<User> findOneByLogin(String login); User findByLogin(String login);
}