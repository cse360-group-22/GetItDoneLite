package proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileLoader {
	
	//Loads string from text file and creates entry list based on data
	public static ArrayList<Entry> load(String path) {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = in.readLine()) != null) {
				entries.add(new Entry(line));
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		/*for(Entry entry : entries) {
			System.out.println(entry.toString());
		}*/
		
		return entries;
	}
	
	//Saves entry list into text file
	public static void save(String path, ArrayList<Entry> entries) {
		try {
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			for(Entry entry : entries) {
				writer.println(entry.toString());
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
