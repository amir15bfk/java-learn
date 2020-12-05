package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    int nummberOfCoffees=1;
    /**
     * This method is called when the order button is clicked.
     */
    String [] s = {"amir15benbachir@gmail.com"};
    public void submitOrder(View view) {
        if (getName().length() >5) composeEmail(s,"coffee order",createOrdrSummery());
        else Toast.makeText(getApplicationContext(), "please enter your name", 2).show();

    }
    public void refresh(View view){
        displayMessage(calculatePrice()+" DA");
    }
    public void increment(View view) {
        if (nummberOfCoffees<100){
        nummberOfCoffees+=1;
        displayQuantity(nummberOfCoffees);}
        else {
            Toast.makeText(getApplicationContext(), "you can not order more than 100 cubes of coffee", 2).show();
        }
        displayMessage(calculatePrice()+" DA");
    }
    public void decrement(View view) {
        if (nummberOfCoffees>1){
        nummberOfCoffees-=1;
         displayQuantity(nummberOfCoffees);}
         else {
            Toast.makeText(getApplicationContext(), "hhh rak ttharch", 2).show();
        }
        displayMessage(calculatePrice()+" DA");

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice() {
        int price=25;
        if (isWhippedCream())price+=5;
        if (isChocolate())price+=5;
        return nummberOfCoffees * price;
    }
    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given price on the screen.
     */
    private boolean isWhippedCream(){
        CheckBox WhippedChackBox = (CheckBox) findViewById(R.id.WhisppedCreamChackBox);
        return WhippedChackBox.isChecked();
    }
    private boolean isChocolate(){
        CheckBox Choc = (CheckBox) findViewById(R.id.ChocolateChackBox);
        return Choc.isChecked();
    }
    private String getName(){
        EditText nameE = (EditText) findViewById(R.id.nameEditText);
        return nameE.getText().toString();
    }
    private void displayMessage(String message) {
        TextView orederSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orederSummaryTextView.setText(message);
    }
    private String createOrdrSummery(){
        return "Name : "+getName()+"\n" +
                "Quantity : "+nummberOfCoffees+"\n" +
                "Add Whipped cream : " +isWhippedCream()+"\n"+
                "Add Chocolate : " +isChocolate()+"\n"+
                "Total : "+calculatePrice()+"DA\n" +
                "Thank you!";
    }
}