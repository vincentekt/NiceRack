package nicerack.com.nicerack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddSellingItemPage extends AppCompatActivity {
    private Button sell_button;

    public static Intent newIntent(Context packageContext){
        Intent i = new Intent(packageContext, AddSellingItemPage.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_selling_item_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sell_button = (Button) findViewById(R.id.sell_button);
        sell_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = Receipt_ListingAcknowledge_Page.newIntent(AddSellingItemPage.this, "bracelet_pandora", "listing_acknowledgement");
                startActivity(i);
            }
        });
    }
}
