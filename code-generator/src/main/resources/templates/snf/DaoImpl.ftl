package ${package};
import com.suning.dal.dao.impl.BaseDaoImpl;
import com.suning.dal.model.${moduleName}.${shortClassName};

/**
* @author ${author}
* @version 1.0.0
*/
@Respository
public class ${className} extends BaseDaoImpl implements ${shortClassName}Dao {

private static final String ${shortClassName?upper_case}_INSERT="${shortClassName?uncap_first}.insert";
private static final String ${shortClassName?upper_case}_UPDATE="${shortClassName?uncap_first}.update";
private static final String ${shortClassName?upper_case}_DELETE_BY_ID="${shortClassName?uncap_first}.delete_by_id";
private static final String ${shortClassName?upper_case}_QUERY_BY_ID="${shortClassName?uncap_first}.query_by_id";
private static final String ${shortClassName?upper_case}_QUERY_COUNT="${shortClassName?uncap_first}.query_count";
private static final String ${shortClassName?upper_case}_QUERY_LIST="${shortClassName?uncap_first}.query_list";

@Resource
private DalClient  dalClient;

@Override
public int create(${shortClassName} ${className?uncap_first}){
return dalClient.persist(${shortClassName?uncap_first});
}

@Override
public int create(${shortClassName} ${shortClassName?uncap_first}){
Map  map  = new HashMap();
return dalClient.persist(${shortClassName?upper_case}_INSERT, param, ${shortClassName}.class).intValue();
}

@Override
public int update(${shortClassName} ${shortClassName?uncap_first}){
return dalClient.merge(${shortClassName?uncap_first});
}

@Override
public ${shortClassName} query(String openId) {
Map<String, Object> param = new HashMap<String, Object>();
param.put("openId", openId);
return this.dalClient.queryForObject(QUERY_BY_OPEN_ID, param, AccountThirdPart.class);
}
}
