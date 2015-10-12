/**
* SUNING APPLIANCE CHAINS.
* Copyright (c) 2012-2012 All Rights Reserved.
*/
package ${package};
import com.suning.dal.dao.BaseDao;
import com.suning.dal.model.${moduleName}.${shortClassName};

/**
* @author ${author}
* @version 1.0.0
*/
public interface ${className} extends BaseDao {

  int create(${shortClassName} ${className?uncap_first});

  int create(${shortClassName} ${shortClassName?uncap_first});

  int update(${shortClassName} ${shortClassName?uncap_first});

  ${shortClassName} query(String openId);

}

