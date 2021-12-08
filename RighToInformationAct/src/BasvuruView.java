
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BasvuruView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            case "select":
                return selectOperation(modelData);
            case "insert":
                return insertOperation(modelData);
            case "update":
                return updateOperation(modelData);
            case "delete":
                return deleteOperation(modelData);
            case "selectSurec":
                return selectSurecOperation(modelData);
            case "selectKurum":
                return selectKurumOperation(modelData);
             
            case "select.gui":
                return selectGUI(modelData);
           case "selectSonuc":
              return selectSonucOperation(modelData);
            case "selectSonuc.gui":
                return selectSonucGUI(modelData);

                
            case "insert.gui":
                return insertGUI(modelData);

            case "selectSurec.gui":
                return selectSurecGUI(modelData);
            case "update.gui":
                return updateGUI(modelData);
            case "delete.gui":
                return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");

    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int basvuruNo = resultSet.getInt("BasvuruNo");
                int basvuruSahibiID = resultSet.getInt("BasvuruSahibiID");
                int basvuruPersonelID = resultSet.getInt("BasvuruPersonelID");
                int basvuruKurumID = resultSet.getInt("BasvuruKurumID");
                short basvuruTipiID = resultSet.getShort("BasvuruTipiID");
                short basvuruCevapTipiID = resultSet.getShort("BasvuruCevapTipiID");
                String basvuruNedeni = resultSet.getString("BasvuruNedeni");
                String basvuruTarihi = resultSet.getString("BasvuruTarihi");
                /*    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                 Date BasvuruTarihi = format.parse(basvuruTarihi); */
                String basvuruSonTarihi = resultSet.getString("BasvuruSonTarihi");
                String ekBilgiTalebi = resultSet.getString("EkBilgiTalebi");

                // Display values
                System.out.print(basvuruNo + "\t");
                System.out.print(basvuruSahibiID + "\t");
                System.out.print(basvuruPersonelID + "\t");
                System.out.print(basvuruKurumID + "\t");
                System.out.print(basvuruTipiID + "\t");
                System.out.print(basvuruCevapTipiID + "\t");
                System.out.print(basvuruNedeni + "\t");
                System.out.print(basvuruTarihi + "\t");
                System.out.print(basvuruSonTarihi + "\t");
                System.out.print(ekBilgiTalebi + "\t");
                System.out.println("");

            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectSurecOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int basvuruNo = resultSet.getInt("BasvuruNo");
                //      int surecID = resultSet.getInt("SurecID");
                String surecIDAdi = resultSet.getString("SurecIDAdi");
                Date surecTarih = resultSet.getDate("SurecTarih");

                // Display values
                System.out.print(basvuruNo + "\t");
                //    System.out.print(surecID + "\t");
                System.out.print(surecIDAdi + "\t");
                System.out.print(surecTarih + "\t");
                System.out.println("");
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }
    
    
    
    
 ViewData selectSonucOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int basvuruNo = resultSet.getInt("BasvuruNo");
                //      int surecID = resultSet.getInt("SurecID");
                String retsebebi = resultSet.getString("RetSebebi");
                String bilgi = resultSet.getString("Bilgi");
                float ucret = resultSet.getFloat("Ucret");
                String basvuruaciklama = resultSet.getString("BasvuruCevabiAciklama");
                

                // Display values
                System.out.print(basvuruNo + "\t");
                //    System.out.print(surecID + "\t");
                System.out.print(retsebebi + "\t");
                System.out.print(bilgi + "\t");
                  System.out.print(ucret + "\t");
                System.out.print(basvuruaciklama + "\t");
                System.out.println("");
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

     ViewData selectSonucGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());
        return new ViewData("Basvuru", "selectSonuc", parameters);
    }
    
     ViewData selectKurumOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int kurumID = resultSet.getInt("KurumID");
  
                String kurumAdi = resultSet.getString("KurumAdi");
                
                System.out.print(kurumID + "\t");
                System.out.print(kurumAdi + "\t");
                
                System.out.println("");
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }
    
    

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");

        Integer basvuruNo = getInteger("BasvuruNo : ", true);
        /*       Integer basvuruSahibiID = getInteger("BasvuruSahibiID : ", true);
         Integer basvuruPersonelID = getInteger("BasvuruPersonelID : ", true);
         Integer basvuruKurumID = getInteger("BasvuruKurumID : ", true);
         Integer basvuruTipiID = getInteger("BasvuruTipiID : ", true);
         Integer basvuruCevapTipiID = getInteger("BasvuruCevapTipiID : ", true);
         String basvuruNedeni = getString("BasvuruNedeni : ", true);
         //       Date basvuruTarihi = getDate("BasvuruTarihi : ", true);
         //      Date basvuruSonTarihi = getDate("BasvuruSonTarihi : ", true);
         String ekBilgiTalebi = getString("EkBilgiTalebi : ", true);*/

        Map<String, Object> whereParameters = new HashMap<>();
        if (basvuruNo != null) {
            whereParameters.put("Basvuru.BasvuruNo", basvuruNo);
        }
        /*    if (basvuruSahibiID != null) {
         whereParameters.put("BasvuruSahibiID", basvuruSahibiID);
         }
         if (basvuruPersonelID != null) {
         whereParameters.put("BasvuruPersonelID", basvuruPersonelID);
         }
         if (basvuruKurumID != null) {
         whereParameters.put("BasvuruKurumID", basvuruNo);
         }
         if (basvuruTipiID != null) {
         whereParameters.put("BasvuruTipiID", basvuruTipiID);
         }
         if (basvuruCevapTipiID != null) {
         whereParameters.put("BasvuruCevapTipiID", basvuruCevapTipiID);
         }
         if (basvuruNedeni != null) {
         whereParameters.put("BasvuruNedeni", basvuruNedeni);
         }
         if (ekBilgiTalebi != null) {
         whereParameters.put("ekBilgiTalebi", ekBilgiTalebi);
         }*/

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Basvuru", "select", parameters);
    }
  /*   ViewData selectKurumGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Basvuru", "selectKurum", parameters);
    }*/

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "BasvuruSahibiID, BasvuruPersonelID, BasvuruKurumID, BasvuruTipiID, BasvuruCevapTipiID, BasvuruNedeni, EkBilgiTalebi");

        List<Object> rows = new ArrayList<>();

        int basvuruNo = 0;
        int basvuruSahibiID;
        int basvuruPersonelID = 1;
        int basvuruKurumID;
        short basvuruTipiID = 2 ; //online başvuru
        short basvuruCevapTipiID;
        String basvuruNedeni;
        Date basvuruTarihi = null;
        Date basvuruSonTarihi = null;
        String ekBilgiTalebi;
        //	do
        //	{
        System.out.println("Fields to insert:");
     //   basvuruNo = getInteger("basvuruNo : ", true);
        basvuruSahibiID = getInteger("basvuruSahibiID : ", true);
   //     basvuruPersonelID = getInteger("BasvuruPersonelID : ", true);
        basvuruKurumID = getInteger("BasvuruKurumID : ", true);
        System.out.println("1. Web\n2. Email\n3. Fax\n4. Yazili");
     //   basvuruTipiID = getShort("BasvuruTipiID", true);
        basvuruCevapTipiID = getShort("BasvuruCevapTipiID", true);
        basvuruNedeni = getString("BasvuruNedeni : ", true);
   //     basvuruTarihi = getString("BasvuruTarihi", true);
   //     basvuruSonTarihi = getString("BasvuruSonTarihi", true);
        ekBilgiTalebi = getString("EkBilgiTalebi : ", true);
        System.out.println();

        if (basvuruSahibiID != -1 && basvuruPersonelID != -1 && basvuruKurumID != -1
                && basvuruTipiID != -1 && basvuruCevapTipiID != -1
                && basvuruNedeni != null && ekBilgiTalebi != null) {
            rows.add(new Basvuru(basvuruNo, basvuruSahibiID, basvuruPersonelID, basvuruKurumID, basvuruTipiID, basvuruCevapTipiID, basvuruNedeni, basvuruTarihi, basvuruSonTarihi, ekBilgiTalebi));
        }
        //	}
	/*	while (basvuruSahibiID != -1 && basvuruPersonelID != -1 && basvuruKurumID != -1
         && basvuruTipiID != -1 && basvuruCevapTipiID != -1    
         && basvuruNedeni != null );
         */
        parameters.put("rows", rows);

        return new ViewData("Basvuru", "insert", parameters);
    }

    /*  Map<String, Object> getWhereParametersforSurec() throws Exception {
     System.out.println("Filter conditions:");
     Integer basvuruNo = getInteger("BasvuruNo : ", true);

     Map<String, Object> whereParameters = new HashMap<>();
     if (basvuruNo != null) {
     whereParameters.put("BasvuruNo", basvuruNo);
     }

     return whereParameters;
     }*/
    ViewData selectSurecGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());
        return new ViewData("Basvuru", "selectSurec", parameters);
    }
    
    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        String name = getString("Name : ", true);
        String groupName = getString("Group Name : ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (name != null) {
            updateParameters.put("Name", name);
        }
        if (groupName != null) {
            updateParameters.put("GroupName", groupName);
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Department", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Basvuru", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Basvuru View";
    }

}
