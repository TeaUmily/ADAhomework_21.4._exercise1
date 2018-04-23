package hr.ferit.tumiljanovic.tasks;

import java.util.List;

import hr.ferit.tumiljanovic.tasks.model.Task;
import hr.ferit.tumiljanovic.tasks.persistance.Database;

public class TasksRepository {

	private static TasksRepository sInstance = null;

	public Database getmDatabase() {
		return mDatabase;
	}

	private Database mDatabase;

	private TasksRepository(){
		mDatabase = new Database();
	}

	public static synchronized TasksRepository getInstance(){
		if(sInstance == null){
			sInstance = new TasksRepository();
		}
		return sInstance;
	}

	public void save(Task task){
		mDatabase.save(task);
	}

	public List<Task> getTasks(){
		return mDatabase.getTasks();
	}



}
