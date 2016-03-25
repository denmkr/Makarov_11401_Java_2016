package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Place;

/**
 * Created by Denis on 26.02.16.
 */
public class PlaceTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Place place = (Place) appContext.getBean("placeWithName");
        Assert.assertEquals(place.getName(), "my place");
    }

    @Test
    public void constructorShouldNotHaveName() {
        Place place = (Place) appContext.getBean("place");
        Assert.assertEquals(place.getName(), null);
    }
}
