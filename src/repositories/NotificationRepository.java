package src.repositories;

import src.models.Notification;

/**
 * Repository for Notification data operations
 */
public class NotificationRepository extends BaseRepository<Notification> {

    public NotificationRepository() {
        super("notifications.json");
    }

    @Override
    protected Class<Notification> getType() {
        return Notification.class;
    }
}
