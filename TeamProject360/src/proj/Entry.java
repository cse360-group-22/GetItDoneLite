package proj;

public class Entry {
	
	public static final String STATUS_NOT_STARTED = "Not Started";
	public static final String STATUS_IN_PROGRESS = "In Progress";
	public static final String STATUS_FINISHED = "Finished";
	public static final String STATUS_DELETED = "Deleted";
	
	private int priority = 0;
	private String status = STATUS_NOT_STARTED;
	private String description = "";
	
	private String startDate = "";
	private String dueDate = "";
	private String finishDate = "";
	
	//constructor for adding new entries in GUI
	public Entry(int priority, String description, String dueDate) {
		setStatus(STATUS_NOT_STARTED);
		
		this.priority = priority;
		this.description = description;
		this.dueDate = dueDate;
	}
	
	//Only use this one for loading from file
	public Entry(int priority, String status, String description, String startDate, String dueDate, String finishDate) {
		this.priority = priority;
		this.status = status;
		this.description = description;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.finishDate = finishDate;
	}
	
	public void start(String date) {
		setStatus(STATUS_IN_PROGRESS);
		startDate = date;
	}
	
	public void finish(String date) {
		setStatus(STATUS_FINISHED);
		finishDate = date;
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
	
	public String toString() {
		String result = "";
		String separator = "|";
		result += getPriority() + separator;
		result += getStatus() + separator;
		result += getDescription() + separator;
		result += getStartDate() + separator;
		result += getDueDate() + separator;
		result += getFinishDate() + separator;
		return result;
	}

}
