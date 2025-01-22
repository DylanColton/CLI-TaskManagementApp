package com.myapp.taskmanager;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import java.util.Set;

public class Task {
	public String	taskName;
	public String	startDate;
	public String	deadLine;
	public String	assignees;
	public String	description;
	public int		progress;

	public Task(Scanner scan) {
		this.taskName = setTaskName(scan);
		SimpleDateFormat f	= new SimpleDateFormat("dd/MM");
		this.startDate	= f.format(new Date());
		this.deadLine = setDeadLine(scan);
		this.assignees = setAssignees(scan);
		this.description = setDescription(scan);
		this.progress	= 0;
	}

	public String setTaskName(Scanner scan) {
		if (scan.hasNextLine())
			scan.nextLine();

		System.out.print("Provide a name for the task: ");
		String input = scan.nextLine();

		return input;
	}

	public String setDeadLine(Scanner scan) {
		if (scan.hasNextLine())
			scan.nextLine();

		System.out.print("Provide a deadline (dd/mm): ");
		String input = scan.nextLine();

		// put some conditioning on this

		return input;
	}

	public String setAssignees(Scanner scan) {
		if (scan.hasNextLine())
			scan.nextLine();

		System.out.print("Assign agents to the task: ");
		String input = scan.nextLine();

		// Possibly make this iterative

		return input;
	}

	public String setDescription(Scanner scan) {
		if (scan.hasNextLine())
			scan.nextLine();

		System.out.print("Provide a description: ");
		String input = scan.nextLine();

		return input;
	}

	private static final String[] PROGRESS = {
		"TODO",
		"In Progress",
		"Awaiting Review",
		"Accepted",
		"Complete"
	};
	public void setProgressForward() {
		if (++this.progress >= PROGRESS.length)
			this.progress--;
	}

	public void setProgressBackward() {
		if (--this.progress < 0)
			this.progress++;
	}

	private static final Set<String> YES_WORDS	= Set.of("y", "yes");
	private static final Set<String> NO_WORDS	= Set.of("n", "no");
	public void setCompleted() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Has the task been completed? (yes/no)");
			String input = scan.next();
			
			if (YES_WORDS.contains(input.toLowerCase())) {
				System.out.println("YES");
			} else if (NO_WORDS.contains(input.toLowerCase())) {
				System.out.println("NO");
			} else {
				System.out.println("Invalid option");
			}
		} catch (Exception e) {
			System.out.println("Error with the Scanner Object: " + e);
		}
	}

	public String jsonifyFromTask() {
		String json = "{\n";
		json = json + "\t\"Title\": "			+ this.taskName					+ ",\n";
		json = json + "\t\"Start_Date\": "		+ this.startDate				+ ",\n";
		json = json + "\t\"Deadline\": "		+ this.deadLine					+ ",\n";
		json = json + "\t\"Assignees\": "		+ this.assignees				+ ",\n";
		json = json + "\t\"Description\": "		+ this.description				+ ",\n";
		json = json + "\t\"Progress\": "		+ PROGRESS[this.progress]		+ "\n";
		json = json + "}";
		return json;
	}

	public static void taskifyFromJSON(String JSON) {
	}
}
