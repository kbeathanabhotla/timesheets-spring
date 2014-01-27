package com.tagcmd.timesheets.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tagcmd.timesheets.dao.ICommonDAO;
import com.tagcmd.timesheets.pojo.Activity;
import com.tagcmd.timesheets.pojo.ActivityType;
import com.tagcmd.timesheets.pojo.Client;
import com.tagcmd.timesheets.pojo.Module;
import com.tagcmd.timesheets.pojo.Person;
import com.tagcmd.timesheets.pojo.Status;

@Repository
@SuppressWarnings({ "unchecked" })
public class CommonDAOImpl implements ICommonDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<String> getPersonNames() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(
				Person.class).setProjection(Projections.property("name")));
	}

	@Override
	public List<String> getStatuses() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(
				Status.class).setProjection(Projections.property("name")));
	}

	@Override
	public List<String> getActivities() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(
				Activity.class).setProjection(Projections.property("name")));
	}

	@Override
	public List<String> getActivityTypes() {
		return hibernateTemplate
				.findByCriteria(DetachedCriteria.forClass(ActivityType.class)
						.setProjection(Projections.property("name")));
	}

	@Override
	public List<String> getClients() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(
				Client.class).setProjection(Projections.property("name")));
	}

	@Override
	public List<String> getModules() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(
				Module.class).setProjection(Projections.property("name")));
	}

	@Override
	public Module getModule(String moduleName) {
		return (Module) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Module.class).add(
						Restrictions.like("name", moduleName))).get(0);
	}

	@Override
	public Status getStatus(String status) {
		return (Status) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Status.class).add(
						Restrictions.like("name", status))).get(0);
	}

	@Override
	public Client getClient(String client) {
		return (Client) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Client.class).add(
						Restrictions.like("name", client))).get(0);
	}

	@Override
	public Activity getActivity(String activity) {
		return (Activity) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Activity.class).add(
						Restrictions.like("name", activity))).get(0);
	}

	@Override
	public Person getPerson(String user) {
		return (Person) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Person.class).add(
						Restrictions.like("name", user))).get(0);
	}

	@Override
	public ActivityType getActivityType(String activityType) {
		return (ActivityType) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(ActivityType.class).add(
						Restrictions.like("name", activityType))).get(0);
	}

	@Override
	public Activity getActivityById(Integer id) {
		return (Activity) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Activity.class).add(
						Restrictions.like("id", id))).get(0);
	}

	@Override
	public ActivityType getActivityTypeById(Integer id) {
		return (ActivityType) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(ActivityType.class).add(
						Restrictions.like("id", id))).get(0);
	}

	@Override
	public Client getClientById(Integer id) {
		return (Client) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Client.class).add(
						Restrictions.like("id", id))).get(0);
	}

	@Override
	public Module getModuleById(Integer id) {
		return (Module) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Module.class).add(
						Restrictions.like("id", id))).get(0);
	}

	@Override
	public Person getPersonById(Integer id) {
		return (Person) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Person.class).add(
						Restrictions.like("id", id))).get(0);
	}

	@Override
	public Status getStatusById(Integer id) {
		return (Status) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(Status.class).add(
						Restrictions.like("id", id))).get(0);
	}

}
