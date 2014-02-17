package com.codepath.todo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoActivity extends Activity {
	private ArrayList<String> todoItems;
	private ArrayAdapter<String> todoAdapter;
	private ListView lvItems;
	private EditText etNewTodo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        lvItems = (ListView) findViewById(R.id.lvItems);
        todoItems = new ArrayList<String>();
        todoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        lvItems.setAdapter(todoAdapter);
        
        populateArrayItems();
        setupListViewListener();
    }

	private void setupListViewListener() {
		lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View item,
					int pos, long id) {
				todoItems.remove(pos);
				todoAdapter.notifyDataSetInvalidated();
				return true;
			}
		});
	}

	private void populateArrayItems() {
    	todoAdapter.add("Milk");
    	todoAdapter.add("Eggs");
    	todoAdapter.add("OJ");
	}
	
	public void addTodoItem(View v) {
		todoAdapter.add(etNewTodo.getText().toString());
		etNewTodo.setText("");
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do, menu);
        return true;
    }
    
}
