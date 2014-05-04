package cn.com.newlife.makejournal.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.com.newlife.makejournal.dao.ISimpleHibernateDAO;
import cn.com.newlife.makejournal.entity.User;
import cn.com.newlife.makejournal.utils.IdUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext-*.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SimpleHibernateDAOTest {
	
	@Autowired
	private ISimpleHibernateDAO simpleHibernateDAO;

	private String id = IdUtil.getUUID();

	@After
	public void cleanData() {
		simpleHibernateDAO.delete(getUserById(id));
	}

	@Test
	public void testSaveOrUpdate() {
		assertNull(getUserById(id));
		User user = new User(id, "test", "test");
		simpleHibernateDAO.saveOrUpdate(user);
//		assertNotNull("没保存进去", getUserById(id));
		String excepted_name = "test1";
		user.setUsername(excepted_name);
		// assertEquals("user还是持久态", "test", getUserById(id).getUsername());
		simpleHibernateDAO.saveOrUpdate(user);
		assertEquals(excepted_name, getUserById(id).getUsername());
	}

	@Test
	public void testDelete() {
		simpleHibernateDAO.delete(null);
		User user = new User(id, "test", "test");
		simpleHibernateDAO.saveOrUpdate(user);
		assertNotNull(getUserById(id));
		simpleHibernateDAO.delete(new User(id, "t", "t"));
		assertNotNull(getUserById(id));
		simpleHibernateDAO.delete(user);
		assertNull(getUserById(id));
	}

	@Test
	@Ignore("Not yet implemented")
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testFindByHQLStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testFindByHQLIntIntStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testGetUniqueResultByHQL() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testFindBySQLStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testFindBySQLIntIntStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testGetUniqueResultBySQL() {
		fail("Not yet implemented");
	}

	private User getUserById(String id) {
		return (User) simpleHibernateDAO.get(User.class, id);
	}

}
