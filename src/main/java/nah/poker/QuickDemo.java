package nah.poker;

import java.util.ArrayList;
import java.util.Collections;

import nah.poker.cards.*;
import nah.poker.hands.*;

public class QuickDemo {
public static void main(String[] args) {

//  Card cAS = new Card(CardNumber.ACE, CardSuit.SPADE);
//  Card cKS = new Card(CardNumber.KING, CardSuit.SPADE);
//  Card cQS = new Card(CardNumber.QUEEN, CardSuit.SPADE);
//  Card cJS = new Card(CardNumber.JACK, CardSuit.SPADE);
//  Card c10S = new Card(CardNumber.TEN, CardSuit.SPADE);
//
//  Card cJH = new Card(CardNumber.JACK, CardSuit.HEART);
//  Card c9S = new Card(CardNumber.NINE, CardSuit.SPADE);
//  Card c2C = new Card(CardNumber.TWO, CardSuit.CLUB);
//  Card c3S = new Card(CardNumber.THREE, CardSuit.SPADE);
//
//  FiveCardHand h1 = new FiveCardHand(c10S, cJS, cAS, cKS, cQS);
//  System.out.println(h1.getCardNumberMultiplicities());
//  System.out.println(h1.isStraight());
//  System.out.println(h1.isFlush());
//
//  int tot = 52*51*50*49*48;
//  System.out.println("tot: " + tot);
//  for(int k = 0; k < tot; k++) {
//    Integer tmp = 1;
//    if(tmp == 2) System.out.println("hi");
//  }
//  System.out.println("done");


for(int i1 = 0; i1 < 13; i1++) {
  for(int i2 = 0; i2 < 13; i2++) {
    for(int i3 = 0; i3 < 13; i3++) {
      for(int i4 = 0; i4 < 13; i4++) {
        for(int i5 = 0; i5 < 13; i5++) {
          if(i2 >= i1 && i3 >= i2 && i4 >= i3 && i5 >= i4) {

            ArrayList<Integer> bank = new ArrayList<>();
            for(int j = 0; j < 13; j++) {
              for(int k = 0; k < 4; k++) bank.add(j);
            }

            boolean ok1, ok2, ok3, ok4, ok5;
            ok1 = ok2 = ok3 = ok4 = ok5 = false;
            if(bank.contains(i1)) {
              ok1 = true;
              bank.remove(new Integer(i1));
            }
            if(bank.contains(i2)) {
              ok2 = true;
              bank.remove(new Integer(i2));
            }
            if(bank.contains(i3)) {
              ok3 = true;
              bank.remove(new Integer(i3));
            }
            if(bank.contains(i4)) {
              ok4 = true;
              bank.remove(new Integer(i4));
            }
            if(bank.contains(i5)) {
              ok5 = true;
              bank.remove(new Integer(i5));
            }

            if(ok1 && ok2 && ok3 && ok4 && ok5) {
              System.out.println(i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " NS");
              if(i1 != i2 && i1 != i3 && i1 != i4 && i1 != i5 && i2 != i3 && i2 != i4 && i2 != i5 && i3 != i4 && i3 != i5 && i4 !=i5) {
                System.out.println(i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " S");
              }
            }

}
}}}}}
System.out.println("Doesn't include A-5 straight, yet gives correct # of equivilant hands...");


}
}
