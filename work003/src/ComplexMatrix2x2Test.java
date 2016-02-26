import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 23.02.16.
 */
public class ComplexMatrix2x2Test {

    public static ComplexNumber number1, number2, number3, number4;
    public static ComplexMatrix2x2 matrix2x2;

    @BeforeClass
    public static void mocksInit() {
        number1 = mock(ComplexNumber.class);
        when(number1.add(anyObject())).thenCallRealMethod();
        when(number1.mult(anyObject())).thenCallRealMethod();

        number2 = mock(ComplexNumber.class);
        when(number2.add(anyObject())).thenCallRealMethod();
        when(number2.mult(anyObject())).thenCallRealMethod();

        number3 = mock(ComplexNumber.class);
        when(number3.add(anyObject())).thenCallRealMethod();
        when(number3.mult(anyObject())).thenCallRealMethod();

        number4 = mock(ComplexNumber.class);
        when(number4.add(anyObject())).thenCallRealMethod();
        when(number4.mult(anyObject())).thenCallRealMethod();
    }

    @Test
    public void complexMatrixShouldBeZero() {
        matrix2x2 = new ComplexMatrix2x2();

        when(number1.getA()).thenReturn(0.0);
        when(number1.getB()).thenReturn(0.0);

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(number1) && matrix2x2.matrix[0][1].equals(number1) &&
                matrix2x2.matrix[1][0].equals(number1) && matrix2x2.matrix[1][1].equals(number1));

    }

    @Test
    public void everyElementShouldEqualsParam() {
        matrix2x2 = new ComplexMatrix2x2(number1);

        when(number1.getA()).thenReturn(1.0);
        when(number1.getB()).thenReturn(2.0);

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(number1) && matrix2x2.matrix[0][1].equals(number1) &&
                matrix2x2.matrix[1][0].equals(number1) && matrix2x2.matrix[1][1].equals(number1));

    }

    @Test
    public void everyElementShouldGetSameElementFromParams() {
        matrix2x2 = new ComplexMatrix2x2(number1, number1, number1, number1);

        when(number1.getA()).thenReturn(1.0, 2.0, 2.0, 1.0);
        when(number1.getB()).thenReturn(2.0, 3.0, 4.0, 1.0);

        Assert.assertTrue(matrix2x2.matrix[0][0].equals(number1) && matrix2x2.matrix[0][1].equals(number1) &&
                matrix2x2.matrix[1][0].equals(number1) && matrix2x2.matrix[1][1].equals(number1));

    }

    @Test
    public void SumOfMatrixsShouldBeCorrect() {
        when(number1.getA()).thenReturn(1.0);
        when(number1.getB()).thenReturn(2.0);
        ComplexMatrix2x2 matrix1 = new ComplexMatrix2x2(number1);

        when(number2.getA()).thenReturn(2.0);
        when(number2.getB()).thenReturn(2.0);
        ComplexMatrix2x2 matrix2 = new ComplexMatrix2x2(number2);

        ComplexMatrix2x2 sumMatrix = matrix1.add(matrix2);

        ComplexNumber number = mock(ComplexNumber.class);

        when(number.getA()).thenReturn(3.0);
        when(number.getB()).thenReturn(4.0);

        Assert.assertTrue(sumMatrix.matrix[0][0].equals(number) && sumMatrix.matrix[0][1].equals(number) &&
                sumMatrix.matrix[1][0].equals(number) && sumMatrix.matrix[1][1].equals(number));

    }

    @Test
    public void MultMatrixShouldBeCorrect() {
        when(number1.getA()).thenReturn(1.0);
        when(number1.getB()).thenReturn(2.0);
        ComplexMatrix2x2 matrix1 = new ComplexMatrix2x2(number1);

        when(number2.getA()).thenReturn(2.0);
        when(number2.getB()).thenReturn(2.0);
        ComplexMatrix2x2 matrix2 = new ComplexMatrix2x2(number2);

        ComplexMatrix2x2 multMatrix = matrix1.mult(matrix2);

        ComplexNumber number = mock(ComplexNumber.class);

        when(number.getA()).thenReturn(-4.0);
        when(number.getB()).thenReturn(12.0);

        Assert.assertTrue(multMatrix.matrix[0][0].equals(number) && multMatrix.matrix[0][1].equals(number) &&
                multMatrix.matrix[1][0].equals(number) && multMatrix.matrix[1][1].equals(number));

    }

    @Test
    public void detOfMatrixShouldBeCorrect() {
        when(number1.getA()).thenReturn(2.0);
        when(number1.getB()).thenReturn(4.0);

        when(number2.getA()).thenReturn(2.0);
        when(number2.getB()).thenReturn(1.0);

        when(number3.getA()).thenReturn(5.0);
        when(number3.getB()).thenReturn(4.0);

        when(number4.getA()).thenReturn(1.0);
        when(number4.getB()).thenReturn(1.0);

        ComplexMatrix2x2 matrix2x2 = new ComplexMatrix2x2(number1, number2, number3, number4);

        ComplexNumber number = mock(ComplexNumber.class);
        when(number.getA()).thenReturn(-8.0);
        when(number.getB()).thenReturn(-7.0);

        Assert.assertTrue(matrix2x2.det().equals(number));
    }

    @Test
    public void multVectorShouldBeCorrect() {
        when(number1.getA()).thenReturn(2.0);
        when(number1.getB()).thenReturn(4.0);

        when(number2.getA()).thenReturn(2.0);
        when(number2.getB()).thenReturn(1.0);

        when(number3.getA()).thenReturn(5.0);
        when(number3.getB()).thenReturn(4.0);

        when(number4.getA()).thenReturn(1.0);
        when(number4.getB()).thenReturn(1.0);

        ComplexMatrix2x2 matrix2x2 = new ComplexMatrix2x2(number1, number2, number3, number4);
        ComplexVector2D vector = new ComplexVector2D(number1, number4);

        ComplexVector2D multVector = matrix2x2.multVector(vector);

        ComplexNumber number = mock(ComplexNumber.class);
        when(number.getA()).thenReturn(-11.0, -6.0);
        when(number.getB()).thenReturn(19.0, 30.0);

        ComplexVector2D vector2D = mock(ComplexVector2D.class);
        when(vector2D.getX()).thenReturn(number);
        when(vector2D.getY()).thenReturn(number);

        Assert.assertTrue(multVector.getX().equals(vector2D.getX()) && multVector.getY().equals(vector2D.getY()));

    }

}
