package features.jvm8;

import features.jvm8.pojo.Employee;
import features.jvm8.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LambdaTests {

    @Test
    void whenGivenInputValid_TestSimpleLambdaFunction() {
        MyVoidFunction function = (i -> System.out.println("Value of input: " + i));
        function.test(10);
        assertNotNull(function);

        MyCalcFunction calcFunction = (i -> Math.pow((int)i,2));
        var out = calcFunction.calculate(10);
        assertNotNull(out);
        assertEquals(Math.pow(10,2), out);
    }

    @Test
    void whenGivenInputList_TestStreamFunction() {
        var intList = Arrays.asList(23,2,12,12,10,32,0,-1);
        Predicate<Integer> gtThan4Predicate = (i) -> i > 4;

        Stream<Integer> integerStream = intList.stream().filter(gtThan4Predicate);
        integerStream.sorted().forEach(System.out::println); //note: usage of method reference call instead of regular call.

        integerStream = intList.stream().filter(gtThan4Predicate);
        assertTrue(integerStream.findAny().isPresent());
    }

    @Test
    void whenGivenMyCustomStaticMethod_TestMethodReferenceCall() {
        var intList = Arrays.asList(23,2,12,12,10,32,0,-1);

        //Function - input something such that it can return output of same or different type
        //Predicate - input something such that it returns a boolean or supplier or consumer
        //Supplier -  no input but get something back in response
        //Consumer - input something but no response expected.

        //NOTE: how without giving a Predicate explicitly the lambda function can be created and Predicate dynamically created.
        System.out.println("# of values > 4 = " + intList.stream().filter(integer -> integer > 4).count()); //just trying count

        System.out.println("**********************************");
        intList.forEach(LambdaTests::printList);
        System.out.println("**********************************");
        intList.forEach(new LambdaTests()::printListInstance);
    }
    static void printList(Integer val) {
        System.out.println("The static value is : "+ val);
    }

    void printListInstance(Integer val) {
        System.out.println("The instance value is : "+ val);
    }


    @Test
    void whenGivenAList_UseMap() {
        //when single element to extract then use map
        List<User> userList = TestUtil.getSampleUserList();
        //gather just phone numbers
        userList.stream().map(user -> user.getPhoneNumber()).forEach(System.out::println);
        //but what if I pass another list to gather. Able to print
        userList.stream().map(user -> user.getEmailAddress()).forEach(System.out::println);
        //NOTE: the .map on list will make the output List<List<Email>> instead of flattening the output to List<Email>
        var list = userList.stream().map(user -> user.getEmailAddress()).collect(Collectors.toList());
    }

    @Test
    void whenGivenAList_flattenInnerStreamToGetJustEmailAddress() {
        //when array within array to extract then use flat map
        List<User> userList = TestUtil.getSampleUserList();
        //one to many always use flatmap if you want to avoid List<List> structure and flatten out the inner list to List<List>
        userList.stream().flatMap(user -> user.getEmailAddress().stream())
                .map(email -> email.getEmailAddress()).forEach(System.out::println);
    }

    @Test
    void whenStringIsGiven_findCountOfEachCharacter () {
        String sampleString = TestUtil.getSimpleString();
        Map<String, Long> literalMapCount = Arrays.asList(sampleString.split(""))
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(literalMapCount);
    }

    @Test
    void whenEmployeeListIsGiven_findHighestPaidEmployeeInEachDepartment() {

        List<Employee> employees = TestUtil.getSampleEmployees();
        //1. group by their departments first,
        //2. once grouping is done, find max in each group. To compare the salaray in each group we need a comparator
        var salaryComparator = Comparator.comparing(Employee::getSalary);
        var employeeDepartmentList = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.reducing(BinaryOperator.maxBy(salaryComparator))));
        System.out.println(employeeDepartmentList);
    }

    @Test
    void whenEmployeeListIsGiven_findHighestPaidEmployeeInEachDepartment_byCollectionThen() {

        List<Employee> employees = TestUtil.getSampleEmployees();
        //1. group by their departments first,
        //2. once grouping is done, find max in each group. To compare the salaray in each group we need a comparator
        var salaryComparator = Comparator.comparingDouble(Employee::getSalary);
        var employeeDepartmentList = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(salaryComparator), Optional::get)));
        System.out.println(employeeDepartmentList);
    }

    @Test
    void whenListIsGiven_TestSimpleStreamAndParallelStream () {
        var list = IntStream.rangeClosed(1,10);
        System.out.println("------------------------------------------------------------");
        list.forEach(value -> System.out.println(Thread.currentThread().getName() + " = " + value));
        System.out.println("------------------------------------------------------------");
        list = IntStream.rangeClosed(1,10);
        list.parallel().forEach(value -> System.out.println(Thread.currentThread().getName() + " = " + value));
        System.out.println("------------------------------------------------------------");
    }

    Object object;
    static int i = 1;

    @Test
    void whenListOfIntegersGiven_PrintEvenOrOddUsingTwoThreads () {
        // main idea is to play with wait and notify
        IntStream.rangeClosed(1,10).forEach(value -> {
            if (value%2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " +value);
                    try {
                        object.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
            if (value%2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " +value);
                    object.notify();
                }
            }
        });
    }
}
