package com.songsy.imybatis.executor.result;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * sql 执行结果类
 * @author songshuiyang
 * @date 2018/11/25 10:19
 */
public class IDefaultResultSetHandler implements IResultSetHandler{

    private IConfiguration configuration;

    public IDefaultResultSetHandler(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public  <E> E handleResultSets(Statement stmt, IMapperRegistry.MapperData mapperData)  {
        Object resultObj = null;
        try {
            resultObj = mapperData.getResultType().newInstance();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                int i = 0;
                for (Field field : resultObj.getClass().getDeclaredFields()) {
                    setValue(resultObj, field, rs ,i);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (E) resultObj;
    }

    @Override
    public void handleOutputParameters(CallableStatement cs) throws SQLException {

    }

    private void setValue(Object resultObj, Field field, ResultSet rs, int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()), field.getType());
        setMethod.invoke(resultObj, getResult(field,rs));
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        String fieldName = camel2Underline(field.getName()) ;

        if(Integer.class == type){
            return rs.getInt(fieldName);
        }
        if(String.class == type){
            return rs.getString(fieldName);
        }
        if(Date.class == type) {
            return new Date();
        }
        if (Boolean.class == type) {
            return rs.getBoolean(fieldName);
        }
        return rs.getString(fieldName);
    }

    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }

    /**
     * 驼峰法转下划线
     *
     * @param line
     *            源字符串
     * @return 转换后的字符串
     */
    private static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase()
                .concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }
}
