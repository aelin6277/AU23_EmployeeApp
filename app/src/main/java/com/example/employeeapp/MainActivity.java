package com.example.employeeapp;

//1. Hämta referenser till dina Views (EditText, Button, ListView) och
// 2. skapa en ArrayList för att lagra anställda.
//3. Skapa en ArrayAdapter för att binda listan av anställda till ListView.
//4. Lägg till en click-lyssnare på knappen för att lägga till en anställd.


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextOccupation;
    private EditText editTextAge;
    private Button addEmployeeButton;
    private ListView employeeListView;
    private ArrayList<Employee> employees;
    private ArrayAdapter<Employee> adapter;

    //TODO DELETE THIS COMMENT:  ERRORS
    //THe app crashses when trying to add employee on empty inputs
    // THe app crashses when the age is not an number (example: age="hej")

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hämtar referenser till dina Views (EditText, Button, ListView)
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        addEmployeeButton = findViewById(R.id.addEmployeeButton);
        employeeListView = findViewById(R.id.employeeListView);


        //skapar en ArrayList för att lagra anställda.
        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees); //SIMPLE LIST ITEM1????
        employeeListView.setAdapter(adapter); //=Skapar en ArrayAdapter för att binda listan av anställda till ListView.

        //Lägger till en onclick-lyssnare på knappen för att lägga till en anställd.
        addEmployeeButton.setOnClickListener(new View.OnClickListener() { //POR Q ESTA GRIS?????
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String ageString = editTextAge.getText().toString().trim();
                String occupation = editTextOccupation.getText().toString().trim();

                if (name.isEmpty() || ageString.isEmpty() || occupation.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.invalidInputs, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        int age = Integer.parseInt(ageString);//converts/parse String into Int
                        Employee employee = new Employee(name, age, occupation);
                        employees.add(employee);
                        adapter.notifyDataSetChanged();

                        cleanInputs();
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, R.string.invalidAge, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    private void cleanInputs() {
        editTextName.setText("");
        editTextAge.setText("");
        editTextOccupation.setText("");
    }
}

//      if(name.isEmpty() || occupation.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_LONG).show();
//
//                }
//EditText editText = findViewById(R.id.editText); // Replace with your EditText's ID
//String userInput = editText.getText().toString().trim(); // Get the user's input as a string
//
//try {
//    // Try to parse the input as an integer
//    int integerValue = Integer.parseInt(userInput);
//
//    // If it's an integer, convert it to a string
//    String stringValue = String.valueOf(integerValue);
//
//    // Use the string value for further processing
//    // ...
//} catch (NumberFormatException e) {
//    // Handle the case where the input is not an integer
//    // For example, show a message to the user
//    Toast.makeText(this, "Input must be a string", Toast.LENGTH_SHORT).show();
//}


//    String inputText = userInput.getText().toString().trim();
//
//                if (inputText.equals("apple")) {
//                        resultTextView.setText("Det är ett äpple.");
//                        } else if (inputText.equals("banana")) {
//                        resultTextView.setText("Det är en banan.");
//                        } else if (inputText.equals("cherry")) {
//                        resultTextView.setText("Det är ett körsbär.");
//                        } else {
//                        resultTextView.setText("Okänt föremål.");
//                        }
//                        }
//                        });