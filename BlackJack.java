/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.blackjack;
import java.util.ArrayList;
import java.lang.System;
/**
 *
 * @author userh
 */
public class BlackJack{
    public static void main(String[] args){
        
        //dealer,userをインスタンス化
        //dealerをインスタンス化したときにカードが52枚入るようにコンストラクタが呼び出されている
        Dealer dealer = new Dealer();
        User user = new User();
        //改行コードを使用
        String crlf = System.getProperty("line.separator");
        //①インスタンス化されたdealerがdealメソッドで呼び出したカード情報をsetCardメソッドでdealerのmyCardsに格納する
        dealer.setCard(dealer.deal());

        System.out.println("BlackJackスタート！");
        //dealerは場に1枚しかオープンにしないので2枚ある内の1枚だけをオープンにする
        System.out.println("Dealerが引いたカードは"+dealer.myCards.get(0)+"と？です！");            
        //①のuser Ver.
        user.setCard(dealer.deal());
        //拡張for文でuserが配られたカードを1枚ずつオープンする
        for(int a : user.myCards){
            System.out.println("Userが引いたカードは"+a+"です！");
        }
        for(int a : user.myCards){
            if(a>10){
                System.out.println("11以上の数字は10として計算しますので");
            }else{}
        }
        //userのmyCardsの合計をopenメソッドで出す
        System.out.println("Userの合計は"+user.open()+"です！");
        System.out.println("お互いの手札はUserが"+user.open()+"、Dealerが"+dealer.myCards.get(0)+"です！"+crlf+"Userはまだ引きますか？");

        //userのcheckSumメソッドでmyCards内の合計値のtrue or falseを判断
        if(user.checkSum()){
            //trueだった場合は合計が18未満なので18以上になるまで引き続けます
            for(int i=1;user.checkSum();i++){
                //あとで何回目にいくつを引いたのか分かるようにint endにmyCardsに格納されている個数を代入します
                int end = user.myCards.size();
                System.out.println("Userはまだ引くようです！");
                //setCardメソッドでdealerのhitメソッドを呼び出し、myCardsにカードを追加していきます
                user.setCard(dealer.hit());
                //iとendにより何回目にいくつを引いたのかが分かります
                System.out.println(user.myCards.get(end)+"を引きました");
                if(user.myCards.get(end)>10){
                    System.out.println("11以上の数字は10として計算しますので");
                }else{}
                System.out.println("Userの"+i+"回目のhitでの手札の合計は"+user.open()+"です");
            }
        }else{
            //18以上になったら結果がfalseになるのでループから抜けます
            System.out.println("Userはもう引きません");
        }
        //userのmyCardsの合計が22以上だった場合、BlackJackのルールに則り問答無用でdealerの勝ちです
        if(user.open()>21){
            System.out.println("Burst!Dealerの勝ちです！");
            System.exit(0);
        }else if(user.open()==21){
            System.out.println("BlackJack!!Userの勝ちです！");
            System.exit(0);
        }else{
            System.out.println("Userは引くのをやめました");
            //それ以下であればdealerのもう一枚の手札の合計をオープンして合計を出します
            System.out.println("Dealerの手札をオープンします");
            System.out.println(dealer.myCards.get(0)+"と"+dealer.myCards.get(1)+"です");
            if(dealer.myCards.get(0)>10 || dealer.myCards.get(1)>10){
                System.out.println("11以上の数字は10として計算されますので");
            }else{}
            System.out.println("Dealerの手札の合計は"+dealer.open());
        }    
        //この時点でdealerの方が合計値が大きければdealerの勝ちです
        if(user.open()<dealer.open()){
            System.out.println(dealer.open()+user.open()+"でDealerの勝ちです！");
            System.exit(0);
        //違う場合は合計値が18未満かどうかcheckSumメソッドで確認し、まだ引くか判断します
        }else if(dealer.checkSum()){
            for(int i=1;dealer.checkSum();i++){
                int end = dealer.myCards.size();
                System.out.println("Dealerはまだ引くようです！");
                dealer.setCard(dealer.hit());
                System.out.println(dealer.myCards.get(end)+"です！");
                if(dealer.myCards.get(end)>10){
                    System.out.println("11以上の数字は10として計算しますので");
                }else{}
                System.out.println("Dealerの"+i+"回目のhitでの手札の合計は"+dealer.open()+"です");
            }
        }else{
            System.out.println("Dealerはもう引きません");
        }
        //合計が22以上ならBurstなのでUserの勝ち。Burstでなければ合計値が上回っている方が勝ちなのでelse ifで条件分岐
        if(dealer.open()>21){
            System.out.println("Burst！Userの勝ちです！");
        }else if(dealer.open()==21){
            System.out.println("BlackJack!!Dealerの勝ちです！");
        }else if(dealer.open()<user.open()){
            System.out.println(user.open()+"と"+dealer.open()+"でUserの勝ちです!");
        }else if(dealer.open()==user.open()){
            System.out.println(dealer.open()+"と"+user.open()+"、なんと！引き分けです！");
        }else{
            System.out.println(dealer.open()+"と"+user.open()+"でDealerの勝ちです！");
        }
    }  
}
