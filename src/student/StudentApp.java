package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class StudentApp {
	
	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> sort ) {
		students.stream().filter(filter).sorted(sort).forEach(action);
	}
	
	/**
	 * This is the main program to check student birth date
	 * @param args is not used
	 */
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		LocalDate local = LocalDate.now();
		StudentApp app = new StudentApp();
//		Predicate<Student> filter = s -> s.getBirthdate().getDayOfYear()-local.getDayOfYear()==13;
		Predicate<Student> filter = s -> s.getBirthdate().getMonthValue() == local.getMonthValue();
		Consumer<Student> print = p -> System.out.println(p+ " will have birthday on "+p.getBirthdate().getDayOfMonth()+" "+p.getBirthdate().getMonth()+".");
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0)-b.getFirstname().charAt(0);
		app.filterAndPrint(students, filter, print, byName /* may */);
	}
}
