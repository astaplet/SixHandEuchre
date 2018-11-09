package self.anikole.euchre.data;

public class Card {
	public static enum Suit {
		HEARTS,
		SPADES,
		CLUBS,
		DIAMONDS
	}
	
	/**
	 * Represents a card's face value and numeric value
	 * @author Aleksandra
	 *
	 */
	public static enum Value {
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13),
		ACE(14);
		
		private int valueNum;
		private Value(int valueNum) {
			this.valueNum = valueNum;
		}
		
		/**
		 * @return numeric value of card's face
		 */
		public int numForValue() {
			return this.valueNum;
		}
		
	}
	
	private Suit suit;
	private Value value;
	
	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}

	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public static final int LEFT_VALUE = 15;
	public static final int RIGHT_VALUE = 16;
	
	/**
	 * Get get the value accounting for trump
	 * @param trumpSuit the trump suit for this hand
	 * @return trump adjusted card value
	 */
	public int getTrumpAccountedValue(Suit trumpSuit) {
		if (this.suit == trumpSuit && this.value == Value.JACK) {
			return RIGHT_VALUE; //this is the right
		}
		boolean thisIsLeft = false;
		if (this.value == Value.JACK) {
			switch(trumpSuit) {
			case CLUBS:
				thisIsLeft = this.suit == Suit.SPADES;
				break;
			case DIAMONDS:
				thisIsLeft = this.suit == Suit.HEARTS;
				break;
			case HEARTS:
				thisIsLeft = this.suit == Suit.DIAMONDS;
				break;
			case SPADES:
				thisIsLeft = this.suit == Suit.CLUBS;
				break;
			default:
				break;
			}
		}
		if (thisIsLeft) {
			return LEFT_VALUE; //this is the left
		}
		
		return this.value.numForValue();
	}
	
	/**
	 * Determine if this card beats another based on trump suit
	 * @param other the card we're comparing against
	 * @param trumpSuit the current trump suit
	 * @return true if we win, false if we lose
	 */
	public boolean checkTrumpAgainst(Card other, Suit trumpSuit) {
		//First handle left-specific comparisons
		int otherVal = other.getTrumpAccountedValue(trumpSuit);
		int thisVal = this.getTrumpAccountedValue(trumpSuit);
		if (otherVal == LEFT_VALUE) {
			if (this.suit != trumpSuit) {
				return false; //left trumps us
			}
			return thisVal > otherVal; //we must be the same suit, do straight comparison
		}
		else if (thisVal == LEFT_VALUE) {
			if (other.suit != trumpSuit) {
				return true; //we're trump other is not
			}
			else {
				return thisVal > otherVal;
			}
		}
		else if (this.suit != other.getSuit()) {
			//We're either trump or we lose for not following suit
			if (this.suit == trumpSuit) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			//suit is the same, straight comparison
			return thisVal > otherVal;
		}
	}
}
