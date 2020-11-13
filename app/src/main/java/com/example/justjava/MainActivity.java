package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    int nummberOfCoffees=0;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String priceMessage="Done you demand a "+nummberOfCoffees+" cube of coffee \n the price is "+(nummberOfCoffees*25)+" DA";
        displayMessage(priceMessage);
    }
    public void increment(View view) {
        nummberOfCoffees+=1;
        displayQuantity(nummberOfCoffees);
        displayPrice(nummberOfCoffees*25);
    }
    public void decrement(View view) {
        nummberOfCoffees-=1;
         displayQuantity(nummberOfCoffees);
        displayPrice(nummberOfCoffees*25);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(""+ number+" DA");
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}