/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;
import java.util.ArrayList;


/**
 *
 * @author userh
 */
//abstractで抽象メソッドopen(),setCard(),checkSum()を持った抽象クラスHumanを生成
abstract public class Human {
    
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> sendCard);
    abstract public boolean checkSum();
}


