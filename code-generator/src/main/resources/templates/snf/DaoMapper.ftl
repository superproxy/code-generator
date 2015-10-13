<#--<#assign service = model.extra.service/>-->
<#--<#assign name = service.name/>-->
<#--<#assign className = model.className/>-->
<#--<#assign shortClassName = model.shortClassName/>-->
<#--<#assign package = model.package/>-->
package ${package};
import com.suning.dal.dao.BaseDao;
import com.suning.dal.model.${moduleName}.${shortClassName};

/**
* @author ${author}
* @version 1.0.0
*/
public interface ${className} extends BaseDao {

}

