package com.codepath.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class EditItemActivity extends Activity {
	private EditText etEditTodo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		String text = getIntent().getStringExtra("text");
		etEditTodo = (EditText) findViewById(R.id.etEditTodo);
		etEditTodo.setText(text);
		etEditTodo.setSelection(text.length());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

}
