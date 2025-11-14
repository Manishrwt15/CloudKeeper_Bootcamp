import java.util.*;
import java.util.stream.Collectors;


@FunctionalInterface
interface NumberRule{
    boolean apply(int n);
}

public class FunInterface{

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(2,3,10,15,8,21,14,7);

        NumberRule isEven = n -> n % 2 == 0;
        NumberRule isPrime = n -> {
            if (n <= 1) return false;
            if(n == 2) return true;
            for (int i = 3; i < n; i++) {
                if (n % 2 == 0) {
                    return false;
                }
            }

            return true;
        };

        List<Integer>  square = list.stream().filter(num -> isEven.apply(num) && isPrime.apply(num)).map(num -> num * num).collect(Collectors.toList());

        Optional<Integer> firstSquare = square.stream().findFirst();

        if(firstSquare.isPresent()){
            System.out.println(firstSquare.get());
        }
        else{
            System.out.println("No matching number found");
        }
    }
}