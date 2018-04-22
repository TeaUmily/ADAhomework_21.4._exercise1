package hr.ferit.bruno.exercise1.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.bruno.exercise1.R;
import hr.ferit.bruno.exercise1.TasksRepository;
import hr.ferit.bruno.exercise1.model.Task;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "Terezija";

	@BindView(R.id.edittext_newtask_title) EditText editTextTitle;
	@BindView(R.id.edittext_newtask_summary) EditText editTextSummary;
	@BindView(R.id.edittext_newtask_importance) EditText editTextImportance;
	@BindView(R.id.textview_newtask_display) TextView textViewDisplayTasks;
	@BindView(R.id.button_newtask_save) Button bSave;

	TasksRepository mRepository;
	String mTitle, mSummary;
	int mImportance;
	Task mTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		mRepository = TasksRepository.getInstance();

	}


	@OnClick(R.id.button_newtask_save)
	public void saveTask() {

		    storeTask();
			clearUI();
			displayTasks();
			logThings("onClick method in MainActivity");

	}

	private void logThings(String message) { Log.d(TAG, message); }


	public void storeTask(){

        // ToDo: 	store the task
        // Parse data from the widgets and store it in a task
        // Store the task in the fake database using the repository

		mTitle= editTextTitle.getText().toString();
		mSummary= editTextSummary.getText().toString();
		mImportance= Integer.parseInt(editTextImportance.getText().toString());


        mTask= new Task(mImportance,mTitle,mSummary);
        mRepository.save(mTask);

	}

    public void clearUI(){

        // ToDo: clear the UI for the new task
        // Clear all of the editText controls

        editTextTitle.setText("");
	    editTextSummary.setText("");
	    editTextImportance.setText("");
    }

    private void displayTasks() {
	    // ToDo: 	define a method
        // Create a method for displaying the tasks in the textview as strings
        // one below the other and call it on each new task.

		textViewDisplayTasks.setText(mRepository.getmDatabase().toString());


    }




}
