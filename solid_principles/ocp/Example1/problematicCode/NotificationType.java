package ocp.Example1.problematicCode;

public enum NotificationType {
    SMS,
    EMAIL,
    PUSH,
    WHATSAPP;

    public void sendSMSNotification(String message){
        System.out.println("SMS: " + message);
    }

    public void sendEmailNotification(String message){
        System.out.println("EMAIL: " + message);
    }

    public void sendPushNotification(String message){
        System.out.println("PUSH: " + message);
    }
    
    public void sendWhatsAppNotification(String message){
        System.out.println("WHATSAPP: " + message);
    }

    


}
