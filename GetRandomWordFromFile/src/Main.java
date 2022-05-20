import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static File myObj = new File("C:\\Users\\Legion\\git\\MyProjects\\GetRandomWordFromFile\\src\\Words.txt");

    public static void main(String[] args) throws IOException {
	
	createFile();
	addWord();
	getRandomWord();
	  
	  

    }

    private static void addWord() throws IOException {
	Scanner scan = new Scanner(System.in);
	String scannedWord = scan.next();
	//System.out.println(scannedWord.length());
	BufferedWriter bufferredWriter = new BufferedWriter(new FileWriter(myObj, true));
	PrintWriter printWriter = new PrintWriter(bufferredWriter);
	//printWriter.println();
	//printWriter.println(scannedWord);
	
	printWriter.close();
    }

    private static void createFile() {
	try {
	      //File myObj = new File("C:\\Users\\Legion\\git\\MyProjects\\GetRandomWordFromFile\\src\\Words.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.\n");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
    }

    private static void getRandomWord() {
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Legion\\git\\MyProjects\\GetRandomWordFromFile\\src\\Words.txt"));
	    String line = reader.readLine();
	    List<String> words = new ArrayList<String>();
	    
	    while(line!=null) {
		String[] wordsLine = line.split(" ");
		for(String word : wordsLine) {
		  // System.out.println(word);
		    words.add(word);
		   
		} 
		line = reader.readLine();
	    }
	    Random rand = new Random();
	    String randomWord = words.get(rand.nextInt(words.size()));
	    System.out.println(randomWord);
	    reader.close();
	    
	} 
	catch (Exception e){
	    
	    System.out.println("Something went wrong");
	    e.printStackTrace();
	    
	}
    }

}
