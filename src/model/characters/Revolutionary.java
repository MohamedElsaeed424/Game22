package model.characters;

import java.awt.Point;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

public class Revolutionary extends Agent {
	private boolean friendly;

	public Revolutionary(boolean friendly) {
		super("Givara", 100, 40);
		this.friendly = friendly;
	}

	public boolean isFriendly() {
		return friendly;
	}


	@Override
	public void attack() throws NotEnoughActionsException, InvalidTargetException {
		if (this.getTarget() instanceof Revolutionary){
			throw  new InvalidTargetException();
		}
		if((this.isFriendly() && this.getTarget() instanceof Hero )){
			throw  new InvalidTargetException();
		}
	}
}
