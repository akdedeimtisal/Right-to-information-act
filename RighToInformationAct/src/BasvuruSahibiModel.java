
import java.sql.*;
import java.util.*;

public class BasvuruSahibiModel implements ModelInterface {

    @Override
    public ResultSet select(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("  BasvuruSahibiID, Sifre");
        sql.append(" FROM [Kullanici.BasvuruSahibi]");
        System.out.println("Giriş Ekranı");
        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;

    }

    @Override
    public int insert(String fieldNames, List<Object> rows) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO [Kullanici.BasvuruSahibi] (" + fieldNames + ") ");
        sql.append(" VALUES ");
        System.out.println("merhaba");
        String[] fieldList = fieldNames.split(",");

        int rowCount = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i) instanceof BasvuruSahibi) {
                rowCount++;

                BasvuruSahibi basvuruSahibi = (BasvuruSahibi) rows.get(i);
                sql.append("(");
                for (int j = 0; j < fieldList.length; j++) {
                    String fieldName = fieldList[j].trim();
                    sql.append(DatabaseUtilities.formatField(basvuruSahibi.getByName(fieldName)));
                    if (j < fieldList.length - 1) {
                        sql.append(", ");
                    }
                }
                sql.append(")");

                if (i < rows.size() - 1) {
                    sql.append(", ");
                }
            }
        }

        //System.out.println(sql.toString());
        // execute constructed SQL statement
        if (rowCount > 0) {
            Connection connection = DatabaseUtilities.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        return rowCount;
    }

    @Override
    public String toString() {
        return "Basvuru Sahibi Model";
    }

    @Override
    public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectSurec(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectSonuc(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectKurum(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectBasvuru(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertBasvuru(String fieldNames, List<Object> rows) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertSonuc(String fieldNames, List<Object> rows) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertSurec(String fieldNames, List<Object> rows) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectRapor(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectSonuclanmamis(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selectGiris(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
