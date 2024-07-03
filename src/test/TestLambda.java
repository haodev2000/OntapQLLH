package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestLambda {
    public static void main(String[] args) {


//        Function<String , Integer> fun = (s) ->{
//            return Integer.parseInt(s);
//        };
//
//        fun.apply("213");
//        System.out.println(fun.apply("213"));

//        int x = 5;
//        int y = 10;
//
//        System.out.println(toDo(x, y, BaseService::tinhTong));

        SayHello s = Hello::new;
        s.display("123");



    }

    public static int toDo(int x, int y, BaseInterface b){
        return b.apply(x,y);
    }
}
