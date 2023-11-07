package hh.sof03.musicdb.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username); // With this you can make SQL queries using username, Spring Security uses this for authentication
}
