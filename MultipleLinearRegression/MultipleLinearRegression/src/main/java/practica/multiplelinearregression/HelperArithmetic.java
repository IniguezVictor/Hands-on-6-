package practica.multiplelinearregression;

public class HelperArithmetic {
    
    Crammer crammer = new Crammer();
    
    public HelperArithmetic(){}
    
    public double[][] Multiplicacion(double[][] valor1, double[][] valor2) {
        int filas1 = valor1.length; 
        int columnas1 = valor1[0].length;
        //3x17
        
        int filas2 = valor2.length;
        int columnas2 = valor2[0].length;
        //17x3
        
        double[][] resultado = new double [filas1][columnas2];
        
        for(int i = 0; i < filas1; i++){
            for(int j = 0; j < columnas2; j++){
                for(int k = 0; k < columnas1; k++){
                    resultado[i][j] += valor1[i][k] * valor2[k][j];
                }
            }
        }
        return resultado;
    }
    
    public double[][] MultiplicacionEscalar(double Escalar, double[][] matriz) {
        for(int i = 0;i < matriz.length; i++){
            for(int j = 0;j < matriz.length; j++){
                matriz[i][j] *= Escalar;
            }      
        }
        return matriz;
    }
    
    public double[][] Transpuesta(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        double[][] aux = new double[columnas][filas];
        
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                aux[j][i] = matriz[i][j];
            }
        }
        return aux;
    }
    
    public double[][] Inversa(double[][] matriz) {
        
        double determinante = 1 / crammer.Determinante(matriz);
        double[][] aux = Adjunta(matriz);
        aux = MultiplicacionEscalar(determinante, aux);
        
        return aux;
    }

    public double[][] Cofactores(double[][] matriz) {
        
        double[][] cofactores = new double[matriz.length][matriz.length];
        
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length; j++) {
                double[][] aux = new double[matriz.length-1][matriz.length-1];
                double celda;
                for(int k = 0;k < matriz.length; k++) {
                    if(k != i) {
                        for(int l = 0;l < matriz.length; l++) {
                            if(l != j){
                                int indice1 = k < i ? k : k - 1 ;
                                int indice2 = l < j ? l : l - 1 ;
                                aux[indice1][indice2] = matriz[k][l];
                            }
                        }
                    }
                }
                celda = crammer.Determinante(aux);
                cofactores[i][j] = celda * (double)Math.pow(-1, i + j + 2);
            }
        }
        return cofactores;
    }

    public double[][] Adjunta(double[][] matriz) {
        return Transpuesta(Cofactores(matriz));
    }
    
}
