package projektEvolution;

import java.awt.EventQueue;

public class Program {
   public static void main(String args[]) {
		
//		double[] point = new double[2];
//		point[0] = -1.0421;
//		point[1] = -1.0018;
//		Point p = new Point();
//		p.setVector(point);
//		
//		IFunction rastr = new RastriginFunction();
//		
//		System.out.println(rastr.getValue(p));
            
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MyFrame();
                    }
                });
       }

}
