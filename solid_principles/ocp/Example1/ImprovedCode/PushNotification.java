package ocp.Example1.ImprovedCode;

public class PushNotification implements Notification {
    
    public void sendMessage(String message){
        System.out.println("PUSH: " + message);
    }
}
