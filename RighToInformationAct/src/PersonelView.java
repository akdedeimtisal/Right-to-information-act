
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonelView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            case "selectBasvuru":
                return selectBasvuruOperation(modelData);
            case "selectGiris":
                return selectGirisOperation(modelData);
            case "selectSonuclanmamis":
                return selectSonuclanmamisOperation(modelData);
            case "insertBasvuru":
                return insertBasvuruOperation(modelData);

            case "insertBasvuru.gui":
                return insertBasvuruGUI(modelData);

            case "insertSonuc":
                return insertSonucOperation(modelData);

            case "insertSonuc.gui":
                return insertSonucGUI(modelData);

            case "insertSurec":
                return insertSurecOperation(modelData);

            case "selectRapor":
                return selectRaporOperation(modelData);

            case "insertSurec.gui":
                return insertSurecGUI(modelData);

        }

        return new ViewData("MainMenu", "");

    }

    ViewData selectBasvuruOperation(ModelData modelData) throws Exception {
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

    ViewData selectSonuclanmamisOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;
        System.out.println("SONUÇLANDIRILMAMIŞ BAŞVURU NUMARALARI\n");
        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int basvuruNo = resultSet.getInt("BasvuruNo");

                // Display values
                System.out.print(basvuruNo + "\t");
                System.out.println("");

            }

            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

    public static short YetkiID;
    public static short flag = 0;

    ViewData selectGirisOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;
        System.out.println("GİRİŞ\n");
        int i = 0;
        if (resultSet != null) {
            int ID = getInteger("ID'nizi giriniz: ", true);
            String girisSifre = getString("Şifrenizi giriniz: ", true);
            //girisSifre = toHexString(getSHA(girisSifre));
            while (resultSet.next()) {
                // Retrieve by column name
                int personelID = resultSet.getInt("PersonelID");
                String ad = resultSet.getString("Ad");
                String soyad = resultSet.getString("Soyad");
                String sifre = resultSet.getString("Sifre");
                YetkiID = resultSet.getShort("YetkiID");

                if (ID == personelID && girisSifre.equals(sifre)) {
                    i = 1;
                    flag = 1 ;
                    YetkiID = resultSet.getShort("YetkiID");
                    System.out.println("Hoş geldiniz. Giriş başarılı.");
                    break;
                }
            }
            if (i == 0) {
                System.out.println("Kullanıcı ID'niz ya da şifrenizi hatalı girdiniz.");

            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectRaporOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;
        int toplamBasvuru = -1;
        int olumluBasvuru = -1;
        int reddedilenBasvuru = -1;
        int gizliBasvuru = -1;
        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                toplamBasvuru = resultSet.getInt("x");
                reddedilenBasvuru = resultSet.getInt("y");
                olumluBasvuru = resultSet.getInt("z");
                gizliBasvuru = resultSet.getInt("t");

                // Display values
            }
            resultSet.close();
            System.out.println(" TOPLAM BASVURU SAYISI : " + toplamBasvuru);
            System.out.println(" REDDEDİLEN BASVURU SAYISI : " + reddedilenBasvuru);
            System.out.println(" OLUMLU BASVURU SAYISI : " + olumluBasvuru);
            System.out.println(" GİZLİ BASVURU HARİCİ SAYISI : " + gizliBasvuru);
            System.out.println("");

        }

        return new ViewData("MainMenu", "");
    }

    ViewData insertBasvuruOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);
        return new ViewData("MainMenu", "");
    }

    ViewData insertSonucOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);
        return new ViewData("MainMenu", "");
    }

    ViewData insertSurecOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);
        return new ViewData("MainMenu", "");
    }

    ViewData insertBasvuruGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "BasvuruSahibiID, BasvuruPersonelID, BasvuruKurumID, BasvuruTipiID, BasvuruCevapTipiID, BasvuruNedeni, EkBilgiTalebi");

        List<Object> rows = new ArrayList<>();

        int basvuruNo = 0;
        int basvuruSahibiID;
        int basvuruPersonelID = 1;
        int basvuruKurumID;
        short basvuruTipiID = 1;  //yazılı başvuru
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

        return new ViewData("Personel", "insertBasvuru", parameters);
    }

    ViewData insertSonucGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "BasvuruNo, BilgiMi, Bilgi, BelgeID, Ucret, RetID, BasvuruCevabiAciklama");

        List<Object> rows = new ArrayList<>();

        int basvuruNo = 0;
        short bilgiMi = 1;
        short belgeID;
        float ucret;
        short retID;
        String bilgi;
        String basvuruCevabiAciklama;

        System.out.println("Fields to insert:");

        basvuruNo = getInteger("BasvuruNo : ", true);
        bilgiMi = getShort("BilgiMi : ", true);

        bilgi = getString("Bilgi : ", true);
        belgeID = getShort("BelgeID: ", true);
        ucret = getFloat("Ucret: ", true);
        retID = getShort("RetID: ", true);
        basvuruCevabiAciklama = getString("BasvuruCevabiAciklama : ", true);
        System.out.println();

        if (basvuruNo != -1 && bilgiMi != -1 && belgeID != -1
                && ucret != -1 && retID != -1
                && bilgi != null && basvuruCevabiAciklama != null) {
            rows.add(new Basvuru(basvuruNo, bilgiMi, bilgi, belgeID, ucret, retID, basvuruCevabiAciklama));
        }

        parameters.put("rows", rows);

        return new ViewData("Personel", "insertSonuc", parameters);
    }

    ViewData insertSurecGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "BasvuruNo, SurecID");

        List<Object> rows = new ArrayList<>();

        int basvuruNo = 0;
        int ID = 0;
        short surecID;
        Date surecTarih = null;

        System.out.println("Fields to insert:");

        basvuruNo = getInteger("BasvuruNo : ", true);
        //    ID = getInteger("ID : ", true);

        surecID = getShort("SurecID: ", true);
        //    surecTarih = getDate("SurecTarih: ", true);

        System.out.println();

        if (basvuruNo != -1 && ID != -1 && surecID != -1) {
            rows.add(new Basvuru(basvuruNo, ID, surecID, surecTarih));
        }

        parameters.put("rows", rows);

        return new ViewData("Personel", "insertSurec", parameters);
    }

}
