package edu.quinnipiac.ser210.beeradvisor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user clicks the button
    public void onClickFindBeer(View view) {
        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.textView);
        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Display the selected item
        brands.setText("Gottle of geer");
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        //Display the beers
        brands.setText(brandsFormatted);
    }
}
