import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;
import ru.kpfu.dm.service.impl.UserRoleServiceImpl;
import ru.kpfu.dm.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 14.05.16.
 */
public class TestUserService {

    private static UserServiceImpl userService;
    private static List<User> users;
    private static User user1, user2;

    @BeforeClass
    public static void init() {
        users = new ArrayList<User>();
        userService = new UserServiceImpl();
        userService.userRepository = mock(UserRepository.class);

        user1 = new User();
        user1.setId(new Long(1));
        user1.setUsername("Denis");
        user1.setPassword("1111");
        user1.setEmail("test@gmail.com");
        users.add(user1);

        user2 = new User();
        user1.setId(new Long(2));
        user2.setUsername("Maxim");
        user1.setPassword("2222");
        user2.setEmail("test@mail.ru");
        users.add(user2);

        when(userService.userRepository.findAll()).thenReturn(users);
        when(userService.userRepository.findByUsername(anyString())).thenReturn(user1);
        when(userService.userRepository.findByEmail(anyString())).thenReturn(user1);
        when(userService.userRepository.saveAndFlush(any(User.class))).thenReturn(user1);
        when(userService.userRepository.findOne(anyLong())).thenReturn(user1);
    }

    @Test
    public void findAllMethodShouldReturnCorrectListOfUser() {
        List<User> users1 = userService.findAll();
        Assert.assertEquals(users1, users);
    }

    @Test
    public void findByUsernameMethodShouldReturnCorrectUser() {
        User user = userService.findByUsername("Denis");
        Assert.assertEquals(user, user1);
    }

    @Test
    public void findByEmailMethodShouldReturnCorrectUser() {
        User user = userService.findByEmail("test@gmail.com");
        Assert.assertEquals(user, user1);
    }

    @Test
    public void findByIdMethodShouldReturnCorrectUser() {
        User user = userService.findById(1);
        Assert.assertEquals(user, user1);
    }

    @Test
    public void createMethodShouldSaveCorrectUser() {
        User user = new User();
        user.setId(new Long(1));
        user.setUsername("Denis");
        user.setPassword("1111");
        user.setEmail("test@gmail.com");

        Assert.assertEquals(userService.create(user), user1);
    }

    @Test
    public void deleteMethodShouldDeleteUserCorrect() {
        Assert.assertEquals(userService.delete(1), user1);
    }



}
