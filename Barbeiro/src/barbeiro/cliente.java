/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class cliente implements Runnable {
    int i = 0; 
    
    
    
    synchronized void chega(barbearia b){
        while(true){
            
            try{
                TimeUnit.SECONDS.sleep(2);
               
            if(b.cadeiras.tryAcquire()){
                    b.cadeiras.acquire();
                    
                   
                    if(b.dormindo.hasQueuedThreads()) b.dormindo.release();
                    System.out.println(i++);
                    b.eperaSentar.release();
                    b.cortando.acquire();
                    System.out.println("Tomei uma picada");
                    b.cadeiras.release(2);
                    

                    }
            else{
               b.cadeiras.release(); 
               System.out.println("ta chei fui embora");
            }
            }
            
            catch(Exception e)
            {

            }

        }
    }
            
    
    
    @Override
    public void run(){
      chega(barbeiro.b);  
    }
    void verificarCadeira(){
        
    }
    
    
}
