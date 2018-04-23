package hr.ferit.tumiljanovic.tasks.persistance;

import java.util.ArrayList;
import java.util.List;

import hr.ferit.tumiljanovic.tasks.model.Task;

public class Database {

	private List<Task> mTasks;

	public Database() {
		mTasks = new ArrayList<>();
	}

	public void save(Task task) {
		mTasks.add(task);
	}

	public List<Task> getTasks() {
		return mTasks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Task t : mTasks
				) {
			builder.append(t.toString() + "\n");
		}

		return builder.toString();
	}




}
