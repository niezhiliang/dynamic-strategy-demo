package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
* @Author ${author}
* @Email nzlsgg@163.com
* @GitHub https://github.com/niezhiliang
* @Date ${date}
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
