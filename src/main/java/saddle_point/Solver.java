package saddle_point;

public class Solver {
    private long[][] array;
    private long alpha, beta;

    public Solver(long[][] array) {
        this.array = array;
    }

    public long[][] getArray() {
        return array;
    }

    public long getAlpha() {
        return alpha;
    }

    public long getBeta() {
        return beta;
    }

    public boolean Solve() {
        long min, max;
        boolean flag = false;// flag alpha or beta identification
        int rows = array.length > 0? array.length: 0;
        int cols = ((array.length > 0) && (array[0].length > 0))? array[0].length: 0;

        for (int i = 0; i < rows; i++) {// for all rows
            min = array[i][0];
            for (int k = 1; k < cols; k++) {// search min by row
                if (array[i][k] < min) {
                    min = array[i][k];
                }
            }
            if (!flag) {// if alpha was non identified
                alpha = min;
                flag = true;
            }
            else {
                if (min > alpha)
                    alpha = min;
            }
        }

        flag = false;// refresh flag
        for (int j = 0; j < cols; j++) {// for all columns
            max = array[0][j];
            for (int k = 1; k < rows; k++) {// search max by column
                if (array[k][j] > max)
                    max = array[k][j];
            }
            if (!flag) {// if beta was non identified
                beta = max;
                flag = true;
            }
            else {
                if (max < beta)
                    beta = max;
            }
        }

        return alpha == beta;
    }
}
