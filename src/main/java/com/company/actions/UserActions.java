package com.company.actions;

import com.company.model.SearchedUser;
import com.company.model.User;

import java.io.*;
import java.util.Scanner;

public class UserActions {

    public void addUserFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("ListOfUsers.txt"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] userInfo = line.split("\\|");
                User user = new User();
                setPropertiesUser(user, userInfo);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User findUser(SearchedUser searchedUser) {
        try (FileReader fileReader = new FileReader("ListOfUsers.txt")) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String search = scanner.next();
                String[] dataUser = search.split("\\|");
                if (dataUser[0].equals(searchedUser.getFirstName()) && dataUser[1].equals(searchedUser.getLastName())) {
                    User user = new User();
                    setPropertiesUser(user,dataUser);
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void add(User user) {
        try (FileWriter writer = new FileWriter("ListOfUsers.txt", true)){
            writer.write(user.toString()+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setPropertiesUser(User user, String[] arr) {
        user.setLastName(arr[0]);
        user.setFirstName(arr[1]);
        user.setMiddleName(arr[2]);
        user.setAge(Integer.parseInt(arr[3]));
        user.setSalary(Double.parseDouble(arr[4]));
        user.setEmail(arr[5]);
        user.setCompanyName(arr[6]);
    }

}
