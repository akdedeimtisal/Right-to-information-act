
import java.time.Instant;
import java.util.Date;

public class Basvuru {

    private int basvuruNo;
    private int basvuruSahibiID;
    private int basvuruPersonelID;
    private int basvuruKurumID;
    private int basvuruTipiID;
    private int basvuruCevapTipiID;
    private String basvuruNedeni;
    private Date basvuruTarihi;
    private Date basvuruSonTarihi;
    private String ekBilgiTalebi;
    
    private short bilgiMi;
    private String bilgi;
    private short belgeID;
    private float ucret;
    private short retID;
    private String basvuruCevabiAciklama;
    
    private int ID;
    private short surecID;
    private Date surecTarih;
    
    
    

    public int getBasvuruNo() {
        return basvuruNo;
    }

    public Basvuru(int basvuruSahibiID, int basvuruPersonelID, int basvuruKurumID, int basvuruTipiID, int basvuruCevapTipiID, String basvuruNedeni, Date basvuruTarihi, Date basvuruSonTarihi, String ekBilgiTalebi) {
        this.basvuruSahibiID = basvuruSahibiID;
        this.basvuruPersonelID = basvuruPersonelID;
        this.basvuruKurumID = basvuruKurumID;
        this.basvuruTipiID = basvuruTipiID;
        this.basvuruCevapTipiID = basvuruCevapTipiID;
        this.basvuruNedeni = basvuruNedeni;
        this.basvuruTarihi = basvuruTarihi;
        this.basvuruSonTarihi = basvuruSonTarihi;
        this.ekBilgiTalebi = ekBilgiTalebi;
    }

    public void setBasvuruNo(int basvuruNo) {
        this.basvuruNo = basvuruNo;
    }

    public int getBasvuruSahibiID() {
        return basvuruSahibiID;
    }

    public void setBasvuruSahibiID(int basvuruSahibiID) {
        this.basvuruSahibiID = basvuruSahibiID;
    }

    public int getBasvuruPersonelID() {
        return basvuruPersonelID;
    }

    public void setBasvuruPersonelID(int basvuruPersonelID) {
        this.basvuruPersonelID = basvuruPersonelID;
    }

    public int getBasvuruKurumID() {
        return basvuruKurumID;
    }

    public void setBasvuruKurumID(int basvuruKurumID) {
        this.basvuruKurumID = basvuruKurumID;
    }

    public void setBasvuruTipiID(short basvuruTipiID) {
        this.basvuruTipiID = basvuruTipiID;
    }

    public int getBasvuruTipiID() {
        return basvuruTipiID;
    }

    public void setBasvuruTipiID(int basvuruTipiID) {
        this.basvuruTipiID = basvuruTipiID;
    }

    public int getBasvuruCevapTipiID() {
        return basvuruCevapTipiID;
    }

    public void setBasvuruCevapTipiID(int basvuruCevapTipiID) {
        this.basvuruCevapTipiID = basvuruCevapTipiID;
    }

    public Date getBasvuruTarihi() {
        return basvuruTarihi;
    }

    public void setBasvuruTarihi(Date basvuruTarihi) {
        this.basvuruTarihi = basvuruTarihi;
    }

    public Date getBasvuruSonTarihi() {
        return basvuruSonTarihi;
    }

    public void setBasvuruSonTarihi(Date basvuruSonTarihi) {
        this.basvuruSonTarihi = basvuruSonTarihi;
    }

    public void setBasvuruCevapTipiID(short basvuruCevapTipiID) {
        this.basvuruCevapTipiID = basvuruCevapTipiID;
    }

    public String getBasvuruNedeni() {
        return basvuruNedeni;
    }

    public void setBasvuruNedeni(String basvuruNedeni) {
        this.basvuruNedeni = basvuruNedeni;
    }

    public String getEkBilgiTalebi() {
        return ekBilgiTalebi;
    }

    public void setEkBilgiTalebi(String ekBilgiTalebi) {
        this.ekBilgiTalebi = ekBilgiTalebi;
    }

    //şimdi idsini biliyor, başvuru yapacağı kurumun idsini bilecek, cevap ne istiyor onu seçecek (yazılı mı sözlü mü),
    //başvuru nedenini girecek
    //ve ek bilgi null o yüzden constructorda yok. 
    public Basvuru() {
    }

    public Basvuru(int basvuruNo, int basvuruSahibiID, int basvuruPersonelID, int basvuruKurumID, int basvuruTipiID, int basvuruCevapTipiID, String basvuruNedeni, Date basvuruTarihi, Date basvuruSonTarihi, String ekBilgiTalebi) {
        this.basvuruNo = basvuruNo;
        this.basvuruSahibiID = basvuruSahibiID;
        this.basvuruPersonelID = basvuruPersonelID;
        this.basvuruKurumID = basvuruKurumID;
        this.basvuruTipiID = basvuruTipiID;
        this.basvuruCevapTipiID = basvuruCevapTipiID;
        this.basvuruNedeni = basvuruNedeni;
        this.basvuruTarihi = basvuruTarihi;
        this.basvuruSonTarihi = basvuruSonTarihi;
        this.ekBilgiTalebi = ekBilgiTalebi;
    }

    public Basvuru(int basvuruNo, int basvuruSahibiID, int basvuruPersonelID, int basvuruKurumID, short basvuruTipiID, short basvuruCevapTipiID, String basvuruNedeni) {
        this.basvuruNo = basvuruNo;
        this.basvuruSahibiID = basvuruSahibiID;
        this.basvuruPersonelID = basvuruPersonelID;
        this.basvuruKurumID = basvuruKurumID;
        this.basvuruTipiID = basvuruTipiID;
        this.basvuruCevapTipiID = basvuruCevapTipiID;
        this.basvuruNedeni = basvuruNedeni;
    }

    public Basvuru(int basvuruNo, short bilgiMi, String bilgi, short belgeID, float ucret, short retID, String basvuruCevabiAciklama) {
        this.basvuruNo = basvuruNo;
        this.bilgiMi = bilgiMi;
        this.bilgi = bilgi;
        this.belgeID = belgeID;
        this.ucret = ucret;
        this.retID = retID;
        this.basvuruCevabiAciklama = basvuruCevabiAciklama;
    }

    public Basvuru(int basvuruNo, int ID, short surecID, Date surecTarih) {
        this.basvuruNo = basvuruNo;
        this.ID = ID;
        this.surecID = surecID;
        this.surecTarih = surecTarih;
       
    }
    
    

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "BasvuruNo":
                return basvuruNo;
            case "BasvuruSahibiID":
                return basvuruSahibiID;
            case "BasvuruPersonelID":
                return basvuruPersonelID;
            case "BasvuruKurumID":
                return basvuruKurumID;
            case "BasvuruTipiID":
                return basvuruTipiID;
            case "BasvuruCevapTipiID":
                return basvuruCevapTipiID;
            case "BasvuruNedeni":
                return basvuruNedeni;
            case "BasvuruTarihi":
                return basvuruTarihi;
            case "BasvuruSonTarihi":
                return basvuruSonTarihi;
            case "EkBilgiTalebi":
                return ekBilgiTalebi;

            case "BilgiMi":
                return bilgiMi;
            case "Bilgi":
                return bilgi;
            case "BelgeID":
                return belgeID;
            case "Ucret":
                return ucret;
            case "RetID":
                return retID;
            case "BasvuruCevabiAciklama":
                return basvuruCevabiAciklama;
          
            case "ID":
                return ID;
             
            case "SurecID":
                return surecID;
                
            case "SurecTarih":
                return surecTarih;
                
                
          
                
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Basvuru{" + "basvuruNo=" + basvuruNo + '}';
    }

}
