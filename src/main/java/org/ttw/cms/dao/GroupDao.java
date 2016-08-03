package org.ttw.cms.dao;

import org.springframework.stereotype.Repository;
import org.ttw.basic.dao.BaseDao;
import org.ttw.cms.model.Group;

@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {


}
