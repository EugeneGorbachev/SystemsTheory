package saddle_point;

public class Main {
    public static void main( String[] args ) {
        long[][] array ={{3,2,1,4}, {10,4,3,10}, {-2,4,1,2}};// Have a point
        //long[][] array ={{7,6,5,4}, {10,4,3,10}, {-2,4,1,2}};// Have no point
        Solver solver = new Solver(array);
        if (solver.Solve()) {
            System.out.println("Saddle point: " + solver.getAlpha());
        }
        else  {
            System.out.println("Saddle point was not found.");
        }
    }
}
