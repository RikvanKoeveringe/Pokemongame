package nl.delphinity.pokemon.model.general;

import nl.delphinity.pokemon.model.area.Area;
import nl.delphinity.pokemon.model.area.Pokecenter;
import nl.delphinity.pokemon.model.battle.Battle;
import nl.delphinity.pokemon.model.item.ItemType;
import nl.delphinity.pokemon.model.trainer.Badge;
import nl.delphinity.pokemon.model.trainer.GymLeader;
import nl.delphinity.pokemon.model.trainer.Trainer;

import java.util.*;

public class Game {

	private static final ArrayList<Area> areas = new ArrayList<>();
	private static final Scanner sc = new Scanner(System.in);
	private static Trainer trainer = null;

	// set up the game in this static block
	static {

		// PEWTER City
		Pokecenter pewterCenter = new Pokecenter("Pewter City's Pokecenter");
		Area pewterCity = new Area("Pewter city", null, true, null, pewterCenter);
		pewterCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.NORMAL, PokemonType.GHOST, PokemonType.ELECTRIC, PokemonType.FIRE));

		// VIRIDIAN City
		Pokecenter viridianCenter = new Pokecenter("Viridian City's Pokecenter");
		Area viridianCity = new Area("Viridian city", null, true, pewterCity, viridianCenter);
		viridianCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.ROCK, PokemonType.DRAGON, PokemonType.FIGHTING, PokemonType.ICE, PokemonType.NORMAL));

		// PALLET Town
		Pokecenter palletCenter = new Pokecenter("Pallet Town's Pokecenter");
		Area palletTown = new Area("Pallet town", null, true, viridianCity, palletCenter);
		palletTown.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.POISON, PokemonType.PSYCHIC, PokemonType.NORMAL));

		Pokecenter cinnabarCenter = new Pokecenter("Cinnabar Island's Pokecenter");
		Area cinnabarIsland = new Area("Cinnabar Island",  null, true, palletTown, cinnabarCenter);
		cinnabarIsland.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.GROUND, PokemonType.WATER, PokemonType.ROCK, PokemonType.DRAGON, PokemonType.FIRE, PokemonType.NORMAL));
		
		Pokecenter fuchsiaCenter = new Pokecenter("fuchsia City's Pokecenter");
		Area fuchsiaCity = new Area("fuchsia City",  null, true,cinnabarIsland ,fuchsiaCenter );
		fuchsiaCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.POISON, PokemonType.NORMAL));
		
		Pokecenter celadonCenter = new Pokecenter("celadon City's Pokecenter");
		Area celadonCity = new Area("celadon City",  null, true,fuchsiaCity ,celadonCenter );
		celadonCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.NORMAL, PokemonType.POISON));
		
		Pokecenter saffronCenter = new Pokecenter("saffron City's Pokecenter");
		Area saffronCity = new Area("saffron City",  null, true,celadonCity ,saffronCenter );
		saffronCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.NORMAL, PokemonType.PSYCHIC));
		
		Pokecenter vermillionCenter = new Pokecenter("vermillion City's Pokecenter");
		Area vermillionCity = new Area("vermillion City",  null, true,saffronCity ,vermillionCenter );
		vermillionCity.setContainsPokemon(
				Arrays.asList(PokemonType.GRASS, PokemonType.FLYING, PokemonType.BUG, PokemonType.GROUND, PokemonType.WATER, PokemonType.NORMAL, PokemonType.DRAGON, PokemonType.ICE, PokemonType.ELECTRIC));
		
		
		areas.add(palletTown);
		areas.add(viridianCity);
		areas.add(pewterCity);
		areas.add(cinnabarIsland);
		areas.add(fuchsiaCity);
		areas.add(celadonCity);
		areas.add(saffronCity);
		areas.add(vermillionCity);
		

		// SETUP gym leaders
		GymLeader pewterLeader = new GymLeader("Bram", new Badge("Boulder Badge"), pewterCity);
		Pokemon p = new Pokemon(PokemonData.ONIX);
		p.setLevel(5);
		p.setOwner(pewterLeader);
		pewterLeader.setActivePokemon(p);
		pewterLeader.getPokemonCollection().add(p);
		pewterCity.setGymLeader(pewterLeader);
		
		GymLeader viridianLeader = new GymLeader("Rens", new Badge("Earth Badge"), viridianCity);
		Pokemon po = new Pokemon(PokemonData.RHYDON);
		po.setLevel(10);
		po.setOwner(viridianLeader);
		viridianLeader.setActivePokemon(po);
		viridianLeader.getPokemonCollection().add(po);
		viridianCity.setGymLeader(viridianLeader);
		
		GymLeader cinnabarLeader = new GymLeader("Gino", new Badge("Volcano Badge"), cinnabarIsland);
		Pokemon pok = new Pokemon(PokemonData.RAPIDASH);
		pok.setLevel(15);
		pok.setOwner(cinnabarLeader);
		cinnabarLeader.setActivePokemon(pok);
		cinnabarLeader.getPokemonCollection().add(pok);
		cinnabarIsland.setGymLeader(cinnabarLeader);
		
		GymLeader fuchsiaLeader = new GymLeader("Judith", new Badge("Soul Badge"), fuchsiaCity);
		Pokemon poke = new Pokemon(PokemonData.WEEZING);
		poke.setLevel(20);
		poke.setOwner(fuchsiaLeader);
		fuchsiaLeader.setActivePokemon(poke);
		fuchsiaLeader.getPokemonCollection().add(poke);
		fuchsiaCity.setGymLeader(fuchsiaLeader);
		
		GymLeader celadonLeader = new GymLeader("Cees-Jan", new Badge("Rainbow Badge"), celadonCity);
		Pokemon pokem = new Pokemon(PokemonData.VICTREEBEL);
		pokem.setLevel(25);
		pokem.setOwner(celadonLeader);
		celadonLeader.setActivePokemon(pokem);
		celadonLeader.getPokemonCollection().add(pokem);
		celadonCity.setGymLeader(celadonLeader);
		
		GymLeader saffronLeader = new GymLeader("Kees", new Badge("Marsh Badge"), saffronCity);
		Pokemon pokemo = new Pokemon(PokemonData.MRMIME);
		pokemo.setLevel(30);
		pokemo.setOwner(celadonLeader);
		saffronLeader.setActivePokemon(pokemo);
		saffronLeader.getPokemonCollection().add(pokemo);
		saffronCity.setGymLeader(saffronLeader);
		
		GymLeader vermillionLeader = new GymLeader("Esther", new Badge("Thunder Badge"), vermillionCity);
		Pokemon pokemon = new Pokemon(PokemonData.ELECTABUZZ);
		pokemon.setLevel(35);
		pokemon.setOwner(vermillionLeader);
		vermillionLeader.setActivePokemon(pokemon);
		vermillionLeader.getPokemonCollection().add(pokemon);
		vermillionCity.setGymLeader(vermillionLeader);
	}

	public static void main(String[] args) {
		System.out.println(
"                                  ,'\\\r\n" + 
"    _.----.        ____         ,'  _\\   ___    ___     ____\r\n" + 
"_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\r\n" + 
"\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\r\n" + 
" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\r\n" + 
"   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\r\n" + 
"    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\r\n" + 
"     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\r\n" + 
"      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\r\n" + 
"       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\r\n" + 
"        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\r\n" + 
"                                `'                            '-._|"
				);
		System.out.println("Welcome new trainer, what's your name?");
		String name = sc.nextLine();
		trainer = new Trainer(name, areas.get(0), 0);
		System.out.println("Hi, " + trainer.getName());

		Pokemon firstPokemon = chooseFirstPokemon();

		firstPokemon.setOwner(trainer);
		trainer.getPokemonCollection().add(firstPokemon);
		System.out.println("You now have " + trainer.getPokemonCollection().size() + " pokemon in your collection!");

		// game loop
		while (true) {
			showGameOptions();
		}
	}

	private static void showGameOptions() {
		System.out.println("What do you want to do?");
		System.out.println("1 ) Find Pokemon");
		System.out.println("2 ) My Pokemon");
		System.out.println("3 ) Inventory");
		System.out.println("4 ) Badges");
		System.out.println("5 ) Challenge " + trainer.getCurrentArea().getName() + "'s Gym Leader");
		System.out.println("6 ) Travel");
		System.out.println("7 ) Visit Pokecenter");
		System.out.println("8 ) Exit game");
		int action = sc.nextInt();
		switch (action) {
		case 1:
			findAndBattlePokemon();
			break;
		case 2:
			trainer.showPokemonColletion();
			break;
		case 3:
			ItemType item = showInventory();
			if (item != null) {
			trainer.useItem(item, null);}
			break;
		case 4:
			trainer.showBadges();
			break;
		case 5:
			if (trainer.getCurrentArea().getGymLeader() != null) {
				startGymBattle();
			} else {
				System.out.println("No Gym Leader in this town!");
			}
			break;
		case 6:
			Area area = showTravel();
			if (area != null) {
				trainer.travel(area);
			}
			break;
		case 7:
			trainer.visitPokeCenter(trainer.getCurrentArea().getPokecenter());
			break;
		case 8:
			quit();
			break;
		default:
			System.out.println("Sorry, that's not a valid option");
			break;
		}
	}

	// TODO: US-PKM-O-6
	private static void findAndBattlePokemon() {

		Pokemon randomPokemon = trainer.findPokemon();
		Battle battle = trainer.battle(trainer.getActivePokemon(), randomPokemon);
		battle.start();
	}

	private static Area showTravel() {
		Area travelTo = null;
		int index = 1;
		List<Area> travelToAreas = new ArrayList<>();

		for (Area area : areas) {
			if (!area.equals(trainer.getCurrentArea()) && area.isUnlocked()
					&& ((area.getNextArea() != null && area.getNextArea().equals(trainer.getCurrentArea()))
							|| trainer.getCurrentArea().getNextArea() != null
									&& trainer.getCurrentArea().getNextArea().equals(area))) {
				travelToAreas.add(area);
			}
		}
		for (Area a : travelToAreas) {
			System.out.println(index + ") " + a.getName());
			index++;
		}
		System.out.println(index + ") Back");
		int choice = sc.nextInt();
		if (choice != index) {
			travelTo = travelToAreas.get(choice - 1);
		}
		return travelTo;
	}

	private static ItemType showInventory() {
		HashMap<ItemType, Integer> items = trainer.getInventory().getItems();
		Set<Map.Entry<ItemType, Integer>> entries = items.entrySet();
		int index = 1;
		for (Map.Entry<ItemType, Integer> entry : entries) {
			System.out.println(index + ") " + entry.getKey() + " " + entry.getValue());
			index++;
		}
		System.out.println(index + ") Back");
		int choice = sc.nextInt();
		if (choice != index) {
			return ItemType.values()[choice - 1];
		}
		return null;
	}

	// TODO: US-PKM-O-1
	private static Pokemon chooseFirstPokemon() {
		System.out.println("Please choose one of these three pokemon");
		System.out.println("1 ) Charmander");
		System.out.println("2 ) Bulbasaur");
		System.out.println("3 ) Squirtle");

		int firstChoice = sc.nextInt();
		Pokemon chosenPokemon;
		switch (firstChoice) {
		case 1:
			chosenPokemon = new Pokemon(PokemonData.CHARMANDER);
			chosenPokemon.setLevel(5);
			trainer.setActivePokemon(chosenPokemon);
			System.out.println(PokemonData.CHARMANDER.art);
			return chosenPokemon;
		case 2:
			chosenPokemon = new Pokemon(PokemonData.BULBASAUR);
			chosenPokemon.setLevel(5);
			trainer.setActivePokemon(chosenPokemon);
			System.out.println(PokemonData.BULBASAUR.art);
			return chosenPokemon;
		case 3:
			chosenPokemon = new Pokemon(PokemonData.SQUIRTLE);
			chosenPokemon.setLevel(5);
			trainer.setActivePokemon(chosenPokemon);
			System.out.println(PokemonData.SQUIRTLE.art);
			return chosenPokemon;

		default:
			return chooseFirstPokemon();

		}
	}

	// TODO: US-PKM-O-8
	private static void startGymBattle() {

		Battle trainerBattle = trainer.challengeTrainer(Game.trainer.getCurrentArea().getGymLeader());

		if (trainerBattle != null && trainerBattle.getWinner().getOwner().equals(trainer)) {

			if (trainerBattle.getEnemy().getOwner().getClass().equals(GymLeader.class)) {

				Pokemon enemyPokemon = trainerBattle.getEnemy();
				Trainer gymLeader = enemyPokemon.getOwner();
				GymLeader gymleader = (GymLeader) gymLeader;
				gymleader.setDefeated(true);
				awardBadge(gymleader.getBadge().getName());
				System.out.println("You earned a Badge");
				Area gymLeaderArea = gymleader.getCurrentArea();
				Area nextArea = gymLeaderArea.getNextArea();

				if (nextArea != null) {
					nextArea.setUnlocked(true);
				}
			}
		}
	}

	// TODO: US-PKM-O-9
	public static void awardBadge(String badgeName) {

		Badge newBadge = new Badge(badgeName);
		trainer.addBadge(newBadge);
	}

	public static void gameOver(String message) {
		System.out.println(message);
		System.out.println("Game over");
		quit();
	}

	// TODO: US-PKM-O-2:
	private static void quit() {
		System.out.println("you quit the game...");
		//quit();

	}
}
