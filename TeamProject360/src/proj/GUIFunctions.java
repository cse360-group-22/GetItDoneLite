package proj;

import java.util.ArrayList;

public class GUIFunctions {

	public static ArrayList<Entry> addEntry(ArrayList<Entry> myList, String
			description, String dueDate)
	{
		int priority = myList.size() + 1;
		Entry newEntry = new Entry(priority, description, dueDate);
		
		myList.add(newEntry);
		
		return myList;
	}
	
	public static ArrayList<Entry> deleteEntry(ArrayList<Entry> myList,
			int entryIndex)
	{
		myList.remove(entryIndex);
		
		return myList;
	}
	
	public static ArrayList<Entry> editEntry(ArrayList<Entry> myList,
			int entryIndex, String description, String dueDate, String status,
			int priority)
	{
		myList.get(entryIndex).setDescription(description);
		myList.get(entryIndex).setDueDate(dueDate);
		myList.get(entryIndex).setPriority(priority);
		myList.get(entryIndex).setStatus(status);
		
		return myList;
	}
}
