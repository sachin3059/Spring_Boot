package ocp.Example1.ImprovedCode;

public class EmailNotification implements Notification {
    @Override
    public void sendMessage(String message){
        System.out.println("EMAIL: " + message);
    }
    
}
