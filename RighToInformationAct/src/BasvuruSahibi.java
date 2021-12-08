
public class BasvuruSahibi {

    private int basvuruSahibiID;
    private short basvuruSahibiTipID; // gercek tuzel
    private String ad;
    private String soyad;
    private short turkVatandasi;
    private String tcKimlikNo;
    private String sifre;
    private String telefonNo;
    private String isTelefonu;
    private String fax;
    private String ePosta;
    private String unvan;
    private int adresID;
    private String adres;

    public BasvuruSahibi(int basvuruSahibiID, short basvuruSahibiTipID, String ad, String soyad, String sifre, short turkVatandasi, String tcKimlikNo, String telefonNo, String isTelefonu, String fax, String ePosta, String unvan, int adresID, String adres) {
        this.basvuruSahibiID = basvuruSahibiID;
        this.basvuruSahibiTipID = basvuruSahibiTipID;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.turkVatandasi = turkVatandasi;
        this.tcKimlikNo = tcKimlikNo;
        this.telefonNo = telefonNo;
        this.isTelefonu = isTelefonu;
        this.fax = fax;
        this.ePosta = ePosta;
        this.unvan = unvan;
        this.adresID = adresID;
        this.adres = adres;
    }
    
    
    
    
    public BasvuruSahibi( short basvuruSahibiTipID, String ad, String soyad, String sifre, short turkVatandasi, String tcKimlikNo, String telefonNo, String isTelefonu, String fax, String ePosta, String unvan, int adresID, String adres) {
        this.basvuruSahibiTipID = basvuruSahibiTipID;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.turkVatandasi = turkVatandasi;
        this.tcKimlikNo = tcKimlikNo;
        this.telefonNo = telefonNo;
        this.isTelefonu = isTelefonu;
        this.fax = fax;
        this.ePosta = ePosta;
        this.unvan = unvan;
        this.adresID = adresID;
        this.adres = adres;
    }
    
    

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    //basvuru sahibi id sistem tarafından otomatik olarak verilecektir
    //set ile databaseden geleni nesneye yazıp
    //get ile kullanıcıya bildiriyoruz
    public int getBasvuruSahibiID() {
        return basvuruSahibiID;
    }

    public void setBasvuruSahibiID(int basvuruSahibiID) {
        this.basvuruSahibiID = basvuruSahibiID;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    //ÖNEMLİ BURADA BİR YERLERDE KRİPTOLAMA OLACAK!!!!!
    public String getSifre() {
        return sifre;
    }

   /* public BasvuruSahibi(short basvuruSahibiTipID, String ad, String soyad,
            short turkVatandasi, String sifre, String telefonNo, String ePosta,
            int adresID, String adres) {
        this.basvuruSahibiTipID = basvuruSahibiTipID;
        this.ad = ad;
        this.soyad = soyad;
        this.turkVatandasi = turkVatandasi;
        this.sifre = sifre;
        this.telefonNo = telefonNo;
        this.adresID = adresID;
        this.adres = adres;
    }*/

    public BasvuruSahibi() {

    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "BasvuruSahibiID":
                return basvuruSahibiID;
            case "BasvuruSahibiTipID":
                return basvuruSahibiTipID;
            case "Ad":
                return ad;
            case "Soyad":
                return soyad;
            case "Sifre":
                return sifre;
            case "TurkVatandasi":
                return turkVatandasi;
            case "TCKN":
                return tcKimlikNo;
            case "Telefon":
                return telefonNo;
            case "IsTelefonu":
                return isTelefonu;
            case "Fax":
                return fax;
            case "EPosta":
                return ePosta;
            case "Unvan":
                return unvan;
            case "AdresID":
                return adresID;
            case "Adres":
                return adres;

            default:
                return null;
        }

    }

}
