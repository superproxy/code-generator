package ${package};
import com.suning.dal.intf.BaseService;
import ${package}.${shortClassName}Entity;

/**
* @author ${author}
* @version 1.0.0
*/
public interface ${className} extends BaseService {

int create(${shortClassName} ${className?uncap_first});

int create(${shortClassName} ${shortClassName?uncap_first});

int update(${shortClassName} ${shortClassName?uncap_first});

${shortClassName} query(String openId);
List<${className}  query();
List<${className}  queryByCondition(QueryParam
<${className}QueryEx> queryparam);


    }

