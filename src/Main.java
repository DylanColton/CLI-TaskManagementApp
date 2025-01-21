import java.util.Scanner;

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

					switch (choice) {
						case 1:
							System.out.println("Creating");
							break;
						case 2:
							System.out.println("Reading");
							break;
						case 3:
							System.out.println("Updating");
							break;
						case 4:
							System.out.println("Deleting");
							break;

						default:
							System.out.println("Illegal action");
							continue;
					}
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println("Bad Instantiation");
		}
	}

	public static void menu(String[] options) {
		for(int i = 0; i < options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
	}

	public static boolean menuQuitCheck(String string) {
		return (
			string.equalsIgnoreCase("exit") ||
			string.equalsIgnoreCase("quit") ||
			string.equalsIgnoreCase("q"));
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
