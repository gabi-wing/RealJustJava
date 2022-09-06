package com.example.realjustjava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayQuantity(quantity);
        displayPrice(quantity * 5);
        String message = "Total: $" + (quantity * 5);
        message += "\nThank you!";
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.textView_quantity);
        quantityTextView.setText("" + number);
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
}