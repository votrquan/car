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
import com.car.exception.carTransactionException;
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
	                + "(e.name,e.phone,e.age) " //
	                + " from " + user.class.getName() + " e ";
	        Session session = this.sessionFactory.getCurrentSession();
	        Query<user> query = session.createQuery(sql, user.class);
	        return query.getResultList();
	    }
	 
	    // MANDATORY: Giao dịch bắt buộc phải được tạo sẵn trước đó.
	    @Transactional(propagation = Propagation.MANDATORY)
	    public void addAmount(int id) throws carTransactionException {
	        userEntity user = this.findById(id);
	        if (user == null) {
	            throw new carTransactionException("user not found " + id);
	        }
//	        String name = user.getName() + amount;
	    }
	 
	    // Không được bắt BankTransactionException trong phương thức này.
	    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = carTransactionException.class)
	    public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws carTransactionException {
	 
//	        addAmount(toAccountId, amount);
//	        addAmount(fromAccountId, -amount);
	    }
}
