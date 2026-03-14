package srp.example2.betterCode;

public class UserManager {
    public void add(User user){
        if(user.getAge() < 18){
            throw new IllegalArgumentException("User is not adult");
        }
        System.out.println("user added");
    }

    public void delete(User user){
        System.out.println("user deleted");
    }

    public void update(User user){
        if(user.getAge() < 18){
            throw new IllegalArgumentException("user is not adult");
        }
        System.out.println("user updated");
    }

    public void get(User user){
        System.out.println("user returned");
    }

    
}
