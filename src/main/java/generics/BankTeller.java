package generics;

import net.mindview.util.Generator;
import net.mindview.util.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Created by jiguang on 2018/6/12.
 */

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
        }
    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}
    public String toString() {
        return "Customer " + id;
    }
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}
    public String toString() {
        return "Teller " + id;
    }
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
