package cn.ibizlab.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service.api")
@Data
public class apiServiceProperties {

	private boolean enabled;

	private boolean auth;


}