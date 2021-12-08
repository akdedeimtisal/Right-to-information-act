
import java.util.*;

class MainMenuView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        Integer menu;
        Integer choice = 1;
        short YetkiID = PersonelView.YetkiID;
        short flag = PersonelView.flag;//Personel Ekranlarını Kontrol Eder.

        do {

            System.out.println("1. Kullanıcı Ekranı");
            System.out.println("2. Başvuru Ekranı");
            System.out.println("3. Personel Ekranı");
            System.out.println("4. Çıkış");
            System.out.println();

            menu = getInteger("Seciminizi Giriniz : ", false);

            if (menu == 1) {
                do {
                    System.out.println("1. Üye olma");
                    System.out.println("2. Giriş yapma");
                    System.out.println("3. Çıkış");
                    System.out.println();
                    choice = getInteger("Seçiminizi giriniz : ", false);
                } while (choice == null || choice < 1 || choice > 3);
            }

            if (menu == 2) {

                do {
                    System.out.println("1. Tüm başvuruları görüntüle");
                    System.out.println("2. Basvurunuzu Görüntüle");
                    System.out.println("3. Basvuru Yapmak icin");
                    System.out.println("4. Sonucunuzu Görüntüleyin");
                    System.out.println("5. Basvurunuzu Silin");
                    System.out.println("6. Basvurunuzun Sureclerini Görüntüle ");
                    System.out.println("7. Kurumları Görüntüle ");
                    System.out.println("8. CIKIS");
                    System.out.println();

                    choice = getInteger("Secimizi Giriniz : ", false);
                } while (choice == null || choice < 1 || choice > 8);
            }

            if (menu == 3) {

                do {
                    if (flag == 0) {
                        System.out.println("8. GİRİŞ");
                    }

                    if (flag == 1 && YetkiID == 0) {
                        System.out.println("1. Tüm başvuruları görüntüle");
                    } else if (flag == 1 && YetkiID == 1) {
                        System.out.println("2. Personel ekle");
                        System.out.println("3. Başvuru ekle");
                        System.out.println("4. Başvuru sonucu ekle");
                        System.out.println("5. Başvuru süreci ekle");
                    } else if (flag == 1 && YetkiID == 2) {
                        System.out.println("1. Tüm başvuruları görüntüle");
                        System.out.println("2. Personel ekle");
                        System.out.println("3. Başvuru ekle");
                        System.out.println("4. Başvuru sonucu ekle");
                        System.out.println("5. Başvuru süreci ekle");
                        System.out.println("6. Raporlama");
                        System.out.println("7. Sonuçlandırılmamış Başvuruları Görüntüle");
                    }
                    System.out.println("9. ÇIKIŞ");
                    System.out.println();

                    choice = getInteger("Secimizi Giriniz : ", false);
                } while (choice == null || choice < 1 || choice > 9);
            }

        } while (menu == null || menu < 1 || menu > 4);

        Map<String, Object> userInput = new HashMap<>();
        userInput.put("mainMenuChoice", choice);

        if (menu == 2) {

            switch (choice.intValue()) {
                case 1:
                    operationName = "select";
                    break;
                case 2:
                    operationName = "select.gui";
                    break;
                case 3:
                    operationName = "insert.gui";
                    break;
                case 4:
                    operationName = "selectSonuc.gui";
                    break;
                case 5:
                    operationName = "delete.gui";
                    break;
                case 6:
                    operationName = "selectSurec.gui";
                    break;
                case 7:
                    operationName = "selectKurum";
                    break;
                default:
                    return new ViewData(null, null);
            }

            return new ViewData("Basvuru", operationName, new HashMap<>());

        } else if (menu == 1) {
            switch (choice.intValue()) {
                case 1:
                    operationName = "insert.gui";
                    break;
                case 2:
                    operationName = "select";
                    break;
                default:
                    return new ViewData(null, null);

            }

            return new ViewData("BasvuruSahibi", operationName, new HashMap<>());
        } else if (menu == 3) {
            switch (choice.intValue()) {
                case 1:
                    operationName = "selectBasvuru";
                    break;
                case 2:
                    operationName = "select.gui";
                    break;
                case 3:
                    operationName = "insertBasvuru.gui";
                    break;
                case 4:
                    operationName = "insertSonuc.gui";
                    break;
                case 5:
                    operationName = "insertSurec.gui";
                    break;
                case 6:
                    operationName = "selectRapor";
                    break;
                case 7:
                    operationName = "selectSonuclanmamis";
                    break;
                case 8:
                    operationName = "selectGiris";
                    break;
                default:
                    return new ViewData(null, null);
            }

            return new ViewData("Personel", operationName, new HashMap<>());

        }
        return new ViewData(null, null);

    }

    @Override
    public String toString() {
        return "Main Menu View";
    }
}
