/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro;

/**
 *
 * @author Gustavo
 */
public class cliente implements Runnable {
    static int i = 0, o = 0, p = 0; 
    
    
    
    synchronized void chega(barbearia b){
        try{

            if(b.cadeiras.tryAcquire()){
                
                

                b.dormindo.acquire();
                b.semNinguem.release();
                if(barbeiro.dormindo)
                    barbeiro.dormindo = false;
                b.dormindo.release();
                
                
                b.cortando.acquire();
                b.eperaSentar.release();
                b.aguarde.acquire();
                System.out.println("Tomei uma picada " + o++);
                b.cadeiras.release();
                b.semNinguem.acquire();
            }
            else{
                 
                System.out.println("ta chei fui embora " + p++);
            }
        }

        catch(Exception e)
        {}
        
        /*try{

            if(b.cadeiras.tryAcquire()){
                
                b.semNinguem.release();

                notify();
                
                b.eperaSentar.release();
                b.cortando.acquire();
                System.out.println("Tomei uma picada " + o++);
                b.cadeiras.release();

                b.semNinguem.acquire();
            }
            else{
                //b.cadeiras.release(); 
                System.out.println("ta chei fui embora " + p++);
            }
        }

        catch(Exception e)
        {}*/

        
    }
            
    
    
    @Override
    public void run(){
      chega(barbeiro.b);  
    }
    void verificarCadeira(){
        
    }
    
    
}
