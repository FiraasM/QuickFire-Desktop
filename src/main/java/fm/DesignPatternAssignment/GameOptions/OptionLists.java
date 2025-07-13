package fm.DesignPatternAssignment.GameOptions;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
/**
 * This class stores a list of options the game can pick
 */
public class OptionLists {
	private static OptionLists instance = null;
	private ArrayList<GameOptions> options;
	
	/**
	 * Only one instance is needed and multiple instance of them would take up a large amount of memory
	 * @return	The list of options
	 */
	public static OptionLists getInstance() {
		
		if(instance == null) {
			instance = new OptionLists();
		}
		
		return instance;
	}
	
	private OptionLists() {
		options = new ArrayList<GameOptions>();
		populateOptionLists();
	} 
	
	/**
	 * This is where questions and answers are coded into
	 * OptionList consists of 'GameOption' instances
	 */
	private void populateOptionLists() {
		//Question are initialised like this:
		//new GameOptions( Question, 4 options, then the colour corresponding to the correct answer)
		//The option colour are ordered this way:
		//Red, green, blue, yellow
		options.add(new GameOptions("What is the chemical symbol for gold?", "Au", "Ag", "H", "O", Color.RED));
		options.add(new GameOptions("What is the chemical symbol for hydrogen?", "Au", "Ag", "H", "O", Color.BLUE));
		options.add(new GameOptions("What is the chemical symbol for silver?", "Au", "Ag", "H", "O", Color.GREEN));
		options.add(new GameOptions("What is the chemical symbol for oxygen?", "Au", "Ag", "H", "O", Color.YELLOW));
		options.add(new GameOptions("What is the main gas that we breathe in?", "Carbon dioxide", "Oxygen", "Helium", "Nitrogen", Color.GREEN));
		options.add(new GameOptions("What do we call the tiny particles that make up everything around us?", "Atoms", "Bugs", "Balls", "Dust", Color.RED));
		options.add(new GameOptions("What is the opposite of melting?", "Boiling", "Freezing", "Evaporating", "Dissolving", Color.GREEN));
		options.add(new GameOptions("What do plants need to make their own food?", "Water and air", "Sunlight and water", "Soil and air", "Sunlight and soil", Color.GREEN));
		options.add(new GameOptions("What do we call the process of a liquid turning into a gas?", "Freezing", "Melting", "Condensation", "Evaporation", Color.YELLOW));
		options.add(new GameOptions("What makes a ball fall to the ground when you drop it?", "Magic", "Gravity", "Air", "Magnets", Color.GREEN));
		options.add(new GameOptions("What is the name of the force that pulls objects toward the center of the Earth?", "Magnetism", "Friction", "Gravity", "Elasticity", Color.BLUE));
		options.add(new GameOptions("What do you call the energy that an object has because of its motion?", "Light", "Sound", "Heat", "Kinetic energy", Color.YELLOW));
		options.add(new GameOptions("What is the chemical formula for water?", "H2O", "CO2", "NaCl", "CH4", Color.RED));
		options.add(new GameOptions("Which of these elements is essential for making plants green?", "Carbon", "Oxygen", "Nitrogen", "Chlorophyll", Color.YELLOW));
		options.add(new GameOptions("What is the main ingredient in baking soda?", "Sodium chloride", "Calcium carbonate", "Sodium bicarbonate", "Potassium bicarbonate", Color.BLUE));
		options.add(new GameOptions("Which of these is a liquid at room temperature?", "Iron", "Oxygen", "Mercury", "Carbon dioxide", Color.BLUE));
		options.add(new GameOptions("What gives lemons their sour taste?", "Citric acid", "Lactic acid", "Acetic acid", "Tartaric acid", Color.RED));
		options.add(new GameOptions("What happens to water when it gets cold enough?", "It freezes", "It boils", "It evaporates", "It condenses", Color.RED));
		options.add(new GameOptions("What color does litmus paper turn in an acidic solution?", "Red", "Green", "Blue", "Yellow", Color.RED));
		options.add(new GameOptions("What is the name of the gas that make drinks fizzy?", "Oxygen", "Nitrogen", "Hydrogen", "Carbon dioxide", Color.YELLOW));
		options.add(new GameOptions("What is the unit of measurement for time?", "Kilogram", "Ampere", "Second", "Meter", Color.BLUE));
		options.add(new GameOptions("Which of the following materials is a good conductor of electricity?", "Wood", "Plastic", "Copper", "Rubber", Color.BLUE));
		options.add(new GameOptions("What is the formula to calculate speed?", "Speed = Distance × Time", "Speed = Time / Distance", "Speed = Distance / Time", "Speed = Time × Distance", Color.BLUE));
		options.add(new GameOptions("Which of the following is a unit of measurement for electric current?", "Volt", "Newton", "Watt", "Ampere", Color.YELLOW));
		options.add(new GameOptions("What is the unit of force?", "Newton", "Joule", "Watt", "Pascal", Color.RED));
		options.add(new GameOptions("What law states that every action has an equal and opposite reaction?", "Newton's First Law", "Newton's Second Law", "Newton's Third Law", "Kepler's Law", Color.BLUE));
		options.add(new GameOptions("Which of the following is the powerhouse of the cell?", "Mitochondria", "Nucleus", "Golgi apparatus", "Endoplasmic reticulum", Color.RED));
		options.add(new GameOptions("What is the process by which plants make their own food?", "Photosynthesis", "Respiration", "Fermentation", "Transpiration", Color.RED));
		options.add(new GameOptions("Which of the following organs is responsible for filtering waste from the blood?", "Kidney", "Liver", "Heart", "Pancreas", Color.RED));
		options.add(new GameOptions("What is the primary function of red blood cells in the body?", "Carrying oxygen", "Fighting infections", "Digesting food", "Producing hormones", Color.RED));
		options.add(new GameOptions("Which of the following is the largest organ in the human body?", "Heart", "Skin", "Brain", "Liver", Color.GREEN));
		options.add(new GameOptions("What is the primary function of the respiratory system?", "Pumping blood", "Exchanging gases", "Digesting food", "Producing urine", Color.GREEN));
		options.add(new GameOptions("What is the main function of the skeletal system?", "Pumping blood", "Digesting food", "Protecting internal organs", "Producing urine", Color.BLUE));
		options.add(new GameOptions("Which of the following is a renewable source of energy?", "Coal", "Natural gas", "Solar power", "Petroleum", Color.BLUE));
		options.add(new GameOptions("What is the freezing point of water on the Celsius scale?", "0°C", "100°C", "32°C", "-273°C", Color.RED));
		options.add(new GameOptions("What is the boiling point of water on the Celsius scale?", "0°C", "100°C", "32°C", "-273°C", Color.GREEN));
		options.add(new GameOptions("What is the study of earthquakes called?", "Meteorology", "Seismology", "Geology", "Astronomy", Color.GREEN));
		options.add(new GameOptions("Which of the following is NOT a state of matter?", "Solid", "Liquid", "Gas", "Light", Color.YELLOW));
		options.add(new GameOptions("What is the chemical symbol for iron?", "Au", "Ag", "Cu", "Fe", Color.YELLOW));
		options.add(new GameOptions("Which of the following is NOT a part of the solar system?", "Neptune", "Jupiter", "Venus", "Andromeda", Color.YELLOW));
		options.add(new GameOptions("What is the unit of measurement for electrical resistance?", "Volt", "Ampere", "Watt", "Ohm", Color.YELLOW));
		
	}
	
	
	/**
	 * Picks one question from a list
	 * @return	The option to display on the UI
	 */
	public GameOptions getRandomOption() {
		int listSize = options.size();
		Random random = new Random();
		return options.get(random.nextInt(listSize));
		
		}
	
	public GameOptions getLastOption() {
		int listSize = options.size();
		return options.get(listSize - 1);
		}
	
	
	
}
