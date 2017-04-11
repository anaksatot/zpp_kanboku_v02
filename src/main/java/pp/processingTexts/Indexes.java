package pp.processingTexts;

import java.util.Random;

/**
 * Created by Admin on 3/29/2017.
 */
public class Indexes {
    public String defineRandomUniqueIndex16_01(int number) {
        String index = "";
        int n;
        Random rand = new Random();
        for (int i=0; i<16;i++) {
            n = rand.nextInt(16);
            String n16 = Integer.toHexString(n);
            index = index + n16;
        }
        String numberOfWords16 = Integer.toHexString(number);
        for (int i=0; i<16-numberOfWords16.length();i++) {
            index = index + "0";
        }
        index = index + numberOfWords16;
        return index;
    }

    public String defineRandomUniqueIndex16_02() {
        String index = "";
        int n;
        Random rand = new Random();
        for (int i=0; i<16;i++) {
            n = rand.nextInt(16);
            String n16 = Integer.toHexString(n);
            index = index + n16;
        }
        return index;
    }
}
