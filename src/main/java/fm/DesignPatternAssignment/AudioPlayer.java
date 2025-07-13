package fm.DesignPatternAssignment;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class allows audio to be played by calling AudioPlayer.playAudio(filePath)
 * 
 */
public class AudioPlayer {

	/**
	 * Plays an audio file corresponding to the specified file path
	 * @param filePath		The file path of the audio to play
	 */
	public static void playAudio(String filePath) {
		  File audioFile = new File(filePath);
		  
		  try {
			  InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
			  AudioInputStream audioInput = AudioSystem.getAudioInputStream(inputStream);
			  Clip clip = AudioSystem.getClip();
			  clip.open(audioInput);
			  clip.start();
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		
	}
}



