package cn.ibizlab.core.uaa.extensions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysApp {
    private String id;
    private String label;
    private String systemid;
    private String fullName;
    private String type;
    private String addr;

}
