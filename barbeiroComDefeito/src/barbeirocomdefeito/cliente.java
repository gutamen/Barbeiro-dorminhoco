/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeirocomdefeito;

/**
 *
 * @author Gustavo
 */
public class cliente implements Runnable {
    static int i = 0, o = 0, p = 0; 
    
    
    
    synchronized void chega(barbearia b){
        try{

            if(b.cadeiras.tryAcquire()){
                b.cadeiras.acquire();
                b.semNinguem.release();

                if(b.dormindo.tryAcquire()) b.dormindo.release(3);
                else b.dormindo.release();
                
                b.eperaSentar.release();
                b.cortando.acquire();
                System.out.println("Tomei uma picada " + o++);
                b.cadeiras.release(2);


            }
            else{
                b.cadeiras.release(); 
                System.out.println("ta chei fui embora " + p++);
            }
        }

        catch(Exception e)
        {}

        
    }
            
    
    
    @Override
    public void run(){
      chega(BarbeiroComDefeito.b);  
    }
    void verificarCadeira(){
        
    }
    
    
}
