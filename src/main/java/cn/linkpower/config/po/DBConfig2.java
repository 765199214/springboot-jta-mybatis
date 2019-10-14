package cn.linkpower.config.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="mysql.datasource.test2")
public class DBConfig2 {
	private String driverClassName;
    private String url;
    private String username;
    private String password;
}
