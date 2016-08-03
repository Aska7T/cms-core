package org.ttw.cms.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.ttw.basic.model.User;
import org.ttw.basic.test.util.AbstractDbUnitTestCase;
import org.ttw.basic.test.util.EntitiesHelper;
import org.ttw.cms.model.Role;
import org.ttw.cms.model.RoleType;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@TestExecutionListeners({
	DbUnitTestExecutionListener.class,
	DependencyInjectionTestExecutionListener.class
	})
public class TestUserDao extends AbstractDbUnitTestCase{
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private IUserDao userDao;
	
	@Before
	public void setUp() throws DataSetException, SQLException, IOException{
		Session session = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(session));
		this.backupAllTable();
	}
	
	@Test
	public void testListUserRoles() throws DatabaseUnitException, SQLException {
		IDataSet dSet = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, dSet);
		List<Role> actuals = Arrays.asList(new Role(2,"文章发布人员",RoleType.ROLE_PUBLISH),new Role(3,"文章审核人员",RoleType.ROLE_AUDIT));
		List<Role> roles = userDao.listUserRoles(2);
		EntitiesHelper.assertRoles(roles,actuals);
	}
	
	
	@After
	public void tearDown() throws FileNotFoundException, DatabaseUnitException, SQLException{
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session session = holder.getSession();
		session.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
}
