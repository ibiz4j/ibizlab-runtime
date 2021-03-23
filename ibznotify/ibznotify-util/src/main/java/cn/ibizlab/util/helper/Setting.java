package cn.ibizlab.util.helper;

import cn.ibizlab.util.domain.EntityBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Setting {
    private String property;
    private String value;


    public static String getValue(String configString,String propertyName)
    {
        return DataObject.getStringValue(getMap(configString).get(propertyName),"");
    }

    public static <T extends EntityBase> T getEntity(String configString,T entityBase)
    {
        if(entityBase!=null) {
            Map map=getMap(configString);
            map.keySet().forEach(key->{
                entityBase.set(key.toString(),map.get(key));
            });
        }
        return entityBase;
    }

    public static Map getMap(String configString)
    {
        Map map=new HashMap();
        map.put("param",configString);
        if(!(StringUtils.isEmpty(configString)))
        {
            try
            {
                Object obj=JSON.parse(configString);
                if(obj==null)
                    return map;
                else if (obj instanceof JSONArray)
                {
                    List<Setting> settings= JSONArray.parseArray(configString,Setting.class);
                    for(Setting setting:settings)
                        map.put(setting.getProperty(),setting.getValue());
                }
                else if (obj instanceof JSONObject)
                {
                    JSONObject jo = (JSONObject)obj;
                    jo.keySet().forEach(key->{
                        map.put(key,jo.get(key));
                    });
                }
            }
            catch (Exception ex)
            {
                if(configString.indexOf("=")>0)
                {
                    Properties proper = new Properties();
                    try {
                        proper.load(new StringReader(configString)); //把字符串转为reader
                    } catch (IOException e) {
                    }
                    Enumeration enum1 = proper.propertyNames();
                    while (enum1.hasMoreElements()) {
                        String strKey = (String) enum1.nextElement();
                        String strValue = proper.getProperty(strKey);
                        map.put(strKey, strValue);
                    }
                }

            }
        }
        return map;
    }


}
