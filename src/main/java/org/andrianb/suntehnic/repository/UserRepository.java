package org.andrianb.suntehnic.repository;

import org.andrianb.suntehnic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 3/28/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneByEmail(String email);
    public User findOneByUsername(String username);
}
