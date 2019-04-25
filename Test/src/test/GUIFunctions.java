package test;

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
	
	public static ArrayList<Entry> changePriority(ArrayList<Entry> myList,int start, int end, boolean lessThan) {
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
	
	public static void SortDisplay(ArrayList<Entry> sort, String selected)
	{
		//statements to sort each list type.
		switch (selected)
		{
			case "Priority": 
				Collections.sort(sort, new Comparator<Entry>() 
				{
					public int compare(Entry e1, Entry e2)
					{
						return Integer.valueOf(e1.getPriority()).compareTo(e2.getPriority());
					}
				});
				break;
				
			case "Due Date":
				Collections.sort(sort, new Comparator<Entry>()
				{
					public int compare(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getDueDate()).compareTo(e2.getDueDate());
					}
				});
				break;
				
			case "Status":
				Collections.sort(sort, new Comparator<Entry>()
				{
					public int compare(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getStatus()).compareTo(e2.getStatus());
					}
				});
				break;
				
			case "Description":
				Collections.sort(sort, new Comparator<Entry>()
				{
					public int compare(Entry e1, Entry e2)
					{
						return String.valueOf(e1.getDescription()).compareTo(e2.getDescription());
					}
				});
				break;
		}
	}
	
	public static ArrayList<Entry> Complete(ArrayList<Entry> myList, Entry completed, String date)
	{
		int index;
		//empty list for completed tasks. This will need to be taken out of the function when implemented in the main.
		ArrayList<Entry> completedList = new ArrayList<Entry>();
		//add completed task to list
		completedList.add(completedList.size(), completed);
		SortDisplay(myList, "Priority");
		//change the priority of all entries with a higher priority than the completed task to one less.
		for(index = completed.getPriority() - 1 ; index < myList.size() ; index++)
		{
			myList.get(index + 1).setPriority(myList.get(index + 1).getPriority() - 1);
		}
		completed.finish(date);
		//remove the completed task from the entry list.
		myList.remove(completed.getPriority() - 1);	
		return completedList;
	}
}