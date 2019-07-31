package self.anikole.euchre.server;

/**
 * Function definitions for running a euchre server
 * @author aleksandra
 *
 */
public interface IEuchreServer {
	
	public EuchreSession startNewGame();
	
	public EuchreSession joinExistingGame(EuchreSession existingGameData);
	
}
