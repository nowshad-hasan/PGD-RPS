/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author nowshad
 */
public class UserInfo {

    private DBConnection dbConnection;
    private Connection connection;

    private String loginSql, registerSql, roleSQL, roleName, getRegistrationTeacher, nameOfUser, sql;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private boolean loginResult, registerResult, checkUserResult;

    public UserInfo() {

        dbConnection = new DBConnection();
        connection = dbConnection.getDbConnection();

    }

    public boolean authinticateUser(String email, String password) {

        loginSql = "select user_name,role_name from user_table,role_table where user_table.role_id=role_table.role_id and user_email=? and user_password=?";

        try {
            statement = connection.prepareStatement(loginSql);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {

                System.out.println(resultSet.getString("user_name"));

                System.out.println(resultSet.getString("role_name"));

                loginResult = true;

            } else {

                System.out.println("jakshdfkja");

                loginResult = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Value: " + loginResult);

        return loginResult;

    }

    public String roleOfUser(String email) {
        roleSQL = "select role_name from user_table,role_table where user_table.role_id=role_table.role_id and user_email=?";

        try {
            statement = connection.prepareStatement(roleSQL);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {

                System.out.println(resultSet.getString("role_name"));

                roleName = resultSet.getString("role_name");

            } else {

                System.out.println("jakshdfkja");

                //  roleName=resultSet.getString("role_name")
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return roleName;

    }

    public boolean deleteUserRegistrationRequest(String email) {
        sql = "delete from registration_request_table where user_email=?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            //resultSet = statement.executeQuery();

            int i = statement.executeUpdate();
            if (i != 0) {
                registerResult = true;
            } else {
                registerResult = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return registerResult;
    }

    public String confirmationCodeEmail(String email) {
        String from = "nowshadapu@gmail.com";
        String PASSWORD = "39614127710";
        String randomString;

        //39614127710
        String RECIPIENT = email;

        String[] to = {RECIPIENT};

        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        randomString = sb.toString();
        System.out.println(randomString);

        String subject = "Java send mail example";
        String body = "Your confirmation code is " + randomString + ". Please copy paste this code in the defined page. Thank you ";

        // String from="nowshadapu@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Sent message successfully....");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return randomString;
    }

    public void sendRejectionEmail(String email) {
        String from = "nowshadapu@gmail.com";
        String PASSWORD = "39614127710";

        //39614127710
        String RECIPIENT = email;

        String[] to = {RECIPIENT};

        String subject = "Java send mail example";
        String body = "Sorry.You can't be registered into this website. This is for specified people who are attached with "
                + "PGD Result Processing System.Thank you";

        // String from="nowshadapu@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Sent message successfully....");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendSuccessEmail(String email) {
        String from = "nowshadapu@gmail.com";
        String PASSWORD = "39614127710";

        //39614127710
        String RECIPIENT = email;

        String[] to = {RECIPIENT};

        String subject = "Java send mail example";
        String body = "You are successfully registered. Now you can successfully login with your account. Please visit "
                + "http://localhost:8080/PGD_RPS/login.jsp for login.Thank you";

        // String from="nowshadapu@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Sent message successfully....");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendEmail(String email) {

        String from = "nowshadapu@gmail.com";
        String PASSWORD = "39614127710";

        //39614127710
        String RECIPIENT = email;

        String[] to = {RECIPIENT};

        String subject = "Java send mail example";
        String body = "Welcome to JavaMail! Click Here http://localhost:8080/PGD_RPS/ValidateUserServlet";

        // String from="nowshadapu@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Sent message successfully....");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public boolean invalidateRegistrationEmail(String email) {
        sql = "update registration_request_table set user_accept_status='no' where user_email=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            int i = statement.executeUpdate();
            if (i != 0) {
                registerResult = true;
            } else {
                registerResult = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return registerResult;

    }

    public boolean checkUser(String email) {
        try {
            statement = connection.prepareStatement("select * from user_table where user_email=?");
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                checkUserResult = true;
            } else {
                checkUserResult = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkUserResult;

    }
    
    public boolean checkUserValidation(String email)
    {
        sql="select * from registration_request_table where user_email=? and user_accept_status='no'";
        
                try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                checkUserResult = true;
            } else {
                checkUserResult = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return checkUserResult;
        
    }
    
    public boolean registerUserTemporary(String name,String email,String password,int roleID)
    {
                try {
                    
                    sql="insert into registration_request_table(user_name,user_email,user_pass,role_id,user_accept_status) values(?,?,?,?,'yes')";

            statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, roleID);

            int i = statement.executeUpdate();
            if (i != 0) {
                registerResult = true;
            } else {
                registerResult = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return registerResult;
    }

    public boolean registerUser(String name, String email, String password, int role) {

        try {

            statement = connection.prepareStatement("insert into user_table(user_name,user_email,user_password,role_id) values(?,?,?,?)");

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, role);

            int i = statement.executeUpdate();
            if (i != 0) {
                registerResult = true;
            } else {
                registerResult = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return registerResult;

    }

    public List<User> getRegistrationRequest() {
        sql = "SELECT user_name,user_email,role_name,registration_request_table.role_id,user_pass FROM registration_request_table,"
                + "role_table WHERE registration_request_table.role_id=role_table.role_id and registration_request_table.user_accept_status='yes'";

        List<User> users = new ArrayList<User>();

        try {
            statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setRoleID(resultSet.getInt("role_id"));
                user.setRoleName(resultSet.getString("role_name"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPass(resultSet.getString("user_pass"));

                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;

    }

    public String getRegistrationTeacher(int session, int courseID) {
        String registrationTeacherName = "";
        getRegistrationTeacher = "select user_name from user_table,registration_table where \n"
                + "user_table.user_id=registration_table.user_id and \n"
                + "registration_table.session_id=? and registration_table.course_id=?";

        try {
            statement = connection.prepareStatement(getRegistrationTeacher);
            statement.setInt(1, session);
            statement.setInt(2, courseID);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                registrationTeacherName = resultSet.getString("user_name");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return registrationTeacherName;
    }

    public String nameOfUser(String email) {
        System.out.println("sdfgesr");

        nameOfUser = "select user_name from user_table where user_email=?";
        String userName = "";
        try {
            statement = connection.prepareStatement(nameOfUser);
            statement.setString(1, email);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userName = resultSet.getString("user_name");
            }

            System.out.println("Name Of User: " + userName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userName;
    }

}
