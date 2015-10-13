package ${package};

import com.suning.dal.dao.BaseDao;
import ${package}.${shortClassName};
import ${package}.${shortClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author ${author}
* @version 1.0.0
*/
@Service
public class ${className} implements ${shortClassName}Service {
@Autowired
private ${shortClassName}Dao ${shortClassName?lower_case}Dao;

@Override
public ${className} create(String phoneNo){
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("phoneNo", phoneNo);
    ${shortClassName?lower_case}Dao
}
