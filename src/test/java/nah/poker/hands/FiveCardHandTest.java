package nah.poker.hands;

import nah.poker.cards.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class FiveCardHandTest {

  @Test
  public void test1() {

    Card cAS = new Card(CardNumber.ACE, CardSuit.SPADE);
    Card cKS = new Card(CardNumber.KING, CardSuit.SPADE);
    Card cQS = new Card(CardNumber.QUEEN, CardSuit.SPADE);
    Card cJS = new Card(CardNumber.JACK, CardSuit.SPADE);
    Card c10S = new Card(CardNumber.TEN, CardSuit.SPADE);
    Card c2S = new Card(CardNumber.TWO, CardSuit.SPADE);

    Card c2H = new Card(CardNumber.TWO, CardSuit.HEART);
    Card c3H = new Card(CardNumber.THREE, CardSuit.HEART);
    Card c4H = new Card(CardNumber.FOUR, CardSuit.HEART);
    Card c5H = new Card(CardNumber.FIVE, CardSuit.HEART);
    Card c6H = new Card(CardNumber.SIX, CardSuit.HEART);

    Card c2C = new Card(CardNumber.TWO, CardSuit.CLUB);
    Card c3C = new Card(CardNumber.THREE, CardSuit.CLUB);
    Card c4C = new Card(CardNumber.FOUR, CardSuit.CLUB);
    Card c5C = new Card(CardNumber.FIVE, CardSuit.CLUB);
    Card c6C = new Card(CardNumber.SIX, CardSuit.CLUB);

    Card c2D = new Card(CardNumber.TWO, CardSuit.DIAMOND);
    Card c3D = new Card(CardNumber.THREE, CardSuit.DIAMOND);
    Card c4D = new Card(CardNumber.FOUR, CardSuit.DIAMOND);
    Card c5D = new Card(CardNumber.FIVE, CardSuit.DIAMOND);
    Card c6D = new Card(CardNumber.SIX, CardSuit.DIAMOND);

    FiveCardHand h1 = new FiveCardHand(cAS, cKS, cQS, cJS, c10S);
    assertEquals(h1.isFlush(), true);
    assertEquals(h1.isStraight(), true);
    assertEquals(h1.isFourOfAKind(), false);
    assertEquals(h1.isFullHouse(), false);
    assertEquals(h1.isThreeOfAKind(), false);
    assertEquals(h1.isTwoPair(), false);
    assertEquals(h1.isPair(), false);

    FiveCardHand h2 = new FiveCardHand(cAS, c2S, c2D, c2C, c2H);
    assertEquals(h2.isFlush(), false);
    assertEquals(h2.isStraight(), false);
    assertEquals(h2.isFourOfAKind(), true);

    FiveCardHand h3 = new FiveCardHand(c3D, c3C, c2D, c2C, c2H);
    assertEquals(h3.isFullHouse(), true);
    assertEquals(h3.isThreeOfAKind(), true);
    assertEquals(h3.isTwoPair(), true);
    assertEquals(h3.isPair(), true);

  }


}
