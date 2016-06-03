package com.mx.develop.dao;
import com.mx.develop.pojo.User;
import java.io.*;
import java.util.*;

/**
 *
 * @author said.olano@oracle.com
 */
public class UserDao {

    public List<User> getAllUsers() {
        List<User> userList = null;
        try {
            File file = new File("UserFile.data");
            if (!file.exists()) {
                User user = new User(1, "Said", "Software Engineering");
                userList = new ArrayList<User>();
                userList.add(user);
                saveUserList(userList);
            } else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<User>) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            System.err.println("IOExceptionFound: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundExceptionFound: " + e.getMessage());
        }
        return userList;
    }

    private void saveUserList(List<User> userList) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("UserFile.data")));
        oos.writeObject(userList);
        oos.close();
    }
}
