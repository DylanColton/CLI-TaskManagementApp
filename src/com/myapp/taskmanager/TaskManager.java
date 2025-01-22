package com.myapp.taskmanager;

import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManager {
	public static boolean selectAction(int action, Scanner scan) {
		switch (action) {
			case 1:
				return createTask(scan);

			case 2:
				return readTask(scan);

			case 3:
				return updateTask(scan);
				
			case 4:
				return deleteTask(scan);

			default:
				System.out.println("Invalid choice");
				return false;
		}
	}

	private static boolean createTask(Scanner scan) {
		Task task = new Task(scan);
		System.out.println(task.jsonifyFromTask());
		/*
		try (BufferedWriter writer = new BufferedWriter(newFileWriter(fileName, true))) {
			writer.write(content);
			writer.newLine();
		} catch (IOException e) {
			return false;
		}
		*/

		return true;
	}

	private static boolean readTask(Scanner scan) {
		return true;
	}

	private static boolean updateTask(Scanner scan) {
		return true;
	}

	private static boolean deleteTask(Scanner scan) {
		return true;
	}
}
