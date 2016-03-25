package task010.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task010.Age;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AgeTest {

    ApplicationContext appContext;

    @Before
    public void springInit() {
        appContext = new ClassPathXmlApplicationContext("task010/spring-config-task010.xml");
    }

    @Test
    public void addAgeShouldBeCorrect() {
        Age age = (Age) appContext.getBean("age1");
        Age age2 = (Age) appContext.getBean("age2");

        age.addAge(age2);

        Assert.assertTrue(age.getDay() == 13 && age.getMonth() == 7 && age.getYear() == 3);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Age age = (Age) appContext.getBean("age1");
        Assert.assertTrue(age.getDay() == 10 && age.getMonth() == 2 && age.getYear() == 1);
    }

}
