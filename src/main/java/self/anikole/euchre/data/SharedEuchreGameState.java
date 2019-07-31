package self.anikole.euchre.data;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Game state that can be sent from the server to the client to display current state to the user
 * @author aleksandra
 *
 */
public abstract class SharedEuchreGameState {
	
	private long teamOneScore = 0;
	private long teamTwoScore = 0;
	
	private boolean gameFinished = false;
	
	private Optional<Team> winningTeam = Optional.empty();
	
	
	/**
	 * Identifies the teams in the game
	 * @author aleksandra
	 *
	 */
	public enum Team {
		ONE,
		TWO
	};
	
	/**
	 * @return the teamOneScore
	 */
	public long getTeamOneScore() {
		return teamOneScore;
	}

	/**
	 * @return the teamTwoScore
	 */
	public long getTeamTwoScore() {
		return teamTwoScore;
	}

	/**
	 * @return the gameFinished
	 */
	public boolean isGameFinished() {
		return gameFinished;
	}

	/**
	 * @return the winningTeam
	 */
	public Optional<Team> getWinningTeam() {
		return winningTeam;
	}
	
	/**
	 * @return The list of player names
	 */
	public abstract List<String> getPlayerNames();
	
	/**
	 * @return a list of {@link Pair}s of player names and cards played this round
	 */
	public abstract List<Pair<String, Card>> getMovesForCurrentRound();
	
	/**
	 * @return a {@link Pair} containing the player name and card that is currently taking the trick
	 */
	public abstract Pair<String, Card> getCurrentWinningMove();
}
