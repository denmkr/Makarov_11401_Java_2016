/**
 * Created by Denis on 23.02.16.
 */
public class ComplexMatrix2x2 {

    public ComplexNumber matrix[][] = new ComplexNumber[2][2];

    public ComplexMatrix2x2() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = new ComplexNumber();
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber number) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = number;
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber number1, ComplexNumber number2, ComplexNumber number3, ComplexNumber number4) {
        matrix[0][0] = number1;
        matrix[0][1] = number2;
        matrix[1][0] = number3;
        matrix[1][1] = number4;
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 matrix) {
        ComplexMatrix2x2 matrix2x2 = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2x2.matrix[i][j] = this.matrix[i][j].add(matrix.matrix[i][j]);
            }
        }
        return matrix2x2;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 matrix) {
        ComplexMatrix2x2 matrix2x2 = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix2x2.matrix[i][j] = matrix2x2.matrix[i][j].add(this.matrix[i][k].mult(matrix.matrix[k][j]));
                }
            }
        }
        return matrix2x2;
    }

    public ComplexNumber det() {
        return matrix[0][0].mult(matrix[1][1]).sub(matrix[0][1].mult(matrix[1][0]));
    }

    public ComplexVector2D multVector(ComplexVector2D vector) {
        ComplexVector2D vector2D = new ComplexVector2D();
        vector2D.setX(this.matrix[0][0].mult(vector.getX()).add(this.matrix[0][1].mult(vector.getY())));
        vector2D.setY(this.matrix[1][0].mult(vector.getX()).add(this.matrix[1][1].mult(vector.getY())));
        return vector2D;
    }

}
