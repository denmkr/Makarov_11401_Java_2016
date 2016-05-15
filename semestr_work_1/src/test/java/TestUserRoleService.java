import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.entity.UserRole;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
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
public class TestUserRoleService {

    private static UserRoleServiceImpl userRoleService;
    private static UserRole role1;
    private static UserRole role2;

    @BeforeClass
    public static void init() {
        userRoleService = new UserRoleServiceImpl();
        userRoleService.userRoleRepository = mock(UserRoleRepository.class);

        role1 = new UserRole();
        role1.setUserId(new Long(1));
        role1.setAuthority("ROLE_USER");

        role2 = new UserRole();
        role2.setUserId(new Long(1));
        role2.setAuthority("ROLE_ADMIN");

        when(userRoleService.userRoleRepository.saveAndFlush(any(UserRole.class))).thenReturn(role1, role2);
    }

    @Test
    public void createUserMethodShouldSetCorrectUserRole() {
        User user = new User();
        user.setId(new Long(1));

        Assert.assertEquals(userRoleService.createUser(user), role1);
    }

    @Test
    public void createAdminMethodShouldSetCorrectUserRole() {
        User user = new User();
        user.setId(new Long(1));

        Assert.assertEquals(userRoleService.createAdmin(user), role2);
    }



}
