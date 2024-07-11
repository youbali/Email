package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 8;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "Company.com";

    //Constructor to receive firstName and lastName
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("created email: "+this.firstName+" "+this.lastName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("The department is "+this.department);

        //Cal a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("The password is "+this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        System.out.println("Your email is "+email);
        System.out.println("Your password is "+this.password);


    } 

    //Ask for the department
    public String setDepartment(){
        System.out.println("Enter the department\n1 for Sale\n2 for IT\n3 for management\n4 for none\nEnter your code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return"sale";
        }else if(depChoice == 2){
            return "IT";
        }else if(depChoice == 3){
            return "Management";
        }else{return "none";}
    }

    //Generate a random password
    private String randomPassword(int length){
        String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!$%&/abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int)(Math.random()*setPassword.length());
            password[i] = setPassword.charAt(rand);
        }
        return new String(password);
    }

    //Set a mailboxCapacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set an alternateEmail
    public void setAlternateEmail(String alteEmail){
        this.alternateEmail = alteEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Display Name: "+firstName+" "+lastName+
        ", Company Email: "+email+
        ", Mailbox Capacity: "+mailboxCapacity+"Mb";
    }


}
