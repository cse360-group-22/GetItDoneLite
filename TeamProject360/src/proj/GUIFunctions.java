package proj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GUIFunctions {

	public static ArrayList<Entry> addEntry(ArrayList<Entry> myList, String
			description, String dueDate) {
		int priority = myList.size() + 1;
		Entry newEntry = new Entry(priority, description, dueDate);
		
		myList.add(newEntry);
		
		return myList;
	}
	
	public static ArrayList<Entry> deleteEntry(ArrayList<Entry> myList,
			int entryIndex) {
		myList.remove(entryIndex);
		
		return myList;
	}
	
	public static ArrayList<Entry> editEntry(ArrayList<Entry> myList,
			int entryIndex, String description, String dueDate, String status,
			int priority) {
		
		//keep track of old priority
		int lastPriority = myList.get(entryIndex).getPriority();
		
		//check if priority is changed or not
		if (lastPriority != priority) {
			
			//check if lastPriority is < or > new priority
			boolean lessThan = false;
			if (lastPriority < priority) {
				lessThan = true;
			}
			
			//call changePriority based on range to be changed
			if (lessThan == true) {
				myList = changePriority(myList, lastPriority + 1, priority, lessThan);
			}
			else {
				myList = changePriority(myList, priority, lastPriority - 1, lessThan);
			}
		}
		
		//make changes to entry
		myList.get(entryIndex).setDescription(description);
		myList.get(entryIndex).setDueDate(dueDate);
		myList.get(entryIndex).setPriority(priority);
		myList.get(entryIndex).setStatus(status);
		
		return myList;
	}
	
	public static ArrayList<Entry> changePriority(ArrayList<Entry> myList,
			int start, int end, boolean lessThan) {
		if(lessThan == true) {
			for(int i = 0; i < myList.size(); i++) {
				int pri = myList.get(i).getPriority();
				if (pri >= start && pri <= end) {
					myList.get(i).setPriority(pri - 1);
				}
			}
		}
		else {
			for(int i = 0; i < myList.size(); i++) {
				int pri = myList.get(i).getPriority();
				if (pri >= start && pri <= end) {
					myList.get(i).setPriority(pri + 1);
				}
			}
		}
		
		return myList;
	}
	
	public static void SortDisplay(String selected)
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
