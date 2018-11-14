/* Note: the boolean is...() methods (e.g. isStraight()) should work fine in real life scenarios
 * but haven't been thoroughly tested for un-realistic scenarios.
 * e.g. isTwoPair() might return false for a 4-of-a-kind hand although it's technically also 2-pair,
 * not sure what will happen for 5-of-a-kind hands, etc.
*/

package nah.poker.hands;

import nah.poker.cards.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FiveCardHand {

  public ArrayList<Card> cards;


  public FiveCardHand(ArrayList<Card> cards) {
    this.cards = cards;
    sort();
  }
  public FiveCardHand(Card... cards) {
    this(new ArrayList<Card>(Arrays.asList(cards)));
  }


  private void sort() { // using bubble sort algorithm
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 4-i; j++) {
        if(cards.get(j).getNumber().getPower() > cards.get(j+1).getNumber().getPower()) Collections.swap(cards, j, j+1);
      }
    }
  }


  public HandPowerType getHandPowerType() {
    if(isFlush() == true && isStraight() == true) return HandPowerType.STRAIGHT_FLUSH;
    else if(isFourOfAKind() == true) return HandPowerType.FOUR_OF_A_KIND;
    else if(isFullHouse() == true) return HandPowerType.FULL_HOUSE;
    else if(isFlush() == true) return HandPowerType.FLUSH;
    else if(isStraight() == true) return HandPowerType.STRAIGHT;
    else if(isThreeOfAKind() == true) return HandPowerType.THREE_OF_A_KIND;
    else if(isTwoPair() == true) return HandPowerType.TWO_PAIR;
    else if(isPair() == true) return HandPowerType.ONE_PAIR;
    else return HandPowerType.HIGH_CARD;
  }


  public boolean isFlush() {
    CardSuit flushSuit = cards.get(0).getSuit();
    for(int k = 1; k < 5; k++) {
      if(cards.get(k).getSuit() != flushSuit) return false;
    }
    return true;
  }


  public boolean isStraight() {
    // check explicitly for A-5 straight:
    if(cards.get(4).getNumber().getPower() == CardNumber.ACE.getPower() &&
        cards.get(0).getNumber().getPower() == CardNumber.TWO.getPower() &&
        cards.get(1).getNumber().getPower() == CardNumber.THREE.getPower() &&
        cards.get(2).getNumber().getPower() == CardNumber.FOUR.getPower() &&
        cards.get(3).getNumber().getPower() == CardNumber.FIVE.getPower()) return true;

    // check if all powers are consecutive
    for(int k = 0; k < 4; k++) {
      if(cards.get(k+1).getNumber().getPower() != cards.get(k).getNumber().getPower()+1) return false;
    }
    return true;
  }


  public HashMap<CardNumber, Integer> getCardNumberMultiplicities() {
    HashMap<CardNumber, Integer> mults = new HashMap<CardNumber, Integer>();
    for(Card card : cards) {
      CardNumber cn = card.getNumber();
      if(!mults.containsKey(cn)) mults.put(cn, 1);
      else mults.replace(cn, mults.get(cn)+1);
    }
    return mults;
  }


  public boolean isFourOfAKind() {
    HashMap<CardNumber, Integer> mults = getCardNumberMultiplicities();
    for(Integer mult : mults.values()) {
      if(mult.equals(4)) return true;
    }
    return false;
  }


  public boolean isFullHouse() {
    HashMap<CardNumber, Integer> mults = getCardNumberMultiplicities();
    if(mults.size() == 2) {
      ArrayList<Integer> vals = new ArrayList<Integer>(mults.values());
      int mult0 = vals.get(0);
      int mult1 = vals.get(1);
      if((mult0 == 2 && mult1 == 3) || (mult0 == 3 && mult1 == 2)) return true;
    }
    return false;
  }


  public boolean isThreeOfAKind() {
    HashMap<CardNumber, Integer> mults = getCardNumberMultiplicities();
    for(Integer mult : mults.values()) {
      if(mult.equals(3)) return true;
    }
    return false;
  }


  public boolean isTwoPair() {
    HashMap<CardNumber, Integer> mults = getCardNumberMultiplicities();
    if(mults.size() == 3 || mults.size() == 2) {
      for(Integer mult : mults.values()) {
        if(mult.equals(2)) return true;
      }
    }
    return false;
  }


  public boolean isPair() {
    HashMap<CardNumber, Integer> mults = getCardNumberMultiplicities();
    for(Integer mult : mults.values()) {
      if(mult.equals(2)) return true;
    }
    return false;
  }


}
