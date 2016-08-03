package org.ttw.cms.dao;

import java.util.List;

import org.ttw.basic.dao.IBaseDao;
import org.ttw.cms.model.Group;
import org.ttw.cms.model.Role;
import org.ttw.cms.model.RoleType;
import org.ttw.cms.model.User;
import org.ttw.cms.model.UserGroup;
import org.ttw.cms.model.UserRole;

public interface IUserDao extends IBaseDao<User>{
	/**
	 * 添加用户
	 * @param user
	 * @param rids 用户的所有角色id
	 * @param gids 所有组id
	 */
	public void add(User user, Integer[] rids, Integer[] gids);
	/**
	 * 更新用户
	 * @param user
	 * @param rids
	 * @param gids
	 */
	public void update(User user, Integer[] rids,Integer[] gids);
	
	
	
	/**
	 * 获取用户的所有角色信息
	 * @param userId
	 * @return
	 */
	public List<Role> listUserRoles(int userId);
	/**
	 * 获取用户的所有角色的id
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserRoleIds(int userId);
	/**
	 * 获取用户的所有组信息
	 * @param userId
	 * @return
	 */
	public List<Group> listUserGroups(int userId);
	/**
	 * 获取用户的所有组的id
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserGroupsIds(int userId);
	/**
	 * 根据用户和角色获取用户角色的关联对象
	 * @param userId
	 * @return
	 */
	public UserRole loadUserRole(int userId, int roleId);
	/**
	 * 根据用户和组获取用户组的关联对象
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public UserGroup loadUserGroup(int userId, int groupId);
	/**
	 * 根据用户名获取用户对象
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);
	/**
	 * 根据角色id获取用户列表
	 * @param roleId
	 * @return
	 */
	public List<User> listRoleUsers(int roleId);
	/**
	 * 根据角色类型获取对象
	 * @param roleType
	 * @return
	 */
	public List<User> listRoleUsers(RoleType roleType);
	/**
	 * 获取某个组中的用户对象
	 * @param gid
	 * @return
	 */
	public List<User> listGroupUsers(int gid);
}
