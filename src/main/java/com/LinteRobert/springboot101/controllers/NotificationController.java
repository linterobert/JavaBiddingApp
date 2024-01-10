package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.consts.Constants;
import com.LinteRobert.springboot101.dtos.GetProductsResponse;
import com.LinteRobert.springboot101.dtos.PostNotification;
import com.LinteRobert.springboot101.dtos.ReturnNotification;
import com.LinteRobert.springboot101.dtos.SortRequest;
import com.LinteRobert.springboot101.entities.Notification;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.mappers.NotificationMapper;
import com.LinteRobert.springboot101.services.NotificationService;
import com.LinteRobert.springboot101.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationMapper notificationMapper;

    @PostMapping
    public ResponseEntity<ReturnNotification> createNotification(@RequestBody PostNotification postNotification) {
        User user = userService.findById(postNotification.getUserId());
        Notification notification = notificationMapper.postNotificationToNotification(postNotification);
        notification.setUser(user);
        ReturnNotification toReturn = notificationMapper.notificationToReturnNotification(notificationService.create(notification));

        return ResponseEntity.created(URI.create("/notification/"+ toReturn.getId()))
                .body(toReturn);
    }

    @GetMapping("userId/{userId}/pageNumber/{pageNumber}")
    public List<ReturnNotification> getNotificationsByPage(@PathVariable("pageNumber") int pageNumber, @PathVariable("userId") int userId) {
        List<ReturnNotification> returnNotifications = new ArrayList<>();
        Sort sort = Sort.by("createdTime").descending();
        Pageable p = PageRequest.of(pageNumber, Constants.NOTIFICATION_PAGE_SIZE, sort);
        notificationService.findNotificationsByPage(p, userId).forEach(notification -> returnNotifications.add(notificationMapper.notificationToReturnNotification(notification)));
        return returnNotifications;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") int id) {
        notificationService.delete(id);
        return ResponseEntity.ok("Notification deleted successfully");
    }
}
