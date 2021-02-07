package cn.ibizlab.util.domain;

import lombok.Data;
import org.flowable.bpmn.model.Process;
import org.kie.api.runtime.KieContainer;
import java.io.File;
import java.io.Serializable;
import java.util.List;

@Data
public class DELogic implements Serializable {
    String id;
    String name;
    Process process;
    KieContainer container;
    List<DELogic> refLogic;
    List<File> refRuleFiles;
    String md5;
}
