package service;

import entity.Condition;
import org.json.simple.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService
public interface DataLayerService {

    @WebMethod
    ArrayList<Object> select(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "conditionsList") List<Condition> condition
    ) throws Exception;

    @WebMethod
    Boolean insert(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "conditionsList") List<Condition> condition
    ) throws Exception;

    @WebMethod
    Boolean update(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "valuesList") List<Condition> values,
            @WebParam(name = "conditionsList") List<Condition> conditions
    ) throws Exception;

    @WebMethod
    Boolean delete(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "conditionsList") List<Condition> condition
    ) throws Exception;
}
