package service;

import entity.Condition;
import org.json.simple.JSONObject;

import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService
public class DataLayerServiceImpl implements DataLayerService {

    private static String getConditionsString(List<Condition> condition) {
        StringBuffer conditions = new StringBuffer();
        conditions.append(" ");
        for (int i = 0; i < condition.size(); i++) {
            Condition cond = condition.get(i);
            conditions.append(cond.getFiledName() + " ");
            conditions.append(cond.getOperator() + " ");
            conditions.append(cond.getValue() + " " + ", ");
        }
        return conditions.toString();
    }

    private static Connection createDatabaseConnection() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://root:root@127.0.0.1:3307/mysql_db");
        return connect;
    }

    @Override
    public ArrayList<Object> select(String tableName, List<Condition> condition) throws Exception {
        String conditions = getConditionsString(condition);
        Connection connect = createDatabaseConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("select * from " + tableName + " where " + conditions);

        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Object> data = new ArrayList<Object>();

        int i = 0;
        while (resultSet.next()) {
            data.add(resultSet.getObject(i));
            i++;
        }
        preparedStatement.close();
        connect.close();
        return data;
    }

    @Override
    public Boolean insert(String tableName, List<Condition> condition) throws Exception {
        String conditions = getConditionsString(condition);
        Connection connect = createDatabaseConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("insert into " + tableName + " values(" + conditions + ")");
        preparedStatement.close();
        connect.close();
        return true;
    }

    @Override
    public Boolean update(String tableName, List<Condition> values, List<Condition> conditions) throws Exception {
        String conditionsString = getConditionsString(conditions);
        Connection connect = createDatabaseConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("update " + tableName + " set " + values + "where " + conditionsString );
        preparedStatement.close();
        connect.close();
        return true;
    }

    @Override
    public Boolean delete(String tableName, List<Condition> condition) throws Exception {
        String conditions = getConditionsString(condition);
        Connection connect = createDatabaseConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("delete from " + tableName + " where " + conditions);
        preparedStatement.close();
        connect.close();
        return true;
    }
}
