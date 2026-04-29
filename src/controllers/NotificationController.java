public class NotificationController {

    private NotificationService service = new NotificationService();

    public void send(String msg) {
        service.send(msg);
    }
}
