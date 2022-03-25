package edtrab;

import java.util.Arrays;
import java.util.LinkedList;
public class KNN {
    public static double eucledianDistance(String[] currentReg,String target){
        String[] valor2 = target.split(",");
        double v1 = 0;
        double v2 = 0;
        double v3 = 0;
        double vt = 0;
        double a1 = Double.valueOf(currentReg[0]).doubleValue();
        double a2 = Double.valueOf(currentReg[1]).doubleValue();
        double a3 = Double.valueOf(currentReg[2]).doubleValue();
        double b1 = Double.valueOf(valor2[0]).doubleValue();
        double b2 = Double.valueOf(valor2[1]).doubleValue();
        double b3 = Double.valueOf(valor2[2]).doubleValue();
        a1 = a1 - b1;
        a2 = a2 - b2;
        a3 = a3 - b3;
        v1 = Math.pow(a1, 2);
        v2 = Math.pow(a2, 2);
        v3 = Math.pow(a3, 2);
        vt = v1 + v2 + v3;
        vt = Math.sqrt(vt);       
        return vt;
    } 
    public static String classify(LinkedList<String[]> dataset,int k,String target){
        double[] distanciaDoTarget = new double[8];
        int i = 0;
        
        int pos = 0;
        double aux = -1;
        String resultado = "";
        if(k<0){
            k = 1;
        }
        if(dataset.isEmpty()){
            return null;
        }
        System.out.println("Resultados dos calculcos de distancia sem ordeneção");
        for (String[] currentReg : dataset) {
            
            
                distanciaDoTarget[i] = eucledianDistance(currentReg,target);
                System.out.println(distanciaDoTarget[i]);
                if(aux <0){
                    aux = distanciaDoTarget[i]; // Vou armazenar o primeiro resultado e posição para poder testar depois no outro if
                    pos = i;
                }
                if(aux > distanciaDoTarget[i]){
                    aux = distanciaDoTarget[i];  // Vai comparar com a primeira posição obitida na função 
                    pos = i;                     // Se for menor vou guardar a posição para poder mostrar a classe no final
                     
                }
                i = i + 1;
                 }
        Arrays.sort(distanciaDoTarget);
        System.out.println("Resultados ordenados :");
        for(i=0;i<8;i++){
            System.out.println(distanciaDoTarget[i]);
        }
        int j = 0;
        int v = 0;
        
        for (String[] clientes : dataset) {
            
            if(j == pos){ // verifica a posição de onde deu o menor resutlado na função eucledianDistance
            for (String cliente : clientes) {
             
             if(v == 3){ // Como a classe fica sempre na quarta posição eu vo so pegar ela para mostrar o resultado 
                 
                 resultado = cliente;
                 //System.out.println(resultado);
                 break;
                 
             }
             
             v = v + 1;
           
            }
         }
            j = j + 1; 
     }
        System.out.println("Posição na LinkedList");
        System.out.println(pos);
        return resultado;
    }
}
