package self.anikole.euchre.data;

import org.junit.Test;
import org.junit.Assert;

import self.anikole.euchre.data.Card.Suit;

public class CardTest {
	@Test
	public void testComparisonsTrump() {
		Card.Suit trumpSuit = Suit.DIAMONDS;
		
		Card left = new Card(Card.Suit.HEARTS, Card.Value.JACK);
		Card right = new Card(Card.Suit.DIAMONDS, Card.Value.JACK);
		
		Assert.assertTrue(right.checkTrumpAgainst(left, trumpSuit));
		Assert.assertFalse(left.checkTrumpAgainst(right, trumpSuit));
		
		Card trumpAce = new Card(trumpSuit, Card.Value.ACE);
		
		Assert.assertTrue(right.checkTrumpAgainst(trumpAce, trumpSuit));
		Assert.assertTrue(left.checkTrumpAgainst(trumpAce, trumpSuit));
		Assert.assertFalse(trumpAce.checkTrumpAgainst(left, trumpSuit));
		Assert.assertFalse(trumpAce.checkTrumpAgainst(right, trumpSuit));
		
		Card clubAce = new Card(Card.Suit.CLUBS, Card.Value.ACE);
		Card clubKing = new Card(Card.Suit.CLUBS, Card.Value.KING);
		Card spadeAce = new Card(Card.Suit.SPADES, Card.Value.ACE);
		
		Assert.assertTrue(clubAce.checkTrumpAgainst(clubKing, trumpSuit));
		Assert.assertFalse(clubAce.checkTrumpAgainst(spadeAce, trumpSuit));
		Assert.assertFalse(clubKing.checkTrumpAgainst(spadeAce, trumpSuit));
		Assert.assertFalse(spadeAce.checkTrumpAgainst(clubAce, trumpSuit));
		Assert.assertFalse(spadeAce.checkTrumpAgainst(clubKing, trumpSuit));
		
		Assert.assertTrue(left.checkTrumpAgainst(clubAce, trumpSuit));
		Assert.assertTrue(left.checkTrumpAgainst(spadeAce, trumpSuit));
		Assert.assertTrue(right.checkTrumpAgainst(clubAce, trumpSuit));
		Assert.assertTrue(right.checkTrumpAgainst(spadeAce, trumpSuit));
	}
	
	@Test
	public void testHigh() {
		Card jackOfClubs = new Card(Card.Suit.CLUBS, Card.Value.JACK);
		Card kingOfClubs = new Card(Card.Suit.CLUBS, Card.Value.KING);
		Card aceOfDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
		
		Assert.assertTrue(kingOfClubs.checkHighAgainst(jackOfClubs));
		Assert.assertFalse(jackOfClubs.checkHighAgainst(kingOfClubs));
		Assert.assertFalse(kingOfClubs.checkHighAgainst(aceOfDiamonds));
		Assert.assertFalse(aceOfDiamonds.checkHighAgainst(jackOfClubs));
	}
	
	@Test
	public void testLow() {
		Card jackOfClubs = new Card(Card.Suit.CLUBS, Card.Value.JACK);
		Card kingOfClubs = new Card(Card.Suit.CLUBS, Card.Value.KING);
		Card aceOfDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
		
		Assert.assertFalse(kingOfClubs.checkLowAgainst(jackOfClubs));
		Assert.assertTrue(jackOfClubs.checkLowAgainst(kingOfClubs));
		Assert.assertFalse(kingOfClubs.checkLowAgainst(aceOfDiamonds));
		Assert.assertFalse(aceOfDiamonds.checkLowAgainst(jackOfClubs));
	}
}
