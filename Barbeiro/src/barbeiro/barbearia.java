/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Gustavo
 */
class barbearia{
    
    int quantasCadeiras;
    Semaphore cadeiras,cortando,dormindo,eperaSentar,semNinguem,aguarde;

    public barbearia(int _quantasCadeiras){
        
        this.quantasCadeiras=_quantasCadeiras;
        this.cortando = new Semaphore(1);
        this.cadeiras = new Semaphore(_quantasCadeiras);
        this.eperaSentar = new Semaphore(0);
        this.semNinguem = new Semaphore(0);
        this.dormindo = new Semaphore(1);
        this.aguarde = new Semaphore(0);

    }
}