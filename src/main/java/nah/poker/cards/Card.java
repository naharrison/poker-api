package nah.poker.cards;

public class Card implements Comparable<Card> {

  private final CardSuit suit;
  private final CardNumber number;

  public Card(final CardNumber number, final CardSuit suit) {
    this.suit = suit;
    this.number = number;
  }

  @Override
  public String toString() {
    return number.toString() + suit.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Card)) {
      return false;
    }

    Card other = (Card) obj;

    return suit.equals(other.suit) && number.equals(other.number);
  }

  
  public int compareTo(Card card) {
    return number.getPower() - card.number.getPower();
  }

  public CardSuit getSuit() {
    return suit;
  }

  public CardNumber getNumber() {
    return number;
  }

}
