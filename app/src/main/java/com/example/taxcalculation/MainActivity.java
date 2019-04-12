package com.example.taxcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText salary;
    TextView tax;
    Button taxtbtn;
    double taxAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        salary=findViewById(R.id.salaryt);
        taxtbtn=findViewById(R.id.btntax);
        tax=findViewById(R.id.taxres);


        taxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Abc", Toast.LENGTH_SHORT).show();
                double sal=Double.parseDouble(salary.getText().toString().trim());
                Salary salr=new Salary(sal);

                double msalary=salr.getSalary();

                double ysalary=(msalary)*12;
//               Toast.makeText(MainActivity.this, ysalary+"", Toast.LENGTH_SHORT).show();

                if(ysalary>0 && ysalary<=200000){

                     taxAmount=0.01*ysalary;

                    tax.setText(taxAmount + "");
                    
                    tax.setTextColor(getResources().getColor(R.color.colorPrimary));
//                    tax.setText();
                    Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();

                }
                else if( ysalary>200000&&ysalary<350000){

                    taxAmount=0.01*200000+(ysalary-200000)*0.15;
                    tax.setText(taxAmount + "");
                    tax.setTextColor(getResources().getColor(R.color.maroon));
                    Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();
                }
                else if(ysalary>350000){
                    taxAmount=0.01*200000+0.15*150000+(ysalary-350000)*0.25;
                    tax.setText(taxAmount + "");
                    tax.setTextColor(getResources().getColor(R.color.red));
                    Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();
                }







            }
        });


    }



}
