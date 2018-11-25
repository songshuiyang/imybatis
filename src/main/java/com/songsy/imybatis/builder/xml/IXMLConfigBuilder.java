package com.songsy.imybatis.builder.xml;

import com.songsy.imybatis.builder.IBaseBuilder;
import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.config.IEnvironment;
import com.songsy.imybatis.datasource.ISimpleDataSource;
import com.songsy.imybatis.exception.IBuilderException;
import com.songsy.imybatis.io.IResources;
import com.songsy.imybatis.parsing.IXNode;
import com.songsy.imybatis.parsing.IXPathParser;
import com.songsy.tmp.entity.User;

import java.io.InputStream;
import java.util.Properties;

/**
 * Xml配置文件构建器
 * 建造者模式
 *
 * @author songsy
 * @Date 2018/11/19 19:23
 */
public class IXMLConfigBuilder extends IBaseBuilder {
    // Xml解析器
    private IXPathParser parser;
    // 环境标识
    private String environment;
    /**
     * 构造 IXMLConfigBuilder
     *
     * @param inputStream
     * @param environment
     * @param props
     */
    public IXMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        // 首先调用父类初始化Configuration
        super(new IConfiguration());
        this.parser = new IXPathParser(inputStream);
        this.environment = environment;
        // 将Properties全部设置到Configuration里面去
        this.IConfiguration.setVariables(props);
    }


    public IConfiguration parse() {
        // 根节点是configuration
        parseConfiguration(parser.evalNode("/IConfiguration"));
        return IConfiguration;
    }

    /**
     * 解析配置
     *
     * @param root
     */
    private void parseConfiguration(IXNode root) {
        try {
            // 读取properties节点
            propertiesElement(root.evalNode("properties"));
            // 读取environments节点
            environmentsElement(root.evalNode("environments"));
            // 读取mapper节点 TODO 硬编码
            this.IConfiguration.addMapper("com.songsy.imybatis.test.mapper.UserMapper.selectByPrimaryKey","SELECT * FROM sys_user WHERE id = #{id}", User.class);

        } catch (Exception e) {
            throw new IBuilderException("Error parsing SQL Mapper IConfiguration. Cause: " + e, e);
        }
    }

    private void propertiesElement(IXNode context) throws Exception {
        if (context != null) {
            //如果在这些地方,属性多于一个的话,MyBatis 按照如下的顺序加载它们:

            //1.在 properties 元素体内指定的属性首先被读取。
            //2.从类路径下资源或 properties 元素的 url 属性中加载的属性第二被读取,它会覆盖已经存在的完全一样的属性。
            //3.作为方法参数传递的属性最后被读取, 它也会覆盖任一已经存在的完全一样的属性,这些属性可能是从 properties 元素体内和资源/url 属性中加载的。
            //传入方式是调用构造函数时传入，public IXMLConfigBuilder(Reader reader, String IEnvironment, Properties props)

            //1.IXNode.getChildrenAsProperties函数方便得到孩子所有Properties
            Properties defaults = context.getChildrenAsProperties();
            //2.然后查找resource或者url,加入前面的Properties
            String resource = context.getStringAttribute("resource");
            String url = context.getStringAttribute("url");
            if (resource != null && url != null) {
                throw new IBuilderException("The properties element cannot specify both a URL and a resource based property file reference.  Please specify one or the other.");
            }
            if (resource != null) {
                defaults.putAll(IResources.getResourceAsProperties(resource));
            } else if (url != null) {
                defaults.putAll(IResources.getUrlAsProperties(url));
            }
            //3.Variables也全部加入Properties
            Properties vars = IConfiguration.getVariables();
            if (vars != null) {
                defaults.putAll(vars);
            }
            parser.setVariables(defaults);
            IConfiguration.setVariables(defaults);
        }
    }

    private void environmentsElement(IXNode context) throws Exception {
        if (context != null) {
            if (environment == null) {
                environment = context.getStringAttribute("default");
            }
            for (IXNode child : context.getChildren()) {
                String id = child.getStringAttribute("id");
                IXNode dataSourceContext = child.evalNode("dataSource");
                Properties props = dataSourceContext.getChildrenAsProperties();
                String driver = "";
                String url = "";
                String username = "";
                String password = "";
                for (Object key : props.keySet()) {
                    String keyStr = (String) key;
                    String valueStr = props.getProperty(keyStr);
                    if (key.equals("driver")) {
                        driver = valueStr;
                    } else if (key.equals("url")) {
                        url = valueStr;
                    } else if (key.equals("username")) {
                        username = valueStr;
                    } else if (key.equals("password")) {
                        password = valueStr;
                    }
                }
                ISimpleDataSource ISimpleDataSource = new ISimpleDataSource(driver, url, username, password);
                IEnvironment iEnvironment = new IEnvironment(id, ISimpleDataSource);
                IConfiguration.setIEnvironment(iEnvironment);
            }
        }
    }
}
