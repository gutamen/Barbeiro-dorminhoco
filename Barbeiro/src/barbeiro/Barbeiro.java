/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barbeiro;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class barbeiro implements Runnable{
    static boolean dormindo = false;
    int tempoParaCorte = 2; 
    static barbearia b = new barbearia(2);
    
    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String args[]){
        
        
        Thread cortador = new Thread(new barbeiro());
        cortador.start();
        int podeChegarGente = 0;
        int chegouAlguem = 0;
        
        while(chegouAlguem < 40)
        { 
            
            Random chegouCliente = new Random();
        if(chegouCliente.nextInt(100) > 40){
            Thread cliente = new Thread(new cliente());
            cliente.start();
            System.out.println(chegouAlguem++);
        }
        
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch(Exception e)
        {}
        }
        
        
        
        System.out.println("Fim de Expediente, deixa eu dormi em paz");
    
    }
    
    
    synchronized public void trabalha(barbearia b){
        while(true){
            try{
                
                b.dormindo.acquire();
                if(b.semNinguem.availablePermits() > 0 ){
                    //System.out.println(b.semNinguem.availablePermits());
                   
                    b.dormindo.release();
                    
                    
                    
                    System.out.println("Cortando cabelo");       
                    TimeUnit.SECONDS.sleep(tempoParaCorte);
                    
             
                    b.cortando.release();
                    b.dormindo.acquire();//tirar causa uma nao-solucao
                }
                else{
                    
                    if(!barbeiro.dormindo){
                        System.out.println("A mimir...");
                        barbeiro.dormindo = true;
                    }
                    
                    b.dormindo.release();
                }
                
                
                
            }
            catch(Exception e)
            {

            }
        }
        
    }
    
    @Override
    public void run(){
      trabalha(b);  
    }
            
}
    