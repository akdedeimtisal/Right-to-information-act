/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class BasvuruSahibiView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            case "select":
                return selectOperation(modelData);

            case "insert":
                return insertOperation(modelData);

            case "select.gui":
                return selectGUI(modelData);

            case "insert.gui":
                return insertGUI(modelData);

        }

        return new ViewData("MainMenu", "");
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
// Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
// to calculate message digest of an input
// and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
// Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    //KULLANICI  SİSTEME ÜYE OLUYOR
    public ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "BasvuruSahibiTipID, Ad,Soyad, Sifre, TurkVatandasi, TCKN,  Telefon, IsTelefonu, Fax, EPosta, Unvan, AdresID, Adres");

        List<Object> rows = new ArrayList<>();

        int basvuruSahibiID = 0;
        short basvuruSahibiTipID; // gercek tuzel
        String ad;
        String soyad;
        short turkVatandasi;
        String tcKimlikNo = "";
        String sifre;
        String telefonNo;
        String isTelefonu;
        String fax;
        String ePosta;
        String unvan = "";
        int adresID;
        String adres;
       
        System.out.println("Gercek kişi için 1, Tüzel kişi için 2'ye basınız: ");
        basvuruSahibiTipID = getShort("BasvuruSahibiTipID: ", true);
        ad = getString("Ad : ", true);
        soyad = getString("Soyad : ", true);
        sifre = getString("Sifre:", true);
        sifre = toHexString(getSHA(sifre));
        System.out.println("Turk Vatandaşı iseniz 1'e değilseniz 0'a basınız: ");
        turkVatandasi = getShort("", true);
        if (turkVatandasi == 1) {
            tcKimlikNo = getString("TCKN:", true);
        }

        //   tcKimlikNo = getString("TCKN:", true);
        telefonNo = getString("Telefon:", true);
        isTelefonu = getString("IsTelefonu:", true);
        fax = getString("Fax:", true);
        //    evTelefonu = getInteger("ev telefonu:", true);
        ePosta = getString("EPosta:", true);
        if (basvuruSahibiTipID == 2) {
            unvan = getString("Unvan: ", true);
        }
        adresID = getInteger("AdresID:", true);
        adres = getString("Adres:", true);

        System.out.println();

        
        if (basvuruSahibiID != -1 && basvuruSahibiTipID != -1 && ad != null
                && soyad != null && sifre != null
                && turkVatandasi != -1 && tcKimlikNo != null && telefonNo != null && isTelefonu != null && fax != null && ePosta != null && unvan != null && adresID != -1 && adres != null) {
           
            rows.add(new BasvuruSahibi(basvuruSahibiID,basvuruSahibiTipID, ad, soyad, sifre, turkVatandasi, tcKimlikNo, telefonNo, isTelefonu, fax, ePosta, unvan, adresID, adres));
        }
    
        parameters.put("rows", rows);
        return new ViewData("BasvuruSahibi", "insert", parameters);
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;
        int i = 0;
        if (resultSet != null) {
            int ID = getInteger("ID'nizi giriniz: ", true);
            String girisSifre = getString("Şifrenizi giriniz: ", true);
            girisSifre = toHexString(getSHA(girisSifre));
            while (resultSet.next()) {
                // Retrieve by column name
                int basvuruSahibiID = resultSet.getInt("BasvuruSahibiID");
                String sifre = resultSet.getString("Sifre");

                if (ID == basvuruSahibiID && girisSifre.equals(sifre)) {
                    i = 1;
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

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");

        Integer basvuruSahibiID = getInteger("BasvuruSahibiID : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (basvuruSahibiID != null) {
            whereParameters.put("[Kullanici.BasvuruSahibi].BasvuruSahibiID", basvuruSahibiID);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BasvuruSahibi", "select", parameters);
    }

}
