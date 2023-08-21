package com.example.baitapdatetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnDate = findViewById(R.id.btnDate);
        btnDays = findViewById(R.id.btnDays);
        listCv = findViewById(R.id.listCv);
        editDate = findViewById(R.id.edtDate);
        editDay = findViewById(R.id.edtTime);
        editContent = findViewById(R.id.edtContent);
        editCv = findViewById(R.id.edtWork);
        List<CongViec> list = new ArrayList<>();
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int days = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String year = String.valueOf(i);
                        String month = String.valueOf(i1+1);
                        String day = String.valueOf(i2);
                        String date = day + "/" + month + "/" + year;
                        editDate.setText(date);
                    }
                },year,month,days);
                dialog.show();

            }
        });
        btnDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar1 = Calendar.getInstance();
                int hour = calendar1.get(Calendar.HOUR);
                int minute = calendar1.get(Calendar.MINUTE);
                TimePickerDialog dialog1 = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                        calendar1.set(0,0,0,i,i1);
                        String date = simpleDateFormat.format(calendar1.getTime());
                        editDay.setText(date);
                    }
                },minute,hour,true);
                dialog1.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String work = editCv.getText().toString();
                String content = editContent.getText().toString();
                String date = editDate.getText().toString();
                String hour = editDay.getText().toString();
                list.add(new CongViec(work,content,date,hour));
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,list);
                listCv.setAdapter(adapter);
                editContent.setText(" ");
                editDate.setText(" ");
                editDay.setText(" ");
                editCv.setText(" ");

            }
        });
    }
    private Button btnAdd;
    private Button btnDate;
    private Button btnDays;
    private ListView listCv;
    private EditText editDate;
    private EditText editDay;
    private EditText editCv;
    private EditText editContent;
}