package javaBank.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javaBank.entity.User;

public class UserRepositoy {
        // Using Collections to create data
        // Choose SET because it doesn't allow to duplicate values in the same Collection
        // HashSet X LinkedHashSet = hashSet doesn't takes care of the insertion order. LinkedhashSet maintain the insertion order.
        // Declaring this SET as static because it is the only SET used for the entire application and only one copy of this SET will be created on the entire program.

        private static Set<User> users = new HashSet<>();

        // STATIC BLOCK = Used for static initialization of a class. This code is executed only once on the first time the class is loaded.
        static{
                User user1 = new User("admin","admin111","123456789","admin",0.0);
                User user2 = new User("user2","user222","789456123","user", 1000.0);
                User user3 = new User("user3","user333","147258369","user", 2000.0);
                User user4 = new User("user4","user444","741852963","user", 2000.0);

                users.add(user1);
                users.add(user2);
                users.add(user3);
                users.add(user4);
        }

        public void printUsers(){
                System.out.println(users);
        }

        // Colecting username and password and turning it into a LIST if is matchas any created properties
        public User login(String username, String password){
                List<User>finalList = users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .collect(Collectors.toList());

                // Checking if the variable finalList is not empty to return it.
                if(!finalList.isEmpty()){
                        return finalList.get(0);
                } else{
                        return null;
                }
        }
}
