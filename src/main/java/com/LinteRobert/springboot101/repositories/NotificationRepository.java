package com.LinteRobert.springboot101.repositories;

import com.LinteRobert.springboot101.entities.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>, PagingAndSortingRepository<Notification, Integer> {
    List<Notification> findAllByUserId(Pageable p, int userId);
}
