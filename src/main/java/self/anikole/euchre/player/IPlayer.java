package self.anikole.euchre.player;

import java.util.List;
import java.util.Optional;

import self.anikole.euchre.data.Bid;
import self.anikole.euchre.data.Bid.BidType;
import self.anikole.euchre.data.Card;
import self.anikole.euchre.data.Card.Suit;

/**
 * The basic functions required of a player
 * in a euchre game
 * @author Aleksandra
 *
 */
public interface IPlayer {
	/**
	 * Set the player's hand to start a round
	 * @param hand the player's hand
	 */
	public void setHand(List<Card> hand);
	
	/**
	 * Play a card for your turn in the trick
	 * @return the card to play
	 */
	public Card takeTurn();
	
	/**
	 * Give a card to your teammate who is shooting
	 * @param type the type of shoot
	 * @param givenCard the card your teammate gave you
	 * @param trumpSuit the trump suit if shoot type is trump
	 * @return a Card for your teammate
	 */
	public Card giveCardForShoot(BidType type, Card givenCard, Optional<Suit> trumpSuit);
	
	/**
	 * Indicate to the dealer/drive that you are shooting. Invoked before bid is requested
	 * @return true if shooting
	 */
	public boolean isShooting();
	
	/**
	 * Declare the shoot type
	 * @return the shoot type
	 */
	public BidType declareShootType();
	
	/**
	 * @return the suit of your shoot
	 */
	public Suit declareShootSuit();
	
	/**
	 * @return the first card to give to a player
	 */
	public Card giveFirstCard();
	
	/**
	 * @return the second card to give to a player
	 */
	public Card giveSecondCard();
	
	//TODO: how to allow to select a player?
	
	/**
	 * @param card the first card received from a teammate for your shoot
	 */
	public void receiveFirstCard(Card card);
	
	/**
	 * @param card the second card received from a teammate for your shoot
	 */
	public void receiveSecondCard(Card card);
	
	/**
	 * @return A pair representing your 
	 */
	public Bid getBid();
}
