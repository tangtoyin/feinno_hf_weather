/*
package com.ucss.elementary.tnwn.util;

import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.tnwn.SysModelDB;
import com.ucss.elementary.tnwn.model.dto.EditTableColumInfo;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.tnwn.SysModelDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.*;
import java.util.Date;

*/
/**
 * @author Smile
 * @date 2018/10/30 17:10
 *//*

@Component
public class JDBCUtil_pat {

    @Autowired
    SysModelDBService sysModelDBService;
    static SysModelDBService dbService;

    @PostConstruct
    public void init() {
        dbService = sysModelDBService;
    }

    //数据连接
    public static Connection getConnection(String url,String user,String pwd) throws Exception {
        try {
            if(url.contains("oracle")){
                Class.forName("oracle.jdbc.driver.OracleDriver");
            }
            return DriverManager.getConnection(url, user, pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //数据连接
    public static Connection getConnection(String dbcode) throws Exception {
        try {
            SysModelDB db = dbService.getSysModelDB(dbcode);
            if (db != null) {
                if (db.getConUrl().contains("oracle")) {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                }
                return DriverManager.getConnection(db.getConUrl(), db.getConUser(), db.getConPwd());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //判断是否存在表
    public static boolean existsTable(Connection conn, String tableName) throws SQLException {
        ResultSet rSet = null;
        try {
            String sql = String.format("SELECT TABLE_NAME FROM USER_ALL_TABLES WHERE TABLE_NAME='%S'", tableName.trim().toUpperCase());
            rSet = conn.prepareStatement(sql).executeQuery();
            if (rSet.next()) {
                if (rSet.getString("TABLE_NAME").equals(tableName.trim().toUpperCase())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
        return false;
    }

    //修改表名
    public static void changeTableName(Connection conn, String oldTableName, String newTableName) throws Exception {
        PreparedStatement pSt = null;
        try {
            String sql = String.format("ALTER TABLE %s RENAME TO %s", oldTableName, newTableName);
            pSt = conn.prepareStatement(sql);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pSt != null) {
                pSt.close();
            }
        }
    }

    //删除表
    public static void delTable(Connection conn, String tableName)throws Exception{
        PreparedStatement pSt = null;
        try {
            String sql = String.format("DROP TABLE %S", tableName);
            pSt = conn.prepareStatement(sql);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pSt != null) {
                pSt.close();
            }
        }
    }

    //获取表结构
    public static List<Map> getTableStruct(Connection conn, String tableName)throws Exception{
        if(StringHelper.isTrimEmpty(tableName)){
            return null;
        }
        //region sql
        String sql="with tmp as\n" +
                " (select m.column_name\n" +
                "    from user_constraints s, user_cons_columns m\n" +
                "   where m.table_name = '#{tablename}'\n" +
                "     and m.table_name = s.table_name\n" +
                "     and m.constraint_name = s.constraint_name\n" +
                "     and s.constraint_type = 'P')\n" +
                "select t.COLUMN_ID,\n" +
                "       T.COLUMN_NAME,\n" +
                "       T.DATA_TYPE,\n" +
                "       T.DATA_LENGTH,\n" +
                "       T.DATA_PRECISION,\n" +
                "       T.NULLABLE,\n" +
                "       T.DATA_DEFAULT,\n" +
                "       C.COMMENTS,\n" +
                "       DECODE(t.column_name, p.column_name, 1, 0) iskey\n" +
                "  from user_tab_cols t\n" +
                "  LEFT JOIN user_col_comments C\n" +
                "    ON C.TABLE_NAME = T.TABLE_NAME\n" +
                "   AND C.COLUMN_NAME = T.COLUMN_NAME\n" +
                "  LEFT JOIN tmp p\n" +
                "    on p.column_name = t.COLUMN_NAME\n" +
                " where t.TABLE_NAME =  '#{tablename}'\n" +
                " ORDER BY t.COLUMN_ID ASC";
        //endregion
        ResultSet rSet = null;
        try {
            sql = sql.replace("#{tablename}",tableName.toUpperCase());
            rSet = conn.prepareStatement(sql).executeQuery();
            ResultSetMetaData rsmd = rSet.getMetaData() ;
            List<Map> list=new ArrayList<>();
            while (rSet.next()){
                Map map=new LinkedHashMap();
                for (int i=1;i<=rsmd.getColumnCount();i++){
                    map.put(rsmd.getColumnName(i).toLowerCase(),rSet.getString(i));
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
        return null;
    }

    */
/**
     * 释放连接 Connection
     *
     * @param conn
     *//*

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }
    //获取sql
    public static String getSql(Connection conn, String tableName,String tableComment, List<String> dropcolums, List<String> primarykeys, List<EditTableColumInfo> columInfos,String changeprimarykey)throws Exception{
        boolean existsTable=existsTable(conn,tableName);
        StringBuffer sql=new StringBuffer("");
        StringBuffer commentSql=new StringBuffer("");
        //表存在
        if(existsTable){
            //若未更改，则返回表的创建sql
            if((dropcolums==null||dropcolums.size()==0)&&(columInfos==null||columInfos.size()==0)&&!"y".equalsIgnoreCase(changeprimarykey)) {
                return getCreateSqlOfTable(conn, tableName);
            }else {
                if(columInfos!=null&&columInfos.size()>0){
                    for (EditTableColumInfo item:columInfos){
                        //若列名不存在，则无效
                        if(!StringHelper.isTrimEmpty(item.getNewName())){
                            //判断是否更改列名,若更改，则只需更改语句
                            if(!StringHelper.isTrimEmpty(item.getOldName())&& !item.getNewName().equalsIgnoreCase(item.getOldName())){
                                sql.append(String.format("alter table %s rename column %s to %s;",tableName,item.getOldName(),item.getNewName()));
                            }
                            //region 组装编辑sql
                            //字段类型
                            String editSql=getDatatypeSql(item.getDataType(),item.getDataLength(),item.getDataPrecision());
                            //默认值
                            if(!StringHelper.isTrimEmpty(item.getDataDefault())){
                                if(StringHelper.toSafeString(item.getDataType()).contains("TIMESTAMP")){
                                   // editSql+=" default '"+DateHelper.str2Date(item.getDataDefault())+"'";
                                } else if(TConverter.ObjectToLong(item.getDataDefault())>0){
                                    editSql+=" default "+item.getDataDefault();
                                }else {
                                    editSql+=" default '"+item.getDataDefault()+"'";
                                }
                            }
                            //是否为空
                            if("N".equalsIgnoreCase(item.getNullable())){
                                editSql+=" not null ";
                            }else if("Y".equalsIgnoreCase(item.getNullable())){
                                editSql+=" null ";
                            }
                            //判断是新增还是编辑
                            if(!StringHelper.isTrimEmpty(editSql)){
                                if(item.getIsAdd()==1){
                                    sql.append(String.format("alter table %s add %s %s;",tableName,item.getNewName(),editSql)+System.getProperty("line.separator"));
                                }else {
                                    sql.append(String.format("alter table %s modify %s %s;",tableName,item.getNewName(),editSql)+System.getProperty("line.separator"));
                                }
                            }
                            //endregion
                            //备注
                            if(!StringHelper.isTrimEmpty(item.getComment())) {
                                commentSql.append(String.format("comment on column %s.%s is '%s';", tableName,item.getNewName(), item.getComment()) + System.getProperty("line.separator"));
                            }
                        }
                    }
                }
                //删除对应的列
                if(dropcolums!=null&&dropcolums.size()>0){
                    for (String name:dropcolums){
                        if(!StringHelper.isTrimEmpty(name)) {
                            sql.append(String.format("alter table %s drop column %s;", tableName, name));
                        }
                    }
                }
                //主键--若存在修改，则删除原先的主键，重新设置
                if("y".equalsIgnoreCase(changeprimarykey)) {
                    //若原来存在主键，则删除
                    if (existPrimarykey(conn, tableName)) {
                        sql.append(String.format("alter table %s drop primary key;", tableName));
                    }
                    if (primarykeys != null && primarykeys.size() > 0) {
                        //添加新的主键
                        sql.append(getAddPrimarykeySql(tableName, primarykeys));
                    }
                }
            }
        }else {
            //表不存在，新建表
            if(columInfos==null||columInfos.size()==0){
                return "";
            }
            commentSql.append(String.format("comment on table %s is '%s';", tableName,tableComment) + System.getProperty("line.separator"));
            sql.append("create table "+tableName+"(");
            for (EditTableColumInfo  item:columInfos){
                //region 列的信息
                //类型
                sql.append(item.getNewName()+" "+getDatatypeSql(item.getDataType(),item.getDataLength(),item.getDataPrecision()));
                //默认值
                if(!StringHelper.isTrimEmpty(item.getDataDefault())){
                    if(TConverter.ObjectToLong(item.getDataDefault())>0){
                        sql.append(" default " + item.getDataDefault() + " ");
                    }
                    else {
                        sql.append(" default '" + item.getDataDefault() + "' ");
                    }
                }
                //不为空
                if("N".equals(item.getNullable())||"n".equals(item.getNullable())){
                    sql.append(" not null ");
                }
                if(columInfos.indexOf(item)!=columInfos.size()-1){
                    sql.append(","+System.getProperty("line.separator"));
                }else {
                    sql.append(System.getProperty("line.separator"));
                }
                //endregion
                //备注
                if(!StringHelper.isTrimEmpty(item.getComment())) {
                    commentSql.append(String.format("comment on column %s.%s is '%s';", tableName,item.getNewName(), item.getComment()) + System.getProperty("line.separator"));
                }
            }
            sql.append(");");
            //添加主键信息
            sql.append(getAddPrimarykeySql(tableName,primarykeys));
        }
        //添加备注信息
        sql.append(commentSql);
        return sql.toString();
    }

    //获取表的创建的sql语句
    public static String getCreateSqlOfTable(Connection conn, String tableName) throws SQLException {
        ResultSet rSet = null;
        try {
            String sql = String.format("SELECT DBMS_METADATA.GET_DDL('TABLE','%s') SQL FROM DUAL", tableName.trim().toUpperCase());
            rSet = conn.prepareStatement(sql).executeQuery();
            if (rSet.next()) {
                return rSet.getString("SQL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
        return null;
    }
    //判断是否存在主键
    public static boolean existPrimarykey(Connection conn, String tableName)throws Exception{
        ResultSet rSet = null;
        try {
            rSet = conn.getMetaData().getPrimaryKeys(null,null,tableName.toUpperCase());
            while (rSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
        return false;
    }
    //添加主键的语句
    public static String getAddPrimarykeySql(String tableName,List<String> primarykeys){
        if(primarykeys==null||primarykeys.size()==0){
            return "";
        }
        String primarykey="";
        for (String key:primarykeys){
            if(!StringHelper.isTrimEmpty(key)){
                if(!StringHelper.isTrimEmpty(primarykey)){
                    primarykey+=",";
                }
                primarykey+=key;
            }
        }
        if(!StringHelper.isTrimEmpty(primarykey)){
            return String.format("ALTER TABLE %S ADD CONSTRAINT PK_%S PRIMARY KEY(%S);",tableName,tableName.toUpperCase(),primarykey);
        }
        return "";
    }
    //获取字段类型的sql
    public static String getDatatypeSql(String datatype,int length,int precision){
        if(!StringHelper.isTrimEmpty(datatype)) {
            if (length > 0) {
                datatype += "(" + length;
                if (precision > 0) {
                    datatype += "," + precision;
                }
                datatype += ")";
            }
            return datatype;
        }
        return "";
    }
    //执行语句
    public static BaseResponse runSql(Connection conn, String strSql)throws Exception{
        Statement  stmt = null;
        try {
            stmt = conn.createStatement();
            for (String item:strSql.split(";")){
                if(!StringHelper.isTrimEmpty(item)){
                    stmt.addBatch(item);
                }
            }
            //执行批量执行
            stmt.executeBatch();
            return new BaseResponse("成功");
        } catch (SQLException e) {
            e.printStackTrace();
            return new BaseResponse(ReturnCodeConst.ERROR,e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    //导出表模板
    public static List<List<String>> exportTableTemplate(Connection conn,String tableName)throws Exception{
        ResultSet rSet = null;
        try {
            String sql = String.format("SELECT * FROM %s WHERE ROWNUM<1", tableName);
            rSet = conn.prepareStatement(sql).executeQuery();
            ResultSetMetaData rsmt = rSet.getMetaData();
            List<String> header=new ArrayList<>();
            for(int i=1;i<=rsmt.getColumnCount();i++){
                //拿到表头信息
                header.add(rsmt.getColumnName(i));
            }
            List<List<String>> list=new ArrayList<>();
            list.add(header);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
        return null ;
    }
    //向表中添加数据
    public static BaseResponse insertDataToTable(Connection conn,String tableName,List<List<Object>> data)throws Exception{
        //第一行为表列名称，若只有1行，则表示没有数据
        if(data==null||data.size()<=1){
            return new BaseResponse(ReturnCodeConst.ERROR,"没有数据");
        }
        PreparedStatement pSt = null;
        try {
            //获取表头
            List<Object> header=data.get(0);
            //组合插入语句的值--若excel中第一行包含seq，则包含seq的的所有列均默认为对应的seq的值
            StringBuffer vals=new StringBuffer("");
            List<Integer> seqCells=new ArrayList<>();
            for (Object item:header){
                if(vals.length()>0){
                    vals.append(",");
                }
                String val1=StringHelper.toSafeString(data.get(1).get(header.indexOf(item))).toLowerCase();
                if(val1.startsWith("[seq_")&&val1.endsWith("]")){
                    seqCells.add(header.indexOf(item));
                    vals.append(String.format("%s.nextval",val1.replace("[","").replace("]","")));
                }else {
                    vals.append("?");
                }
            }
            String sql = String.format("insert into %s values(%s)", tableName,vals);
            pSt = conn.prepareStatement(sql);
            int index=0;
            int paramIndex=1;
            for (int i=1;i<data.size();i++){
                index++;
                paramIndex=1;
                for (int j=0;j<data.get(i).size();j++){
                    //若字段为[uuid]，则随机生成
                    if(StringHelper.toSafeString(data.get(i).get(j)).equalsIgnoreCase("[uuid]")){
                        pSt.setObject(paramIndex++, UUIDUtil.getUUID());
                    }else if(StringHelper.toSafeString(data.get(i).get(j)).equalsIgnoreCase("[nowtime]")){
                        //当前时间
                        pSt.setObject(paramIndex++, new Date());
                    } else if(seqCells.contains(j)){
                        //seq
                        continue;
                    }
                    else {
                        pSt.setObject(paramIndex++, data.get(i).get(j));
                    }
                }
                pSt.addBatch();
                // 批处理
                if (index% 10000 == 0) {
                    pSt.executeBatch();
                    pSt.clearBatch();
                }
            }
            pSt.executeBatch();
            pSt.clearBatch();
            return new BaseResponse("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(ReturnCodeConst.ERROR,e.getMessage());
        } finally {
            if (pSt != null) {
                pSt.close();
            }
        }
    }
    //获取表数据
    public static List<Map<String,Object>> getTableData(Connection conn,String tableName,int count,String wheresql)throws Exception{
        if (!StringHelper.isTrimEmpty(wheresql)){
            wheresql="("+wheresql+") and ";
        }else {
            wheresql="";
        }
        String sql=String.format("select * from %s where %s  rownum<=%d ",tableName,wheresql,count);
        return getDataFromSQL(conn,sql);
    }
    //清空表
    public static void emptyTable(Connection conn,String tableName)throws Exception{
        PreparedStatement pSt = null;
        try {
            String sql = String.format("TRUNCATE TABLE %S", tableName);
            pSt = conn.prepareStatement(sql);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pSt != null) {
                pSt.close();
            }
        }
    }
    //获取数据
    public static  List<Map<String,Object>> getDataFromSQL(String dbcode,String sql)throws Exception{
        if(StringHelper.isTrimEmpty(dbcode)||StringHelper.isTrimEmpty(sql)){
            return null;
        }
        try {
            Connection conn=getConnection(dbcode);
            if(conn!=null){
                return getDataFromSQL(conn,sql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //获取数据
    public static  List<Map<String,Object>> getDataFromSQL(Connection conn,String sql) throws Exception{
        try {
            if(StringHelper.isTrimEmpty(sql)){
                return null;
            }
            ResultSet rset = conn.prepareStatement(sql).executeQuery();
            ResultSetMetaData md = rset.getMetaData(); //获得结果集结构信息,元数据
            List<Map<String, Object>> list = new ArrayList<>();
            while (rset.next()) {
                //region 赋值
                Map<String, Object> rowData = new HashMap<>();
                for (int j = 1; j <= md.getColumnCount(); j++) {
                    if (rset.getObject(j) instanceof oracle.sql.TIMESTAMP) {
                        rowData.put(md.getColumnName(j).toLowerCase(), DateHelper.date2Str(rset.getDate(j)));
                    } else {
                        rowData.put(md.getColumnName(j).toLowerCase(), rset.getObject(j));
                    }
                }
                list.add(rowData);
            }
            rset.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
*/
