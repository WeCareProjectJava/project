package Client;


public class User {
    public String name;
    public String fullName;
    public String password;
    public String email;
    public String gender;
    public String phoneNo;
    public String status;
    public User(String fullname, String password){
       this.fullName=fullname;
       this.password=password;
    }

    public User(String name, String fullName, String password, String email, String gender, String phoneNo, String status) {
        this.name = name;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.status=status;
    }
    
    public User(){
        
 
    }
}
