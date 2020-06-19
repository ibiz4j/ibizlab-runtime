package cn.ibizlab.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(prefix = "service.api")
@Data
public class apiServiceProperties {

	private boolean enabled;

	private boolean auth;


}