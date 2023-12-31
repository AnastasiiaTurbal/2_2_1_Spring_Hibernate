package hiber.dao;

import hiber.model.User;
import hiber.model.Car;

import java.util.List;

public interface UserDao {
   void add(User user);

   void add(Car car);

   public User getUserByCar(Car car);

   List<User> listUsers();

}
