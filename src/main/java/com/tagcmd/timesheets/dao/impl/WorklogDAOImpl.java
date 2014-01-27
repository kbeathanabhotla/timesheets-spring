package com.tagcmd.timesheets.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tagcmd.timesheets.dao.IWorklogDAO;
import com.tagcmd.timesheets.pojo.Worklog;

@Repository
@SuppressWarnings({ "unchecked" })
public class WorklogDAOImpl implements IWorklogDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Date> getDatesOfLog(String user) {
		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(Worklog.class)
				.createAlias("person", "p")
				.add(Restrictions.disjunction().add(
						Restrictions.like("p.name", user)))
				.setProjection(Projections.property("date"))
				.addOrder(Order.desc("date")));
	}

	@Override
	public void addWorklog(List<Worklog> worklog) {
		
		//hibernateTemplate.deleteAll(hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Worklog.class).createAlias("person", "p").add(Restrictions.and(Restrictions.like("p.name", worklog.get(0).getPerson().getName()), Restrictions.like("date", worklog.get(0).getDate())))));
		
		hibernateTemplate.saveOrUpdateAll(worklog);
	}

	@Override
	public List<Worklog> getWorklogOfUser(String user, Date startDate,
			Date endDate) {

		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(Worklog.class)
				.createAlias("person", "p")
				.add(Restrictions.disjunction().add(
						Restrictions.and(Restrictions.like("p.name", user),
								Restrictions
										.between("date", startDate, endDate))))
				.addOrder(Order.asc("date")));
	}

}
