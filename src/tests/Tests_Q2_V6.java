package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.Test;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;
import model.characters.Character;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.world.Cell;
import model.world.CharacterCell;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class Tests_Q2_V6 {

	String characterPath = "model.characters.Character";
	String collectiblePath = "model.collectibles.Collectible";
	String vaccinePath = "model.collectibles.Vaccine";
	String supplyPath = "model.collectibles.Supply";
	String fighterPath = "model.characters.Fighter";

	private String charCell = "model.world.CharacterCell";
	private String cellPath = "model.world.Cell";
	private String collectibleCellPath = "model.world.CollectibleCell";
	private String trapCellPath = "model.world.TrapCell";
	private String enumDirectionPath = "model.characters.Direction";

	String gamePath = "engine.Game";
	String medicPath = "model.characters.Medic";
	String explorerPath = "model.characters.Explorer";
	String heroPath = "model.characters.Hero";

	String gameActionExceptionPath = "exceptions.GameActionException";
	String invalidTargetExceptionPath = "exceptions.InvalidTargetException";
	String movementExceptionPath = "exceptions.MovementException";
	String noAvailableResourcesExceptionPath = "exceptions.NoAvailableResourcesException";
	String notEnoughActionsExceptionPath = "exceptions.NotEnoughActionsException";

	String zombiePath = "model.characters.Zombie";
	String agentPath = "model.characters.Agent";
	String militantPath = "model.characters.Militant";
	String revolutionaryPath = "model.characters.Revolutionary";

	public void generateGameWithCharacter(Character c1, Character c2, Point p1, Point p2) throws IllegalArgumentException, IllegalAccessException {
		Hero h = new Medic("Medic", 100, 10, 2);
		Game.startGame(h);
		for (int i = 0; i < Game.map.length; i++) {
			for (int j = 0; j < Game.map[i].length; j++) {
				Game.map[i][j] = new CharacterCell(null);
			}
		}
		Class agentClass = null;
		try {
			agentClass = Class.forName(agentPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Agent not found.", true);
		}

		Field f = null;

		try {
			f = Game.class.getDeclaredField("agents");
		} catch (NoSuchFieldException e) {
			assertFalse("Attribute agents not found.", true);
		} catch (SecurityException e) {
			assertFalse("Attribute agents not found.", true);
		}

		f.setAccessible(true);

		ArrayList<Object> agents = (ArrayList<Object>)f.get(null);


		Game.heroes.clear();
		Game.zombies.clear();
		agents.clear();

		Game.map[p1.x][p1.y] = new CharacterCell(c1);
		Game.map[p2.x][p2.y] = new CharacterCell(c2);
		c1.setLocation(p1);
		c2.setLocation(p2);

		if (c1 instanceof Hero) {
			Game.heroes.add((Hero) c1);
		} else if (c1 instanceof Zombie) {
			Game.zombies.add((Zombie) c1);
		}else
		{
			agents.add(c1);
		}

		if (c2 instanceof Hero) {
			Game.heroes.add((Hero) c2);
		} else if (c2 instanceof Zombie) {
			Game.zombies.add((Zombie) c2);
		}else
		{
			agents.add(c2);
		}
	}

	@Test(timeout = 100)
	public void testGameStartAddsAgentsCorrectly() throws IllegalArgumentException, IllegalAccessException
	{
		Field f = null;
		try {
			f = Game.class.getDeclaredField("agents");
		} catch (NoSuchFieldException e) {
			assertFalse("Attribute agents not found.", true);
		} catch (SecurityException e) {
			assertFalse("Attribute agents not found.", true);
		}

		f.setAccessible(true);

		ArrayList<Object> agents = (ArrayList<Object>)f.get(null);

		agents.clear();
		Hero h = new Medic("Medic", 100, 10, 2);
		Game.startGame(h);
		
		assertEquals("Game should have 2 agents.", 2, agents.size());

		int countMilitant = 0;
		int countRevolutionary = 0;
		boolean foundFriendly = false;
		boolean foundUnfriendly = false;

		for (Object o : agents) {
			if (o.getClass().getName().equals(revolutionaryPath)) {
				countRevolutionary++;
			}
			if (o.getClass().getName().equals(revolutionaryPath)) {
				try {
					Method m = o.getClass().getDeclaredMethod("isFriendly");
					if ((boolean)m.invoke(o)) {
						foundFriendly = true;
					}
					else {
						foundUnfriendly = true;
					}
				} catch (NoSuchMethodException e) {
					assertTrue("The attribute friendly should be a Read attribute.", false);
				} catch (SecurityException e) {
					assertTrue("The attribute friendly should be a Read attribute.", false);
				} catch (InvocationTargetException e) {
					assertTrue("The attribute friendly should be a Read attribute.", false);
				}
			}
		}
		assertEquals("Game should have 2 Revolutionaries.", 2, countRevolutionary);
		assertTrue("Game should have 1 Revolutionary that is friendly.", foundFriendly);
		assertTrue("Game should have 1 Revolutionary that is unfriendly.", foundUnfriendly);
	}

	@Test(timeout = 100)
	public void testFriendlyRevolutionaryShouldNotAttackHero() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(true);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(r, h, new Point(0, 1), new Point(0, 0));
		Game.endTurn();
		assertEquals("Friendly Revolutionary should not attack hero.", 100, h.getCurrentHp());
	}

	@Test(timeout = 100)
	public void testUnFriendlyRevolutionaryShouldAttackHero() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(false);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(h, r, new Point(0, 0), new Point(0, 1));
		Game.endTurn();
		assertEquals("UnFriendly Revolutionary should attack hero.", 60, h.getCurrentHp());
		Field f = null;

	}

	

	@Test(timeout = 100)
	public void testRevolutionaryShouldNotAttackRevolutionary() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructorr = null;
		try {
			constructorr = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character rt1 = (Character) constructorr.newInstance(true);
		Character rf1 = (Character) constructorr.newInstance(false);
		Character rt2 = (Character) constructorr.newInstance(true);
		Character rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rt1, rt2, new Point(0, 0), new Point(0, 1));
		Game.endTurn();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt2.getCurrentHp());
		rt1 = (Character) constructorr.newInstance(true);
		rf1 = (Character) constructorr.newInstance(false);
		rt2 = (Character) constructorr.newInstance(true);
		rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rt1, rf2, new Point(0, 0), new Point(0, 1));
		Game.endTurn();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf2.getCurrentHp());
		rt1 = (Character) constructorr.newInstance(true);
		rf1 = (Character) constructorr.newInstance(false);
		rt2 = (Character) constructorr.newInstance(true);
		rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rf1, rf2, new Point(0, 0), new Point(0, 1));
		Game.endTurn();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf2.getCurrentHp());
	}
	

	
	@Test(timeout = 100)
	public void testHeroCanAttackUnFriendlyRevolutionary() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(false);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(h, r, new Point(0, 0), new Point(0, 1));
		h.setTarget(r);
		h.attack();
		assertEquals("Hero should able to attack an unfriendly Revolutionary.", 90, r.getCurrentHp());
	}

	@Test(timeout = 100)
	public void testHeroCanNotAttackFriendlyRevolutionary() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(true);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(h, r, new Point(0, 0), new Point(0, 1));
		h.setTarget(r);
		try{
			h.attack();
			fail("Hero should not be able to attack a friendly Revolutionary. expected InvalidTargetException");
		}catch(InvalidTargetException e){
		}
	}

	
	@Test(timeout = 100)
	public void testFriendlyRevolutionaryShouldNotAttackHeroinAttack() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(true);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(r, h, new Point(0, 1), new Point(0, 0));
		r.attack();
		assertEquals("Friendly Revolutionary should not attack hero.", 100, h.getCurrentHp());
	}

	@Test(timeout = 100)
	public void testUnFriendlyRevolutionaryShouldAttackHeroinAttack() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructor = null;
		try {
			constructor = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character r = (Character) constructor.newInstance(false);
		Character h = new Medic("Medic", 100, 10, 2);
		generateGameWithCharacter(h, r, new Point(0, 0), new Point(0, 1));
		r.attack();
		assertEquals("UnFriendly Revolutionary should attack hero.", 60, h.getCurrentHp());
		Field f = null;

	}

	

	@Test(timeout = 100)
	public void testRevolutionaryShouldNotAttackRevolutionaryinAttack() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotEnoughActionsException, InvalidTargetException
	{
		Class revolutionaryClass = null;
		try {
			revolutionaryClass = Class.forName(revolutionaryPath);
		} catch (ClassNotFoundException e) {
			assertFalse("Class Revolutionary not found.", true);
		}

		Constructor constructorr = null;
		try {
			constructorr = revolutionaryClass.getConstructor(boolean.class);
		} catch (NoSuchMethodException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		} catch (SecurityException e) {
			assertTrue("Constructor of Revolutionary not found.", false);
		}

		Character rt1 = (Character) constructorr.newInstance(true);
		Character rf1 = (Character) constructorr.newInstance(false);
		Character rt2 = (Character) constructorr.newInstance(true);
		Character rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rt1, rt2, new Point(0, 0), new Point(0, 1));
		rt1.attack();
		rt2.attack();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt2.getCurrentHp());
		rt1 = (Character) constructorr.newInstance(true);
		rf1 = (Character) constructorr.newInstance(false);
		rt2 = (Character) constructorr.newInstance(true);
		rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rt1, rf2, new Point(0, 0), new Point(0, 1));
		rt1.attack();
		rf2.attack();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rt1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf2.getCurrentHp());
		rt1 = (Character) constructorr.newInstance(true);
		rf1 = (Character) constructorr.newInstance(false);
		rt2 = (Character) constructorr.newInstance(true);
		rf2 = (Character) constructorr.newInstance(false);
		generateGameWithCharacter(rf1, rf2, new Point(0, 0), new Point(0, 1));
		rf1.attack();
		rf2.attack();
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf1.getCurrentHp());
		assertEquals("Revolutionary should not attack Revolutionary.", 100, rf2.getCurrentHp());
	}
	

}
