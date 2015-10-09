<#assign columns = fieldList?sort/>
<#assign pks = pkFieldList?sort/>
package ${package};

import com.suning.dal.dao.BaseDao;
import ${package}.${shortClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author ${author}
* @version 1.0.0
*/
@Controller
@RequestMapping("/${shortClassName}")
public class ${className}  extends BaseController {
@Autowired
private ${shortClassName}Service ${shortClassName?lower_case}Service;

    @RequestMapping(value = "/add${shortClassName}", method = RequestMethod.GET)
    public ResponseEntity<String> add${shortClassName}( HttpServletRequest httpRequest) {
        CommonResponse<${shortClassName}> result = ${shortClassName?lower_case}Service.add${shortClassName}( );
         return messageBuilder.buildResult("${shortClassName}.add${shortClassName}", result, result.getData());
        } 
    @RequestMapping(value = "/del${shortClassName}", method = RequestMethod.GET)
    public ResponseEntity<String> del${shortClassName}(pk,HttpServletRequest httpRequest) {
          CommonResponse<Integer> result = ${shortClassName?lower_case}Service.del${shortClassName}(pk);
                return messageBuilder.buildResult("${shortClassName}.del${shortClassName}", result, result.getData());
        }
       @RequestMapping(value = "/update${shortClassName}", method = RequestMethod.GET)
       public ResponseEntity <String> updateBaby( HttpServletRequest httpRequest) {
        CommonResponse<Integer> result = ${shortClassName?lower_case}Service.update${shortClassName}();
          return messageBuilder.buildResult("${shortClassName}.update${shortClassName}", result,
                        result.getData());
       }


       @RequestMapping(value = "/get${shortClassName}Detail", method = RequestMethod.GET)
        public ResponseEntity<String> get${shortClassName}Detail(pk, HttpServletRequest httpRequest) {
                CommonResponse <${shortClassName}> result = ${shortClassName?lower_case}Service.get${shortClassName}Detail(pk);
                return messageBuilder.buildResult("${shortClassName}.get${shortClassName}Detail",
                                result, result.getData());
         }
         @RequestMapping(value = "/get${shortClassName}List", method = RequestMethod.GET)
          public ResponseEntity<String> get${shortClassName}List(pk, HttpServletRequest httpRequest) {
             CommonResponse <List<${shortClassName}>> result = ${shortClassName?lower_case}Service.get${shortClassName}List(pk);
                                        return messageBuilder.buildResult("${shortClassName}.get${shortClassName}List", result, result.getData());
         }
        }