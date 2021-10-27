package practica.multiplelinearregression;

public class MLR implements MLRinterfaz {
    
    HelperArithmetic helper = new HelperArithmetic();
    DataSet data = new DataSet();
    Crammer crammer = new Crammer();
    
    @Override
    public void Metodo() {
        
        double[][] x = data.getX();
        double[][] y = data.getY();  
        double[][] xt = helper.Transpuesta(x);
        
        double[][] XtX = new double[xt.length][x[0].length];
        XtX = helper.Multiplicacion(xt, x);
        
        double[][] XtY = new double[xt.length][y[0].length];
        XtY = helper.Multiplicacion(xt, y);
        
        double[][] inversa = helper.Inversa(XtX);
        
        double[][] resultado = helper.Multiplicacion(inversa, XtY);
        
        print_(resultado);
    }    
    
    @Override
    public void print_(double[][] matriz){
        for(double[] fila : matriz){
            for(double columna : fila){
                System.out.print(columna + " ");
            }
        System.out.println("");
        }
    }
}