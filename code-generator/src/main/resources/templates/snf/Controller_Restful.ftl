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
@RequestMapping("/${shortClassName?uncap_first}")
public class ${className}  extends BaseController {
@Autowired
private ${shortClassName}Service ${shortClassName?lower_case}Service;
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ResponseEntity<String> add( HttpServletRequest httpRequest) {
        CommonResponse<${shortClassName}> result = ${shortClassName?lower_case}Service.add${shortClassName}( );
         return messageBuilder.buildResult("${shortClassName}.add${shortClassName}", result, result.getData());
    }

    @RequestMapping(value = "/{id}",  method = RequestMethod.POST)
    public ResponseEntity<String> create(pk, HttpServletRequest httpRequest) {
        CommonResponse <List<${shortClassName}>> result = ${shortClassName?lower_case}Service.get${shortClassName}List(pk);
        return messageBuilder.buildResult("${shortClassName}.get${shortClassName}List", result, result.getData());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete${shortClassName}(@PathVariable Long id,HttpServletRequest httpRequest) {
          CommonResponse<Integer> result = ${shortClassName?lower_case}Service.del${shortClassName}(pk);
                return messageBuilder.buildResult("${shortClassName}.del${shortClassName}", result, result.getData());
     }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public ResponseEntity <String> update( HttpServletRequest httpRequest) {
    CommonResponse<Integer> result = ${shortClassName?lower_case}Service.update${shortClassName}();
      return messageBuilder.buildResult("${shortClassName}.update${shortClassName}", result,
                    result.getData());
   }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> get${shortClassName}(@PathVariable Long id,HttpServletRequest httpRequest) {
                        CommonResponse <${shortClassName}> result = ${shortClassName?lower_case}Service.get${shortClassName}Detail(pk);
            return messageBuilder.buildResult("${shortClassName}.get${shortClassName}Detail",
                            result, result.getData());
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable Long id,HttpServletRequest httpRequest) {
                        CommonResponse <${shortClassName}> result = ${shortClassName?lower_case}Service.get${shortClassName}Detail(pk);
            return messageBuilder.buildResult("${shortClassName}.get${shortClassName}Detail",
                            result, result.getData());
     }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
       public ResponseEntity<String> index(@PathVariable Long id,HttpServletRequest httpRequest) {
        CommonResponse <${shortClassName}> result = ${shortClassName?lower_case}Service.get${shortClassName}Detail(pk);
        return messageBuilder.buildResult("${shortClassName}.get${shortClassName}Detail",
         result, result.getData());
    }

}