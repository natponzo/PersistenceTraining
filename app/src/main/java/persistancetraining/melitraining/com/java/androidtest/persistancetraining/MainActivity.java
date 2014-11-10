package persistancetraining.melitraining.com.java.androidtest.persistancetraining;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private TextView greetingTextView;
    private EditText newNickNameEditText;
    private ListView notesListView;


    final ArrayList<String> notesList = new ArrayList<String>();
    private EditText newNoteEditText;
    private ArrayAdapter<String> listViewAdapter;

    //Example notes
    private String[] notes = new String[]{"Comprar pan", "Llamar a Babu", "Comprar regalo beto", "Arreglar auto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpLayout();

    }

    private void setUpLayout() {
        setUpNickNameSection();

        setUpNotesSection();

    }

    private void setUpNotesSection() {
        notesListView = (ListView) findViewById(R.id.notes_listView);
        newNoteEditText = (EditText) findViewById(R.id.new_note_editText);

        for (int i = 0; i < notes.length; ++i) {
            notesList.add(notes[i]);
        }

        listViewAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(listViewAdapter);


        Button newNoteButton = (Button) findViewById(R.id.new_note_button);
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new note to notes list
                notesList.add(newNoteEditText.getText().toString());
                ArrayAdapter<String> stringArrayAdapter = (ArrayAdapter<String>) notesListView.getAdapter();
                stringArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpNickNameSection() {
        greetingTextView = (TextView) findViewById(R.id.greeting_textView);
        newNickNameEditText = (EditText) findViewById(R.id.new_nickname_editText);

        Button newNickNameButton = (Button) findViewById(R.id.new_nickname_button);
        newNickNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change greeting title
                greetingTextView.setText(makeGreeting(newNickNameEditText.getText()));

            }
        });
    }

    private String makeGreeting(CharSequence newNick) {
        return getString(R.string.greeting) + " " + newNick + "!";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
