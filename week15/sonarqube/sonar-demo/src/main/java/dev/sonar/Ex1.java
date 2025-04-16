
package dev.sonar;

import java.util.logging.Logger;

public class Ex1 {

    Logger logger = Logger.getLogger("Ex1");

    void run() throws InterruptedException {
        boolean flag = true;
        int a = 1;

        while (flag) {
            logger.info("Hello!");
            Thread.sleep(5000);

            if (a == 1) {
                flag = false;
            }
        }
    }
}
