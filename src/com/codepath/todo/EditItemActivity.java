package com.codepath.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {
	private EditText etEditTodo;
	private int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		String text = getIntent().getStringExtra("text");
		int pos = getIntent().getIntExtra("pos", 0);
		
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
	
	public void updateTodo(View v) {
		Intent data = new Intent();
		data.putExtra("text", etEditTodo.getText().toString());
		data.putExtra("pos", pos);
		setResult(1, data);
		finish();
	}

}
