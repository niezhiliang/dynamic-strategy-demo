package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

/**
* @Author ${author}
* @Email nzlsgg@163.com
* @GitHub https://github.com/niezhiliang
* @Date ${date}
*/
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
