package practica.multiplelinearregression;

public class Crammer {
    
    public Crammer(){}
    
    public double Determinante(double[][] matriz) {
        
        double determinante;
        
        if(matriz.length == 2){
            determinante = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
            return determinante;
        }
        double suma = 0;
        for(int i = 0; i < matriz.length; i++){
        double[][] aux = new double[matriz.length - 1][matriz.length - 1];
            for(int j = 0; j < matriz.length; j++){
                if(j != i){
                    for(int k = 1; k < matriz.length; k++){
                        int indice = -1;
                        if(j < i)
                            indice = j;
                        else if(j > i)
                            indice = j - 1;                    
                            aux[indice][k - 1] = matriz[j][k];
                    }
                }
            }
            if(i%2 == 0)
                suma += matriz[i][0] * Determinante(aux);
            else
                suma -= matriz[i][0] * Determinante(aux);
        }
        return suma;
    }
    
}
