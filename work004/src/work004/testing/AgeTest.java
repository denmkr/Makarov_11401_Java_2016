package work004.testing;

import org.junit.Assert;
import org.junit.Test;
import work004.Age;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 26.02.16.
 */
public class AgeTest {

    @Test
    public void addAgeShouldBeCorrect() {
        Age age = new Age(1, 2, 10);
        Age age2 = mock(Age.class);

        when(age2.getYear()).thenReturn(2);
        when(age2.getMonth()).thenReturn(5);
        when(age2.getDay()).thenReturn(3);

        age.addAge(age2);

        Assert.assertTrue(age.getDay() == 13 && age.getMonth() == 7 && age.getYear() == 3);
    }

    @Test
    public void constructorShouldSaveParamInAttribute() {
        Age age = new Age(3, 2, 4);
        Assert.assertTrue(age.getDay() == 4 && age.getMonth() == 2 && age.getYear() == 3);
    }

}
