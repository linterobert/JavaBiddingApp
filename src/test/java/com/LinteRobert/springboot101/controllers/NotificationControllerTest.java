package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.PostNotification;
import com.LinteRobert.springboot101.dtos.ReturnNotification;
import com.LinteRobert.springboot101.entities.Notification;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.mappers.NotificationMapper;
import com.LinteRobert.springboot101.services.NotificationService;
import com.LinteRobert.springboot101.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @Mock
    private UserService userService;

    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    public void testCreateNotification() {
        when(userService.findById(anyInt())).thenReturn(new User());

        when(notificationMapper.postNotificationToNotification(any())).thenReturn(new Notification(/* define notification */));
        when(notificationMapper.notificationToReturnNotification(any())).thenReturn(new ReturnNotification(/* define returnNotification */));

        when(notificationService.create(any())).thenReturn(new Notification(/* define notification */));

        PostNotification postNotification = new PostNotification(/* define postNotification */);
        ResponseEntity<ReturnNotification> response = notificationController.createNotification(postNotification);

        verify(userService, times(1)).findById(anyInt());
        verify(notificationMapper, times(1)).postNotificationToNotification(any());
        verify(notificationService, times(1)).create(any());
    }

    @Test
    public void testDeleteNotification() {
        int notificationId = 123;

        notificationController.deleteNotification(notificationId);

        verify(notificationService, times(1)).delete(notificationId);
    }
}

