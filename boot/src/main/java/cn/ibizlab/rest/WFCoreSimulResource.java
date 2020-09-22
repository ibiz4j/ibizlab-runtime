package cn.ibizlab.rest;

import cn.ibizlab.api.rest.extensions.WFCoreResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api-wfcore-simul")
@RequestMapping("/wfcore")
public class WFCoreSimulResource extends WFCoreResource {
}
