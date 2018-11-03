package com.example.vietanhphan.lab032;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private DbAdapter dbAdapter;
//    private Cursor cursor;
//    private List<String> users;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final DatabaseHandler db = new DatabaseHandler(this);
        db.deleteAllContact();
// Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));
        // Reading all contacts
        Log.e("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);

//    dbAdapter=new DbAdapter(this);
//    dbAdapter.open();
//    dbAdapter.deleteAllUsers();
//
//    for (int i=0;i<10;i++){
//        dbAdapter.createUser("Nguyen Van An"+i);
//    }
//    users=getData();
//    showData();
        }
        showData();
       final ArrayAdapter<Contact> contactArrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.item_user,contacts);
        ListView lvcontact=(ListView) findViewById(R.id.lv_contact);
        lvcontact.setAdapter(contactArrayAdapter);
        lvcontact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteContact(contacts.get(position));
                contacts.remove(position);
              contactArrayAdapter.notifyDataSetChanged();
              //showData();
                return false;
            }
        });
//    private List<String> getData(){
//        List<String> users=new ArrayList<>();
//        cursor=dbAdapter.getAllUsers();
//        while (cursor.moveToNext()){
//            users.add(cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NAME)));
//        }
//        return users;
//    }
    }
    private void showData(){
        ListView lvcontact=(ListView) findViewById(R.id.lv_contact);
        ArrayAdapter<Contact> contactArrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.item_user,contacts);
        lvcontact.setAdapter(contactArrayAdapter);
    }

}
