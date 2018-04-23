package hr.ferit.tumiljanovic.tasks.hr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.tumiljanovic.tasks.R;
import hr.ferit.tumiljanovic.tasks.TasksRepository;
import hr.ferit.tumiljanovic.tasks.model.Task;

public class ShowTasksActivity extends AppCompatActivity {

	private static final String TAG = "Terezija";

	@BindView(R.id.edittext_newtask_title) EditText editTextTitle;
	@BindView(R.id.edittext_newtask_summary) EditText editTextSummary;
	@BindView(R.id.edittext_newtask_importance) EditText editTextImportance;
	@BindView(R.id.textview_newtask_display) TextView textViewDisplayTasks;
	@BindView(R.id.button_newtask_save) Button bSave;

	TasksRepository mRepository;
	String mTitle, mSummary;
	int mImportance;


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
			logThings("onClick method in ShowTasksActivity");

	}

	private void logThings(String message) { Log.d(TAG, message); }


	public void storeTask(){

		mTitle= editTextTitle.getText().toString();
		mSummary= editTextSummary.getText().toString();
		mImportance= Integer.parseInt(editTextImportance.getText().toString());
		Task mTask;

        mTask= new Task(mImportance,mTitle,mSummary);
        mRepository.save(mTask);

	}

    public void clearUI(){

        editTextTitle.setText("");
	    editTextSummary.setText("");
	    editTextImportance.setText("");
    }

    private void displayTasks() {
		textViewDisplayTasks.setText(mRepository.getmDatabase().toString());


    }




}
