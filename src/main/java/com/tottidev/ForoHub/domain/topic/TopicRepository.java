package com.tottidev.ForoHub.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleIgnoreCase(String title);

    boolean existsByMessageIgnoreCase(String message);
}
