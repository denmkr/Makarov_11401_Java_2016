/**
 * Created by Denis on 23.02.16.
 */
public class Matrix2x2 {

    public double matrix[][] = new double[2][2];

    public Matrix2x2() {

    }

    public Matrix2x2(double value) {
        for (int i=0; i<2; i++)
            for (int j=0; j<2; j++)
                matrix[i][j] = value;

    }

    public Matrix2x2(double matrix[][]) {
        this.matrix = matrix;
    }

    public Matrix2x2(double elem1, double elem2, double elem3, double elem4) {
        matrix[0][0] = elem1;
        matrix[0][1] = elem2;
        matrix[1][0] = elem3;
        matrix[1][1] = elem4;
    }

    public Matrix2x2 add(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                matrix2x2.matrix[i][j] = matrix.matrix[i][j] + this.matrix[i][j];

        return matrix2x2;
    }

    public void add2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                this.matrix[i][j] += matrix.matrix[i][j];

    }

    public Matrix2x2 sub(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                matrix2x2.matrix[i][j] = this.matrix[i][j] - matrix.matrix[i][j];

        return matrix2x2;
    }

    public void sub2(Matrix2x2 matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] - matrix.matrix[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double k) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2x2.matrix[i][j] = this.matrix[i][j] * k;
            }
        }
        return matrix2x2;
    }

    public void multNumber2(double k) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] * k;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 matrix) {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix2x2.matrix[i][j] += this.matrix[i][k] * matrix.matrix[k][j];
                }
            }
        }
        return matrix2x2;
    }

    public void mult2(Matrix2x2 matrix) {
        double elem1 = 0;
        double elem2 = 0;
        double elem3 = 0;
        double elem4 = 0;

        for (int i = 0; i < 2; i++) {
            elem1 += this.matrix[0][i] * matrix.matrix[i][0];
            elem2 += this.matrix[0][i] * matrix.matrix[i][1];
            elem3 += this.matrix[1][i] * matrix.matrix[i][0];
            elem4 += this.matrix[1][i] * matrix.matrix[i][1];
        }

        this.matrix[0][0] = elem1;
        this.matrix[0][1] = elem2;
        this.matrix[1][0] = elem3;
        this.matrix[1][1] = elem4;
    }

    public double det() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public void transpon() {
        double elem = this.matrix[1][0];
        this.matrix[1][0] = this.matrix[0][1];
        this.matrix[0][1] = elem;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 matrix2x2 = new Matrix2x2();
        if (this.det() != 0) {
            matrix2x2.matrix[0][0] = this.matrix[1][1] / this.det();
            matrix2x2.matrix[0][1] = -this.matrix[1][0] / this.det();
            matrix2x2.matrix[1][0] = -this.matrix[0][1] / this.det();
            matrix2x2.matrix[1][1] = this.matrix[0][0] / this.det();
            matrix2x2.transpon();

        } else {
            System.out.println("Error! Det = 0");
        }

        return matrix2x2;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 matrix2x2 = new Matrix2x2();

        matrix2x2.matrix[0][0] = this.matrix[0][0];
        matrix2x2.matrix[0][1] = 0;
        matrix2x2.matrix[1][0] = 0;
        matrix2x2.matrix[1][1] = this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0] / this.matrix[0][0];
        return matrix2x2;
    }

    public Vector2D multVector(Vector2D vector) {
        Vector2D vector2D = new Vector2D();
        vector2D.setX(this.matrix[0][0] * vector.getX() + this.matrix[0][1] * vector.getY());
        vector2D.setY(this.matrix[1][0] * vector.getX() + this.matrix[1][1] * vector.getY());
        return vector2D;
    }


}
