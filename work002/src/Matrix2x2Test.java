import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Denis on 23.02.16.
 */
public class Matrix2x2Test {

    public static Matrix2x2 matrix2x2;

    @Test
    public void matrixShouldBeZero() {
        matrix2x2 = new Matrix2x2();
        double matrix[][] = {{0, 0}, {0, 0}};
        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void everyElementShouldEqualsParam() {
        matrix2x2 = new Matrix2x2(5);
        double matrix[][] = {{5, 5}, {5, 5}};
        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void everyElementShouldGetSameElementFromParamArray() {
        double matrix[][] = {{1, 4}, {6, 1}};
        matrix2x2 = new Matrix2x2(matrix);

        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void everyElementShouldGetSameElementFromParams() {
        matrix2x2 = new Matrix2x2(1, 2, 3, 4);
        double matrix[][] = {{1, 2}, {3, 4}};
        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void SumOfMatrixsShouldBeCorrect() {
        Matrix2x2 matrix1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 matrix2 = new Matrix2x2(4);
        double matrix[][] = {{5, 6}, {7, 8}};

        Matrix2x2 sumMatrix = matrix1.add(matrix2);
        Assert.assertArrayEquals(sumMatrix.matrix, matrix);
    }

    @Test
    public void originalMatrixShouldBeSumOfMatrixs() {
        Matrix2x2 matrix1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 matrix2 = new Matrix2x2(4);
        double matrix[][] = {{5, 6}, {7, 8}};

        matrix1.add2(matrix2);
        Assert.assertArrayEquals(matrix1.matrix, matrix);
    }

    @Test
    public void SubOfMatrixsShouldBeCorrect() {
        Matrix2x2 matrix1 = new Matrix2x2(4);
        Matrix2x2 matrix2 = new Matrix2x2(1, 2, 3, 4);
        double matrix[][] = {{3, 2}, {1, 0}};

        Matrix2x2 subMatrix = matrix1.sub(matrix2);
        Assert.assertArrayEquals(subMatrix.matrix, matrix);
    }

    @Test
    public void originalMatrixShouldBeSubOfMatrixs() {
        Matrix2x2 matrix1 = new Matrix2x2(4);
        Matrix2x2 matrix2 = new Matrix2x2(1, 2, 3, 4);
        double matrix[][] = {{3, 2}, {1, 0}};

        matrix1.sub2(matrix2);
        Assert.assertArrayEquals(matrix1.matrix, matrix);
    }

    @Test
    public void MultMatrixShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(1, 2, 5, 2);
        Matrix2x2 multMatrix = matrix2x2.multNumber(2);
        double matrix[][] = {{2, 4}, {10, 4}};
        Assert.assertArrayEquals(multMatrix.matrix, matrix);
    }

    @Test
    public void originalMatrixShouldBeMultMatrix() {
        matrix2x2 = new Matrix2x2(1, 2, 5, 2);
        matrix2x2.multNumber2(2);
        double matrix[][] = {{2, 4}, {10, 4}};
        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void MultOfMatrixsShouldBeCorrect() {
        Matrix2x2 matrix1 = new Matrix2x2(1, 2, 5, 2);
        Matrix2x2 matrix2 = new Matrix2x2(3);
        Matrix2x2 multMatrix = matrix1.mult(matrix2);
        double matrix[][] = {{9, 9}, {21, 21}};
        Assert.assertArrayEquals(multMatrix.matrix, matrix);
    }

    @Test
    public void originalMatrixShouldBeMultOfMatrixs() {
        Matrix2x2 matrix1 = new Matrix2x2(1, 2, 5, 2);
        Matrix2x2 matrix2 = new Matrix2x2(3, 1, 2, 2);
        matrix1.mult2(matrix2);
        double matrix[][] = {{7, 5}, {19, 9}};
        Assert.assertArrayEquals(matrix1.matrix, matrix);
    }

    @Test
    public void detOfMatrixShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(1, 2, 5, 2);
        Assert.assertEquals(matrix2x2.det(), -8, 1e-9);
    }

    @Test
    public void transponMatrixShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(1, 3, 6, 3);
        matrix2x2.transpon();
        double matrix[][] = {{1, 6}, {3, 3}};
        Assert.assertArrayEquals(matrix2x2.matrix, matrix);
    }

    @Test
    public void inverseMatrixShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(4, 2, 6, 8);
        Matrix2x2 inverseMatrix = matrix2x2.inverseMatrix();
        double matrix[][] = {{0.4, -0.1}, {-0.3, 0.2}};
        Assert.assertArrayEquals(inverseMatrix.matrix, matrix);
    }

    @Test
    public void matrixWithDetZeroNotShouldBeInverse() {
        matrix2x2 = new Matrix2x2(4);
        Matrix2x2 inverseMatrix = matrix2x2.inverseMatrix();
        double matrix[][] = {{0, 0}, {0, 0}};
        Assert.assertArrayEquals(inverseMatrix.matrix, matrix);
    }

    @Test
    public void equivalentDiagonalMatrixShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(1, 10, 3, 8);
        Matrix2x2 eqDialMatrix = matrix2x2.equivalentDiagonal();
        double matrix[][] = {{1, 0}, {0, -22}};
        Assert.assertArrayEquals(eqDialMatrix.matrix, matrix);
    }

    @Test
    public void multVectorShouldBeCorrect() {
        matrix2x2 = new Matrix2x2(2, 4, 8, 2);
        Vector2D vector = new Vector2D(2, 3);
        Vector2D vector2D = matrix2x2.multVector(vector);
        Assert.assertTrue(vector2D.getX() == 16 && vector2D.getY() == 22);
    }

}
