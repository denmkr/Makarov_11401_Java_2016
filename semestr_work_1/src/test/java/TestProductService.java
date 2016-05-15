import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.repository.GroupRepository;
import ru.kpfu.dm.repository.ProductRepository;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;
import ru.kpfu.dm.service.impl.GroupServiceImpl;
import ru.kpfu.dm.service.impl.ProductServiceImpl;
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
public class TestProductService {

    private static ProductServiceImpl productService;
    private static Product product1, product2;
    private static List<Product> products;

    @BeforeClass
    public static void init() {
        productService = new ProductServiceImpl();
        productService.productRepository = mock(ProductRepository.class);
        productService.groupService = mock(GroupServiceImpl.class);

        product1 = new Product();
        product2 = new Product();

        product1.setName("product1");

        product2.setName("product2");
        product1.setId(new Long(1));

        ProductGroup group = new ProductGroup();
        group.setName("Test");
        group.setGroupId("1001");

        product1.setProductGroup(group);
        product2.setProductGroup(group);

        products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);

        when(productService.productRepository.saveAndFlush(any(Product.class))).thenReturn(product1);
        when(productService.groupService.findByGroupId(anyString())).thenReturn(group);
        when(productService.productRepository.findAll()).thenReturn(products);
        when(productService.productRepository.findByArticule(anyString())).thenReturn(product1,product1, null);
        when(productService.productRepository.findOne(anyLong())).thenReturn(product1);
    }

    @Test
    public void findAllMethodShouldReturnCorrectProducts() {
        Assert.assertEquals(productService.findAll(), products);
    }

    @Test
    @Ignore
    public void findAllProductsMethodShouldReturnCorrectProducts() {
        Assert.assertEquals(productService.findAll("1", 2, "0", "", "name_ASC"), new PageImpl<Product>(products));
    }

    @Test
    public void findByArticuleMethodShouldReturnCorrectProduct() {
        Assert.assertEquals(productService.findByArticule("10011"), product1);
    }

    @Test
    public void findByIdMethodShouldReturnCorrectProduct() {
        Assert.assertEquals(productService.findById(new Long(1)), product1);
    }

    @Test
    public void addProductsMethodShouldWorkCorrect() {
        productService.addProducts(products);
        Assert.assertEquals(productService.findAll(), products);
    }

    @Test
    public void createMethodShouldReturnCorrectProduct() {
        Product product = new Product();
        product.setName("product1");
        product.setId(new Long(1));
        Assert.assertEquals(productService.create(product), product1);
    }

    @Test
    public void deleteMethodShouldWorkCorrect() {
        Assert.assertEquals(productService.delete(new Long(1)), true);
    }

    @Test
    public void updateProductsWithArticuleMoreThan0MethodShouldWorkCorrect() {
        Product product = new Product();
        product.setName("product1");
        product.setId(new Long(1));
        product.setArticule("32323");
        product.setPrice(new Float(1001.00));
        product.setStock(0);
        product.setCurrency("руб");
        ProductGroup group = new ProductGroup();
        group.setName("Test");
        group.setGroupId("1001");
        product.setProductGroup(group);

        List<Product> products1 = new ArrayList<Product>();
        products1.add(product);

        Assert.assertEquals(productService.updateProducts(products1), true);
    }

    @Test
    public void updateProductsWithArticuleEquals0MethodShouldWorkCorrect() {
        Product product = new Product();
        product.setName("product1");
        product.setId(new Long(1));
        product.setPrice(new Float(1001.00));
        product.setStock(0);
        product.setCurrency("руб");
        ProductGroup group = new ProductGroup();
        group.setName("Test");
        group.setGroupId("1001");
        product.setProductGroup(group);

        List<Product> products1 = new ArrayList<Product>();
        products1.add(product);

        Assert.assertEquals(productService.updateProducts(products1), true);
    }


    @Test
    public void updateMethodShouldWorkCorrect() {
        Product product = new Product();
        product.setName("product1");
        product.setId(new Long(1));
        Assert.assertEquals(productService.update(product), product1);
    }


}

