import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.repository.GroupRepository;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;
import ru.kpfu.dm.service.impl.GroupServiceImpl;
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
public class TestGroupService {

    private static GroupServiceImpl groupService;
    private static ProductGroup group1, group2;
    private static List<ProductGroup> groups;

    @BeforeClass
    public static void init() {
        groupService = new GroupServiceImpl();
        groupService.groupRepository = mock(GroupRepository.class);

        group1 = new ProductGroup();
        group2 = new ProductGroup();

        group1.setName("group1");
        group2.setName("group2");
        group1.setGroupId("10011");
        group1.setId(new Long(1));

        groups = new ArrayList<ProductGroup>();
        groups.add(group1);
        groups.add(group2);

        when(groupService.groupRepository.saveAndFlush(any(ProductGroup.class))).thenReturn(group1);
        when(groupService.groupRepository.findAll()).thenReturn(groups);
        when(groupService.groupRepository.findByGroupId(anyString())).thenReturn(group1);
        when(groupService.groupRepository.findOne(anyLong())).thenReturn(group1);
    }

    @Test
    public void findAllMethodShouldReturnCorrectGroups() {
        Assert.assertEquals(groupService.findAll(), groups);
    }

    @Test
    public void findByGroupIdMethodShouldReturnCorrectGroup() {
        Assert.assertEquals(groupService.findByGroupId("10011"), group1);
    }

    @Test
    public void findByIdMethodShouldReturnCorrectGroup() {
        Assert.assertEquals(groupService.findById(new Long(1)), group1);
    }

    @Test
    public void addGroupsMethodShouldWorkCorrect() {
        groupService.addGroups(groups);
        Assert.assertEquals(groupService.findAll(), groups);
    }

    @Test
    public void addParentsGroupsToGroupsMethodShouldWorkCorrect() {
        List<GroupRelation> relations = new ArrayList<GroupRelation>();
        GroupRelation relation = new GroupRelation();
        relations.add(relation);
        Assert.assertEquals(groupService.addParentsGroupsToGroups(relations), true);
    }

    @Test
    public void createMethodShouldReturnCorrectGroup() {
        ProductGroup group = new ProductGroup();
        group.setName("group1");
        group.setGroupId("10011");
        group.setId(new Long(1));
        Assert.assertEquals(groupService.create(group), group1);
    }

    @Test
    public void deleteMethodShouldWorkCorrect() {
        Assert.assertEquals(groupService.delete(new Long(1)), true);
    }

    @Test
    public void updateGroupsMethodShouldWorkCorrect() {
        List<ProductGroup> groups = new ArrayList<ProductGroup>();
        ProductGroup group = new ProductGroup();
        group.setName("Test");
        groups.add(group);
        Assert.assertEquals(groupService.updateGroups(groups), true);
    }

    @Test
    public void updateMethodShouldWorkCorrect() {
        ProductGroup group = new ProductGroup();
        group.setName("group1");
        group.setGroupId("10011");
        group.setId(new Long(1));
        Assert.assertEquals(groupService.update(group), group1);
    }


}
