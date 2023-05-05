package com.example.fidgetingapp;

import androidx.appcompat.R.layout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fidgetingapp.adapter.MenuAdapter;
import com.example.fidgetingapp.entity.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_PASSWORD = "com.example.fidgettingapp";
    private RecyclerView recyclerView;
    private List<Menu> list = new ArrayList<>();
    private MenuAdapter menuAdapter;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    RelativeLayout containerBackground;

    ListView listView;

    @SuppressLint({"UseCompatLoadingForDrawables", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);

        list.add(new Menu("Ilham",getDrawable(R.drawable.baseline_person_24)));
        list.add(new Menu("Putri",getDrawable(R.drawable.baseline_person_2_24)));
        list.add(new Menu("Bunda",getDrawable(R.drawable.baseline_person_3_24)));
        list.add(new Menu("Amba",getDrawable(R.drawable.baseline_person_4_24)));
        list.add(new Menu("Bocil",getDrawable(R.drawable.baseline_child_care_24)));
        list.add(new Menu("Smaili",getDrawable(R.drawable.baseline_emoji_emotions_24)));

        menuAdapter = new MenuAdapter(getApplicationContext(), list);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(menuAdapter);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);
        containerBackground = findViewById(R.id.containerBackground);
        EditText editText = findViewById(R.id.editText);

        Button confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                if(radioButton.getText().equals("Hitam")){
                    textView.setTextColor(Color.BLACK);
                    containerBackground.setBackgroundColor(Color.WHITE);
                    radioButton.setTextColor(Color.BLACK);

                } else
                    if(radioButton.getText().equals("Putih")){
                        textView.setTextColor(Color.WHITE);
                        containerBackground.setBackgroundColor(Color.BLACK);
                        radioButton.setTextColor(Color.WHITE);
                    } else
                        if(radioButton.getText().equals("ApA NiH")){
                        textView.setTextColor(Color.RED);
                        containerBackground.setBackgroundColor(Color.GRAY);
                            radioButton.setTextColor(Color.RED);
                        }

                if(editText.getText().toString().equals("Christo")||
                        editText.getText().toString().equals("admin")||
                        editText.getText().toString().equals("user")){
                    EditText editText = (EditText) findViewById(R.id.editText);
                    String password = editText.getText().toString();

                    Intent intent = new Intent(MainActivity.this, TempatRahasia.class);
                    intent.putExtra(EXTRA_PASSWORD, password);
                    startActivity(intent);
                }
            }

        });

        String listData[] = {"1","2","3","4","5","6","7","8","9","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30",
                "31","32","33","34","35","36","37","38","39","40",
                "41","42","43","44","45","46","47","48","49","50",
                "51","52","53","54","55","56","57","58","59","60",
                "61","62","63","64","65","66","67","68","69","70",
                "71","72","73","74","75","76","77","78","79","80",
                "81","82","83","84","85","86","87","88","89","90",
                "91","92","93","94","95","96","97","98","99","100"};

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, layout.support_simple_spinner_dropdown_item, listData);

        listView.setAdapter(adapter);

        Button btnkucing1 = findViewById(R.id.btnkucing1);
        btnkucing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, FragmentKucing1.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        Button btnkucing2 = findViewById(R.id.btnkucing2);
        btnkucing2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, FragmentKucing2.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        Button btnhome = findViewById(R.id.btnhome);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }


}