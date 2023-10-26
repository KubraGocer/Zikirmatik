public class PojoClass {


        public static int countID;
        public static int count;

        ZikirmatikRepository zkr = new ZikirmatikRepository();


        public PojoClass(int count) {
            this.count = 0;
        }

        public PojoClass() {

        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void arttirma(){
            int id = countID;
            int counter = count;
            counter++;
            zkr.updateCount(id, counter);
            run();
        }

        public void azaltma(){
            int id = countID;
            int counter = count;
            if(counter > 0) {
                counter--;
            }
            zkr.updateCount(id, counter);
            run();
        }

        public void sifirlama (){
            int id = countID;
            int counter = count;
            counter = 0;
            zkr.updateCount(id, counter);
            run();

        }

        public void run (){
            zkr.getCount();
        }
    }


