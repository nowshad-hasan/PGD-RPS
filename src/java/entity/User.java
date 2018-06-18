/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nowshad Hasan
 */
public class User {

    private String userName,userEmail,roleName,userPass;
    private int roleID;

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getRoleID() {
        return roleID;
    }
    
    



}
