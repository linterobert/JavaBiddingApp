package com.LinteRobert.springboot101.mappers;

import com.LinteRobert.springboot101.dtos.PostNotification;
import com.LinteRobert.springboot101.dtos.ReturnNotification;
import com.LinteRobert.springboot101.entities.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public Notification postNotificationToNotification(PostNotification postNotification) {
        return new Notification(postNotification.getText());
    }
    public ReturnNotification notificationToReturnNotification(Notification notification) {
        return new ReturnNotification(notification.getId(), notification.getText(), notification.getCreatedTime(), notification.getUser().getEmail());
    }
}
