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
//抽象クラスHumanを継承したUserクラスを生成
public class User extends Human{
        
    @Override
    //myCradsの中身の合計を出す
    public int open(){
        int total=0;
        //BlackJackでは11以上は全て10として計算するので11以上の数値は全てtotalに10を足す
        for(int i : myCards){
            if(i>10){
                total+=10;
            //それ以下はそのまま足す
            }else{
                total+=i;
            }
        }
        return total;
    }
    
    @Override
    //sendCardに一度格納して格納されている数値をmyCardsにaddする
    public void setCard(ArrayList<Integer> sendCard){
        for(int i : sendCard){
            myCards.add(i);
        }
    }
    
    @Override
    //手札の合計値が18未満の場合はfalse、18以上の場合はtrueを返す
    public boolean checkSum(){
        boolean underEighteen = true;
        boolean overEighteen = false;
        underEighteen = open()<18;
        if(underEighteen){
            return underEighteen;
        }else{
            return overEighteen;
        }     
    }
    
}
