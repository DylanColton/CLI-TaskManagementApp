import com.myapp.taskmanager.TaskManager;

import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		String[] opts = {
			"Create",
			"Read",
			"Update",
			"Delete"
		};

		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				menu(opts);
				String input = scan.next();
				if (menuQuitCheck(input))
					break;

				if (isNumeric(input)) {
					int choice = Integer.parseInt(input);

					TaskManager.selectAction(choice, scan);
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println("Error Occurred: " + e.getMessage());
		}
	}

	public static void menu(String[] options) {
		for(int i = 0; i < options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
	}

	private static final Set<String> QUIT_WORDS = Set.of("exit", "quit", "q");
	public static boolean menuQuitCheck(String string) {
		return QUIT_WORDS.contains(string.toLowerCase());
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
