package com.example.andriod.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android .view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import java.text.NumberFormat;
import com.example.andriod.justjava.R;
/**
 * this app displays and order form to order coffee
 */
public class MainActivity extends AppCompatActivity {

    int quantity =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /**
     *This method is called when the plus bottom is clicked
     */

    public void increment(View View){
        quantity = quantity +1;
        int someQuantity = 100;
        displayQuantity(someQuantity);

    }

    /**
     *This method is called when minus bottom is clicked
     */
    public void decrement(View View){
        quantity = quantity - 1;
        displayQuantity(quantity);

    }
    public void resetQuantity(View v){


    }
    /**
     *This method is called when the order button is click
     */
    public void submitOrder(View View){
        EditText fieldName =(EditText) findViewById(R.id.name_field);
        String name =fieldName.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream =whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox =(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox .isChecked();
        int price =  calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary ( name, price ,hasWhippedCream, hasChocolate );
        displayPrice(priceMessage);



}

    private int calculatePrice(boolean addWhippedCream ,boolean addChocolate){
        int basePrice = 5;
        if(addWhippedCream){
            basePrice = basePrice*2;
        }
        if(addChocolate){
            basePrice = basePrice*1;
        }
        int price  = quantity*basePrice;
        return price;


    }
    private String createOrderSummary( String name, int price, boolean addWhippedCream ,boolean addChocolate){
       String priceMessage = "Name: " + name;
       priceMessage +="\nAdd whipped cream? " +addWhippedCream;
       priceMessage +="\nAdd chocolate? " +addChocolate;
       priceMessage += "\nquantity" + quantity;
       priceMessage += "\ntotal = $" + price;
       priceMessage += "\n Thank you!";
        return priceMessage;

    }




    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView =(TextView) findViewById
                (R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);

    }


    private void displayPrice(String message){
        TextView orderSummaryTextView =(TextView) findViewById
                (R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}

