package ${package.Controller};


<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
* @Author ${author}
* @Email nzlsgg@163.com
* @GitHub https://github.com/niezhiliang
* @Date ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

}
</#if>
