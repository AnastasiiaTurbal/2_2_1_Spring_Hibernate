package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      Car car1 = new Car("car1", 1);
      Car car2 = new Car("car2", 2);
      Car car3 = new Car("car3", 3);

      userService.add(new User("User4", "Lastname4", "user1@mail.ru", car1));
      userService.add(new User("User5", "Lastname5", "user2@mail.ru", car2));
      userService.add(new User("User6", "Lastname6", "user3@mail.ru", car3));

      List<User> usersWithCars = userService.listUsers();
      for (User user : usersWithCars) {
         System.out.println(user);
         System.out.println();
      }

      System.out.println(userService.getUserByCar(car1));

      context.close();
   }
}