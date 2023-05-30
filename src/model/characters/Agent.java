package model.characters;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

public abstract class Agent extends Character {
	
	public Agent (String name, int maxHP, int attackDmg) {
		super(name,maxHP,attackDmg);
	}
	
	public abstract void attack() throws NotEnoughActionsException,InvalidTargetException;

}
