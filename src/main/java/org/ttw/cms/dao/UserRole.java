package org.ttw.cms.dao;

import java.util.List;
import java.util.Map;

import org.ttw.basic.dao.BaseDao;
import org.ttw.basic.model.Pager;
import org.ttw.cms.model.Group;
import org.ttw.cms.model.Role;
import org.ttw.cms.model.RoleType;
import org.ttw.cms.model.User;
import org.ttw.cms.model.UserGroup;

public class UserRole extends BaseDao<User> implements IUserDao {


	@Override
	public List<Role> listUserRoles(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserRoleIds(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> listUserGroups(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserGroupsIds(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.ttw.cms.model.UserRole loadUserRole(int userId, int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserGroup loadUserGroup(int userId, int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listRoleUsers(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listRoleUsers(RoleType roleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listGroupUsers(int gid) {
		// TODO Auto-generated method stub
		return null;
	}

}
