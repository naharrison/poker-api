package nah.poker;

import nah.poker.cards.*;
import nah.poker.hands.*;

public class QuickDemo {
public static void main(String[] args) {

  Card cAS = new Card(CardNumber.ACE, CardSuit.SPADE);
  Card cKS = new Card(CardNumber.KING, CardSuit.SPADE);
  Card cQS = new Card(CardNumber.QUEEN, CardSuit.SPADE);
  Card cJS = new Card(CardNumber.JACK, CardSuit.SPADE);
  Card c10S = new Card(CardNumber.TEN, CardSuit.SPADE);

  Card cJH = new Card(CardNumber.JACK, CardSuit.HEART);
  Card c9S = new Card(CardNumber.NINE, CardSuit.SPADE);
  Card c2C = new Card(CardNumber.TWO, CardSuit.CLUB);
  Card c3S = new Card(CardNumber.THREE, CardSuit.SPADE);

  FiveCardHand h1 = new FiveCardHand(c10S, cJS, cAS, cKS, cQS);
  System.out.println(h1.getCardNumberMultiplicities());
  System.out.println(h1.isStraight());
  System.out.println(h1.isFlush());

  int tot = 52*51*50*49*48;
  System.out.println("tot: " + tot);
  for(int k = 0; k < tot; k++) {
    Integer tmp = 1;
    if(tmp == 2) System.out.println("hi");
  }
  System.out.println("done");

}
}
