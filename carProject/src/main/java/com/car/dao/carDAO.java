package com.car.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.car.entity.userEntity;
import com.car.model.user;

@Repository
@Transactional
public class carDAO {
	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    public carDAO() {
	    }
	 
	    public userEntity findById(int id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        return session.get(userEntity.class, id);
	    }
	 
	    public List<user> listCarInfo() {
	        String sql = "Select new " + user.class.getName() //
	                + "(e.id as id, e.phone as phoneNumber, e.name as name, e.age as age)" //
	                + " from " + userEntity.class.getName() + " e ";
	        Session session = this.sessionFactory.getCurrentSession();
	        Query<user> query = session.createQuery(sql, user.class);
	        return query.getResultList();
	    }
	    
	    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	    public void insertUser(userEntity us)
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
            session.save(us);
		        // Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
//	        session.flush();
	    }
	    	 
}
