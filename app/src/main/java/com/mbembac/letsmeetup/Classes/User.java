package com.mbembac.letsmeetup.Classes;

/**
 * Created by Jon Ruben on 10/16/2014.
 */
public class User {

    private String firstName;
    private String lastName;
    private String fullName;
    private String imageFileName;
    private String password;
    private String email;
    private int userId;
    private boolean loginStatus;

    //GPSCOORD


    //check that password is correct before calling this function!!!
    public User(String firstNameInput, String lastNameInput, String imageFileNameInput, String passwordInput, String emailInput){
        firstName = firstNameInput;
        lastName = lastNameInput;
        fullName = firstNameInput + " " + lastNameInput;
        imageFileName = imageFileNameInput;
        password = passwordInput;
        email = emailInput;
    }

    public boolean getLoginStatus(){
        return loginStatus;
    }
    private boolean checkPassword(String passwordInput){
        if(passwordInput.equals(password)){
            return true;
        }
        return false;
    }

    public boolean login(String passwordInput){
        if(checkPassword(passwordInput)){
            loginStatus = true;
            return true;
        }
        return false;
    }
    public void logout(){
        loginStatus = false;
    }

    private void setEmail(String emailInput){
        email = emailInput;
    }

    public String getEmail(){
        return email;
    }

    private void setFirstName(String firstNameInput){
        firstName = firstNameInput;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    private void setLastName(String lastNameInput){
        lastName = lastNameInput;
    }

    //returns false if the two passwords inputted aren't identical
    private boolean setPassword(String passwordInput1, String passwordInput2){
        if(passwordInput1.equals(passwordInput2)){
            password = passwordInput1;
            return true;
        }
        return false;
    }

    private void setImageFileName(String imageFileNameInput){
        imageFileName = imageFileNameInput;
    }

    public String getImageFileName(){
        return imageFileName;
    }
}
