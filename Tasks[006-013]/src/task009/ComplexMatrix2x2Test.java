package task009;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.mock;

/**
 * Created by Denis on 23.02.16.
 */
public class ComplexMatrix2x2Test {

    public static ApplicationContext appContext;
    public static ComplexNumber number1, number2, number3, number4;
    public static ComplexMatrix2x2 matrix2x2;

    @BeforeClass
    public static void mocksInit() {
        appContext = new ClassPathXmlApplicationContext("task009/spring-config-task009.xml");

        number1 = (ComplexNumber) appContext.getBean("number1");
        number2 = (ComplexNumber) appContext.getBean("number2");
        number3 = (ComplexNumber) appContext.getBean("number3");
        number4 = (ComplexNumber) appContext.getBean("number4");
    }

    @Test
    public void complexMatrixShouldBeZero() {
        matrix2x2 = (ComplexMatrix2x2) appContext.getBean("matrix2x2");
        ComplexNumber zeroNumber = (ComplexNumber) appContext.getBean("zeroNumber");

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(zeroNumber) && matrix2x2.matrix[0][1].equals(zeroNumber) &&
                matrix2x2.matrix[1][0].equals(zeroNumber) && matrix2x2.matrix[1][1].equals(zeroNumber));

    }

    @Test
    public void everyElementShouldEqualsParam() {
        matrix2x2 = (ComplexMatrix2x2) appContext.getBean("matrixOneParam");

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(number1) && matrix2x2.matrix[0][1].equals(number1) &&
                matrix2x2.matrix[1][0].equals(number1) && matrix2x2.matrix[1][1].equals(number1));

    }

    @Test
    public void everyElementShouldGetSameElementFromParams() {
        matrix2x2 = (ComplexMatrix2x2) appContext.getBean("matrixFourParams");

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(number1) && matrix2x2.matrix[0][1].equals(number2) &&
                matrix2x2.matrix[1][0].equals(number3) && matrix2x2.matrix[1][1].equals(number4));

    }

    @Test
    public void SumOfMatrixsShouldBeCorrect() {
        ComplexMatrix2x2 matrix1 = (ComplexMatrix2x2) appContext.getBean("zeroMatrix");
        ComplexMatrix2x2 matrix2 = (ComplexMatrix2x2) appContext.getBean("matrixFourParams");

        ComplexMatrix2x2 sumMatrix = matrix1.add(matrix2);

        Assert.assertTrue(sumMatrix.matrix[0][0].equals(number1) && sumMatrix.matrix[0][1].equals(number2) &&
                sumMatrix.matrix[1][0].equals(number3) && sumMatrix.matrix[1][1].equals(number4));

    }

    @Test
    public void MultMatrixShouldBeCorrect() {
        ComplexMatrix2x2 matrix1 = (ComplexMatrix2x2) appContext.getBean("matrixWithFourthNumber");
        ComplexMatrix2x2 matrix2 = (ComplexMatrix2x2) appContext.getBean("matrixWithFirthNumber");

        ComplexMatrix2x2 multMatrix = matrix1.mult(matrix2);

        ComplexNumber multNumber = (ComplexNumber) appContext.getBean("multNumber");

        Assert.assertTrue(multMatrix.matrix[0][0].equals(multNumber) && multMatrix.matrix[0][1].equals(multNumber) &&
                multMatrix.matrix[1][0].equals(multNumber) && multMatrix.matrix[1][1].equals(multNumber));

    }

    @Test
    public void detOfMatrixShouldBeCorrect() {
        matrix2x2 = (ComplexMatrix2x2) appContext.getBean("matrixFourParams");

        ComplexNumber detNumber = (ComplexNumber) appContext.getBean("detNumber");

        Assert.assertTrue(matrix2x2.det().equals(detNumber));
    }

    @Test
    public void multVectorShouldBeCorrect() {

        matrix2x2 = (ComplexMatrix2x2) appContext.getBean("matrixFourParams");
        ComplexVector2D vector = (ComplexVector2D) appContext.getBean("complexVector");

        ComplexVector2D multVector = matrix2x2.multVector(vector);

        ComplexVector2D vector2D = (ComplexVector2D) appContext.getBean("multVector");
        Assert.assertTrue(multVector.getX().equals(vector2D.getX()) && multVector.getY().equals(vector2D.getY()));

    }

}
