package src.repositories;

import src.models.Notification;
import src.utils.JsonHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for Notification data operations
 * Handles system alerts and messages
 */
public class NotificationRepository extends BaseRepository<Notification> {
    
    public NotificationRepository() {
        super("notifications.json");
    }
    
    @Override
    protected Class<Notification> getType() {
        return Notification.class;
    }
    
    /**
     * Get all unread notifications
     */
    public List<Notification> getUnreadNotifications() {
        List<Notification> unread = new ArrayList<>();
        for (Notification n : items) {
            if (!n.isRead()) {
                unread.add(n);
            }
        }
        return unread;
    }
    
    /**
     * Get all read notifications
     */
    public List<Notification> getReadNotifications() {
        List<Notification> read = new ArrayList<>();
        for (Notification n : items) {
            if (n.isRead()) {
                read.add(n);
            }
        }
        return read;
    }
    
    /**
     * Mark a specific notification as read
     */
    public void markAsRead(int notificationId) {
        for (Notification n : items) {
            if (n.getNotificationId() == notificationId) {
                n.markAsRead();
                save();
                break;
            }
        }
    }
    
    /**
     * Mark all notifications as read
     */
    public void markAllAsRead() {
        for (Notification n : items) {
            n.markAsRead();
        }
        save();
    }
    
    /**
     * Add a budget warning notification
     * @param category The budget category that exceeded limit
     * @param limit The budget limit amount
     * @param spent The amount spent
     */
    public void addBudgetWarning(String category, double limit, double spent) {
        String message = "⚠️ Budget Warning: You have spent " + spent + " out of " + limit + " on " + category;
        int newId = getNextId();
        Notification notification = new Notification(newId, message);
        add(notification);
    }
    
    /**
     * Add a general notification
     * @param message The notification message
     */
    public void addNotification(String message) {
        int newId = getNextId();
        Notification notification = new Notification(newId, message);
        add(notification);
    }
    
    /**
     * Generate next ID for new notification
     */
    private int getNextId() {
        int maxId = 0;
        for (Notification n : items) {
            if (n.getNotificationId() > maxId) {
                maxId = n.getNotificationId();
            }
        }
        return maxId + 1;
    }
    
    /**
     * Delete a notification by ID
     */
    public void deleteNotification(int notificationId) {
        Notification toRemove = null;
        for (Notification n : items) {
            if (n.getNotificationId() == notificationId) {
                toRemove = n;
                break;
            }
        }
        if (toRemove != null) {
            remove(toRemove);
        }
    }
    
    /**
     * Delete all notifications
     */
    public void deleteAllNotifications() {
        clear();
    }
}
