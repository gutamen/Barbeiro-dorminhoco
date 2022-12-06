/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeirocomdefeito;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Gustavo
 */
class barbearia{
    
    int quantasCadeiras;
    //int[] cadeiras;
    Semaphore cadeiras,cortando,dormindo,eperaSentar,semNinguem;

    public barbearia(int _quantasCadeiras){
        //this.cadeiras = new int[_quantasCadeiras];
        this.quantasCadeiras=_quantasCadeiras;
        this.cortando = new Semaphore(0);
        this.cadeiras = new Semaphore(_quantasCadeiras);
        this.eperaSentar = new Semaphore(0);
        this.semNinguem = new Semaphore(0);
        this.dormindo = new Semaphore(0);

    }
}