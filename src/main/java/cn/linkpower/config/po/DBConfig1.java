package cn.linkpower.config.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
//如果需要根据配置文件映射至类中，则需要此注解，不然则会出现 //Parameter 0 of method dataSource1 in cn.linkpower.config.DataSourceConfig1 required a bean of type 'cn.linkpower.config.po.DBConfig1' that could not be found
@Component 
@ConfigurationProperties(prefix="mysql.datasource.test1")
public class DBConfig1 {
	private String driverClassName;
    private String url;
    private String username;
    private String password;
}
