package ${package};
import com.suning.dal.intf.BaseService;
import ${package}.${shortClassName}Entity;

/**
* @author ${author}
* @version 1.0.0
*/
public interface ${className} extends BaseService {

       int    create();
       int    update();
       int    delete();
      List<${className}  query();
      List<${className}  queryByCondition(QueryParam<${className}QueryEx> queryparam);


}

