package ocp.Example1.ImprovedCode;

public class SMSNotification implements Notification {
    @Override
    public void sendMessage(String message){
        System.out.println("SMS: " + message);
    }
}
