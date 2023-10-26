import java.util.Scanner;


    import java.util.Scanner;

    public class Runner {
        public static void main(String[] args) {

            PojoClass pojoClass = new PojoClass();
            Scanner scan= new Scanner(System.in);
            pojoClass.run();

            while(true){

                System.out.println("Zikir sayiniz: " + pojoClass.getCount());
                System.out.println("Arttirmak icin '+' ,\nAzaltmak icin '-' ,\nSifirlamak icin '*' tusuna basabilirsiniz.");
                String input= scan.nextLine();

                switch (input) {
                    case "+":
                        pojoClass.arttirma();
                        break;
                    case "-":
                        pojoClass.azaltma();
                        break;
                    case "*":
                        pojoClass.sifirlama();
                        break;
                    default:
                        System.out.println("Lutfen gecerli bir secim yapiniz.");
                        break;
                }
            }
        }
    }


