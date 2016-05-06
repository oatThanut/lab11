package student;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {
	
	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action ) {
		for(Student s : students ) {
			if (filter.test(s))
//	                  System.out.println( s );
				action.accept(s);
		}
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		LocalDate local = LocalDate.now();
		StudentApp app = new StudentApp();
		Predicate<Student> filter = s -> s.getBirthdate().getMonthValue() == local.getMonthValue();
		Consumer<Student> print = p -> System.out.println(p+ " will have birthday on "+p.getBirthdate().getDayOfMonth()+" "+p.getBirthdate().getMonth()+".");
		app.filterAndPrint(students, filter, print /* may */);
	}

	//------------------------------------------------------------------------------------------------------
	
//	/**
//	 * Print the names (and birthdays) of students having a birtday in the
//	 * specified month.
//	 * @param students list of students
//	 * @param month the month to use in selecting bithdays
//	 */
//	public void filterAndPrint( List<Student> students, int month ) {
//		for(Student s : students ) {
//			if (s.getBirthdate().getMonthValue() == month)
//	                  System.out.println( s );
//		}
//	}
//	
//	public static void main(String[] args) {
//		List<Student> students = Registrar.getInstance().getStudents();
//		StudentApp app = new StudentApp();
//		app.filterAndPrint(students, 5 /* may */);
//	}
}
