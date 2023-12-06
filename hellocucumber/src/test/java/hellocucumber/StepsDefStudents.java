package hellocucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StepsDefStudents {
    int youngestAge = 16;
    List<String> onlyStAge = new ArrayList<>();

    @Given("some students")
    public void students_age(DataTable dataTable) {

        List<List<String>> rows = dataTable.asLists(String.class);
        int size = rows.size();

        for (int i = 1; i <= (size - 1); i++) {
            List<String> allStudentsData = rows.get(i);
            String studentAge = allStudentsData.get(1);
            onlyStAge.add(studentAge);
        }
    }

    @When("sort students by age")
    public void sort_students_by_age () {
            Collections.sort(onlyStAge);
            youngestAge = Integer.parseInt(onlyStAge.get(0));

    }

    @Then("check that the youngest student is over {int}")
    public void check_that_the_youngest_student_is_over(Integer int1) {
        Assertions.assertTrue(youngestAge > int1);
    }
}