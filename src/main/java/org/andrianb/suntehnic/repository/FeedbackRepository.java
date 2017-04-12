package org.andrianb.suntehnic.repository;

import org.andrianb.suntehnic.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndrianB on 4/12/2017.
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
