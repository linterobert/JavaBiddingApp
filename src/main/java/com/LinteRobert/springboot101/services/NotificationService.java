package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.Notification;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification create(Notification notification) {
        notification.setCreatedTime(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> findNotificationsByPage(Pageable p, int userId) {
        return notificationRepository.findAllByUserId(p, userId);
    }

    public void delete(int id) {
        notificationRepository.deleteById(id);
    }
}
