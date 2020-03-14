package com.example.frontend;


import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            //return super.getView(position, convertView, parent);

            View row = convertView;

            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
            }

            TextView label=(TextView)row.findViewById(R.id.name);
            label.setText(names[position]);

            TextView numLabel=(TextView)row.findViewById(R.id.status);
            numLabel.setText(status[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.icon);

            if (status[position]=="in"){
                icon.setImageResource(R.drawable.ok);
            }
            else{
                icon.setImageResource(R.drawable.xmark);
            }

            return row;
        }
    }

    String[] names = {
            "Jane", "Frank", "Mary", "April",
            "Chris", "Julia", "Joan", "Amy",
            "Stephen", "Mike", "Noel", "David"
    };

    String[] status = {
            "in", "out","in", "in","in", "out","out", "in","in", "in","out", "in"
    };


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new MyCustomAdapter(MainActivity.this, R.layout.row, names));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
// TODO Auto-generated method stub
//super.onListItemClick(l, v, position, id);
        String selection = l.getItemAtPosition(position).toString();
        Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }

}