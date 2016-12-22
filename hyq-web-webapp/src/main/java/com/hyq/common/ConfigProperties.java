package com.hyq.common;

/**
 * Created by Administrator on 2016/12/22.
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ConfigProperties {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigProperties.class);
    private String rootPath;
    private Map<String, String> propertiesMap = new HashMap();
    private Resource location;

    public ConfigProperties() {
    }

    public void init() {
        try {
            if(this.location == null || !this.location.getFile().exists()) {
                throw new IOException("系统配置文件路径未指定，或文件不存在！");
            }

            Properties e = PropertiesLoaderUtils.loadProperties(this.location);
            this.rootPath = e.getProperty("root.path");
            Iterator var2 = e.keySet().iterator();

            while(var2.hasNext()) {
                Object key = var2.next();
                this.propertiesMap.put((String)key, (String)e.get(key));
            }
        } catch (Exception var4) {
            LOG.error(var4.getMessage(), var4);
        }

    }

    public Resource getLocation() {
        return this.location;
    }

    public void setLocation(Resource location) {
        this.location = location;
    }

    public String getRootPath() {
        return this.rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getUploadPath() {
        return this.rootPath + File.separator + "userfiles";
    }

    public String getUploadUrl() {
        return "/userfiles";
    }

    public void setPropertiesMap(Map<String, String> propertiesMap) {
        this.propertiesMap = propertiesMap;
    }

    public String get(String key) {
        return (String)this.propertiesMap.get(key);
    }
}

