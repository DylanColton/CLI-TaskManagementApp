
public class TaskManager {
	public static boolean SelectAction(int action) {
		switch (action) {
			case 1:
				return CreateTask();

			case 2:
				return ReadTask();

			case 3:
				return UpdateTask();
				
			case 4:
				return DeleteTask();

			default:
				return false;
		}
	}

	private static boolean CreateTask() {
		return true;
	}

	private static boolean ReadTask() {
		return true;
	}

	private static boolean UpdateTask() {
		return true;
	}

	private static boolean DeleteTask() {
		return true;
	}
}
