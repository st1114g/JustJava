/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static android.R.attr.id;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    /** Let the mess begin..................................................... */
    /**
     * triggers the + button
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * triggers the - button
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        CheckBox wcCheckBox = (CheckBox) findViewById(R.id.wc_checkbox);
        boolean hasWc = wcCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream? " + hasWc);



        int price = calculatePrice();
        displayMessage(createOrderSummary(price, hasWc));
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * pricePerCup;
    }
    /** Order Summary.
     * @param price of order.
     * @return text summary.
     * @param addWC shows whether or not we have whipped cream added to the order.
     * now what?
     *
     */

    private String createOrderSummary(int price, boolean addWC) {
        String priceMessage = "Name: Lyla the Labyrinth";
        priceMessage += "\nWhipped Cream?: " + addWC;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal= $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
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
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(java.text.NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


}