/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barbeiro;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class barbeiro implements Runnable{
    static boolean dormindo = true, cortandoCabelo = false;
    int tempoParaCorte = 1;
    static barbearia b = new barbearia(5);
    
    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String args[]){
        
        
        Thread cortador = new Thread(new barbeiro());
        cortador.start();
        int l = 0;
        
        
        while(l < 100)
        { 
            Random chegouCliente = new Random();
        if(chegouCliente.nextInt(100) > 80){
            Thread cliente = new Thread(new cliente());
            cliente.start();
        }
        System.out.println(l);
        try{
         TimeUnit.SECONDS.sleep(1);
        }
        catch(Exception e)
        {}
        //Thread t2 = new Thread(new consumidor(b));
        l++;
        }
        
        
        
        System.out.println("Fim prod/cons");
    
    }
    
    
    synchronized public void trabalha(barbearia b){
        while(true){
            try{
                
                b.dormindo.acquire();
                if(b.semNinguem.availablePermits() > 0){
                    System.out.println(b.semNinguem.availablePermits());
                   
                    b.dormindo.release();
                    
                    
                    b.eperaSentar.acquire();
                    System.out.println("Cortando na frente, picando atras");       
                    TimeUnit.SECONDS.sleep(tempoParaCorte);
                    b.aguarde.release();
             
                    b.cortando.release();
                }
                else{
                    
                    
                    System.out.println("A mimir...");
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch(Exception e)
                    {}
                    b.dormindo.release();
                }
                
                /*if(b.semNinguem.tryAcquire()){
                    b.semNinguem.release();
                    // System.out.println("senta");
                    b.eperaSentar.acquire();
                    System.out.println("Cortando na frente, picando atrás");
                    TimeUnit.SECONDS.sleep(tempoParaCorte);
                    b.cortando.release();
                }
                else{
                    System.out.println("A mimir...");
                    wait();
                }*/
                   
                
                
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
    