package self.anikole.euchre.data;

import java.util.Optional;

import self.anikole.euchre.data.Card.Suit;

/**
 * A bid in a game of euchre
 * @author Aleksandra
 *
 */
public class Bid {
	/**
	 * The type of bid a player has declared
	 * @author Aleksandra
	 *
	 */
	public static enum BidType {
		HIGH,
		LOW,
		TRUMP
	}
	
	private BidType bidType;
	private Optional<Suit> bidSuit = Optional.empty();
	private int bidAmount;
	
	/**
	 * @param bidType the type of bid
	 * @param suit the suit of the bid if needed
	 * @param bidAmount the amount of the bid
	 */
	public Bid(BidType bidType, Optional<Suit> suit, int bidAmount) {
		this.bidAmount = bidAmount;
		this.bidType = bidType;
		this.bidSuit = suit;
	}

	/**
	 * @return the bidType
	 */
	public BidType getBidType() {
		return bidType;
	}

	/**
	 * @return the bidSuit
	 */
	public Optional<Suit> getBidSuit() {
		return bidSuit;
	}

	/**
	 * @return the bidAmount
	 */
	public int getBidAmount() {
		return bidAmount;
	}
}
