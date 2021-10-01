package soundPlayer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class SoundPlayer {
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		homeScreen();
		
	}
	  static void selector(String wave) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		  	Scanner reader = new Scanner(System.in);
		  	File file = new File(wave);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			
			String response = "";
			
			
			while(!response.equals("Q")) {
				System.out.println("P = play, S = stop, R = reset, H = home Q = quit");
				System.out.print("Enter your Choice ");
				response = reader.next();
				response = response.toUpperCase();
				switch(response ) {
				case("P"): clip.start();
				break;
				case("S"): clip.stop();
				break;
				case("R"): clip.setMicrosecondPosition(0);
				break;
				case("H"): homeScreen();
				break;
				case("Q"): clip.close();
				break;
				default: System.out.println("Not a Valid Choice!");
				}
			}
			System.out.println(" Exited Player");
//			scanner.close();
		}
	  static void homeScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			Scanner scanner = new Scanner(System.in);
			
			String[] waves = {"life_moves_fast.wav", "conan_best_in_life.wav"};
			System.out.println("1: Ferris , 2: Conan");
			System.out.println("Select A Wave: 1 or 2 ");
			int wave = Integer.valueOf(scanner.nextLine());
			if(wave != 1 && wave != 2) {
				wave = 1;
			} 
			selector(waves[wave - 1]);
	  }

}
