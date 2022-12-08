/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro;

import java.util.concurrent.Semaphore;


class barbearia{
    
    int quantasCadeiras;
    Semaphore cadeiras,cortando,dormindo,semNinguem;

    public barbearia(int _quantasCadeiras){
        
        this.quantasCadeiras=_quantasCadeiras;
        this.cortando = new Semaphore(0);
        this.cadeiras = new Semaphore(_quantasCadeiras);
        this.semNinguem = new Semaphore(0);
        this.dormindo = new Semaphore(1);
        

    }
}