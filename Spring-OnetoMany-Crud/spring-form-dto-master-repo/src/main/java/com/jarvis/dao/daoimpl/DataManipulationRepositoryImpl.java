package com.jarvis.dao.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.jarvis.app.dao.domain.StudentMaster;
import com.jarvis.dao.daolayer.DataManipulationRepository;

public class DataManipulationRepositoryImpl implements DataManipulationRepository {

	@Autowired
	SessionFactory sessionFactory;

	public boolean saveStudent(StudentMaster studentMaster) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(studentMaster);
		tx.commit();

		return tx.wasCommitted();
	}

	public List<StudentMaster> getStudentList() {

		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(StudentMaster.class);
		List<StudentMaster> studentmasterlist = cr.list();
		return studentmasterlist;
	}

	public StudentMaster editStudent(Integer id) {
		Session session = sessionFactory.openSession();
		StudentMaster studentMaster = (StudentMaster) session.get(StudentMaster.class, id);

		return studentMaster;
	}


	public boolean deleteStudent(StudentMaster transferStudentDtoIdtoStudentMasterId) {
		Session session=sessionFactory.openSession();
		StudentMaster studentMaster=(StudentMaster) session.get(StudentMaster.class, transferStudentDtoIdtoStudentMasterId.getId());
		Transaction tx=session.beginTransaction();
		session.delete(studentMaster);
		tx.commit();
		return tx.wasCommitted();
	}

	
		
		
	
	
	
	

}
