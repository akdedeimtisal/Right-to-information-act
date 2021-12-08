import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class NopModel implements ModelInterface {

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		return null;
	}
        
        @Override
	public ResultSet selectGiris(Map<String, Object> whereParameters) throws Exception {
		return null;
	}
        
        
        @Override
	public ResultSet selectSonuclanmamis(Map<String, Object> whereParameters) throws Exception {
		return null;
	}
        
        
       public ResultSet selectRapor(Map<String, Object> whereParameters) throws Exception {
		return null;
	}
        
        @Override
	public ResultSet selectBasvuru(Map<String, Object> whereParameters) throws Exception {
		return null;
	}
        
	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}
        @Override
	public int insertSonuc(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}
        
         @Override
	public int insertSurec(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}
        
        @Override
	public int insertBasvuru(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}
        
	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public int delete(Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public String toString() {
		return "No Operation Model";
	}

    @Override
    public ResultSet selectSurec(Map<String, Object> whereParameters) throws Exception {
                return null;
    
    }

    @Override
    public ResultSet selectSonuc(Map<String, Object> whereParameters) throws Exception {
                return null;
    }

    @Override
    public ResultSet selectKurum(Map<String, Object> whereParameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}