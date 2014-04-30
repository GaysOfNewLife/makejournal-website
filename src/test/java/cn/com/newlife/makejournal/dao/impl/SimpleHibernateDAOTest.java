package cn.com.newlife.makejournal.dao.impl;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.newlife.makejournal.dao.ISimpleHibernateDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext-database.xml")
public class SimpleHibernateDAOTest {

	@Autowired
	private ISimpleHibernateDAO simpleHibernateDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("SimpleHibernateDAOTest Begin.");
		System.out.println(simpleHibernateDAO);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(simpleHibernateDAO);
		System.out.println("SimpleHibernateDAOTest End.");
	}

	@Test
	public void testSaveOrUpdate() {
		System.out.println(simpleHibernateDAO);
		System.out.println("testSaveOrUpdate");
	}

	@Test
	@Ignore("Not yet implemented")
	public void testDelete() {
		fail("Not yet implemented");
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

}
