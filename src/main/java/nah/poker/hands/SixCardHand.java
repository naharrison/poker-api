package nah.poker.hands;

import nah.poker.cards.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SixCardHand {

  public ArrayList<Card> cards;


  public SixCardHand(ArrayList<Card> cards) {
    this.cards = cards;
  }
  public SixCardHand(Card... cards) {
    this(new ArrayList<Card>(Arrays.asList(cards)));
  }


  public ArrayList<FiveCardHand> getFiveCardHands() {
    ArrayList<FiveCardHand> fiveCardHands = new ArrayList<>();
    for(int k = 0; k < 6; k++) {
      ArrayList<Card> fiveCards = new ArrayList<>();
      for(int j = 0; j < 6; j++) {
        if(j != k) fiveCards.add(cards.get(j));
      }
      FiveCardHand fiveCardHand = new FiveCardHand(fiveCards);
      fiveCardHands.add(fiveCardHand);
    }
    return fiveCardHands;
  }


  public static void main(String[] args) {
    Card cAS = new Card(CardNumber.ACE, CardSuit.SPADE);
    Card cKS = new Card(CardNumber.KING, CardSuit.SPADE);
    Card cQS = new Card(CardNumber.QUEEN, CardSuit.SPADE);
    Card cJS = new Card(CardNumber.JACK, CardSuit.SPADE);
    Card c10S = new Card(CardNumber.TEN, CardSuit.SPADE);
    Card cJH = new Card(CardNumber.JACK, CardSuit.HEART);

    SixCardHand h = new SixCardHand(cAS, cKS, cQS, cJS, c10S, cJH);
    for(FiveCardHand hand : h.getFiveCardHands()) {
      for(int k = 0; k < 5; k++) System.out.println(hand.cards.get(k).toString());
      System.out.println("");
    }
  }

}
