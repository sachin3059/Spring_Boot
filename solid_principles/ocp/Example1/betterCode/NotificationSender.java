package ocp.Example1.betterCode;
import java.util.List;


public class NotificationSender {
     public void sendNotification(List<String> notificationTypes, String message){
        for(String notificationType : notificationTypes){
            switch(notificationType){
                case "SMS":
                    SMSNotification notification = new SMSNotification();
                    notification.sendSMSNotification(message);
                    break;
                case "EMAIL":
                    EmailNotification emailNotification = new EmailNotification();
                    emailNotification.sendEmailNotification(message);
                    break;
                case "PUSH":
                    PushNotification pushNotification = new PushNotification();
                    pushNotification.sendPushNotification(message);
                    break;
            }
        }
    }
}
