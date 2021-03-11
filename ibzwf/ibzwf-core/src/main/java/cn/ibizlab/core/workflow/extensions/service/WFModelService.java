package cn.ibizlab.core.workflow.extensions.service;

import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.service.IWFProcessDefinitionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class WFModelService
{



	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private IWFProcessDefinitionService iwfProcessDefinitionService;

	public List<WFProcessDefinition> getDynamicWorkflow(String dynamic, String system,String entity) {
		return process(iwfProcessDefinitionService.list(new QueryWrapper<WFProcessDefinition>().
				likeRight("definitionkey","dyna-"+dynamic+"-"+system+"-"+entity+"-").eq("modelenable",1).orderByDesc("modelversion")));
	}

	public List<WFProcessDefinition> getWorkflow(String system,String entity) {
		return iwfProcessDefinitionService.list(new QueryWrapper<WFProcessDefinition>().
				likeRight("definitionkey",system+"-"+entity+"-").eq("modelenable",1).orderByDesc("modelversion"));
	}

	public LinkedHashMap<String,UserTask> getModelStepByKey(String definitionkey)
	{
		LinkedHashMap<String, UserTask> allTask=new LinkedHashMap<String,UserTask>();
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().processDefinitionKey(definitionkey).orderByProcessDefinitionVersion().desc().list();
		boolean blastest=true;
		for (ProcessDefinition def : list) {
			LinkedHashMap<String, UserTask> userTasks=getModelStepById(def.getId());
			if(blastest){
				allTask.putAll(userTasks);
				blastest=false;
			}
			else {
				for(String key:userTasks.keySet()) {
					if(!allTask.containsKey(key)) {
						String taskName = userTasks.get(key).getName() + "-历史版本v" +def.getVersion();
						userTasks.get(key).setName(taskName);
						allTask.put(key, userTasks.get(key));
					}
				}
			}
		}
		return allTask;
	}

	public LinkedHashMap<String,UserTask> getModelStepById(String definitionid)
	{
		LinkedHashMap<String, UserTask> userTasks = new LinkedHashMap<String, UserTask>();
		Map<String,UserTask> map=new HashMap<>();
		for(FlowElement f:repositoryService.getBpmnModel(definitionid).getMainProcess().getFlowElements()) {
			if(f instanceof UserTask) {
				map.put(f.getId(),(UserTask)f);
			}
		}
		List<Map.Entry<String, UserTask>> infoIds =new ArrayList<Map.Entry<String, UserTask>>(map.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<String, UserTask>>() {
			public int compare(Map.Entry<String, UserTask> o1, Map.Entry<String, UserTask> o2) {
				String p1 =  o1.getKey();
				String p2 = o2.getKey();
				return p1.compareTo(p2);
			}
		});
		for(Map.Entry<String,UserTask> entity : infoIds){
			userTasks.put(entity.getKey(), entity.getValue());
		}
		return userTasks;
	}

	public Map<String,Object> getProcessGlobalSetting(String definitionId)
	{
		LinkedHashMap<String,Object> setting = new LinkedHashMap();
		Process process=repositoryService.getBpmnModel(definitionId).getMainProcess();
		for(ExtensionElement field:process.getExtensionElements().get("field")) {
			if((!StringUtils.isEmpty(field.getAttributes().get("name").get(0).getValue()))&&(!StringUtils.isEmpty(field.getChildElements().get("string").get(0).getElementText())))
				setting.put(field.getAttributes().get("name").get(0).getValue(),field.getChildElements().get("string").get(0).getElementText());
		}
		return setting;
	}

	/**
	 * 设置流程启动视图
	 * @param defs
	 * @return
	 */
	private List<WFProcessDefinition> process(List<WFProcessDefinition> defs) {
		for (WFProcessDefinition def : defs) {
			List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey(def.getDefinitionkey()).orderByProcessDefinitionVersion().desc().list();
			if (ObjectUtils.isEmpty(processDefinitions))
				return defs;
			ProcessDefinition lastestwf = processDefinitions.get(0);
			for (FlowElement element : repositoryService.getBpmnModel(lastestwf.getId()).getMainProcess().getFlowElements()) {
				if (element instanceof StartEvent) {
					if (!ObjectUtils.isEmpty(element) && !ObjectUtils.isEmpty(element.getExtensionElements()) && !ObjectUtils.isEmpty(element.getExtensionElements().get("form"))) {
						for (ExtensionElement prop : element.getExtensionElements().get("form")) {
							for (String attribute : prop.getAttributes().keySet()) {
								for (ExtensionAttribute param : prop.getAttributes().get(attribute)) {
									def.set(param.getName(), param.getValue());
								}
							}
						}
					}
				}
			}
		}
		return defs;
	}
}
