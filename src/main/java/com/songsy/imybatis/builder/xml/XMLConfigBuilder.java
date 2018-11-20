package com.songsy.imybatis.builder.xml;

import com.songsy.imybatis.builder.BaseBuilder;
import com.songsy.imybatis.config.Configuration;
import com.songsy.imybatis.exception.BuilderException;
import com.songsy.imybatis.io.Resources;
import com.songsy.imybatis.parsing.XNode;
import com.songsy.imybatis.parsing.XPathParser;

import java.io.InputStream;
import java.util.Properties;

/**
 * Xml配置文件构建器
 * 建造者模式
 * @author songsy
 * @Date 2018/11/19 19:23
 */
public class XMLConfigBuilder extends BaseBuilder {

    // Xml解析器
    private XPathParser parser;
    // 环境标识
    private String environment;

    /**
     * 构造 XMLConfigBuilder
     * @param inputStream
     * @param environment
     * @param props
     */
    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        // 首先调用父类初始化Configuration
        super(new Configuration());
        this.parser = new XPathParser(inputStream);
        this.environment = environment;
        // 将Properties全部设置到Configuration里面去
        this.configuration.setVariables(props);
    }


    public Configuration parse() {
        // 根节点是configuration
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }

    /**
     * 解析配置
     * @param root
     */
    private void parseConfiguration(XNode root) {
        try {
            // 读取properties节点
            propertiesElement(root.evalNode("properties"));
            // 读取environments节点
            environmentsElement(root.evalNode("environments"));
        } catch (Exception e) {
            throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
    }

    private void propertiesElement(XNode context) throws Exception {
        if (context != null) {
            //如果在这些地方,属性多于一个的话,MyBatis 按照如下的顺序加载它们:

            //1.在 properties 元素体内指定的属性首先被读取。
            //2.从类路径下资源或 properties 元素的 url 属性中加载的属性第二被读取,它会覆盖已经存在的完全一样的属性。
            //3.作为方法参数传递的属性最后被读取, 它也会覆盖任一已经存在的完全一样的属性,这些属性可能是从 properties 元素体内和资源/url 属性中加载的。
            //传入方式是调用构造函数时传入，public XMLConfigBuilder(Reader reader, String environment, Properties props)

            //1.XNode.getChildrenAsProperties函数方便得到孩子所有Properties
            Properties defaults = context.getChildrenAsProperties();
            //2.然后查找resource或者url,加入前面的Properties
            String resource = context.getStringAttribute("resource");
            String url = context.getStringAttribute("url");
            if (resource != null && url != null) {
                throw new BuilderException("The properties element cannot specify both a URL and a resource based property file reference.  Please specify one or the other.");
            }
            if (resource != null) {
                defaults.putAll(Resources.getResourceAsProperties(resource));
            } else if (url != null) {
                defaults.putAll(Resources.getUrlAsProperties(url));
            }
            //3.Variables也全部加入Properties
            Properties vars = configuration.getVariables();
            if (vars != null) {
                defaults.putAll(vars);
            }
            parser.setVariables(defaults);
            configuration.setVariables(defaults);
        }
    }

    private void environmentsElement(XNode context) throws Exception {
        if (context != null) {
            if (environment == null) {
                environment = context.getStringAttribute("default");
            }
            for (XNode child : context.getChildren()) {
                String id = child.getStringAttribute("id");
                //循环比较id是否就是指定的environment
            }
        }
    }

}
