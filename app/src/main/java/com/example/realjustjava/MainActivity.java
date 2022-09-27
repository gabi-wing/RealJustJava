package com.example.realjustjava;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity;
    int price = 5;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if(quantity<100) {quantity += 1;}
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity>1){quantity -= 1;}
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.nameInput);
        displayQuantity(quantity);
        String message = "Name: " + name.getText();;
        message+="\nAdd whipped cream? " + whippedCream();
        message+="\nAdd chocolate? " + chocolate();
        message+= "\nQuantity: " + quantity;
        message+="\nTotal: $" + calculatePrice(quantity);
        message += "\nThank you!";
        displayMessage(message);
        composeEmail();
    }

    public int calculatePrice(int quantity){
        if(whippedCream()){price++;}
        if (chocolate()){price+=2;}
        return price*quantity;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.textView_quantity);
        quantityTextView.setText("" + quantity);
    }

    /**
     * method to display the price value
     */
    //I'm no longer using this method
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.textView_price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * method to display the price message
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.textView_price);
        priceTextView.setText(message);
    }

    public boolean whippedCream() {
        boolean hasWhip=false;
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox);
        if(whippedCream.isChecked()){hasWhip=true;}
        return hasWhip;
    }

    public boolean chocolate() {
        boolean hasChocolate=false;
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox2);
        if(chocolate.isChecked()){hasChocolate=true;}
        return hasChocolate;
    }

    public void composeEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "order summary");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}