
import java.time.Instant;
import java.util.Date;


 class Personel {
    private int PersonelID;
    private String Ad;
    private String Soyad;
    private String Sifre;
    private int YetkiID;


     Personel(int PersonelID, String Ad, String Soyad, String Sifre, int YetkiID) {
        this.PersonelID = PersonelID;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Sifre = Sifre;
        this.YetkiID = YetkiID;
    }

    public void setPersonelID(int PersonelID) {
        this.PersonelID = PersonelID;
    }

    public int getPersonelID() {
        return PersonelID;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getAd() {
        return Ad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }
    
    public String getSifre() {
        return Sifre;
    }
   
    public void setYetkiID(int YetkiID) {
        this.YetkiID = YetkiID;
    }

    public int getYetkiID() {
        return YetkiID;
    }
   

    public Personel() {
    }

    
      public Object getByName(String attributeName) {
		switch (attributeName) {
			case "PersonelID": return PersonelID;
			case "Ad": return Ad;
			case "Soyad": return Soyad;
			case "Sifre": return Sifre;
            case "YetkiID": return YetkiID;
                
		default: return null;
		}
	}

    @Override
    public String toString() {
        return "Personel{\n" + "PersonelID: " + PersonelID + "Ad: "+Ad+ "Soyad: "+ Soyad+ "Sifre: " + Sifre+ "YetkiID: "+YetkiID+'}';
    }
    
     
    
}
