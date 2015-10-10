<#ftl encoding="UTF-8">
/**
 * @(#) ${className}.java
 */


package ${package};


import com.suning.dal.model.BaseModel;
import java.util.Date;

/**
* ${className} class.
*
* 序号   时间          作者        修改内容
* 1.   ${date}	  ${author}    created this class.
*/
public class ${className} implements BaseModel {
//Auto Generated Begin

/**
* serial Version UID.
*/
private static final long serialVersionUID = ${serialVersionUID};

<#list javaBean.fieldList as field>
/**
* ${field.comment}
*/
private ${field.shortJavaType} ${field.javaName};

</#list>

<#list fields as field>
/**
* ${field.comment}
*/
private ${field.shortJavaType} ${field.javaName};

</#list>

<#list pkFields as field>
/**
* @return the ${field.javaName}
*/
public ${field.shortJavaType} get${field.javaName?cap_first}() {
return ${field.javaName};
}

/**
* @param ${field.javaName} the ${field.javaName} to set
*/
public void set${field.javaName?cap_first}(${field.shortJavaType} ${field.javaName}) {
this.${field.javaName} = ${field.javaName};
}

</#list>

<#list fields as field>
/**
* @return the ${field.javaName}
*/
public ${field.shortJavaType} get${field.javaName?cap_first}() {
    return ${field.javaName};
}

/**
* @param ${field.javaName} the ${field.javaName} to set
*/
public void set${field.javaName?cap_first}(${field.shortJavaType} ${field.javaName}) {
    this.${field.javaName} = ${field.javaName};
}

</#list>

//Auto Generated End
}
