/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeirocomdefeito;


public class cliente implements Runnable {
    static int i = 0, o = 0, p = 0; 
    
    
    
    synchronized void chega(barbearia b){
        try{

            if(b.cadeiras.tryAcquire()){
                

                b.dormindo.acquire();
                b.semNinguem.release();
                if(BarbeiroComDefeito.dormindo){
                    BarbeiroComDefeito.dormindo = false;
                    System.out.println("Acorda fi do caum");
                }
                b.dormindo.release();
                
                
                b.cortando.acquire();
               
                System.out.println("Valeu pelo corte " + o++);
                
                b.cadeiras.release();
                b.semNinguem.acquire();
                //b.dormindo.release();//tirar causa uma nao-solucao
            }
            else{
                 
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
