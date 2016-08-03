package org.ttw.cms.dao;

import org.springframework.stereotype.Repository;
import org.ttw.basic.dao.BaseDao;
import org.ttw.cms.model.Role;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {


}
