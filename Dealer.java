/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author userh
 */
//抽象クラスHumanを継承したDealerクラスを生成
public class Dealer extends Human{
        
    protected ArrayList<Integer> Cards = new ArrayList<Integer>();
    
    //コンストラクタ、このクラスがインスタンス化されたときに1から13までの数値を4回、Cardsにaddする
    Dealer(){
        for(int i=1; i<=4; i++){
            for(int a=1; a<=13; a++){
                Cards.add(a);
            }
        }
    //全部addし終わった後にCardsの中身をコレクションクラスのシャッフルメソッドで混ぜる
    Collections.shuffle(Cards);
    
    }
    
    //Cardsの上から2枚引いてdraw1に格納、引いた2枚をCardsからremove
    public ArrayList<Integer> deal(){
        ArrayList<Integer> draw1 = new ArrayList<Integer>();
            
            draw1.add(Cards.get(0));
            draw1.add(Cards.get(1));
            Cards.remove(0);
            Cards.remove(0);
            return draw1;    
    }
    
    //Cardsの上から1枚引いてdraw2に格納、引いた1枚をCardsからremove
    public ArrayList<Integer> hit(){
        ArrayList<Integer> draw2  = new ArrayList<Integer>();
           
            draw2.add(Cards.get(0));
            Cards.remove(0);
            return draw2;
    }
    
    @Override
    //myCardsの中身の合計を出す
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
