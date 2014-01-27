package com.tagcmd.timesheets.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="worklog")
public class Worklog {

	private Integer id;
	private Person person;
	private Date date;
	private Client client;
	private ActivityType activityType;
	private Module module;
	private String taskName;
	private String taskDescription;
	private Activity activity;
	private Float hoursSpent;
	private Status status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="log_date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_type_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public ActivityType getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="module_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	@Column(name="task_name",nullable=false,length=160)
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Column(name="task_description",nullable=false,length=256)
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	@Column(name="hours_spent",nullable=false)
	public Float getHoursSpent() {
		return hoursSpent;
	}
	public void setHoursSpent(Float hoursSpent) {
		this.hoursSpent = hoursSpent;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id",referencedColumnName="id",updatable=true,insertable=true,nullable=false)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
    //Fields for Spring form
    private String statusString;
    private String moduleString;
    private String activityString;
    private String activityTypeSting;
    private String clientString;
    
    @Transient
    public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	
	@Transient
	public String getModuleString() {
		return moduleString;
	}
	public void setModuleString(String moduleString) {
		this.moduleString = moduleString;
	}
	
	@Transient
	public String getActivityString() {
		return activityString;
	}
	public void setActivityString(String activityString) {
		this.activityString = activityString;
	}
	
	@Transient
	public String getActivityTypeSting() {
		return activityTypeSting;
	}
	public void setActivityTypeSting(String activityTypeSting) {
		this.activityTypeSting = activityTypeSting;
	}
	
	@Transient
	public String getClientString() {
		return clientString;
	}
	public void setClientString(String clientString) {
		this.clientString = clientString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result
				+ ((activityType == null) ? 0 : activityType.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((hoursSpent == null) ? 0 : hoursSpent.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result
				+ ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worklog other = (Worklog) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (activityType == null) {
			if (other.activityType != null)
				return false;
		} else if (!activityType.equals(other.activityType))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hoursSpent == null) {
			if (other.hoursSpent != null)
				return false;
		} else if (!hoursSpent.equals(other.hoursSpent))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}
}
