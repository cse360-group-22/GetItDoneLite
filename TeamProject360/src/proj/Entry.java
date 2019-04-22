package proj;

public class Entry {
	
	public static final String DATA_SEPARATOR = "~";
	
	public static final String STATUS_NOT_STARTED = "Not Started";
	public static final String STATUS_IN_PROGRESS = "In Progress";
	public static final String STATUS_FINISHED = "Finished";
	public static final String STATUS_DELETED = "Deleted";
	
	private int priority = 0;
	private String status = STATUS_NOT_STARTED;
	private String description = "";
	
	private String startDate = "MM/DD/YYYY";
	private String dueDate = "MM/DD/YYYY";
	private String finishDate = "MM/DD/YYYY";
	
	//Constructor for adding new entries in GUI
	public Entry(int priority, String description, String dueDate) {
		setStatus(STATUS_NOT_STARTED);
		
		this.priority = priority;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	//Creates new entry based on data from text file
	public Entry(String data) {
		String[] parameters = data.split(DATA_SEPARATOR);
		
		this.priority = Integer.parseInt(parameters[0]);
		this.status = parameters[1];
		this.description = parameters[2];
		this.startDate = parameters[3];
		this.dueDate = parameters[4];
		this.finishDate = parameters[5];
	}
	
	public void start(String date) {
		setStatus(STATUS_IN_PROGRESS);
		startDate = date;
	}
	
	public void finish(String date) {
		setStatus(STATUS_FINISHED);
		finishDate = date;
	}
	
	public void delete() {
		setStatus(STATUS_DELETED);
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		//Make sure status is valid
		if(!status.equals(STATUS_NOT_STARTED) && !status.equals(STATUS_IN_PROGRESS) &&
				!status.equals(STATUS_FINISHED) && !status.equals(STATUS_DELETED)) {
			return;
		}
		
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getFinishDate() {
		return finishDate;
	}
	
	//Returns string that is stored in text file when saving
	public String toString() {
		String result = "";
		result += getPriority() + DATA_SEPARATOR;
		result += getStatus() + DATA_SEPARATOR;
		result += getDescription() + DATA_SEPARATOR;
		result += getStartDate() + DATA_SEPARATOR;
		result += getDueDate() + DATA_SEPARATOR;
		result += getFinishDate() + DATA_SEPARATOR;
		return result;
	}

}
