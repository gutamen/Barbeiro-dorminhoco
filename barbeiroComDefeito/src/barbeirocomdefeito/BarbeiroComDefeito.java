/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barbeirocomdefeito;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class BarbeiroComDefeito implements Runnable{
    boolean dormindo = true, cortandoCabelo = false;
    int tempoParaCorte = 3;
    static barbearia b = new barbearia(10);
    
    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String args[]){
        
        
        Thread cortador = new Thread(new BarbeiroComDefeito());
        cortador.start();
        int l = 0;
        
        
        while(l < 100)
        {
        Thread cliente = new Thread(new cliente());
        cliente.start();
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
                
                if(!b.semNinguem.tryAcquire()){
                    System.out.println("A mimir...");
                    b.dormindo.acquire(2);
                }
                else b.semNinguem.release();
                
                    b.eperaSentar.acquire();
                    System.out.println("Cortando na frente, picando atrás");
                    TimeUnit.SECONDS.sleep(tempoParaCorte);
                    b.cortando.release();
                
                
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
    