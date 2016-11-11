package org.changs.campus.mobile;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yincs on 2016/11/11.
 */

public class LambdaUnitTest {

    interface Apply {
        void call();
    }

    interface Apply_ {
        int call();
    }

    interface Apply1 {
        int call(int a);

        int call(String a);
    }

    interface Apply2 {
        int call(String a, int b);
    }

    public class Execute<T> {
        T object;

        public Execute(T apply2) {

        }

        public Execute() {

        }

        public void setObject(T object) {
            this.object = object;
        }
    }

    @Test
    public void primary() {
        new Execute<Apply>()
                .setObject(() -> System.out.println("哈哈"));

        new Execute<Apply_>().setObject(() -> 1);


//        new Execute<Apply1>().setObject(a -> a * 2);
        new Execute<Apply1>().setObject(new Apply1() {
            @Override
            public int call(int a) {
                return 21321;
            }

            @Override
            public int call(String a) {
                return 321312;
            }
        });


        new Execute<Apply2>((a, b) -> b);
    }

    @Test
    public void primary2() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        for (String player : players) {
            System.out.print(player + "; ");
        }
        Runnable runnable = () -> System.out.println("哈哈");
        Runnable runnable1 = () -> System.out.print("");
        Runnable runnable2 = () -> {
        };
    }
}
