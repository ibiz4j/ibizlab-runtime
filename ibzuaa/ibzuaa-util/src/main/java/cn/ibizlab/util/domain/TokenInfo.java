package cn.ibizlab.util.domain;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accessToken;
    private Long lastRefreshTime;
    private String ticket;
}
