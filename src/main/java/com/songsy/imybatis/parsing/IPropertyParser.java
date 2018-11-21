package com.songsy.imybatis.parsing;

import java.util.Properties;

/**
 * 属性解析器
 * @author Clinton Begin
 */
public class IPropertyParser {

  private IPropertyParser() {
    // Prevent Instantiation
  }

  public static String parse(String string, Properties variables) {
    VariableITokenHandler handler = new VariableITokenHandler(variables);
    IGenericTokenParser parser = new IGenericTokenParser("${", "}", handler);
    return parser.parse(string);
  }

  //就是一个map，用相应的value替换key
  private static class VariableITokenHandler implements ITokenHandler {
    private Properties variables;

    public VariableITokenHandler(Properties variables) {
      this.variables = variables;
    }

    @Override
    public String handleToken(String content) {
      if (variables != null && variables.containsKey(content)) {
        return variables.getProperty(content);
      }
      return "${" + content + "}";
    }
  }
}
