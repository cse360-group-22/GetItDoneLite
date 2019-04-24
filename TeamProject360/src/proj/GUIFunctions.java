package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public static void SortDispaly(String selected)
	{
		switch (selected)
		{
			case "Priority": 
				Collections.sort(entries, new Comparator<Entry>() 
				{
					public int compair(Entry e1, Entry e2)
					{
						return Integer.valueOf(e1.getPriority()).compareTo(e2.getPriority());
					}
				});
				break;
				
			case "Due Date":
				Collections.sort(entries, new Comparator<Entry>()
				{
					public int compair(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getDueDate()).compareTo(e2.getDueDate());
					}
				});
				break;
				
			case "Status":
				Collections.sort(entries, new Comparator<Entry>()
				{
					public int compair(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getStatus()).compareTo(e2.getStatus());
					}
				});
				break;
			case "Description":
				Collections.sort(entries, new Comparator<Entry>()
				{
					public int compair(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getDescription()).compareTo(e2.getDescription());
					}
				});
				break;
		}
	}
}
