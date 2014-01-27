package com.tagcmd.timesheets.admin;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DemoDataInitializer implements ApplicationListener<ContextRefreshedEvent>  {
	/*
	@Autowired
	private IConstantService constantService;
	
	@Autowired
	private ConstantsGenerator constantsGetter;
	
	@Autowired
	private ConstantTypesGenerator constantTypesGetter;
	
	@Autowired
	private PersonsGenerator personsGenerator;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private boolean initializeDemoActivities;
	private boolean initializeDemoUsers;*/
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*
		if(isInitializeDemoActivities()) {
			
			List<ConstantType> constantTypes =  Arrays.asList(new ConstantType[] {constantTypesGetter.getConstantType("Status"),
					constantTypesGetter.getConstantType("Activity"),
					constantTypesGetter.getConstantType("Activity Type"),
					constantTypesGetter.getConstantType("Module"),
					constantTypesGetter.getConstantType("Client")});
			
			constantService.addConstantTypes(constantTypes);
			constantTypes = null;
			
			
			Constant[] constants = new Constant[] {constantsGetter.getConstant("Analysis","Activity"),
					constantsGetter.getConstant("Bug Fixing","Activity"),
					constantsGetter.getConstant("Client Call","Activity"),
					constantsGetter.getConstant("Code Review","Activity"),
					constantsGetter.getConstant("Coding","Activity"),
					constantsGetter.getConstant("Deployment","Activity"),
					constantsGetter.getConstant("Documentation","Activity"),
					constantsGetter.getConstant("Feedback Imp.","Activity"),
					constantsGetter.getConstant("Internal Meeting","Activity"),
					constantsGetter.getConstant("Interview","Activity"),
					constantsGetter.getConstant("Leave","Activity"),
					constantsGetter.getConstant("Meeting - Others(Specify in Task Desc.)","Activity"),
					constantsGetter.getConstant("Others (Specify in Task Desc.)","Activity"),
					constantsGetter.getConstant("Peer Review","Activity"),
					constantsGetter.getConstant("Project Management","Activity"),
					constantsGetter.getConstant("R & D","Activity"),
					constantsGetter.getConstant("Support","Activity"),
					constantsGetter.getConstant("Testing","Activity"),
					constantsGetter.getConstant("Training","Activity"),
					constantsGetter.getConstant("Unit Testing","Activity"),
					constantsGetter.getConstant("UTC","Activity"),
					constantsGetter.getConstant("Weekly Status Meeting","Activity"),
					constantsGetter.getConstant("In Process", "Status"),
					constantsGetter.getConstant("On Hold", "Status"),
					constantsGetter.getConstant("Completed", "Status"),
					constantsGetter.getConstant("Symphony7","Module"),
					constantsGetter.getConstant("ValueLabs","Module"),
					constantsGetter.getConstant("TAGV5","Module"),
					constantsGetter.getConstant("Others (Specify in Task Desc.)","Activity Type"),
					constantsGetter.getConstant("Development","Activity Type"),
					constantsGetter.getConstant("Maintainence","Activity Type"),
					constantsGetter.getConstant("QA","Activity Type"),
					constantsGetter.getConstant("Client","Client"),
					constantsGetter.getConstant("Valuelabs","Client")};
			
			constantService.addConstants(Arrays.asList(constants));
			constants = null;
			 
			logger.info("initialized demo activities");
		}
		
		if(isInitializeDemoUsers()) {
			
			Person personArray[] = new Person[] {
					personsGenerator.getPerson("Ravi Thalupula"),
					personsGenerator.getPerson("Vijayaprasad Pala"),
					personsGenerator.getPerson("Gopi Thumati"),
					personsGenerator.getPerson("Kiran Putcha"),
					personsGenerator.getPerson("Rajeshwaran Krishnamoorthy"),
					personsGenerator.getPerson("Mohan Panchireddy"),
					personsGenerator.getPerson("Sudheer Gowlikar"),
					personsGenerator.getPerson("Madhusudhana Reddy"),
					personsGenerator.getPerson("Pratima Cheppala"),
					personsGenerator.getPerson("Tarun Juneja"),
					personsGenerator.getPerson("Smita Panasa"),
					personsGenerator.getPerson("Goutham Patala"),
					personsGenerator.getPerson("Sathish Kumar Reddy Pothuirai"),
					personsGenerator.getPerson("Sathish Thoutham"),
					personsGenerator.getPerson("Siva Kumar Reddy Tamma"),
					personsGenerator.getPerson("Sai Krishna Kishore"),
					personsGenerator.getPerson("Ramesh Gangineni")
			};
			
			constantService.addPersonList(Arrays.asList(personArray));
			
			logger.info("initialized demo users");
		}*/
	}

	/*public boolean isInitializeDemoActivities() {
		return initializeDemoActivities;
	}

	public void setInitializeDemoActivities(boolean initializeDemoActivities) {
		this.initializeDemoActivities = initializeDemoActivities;
	}

	public boolean isInitializeDemoUsers() {
		return initializeDemoUsers;
	}

	public void setInitializeDemoUsers(boolean initializeDemoUsers) {
		this.initializeDemoUsers = initializeDemoUsers;
	}*/
}
