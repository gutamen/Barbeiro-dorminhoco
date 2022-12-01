/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barbeiro;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class barbeiro implements Runnable{
    boolean dormindo = true, cortandoCabelo = false;
    int tempoParaCorte = 3;
    static barbearia b = new barbearia(5);
    
    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String args[]){
        
        
        Thread cortador = new Thread(new barbeiro());
        cortador.start();
        for(int i = 0; i < 7;i++)
        {
        Thread cliente = new Thread(new cliente());
        cliente.start();
        //Thread t2 = new Thread(new consumidor(b));
        }
        
        
        try{
            cortador.join();
        }
        catch(Exception e)
        {}
        //System.out.println("Fim prod/cons");
    
    }
    
    synchronized public boolean estaDormindo(){
        return this.dormindo;
    }
    
    synchronized public boolean estaCortando(){
        return this.cortandoCabelo;
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
    