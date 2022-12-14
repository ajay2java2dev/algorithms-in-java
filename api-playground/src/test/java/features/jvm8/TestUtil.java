package features.jvm8;

import features.jvm8.pojo.Email;
import features.jvm8.pojo.Employee;
import features.jvm8.pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestUtil {

    public static List<User> getSampleUserList () {

        Email person1Email1 = new Email();
        person1Email1.setEmailAddress("1@gmail.com");
        person1Email1.setPreferred(Boolean.TRUE);

        Email person1Email2 = new Email();
        person1Email2.setEmailAddress("2@gmail.com");
        person1Email2.setPreferred(Boolean.FALSE);

        return Stream.of(
                new User("Ajay 1",1234567890l, null, Arrays.asList(person1Email1, person1Email2)),
                new User("Ajay 2",3213213214l, null, Arrays.asList(person1Email1, person1Email2))
        ).collect(Collectors.toList());


    }

    public static String getSimpleString() {
        return "Grass is not always greener on the other side. " +
                "Sometimes its brown, sometimes is gray but then how do you know if you are not on the other side ?";
    }

    public static List<Employee> getSampleEmployees() {
        Email person1Email1 = new Email();
        person1Email1.setEmailAddress("1@gmail.com");
        person1Email1.setPreferred(Boolean.TRUE);

        Email person1Email2 = new Email();
        person1Email2.setEmailAddress("2@gmail.com");
        person1Email2.setPreferred(Boolean.FALSE);

        List<Email> emailList = new ArrayList<>();
        emailList.add(person1Email1);
        emailList.add(person1Email2);

        return Stream.of (
                new Employee(1l,"Ajay", "1", "Menon", "DEV", 100000.00, emailList),
                new Employee(2l,"Ajay", "2", "Menon", "DEV", 130000.00, emailList),
                new Employee(3l,"Ajay", "3", "Menon", "QA", 120000.00,emailList),
                new Employee(4l,"Ajay", "4", "Menon", "QA", 90000.00,emailList),
                new Employee(5l,"Ajay", "5", "Menon", "PM", 100000.00, emailList),
                new Employee(6l,"Ajay", "6", "Menon", "PM", 130000.00, emailList),
                new Employee(7l,"Ajay", "7", "Menon", "VP", 220000.00,emailList),
                new Employee(8l,"Ajay", "8", "Menon", "VP", 290000.00,emailList)
        ).collect(Collectors.toList());
    }
}
