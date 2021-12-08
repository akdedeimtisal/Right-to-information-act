
import java.sql.*;
import java.util.*;

interface ModelInterface {

    abstract ResultSet select(Map<String, Object> whereParameters) throws Exception;
    
    
      abstract ResultSet selectSonuclanmamis(Map<String, Object> whereParameters) throws Exception;
      
      abstract ResultSet selectGiris(Map<String, Object> whereParameters) throws Exception;
     abstract ResultSet selectRapor(Map<String, Object> whereParameters) throws Exception;

    abstract ResultSet selectBasvuru(Map<String, Object> whereParameters) throws Exception;

    abstract ResultSet selectSurec(Map<String, Object> whereParameters) throws Exception;

    abstract ResultSet selectKurum(Map<String, Object> whereParameters) throws Exception;

    abstract int insert(String fieldNames, List<Object> rows) throws Exception;

    abstract int insertBasvuru(String fieldNames, List<Object> rows) throws Exception;

    abstract int insertSonuc(String fieldNames, List<Object> rows) throws Exception;

    abstract int insertSurec(String fieldNames, List<Object> rows) throws Exception;

    abstract int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception;

    abstract int delete(Map<String, Object> whereParameters) throws Exception;

    abstract ResultSet selectSonuc(Map<String, Object> whereParameters) throws Exception;

    default ModelData execute(ViewData viewData) throws Exception {
        if (viewData.viewParameters == null) {
            return new ModelData();
        }

        switch (viewData.operationName) {
            case "select": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = select(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }
            
            case "selectSonuclanmamis": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectSonuclanmamis(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }
            
            
               case "selectGiris": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectGiris(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }

            case "selectBasvuru": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectBasvuru(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }

            case "selectSurec": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectSurec(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }

            case "selectSonuc": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectSonuc(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }
             case "selectRapor": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectRapor(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }

            case "selectKurum": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                ResultSet resultSet = selectKurum(whereParameters);

                return new ModelData(viewData.functionName, resultSet);
            }

            case "insert": {
                String fieldNames = (String) (viewData.viewParameters.get("fieldNames"));
                List<Object> rows = (List<Object>) (viewData.viewParameters.get("rows"));

                int recordCount = insert(fieldNames, rows);

                return new ModelData(viewData.functionName, recordCount);
            }

            case "insertSonuc": {
                String fieldNames = (String) (viewData.viewParameters.get("fieldNames"));
                List<Object> rows = (List<Object>) (viewData.viewParameters.get("rows"));

                int recordCount = insertSonuc(fieldNames, rows);

                return new ModelData(viewData.functionName, recordCount);
            }

            case "insertSurec": {
                String fieldNames = (String) (viewData.viewParameters.get("fieldNames"));
                List<Object> rows = (List<Object>) (viewData.viewParameters.get("rows"));

                int recordCount = insertSurec(fieldNames, rows);

                return new ModelData(viewData.functionName, recordCount);
            }

            case "insertBasvuru": {
                String fieldNames = (String) (viewData.viewParameters.get("fieldNames"));
                List<Object> rows = (List<Object>) (viewData.viewParameters.get("rows"));

                int recordCount = insertBasvuru(fieldNames, rows);

                return new ModelData(viewData.functionName, recordCount);
            }
            case "update": {
                Map<String, Object> updateParameters = (Map<String, Object>) (viewData.viewParameters.get("updateParameters"));
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                int recordCount = update(updateParameters, whereParameters);

                return new ModelData(viewData.functionName, recordCount);
            }
            case "delete": {
                Map<String, Object> whereParameters = (Map<String, Object>) (viewData.viewParameters.get("whereParameters"));

                int recordCount = delete(whereParameters);

                return new ModelData(viewData.functionName, recordCount);
            }
        }

        return new ModelData();
    }

}
