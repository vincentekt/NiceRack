package nicerack.com.nicerack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemPage extends AppCompatActivity {
    private static final String YOU_MIGHT_LIKE_IMAGE_TARGET = "nicerack.youMightLikeImageTarget";
    private String imageTarget;

    private ImageView item_photo;
    private Button pass_button;
    private Button like_button;
    private Button buy_button;
    private TextView item_name;
    private TextView item_asking_price;
    private TextView item_description_text;
    private TextView item_location;
    private TextView item_expire_duration;
    private TextView seller_name;

    private int itemIndex;
    private int[] item_photo_holder = {R.drawable.razer_hammerhead_pro_earphones_original, R.drawable.book};
    private int[] item_name_holder = {R.string.item_name_razer_hammerhead, R.string.item_name_book};
    private int[] item_asking_price_holder = {R.string.item_price_razer_hammerhead, R.string.item_price_book};
    private int[] item_description_text_holder = {R.string.description_razer_hammerhead, R.string.description_book};
    private int[] item_location_holder = {R.string.location_razer_hammerhead, R.string.location_book};
    private int[] item_expire_duration_holder = {R.string.expire_duration_razer_hammerhead, R.string.expire_duration_book};
    private int[] seller_name_holder = {R.string.seller_name_razer_hammerhead, R.string.seller_name_book};

    private String[] imageName_holder = {"Razer_Hammerhead_Pro_EarPhone", "Inside_Strategy"};

    public static Intent newIntent(Context packageContext, String imageTarget){
        Intent i = new Intent(packageContext, ItemPage.class);
        i.putExtra(YOU_MIGHT_LIKE_IMAGE_TARGET, imageTarget);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageTarget = getIntent().getStringExtra(YOU_MIGHT_LIKE_IMAGE_TARGET);

        if (imageTarget.equals("Razer_Hammerhead_Pro_EarPhone")){
            itemIndex = 0;
        } else {
            itemIndex = 1;
        }

        item_photo = (ImageView) findViewById(R.id.item_photo);
        item_name = (TextView) findViewById(R.id.item_name);
        item_asking_price = (TextView) findViewById(R.id.item_asking_price);
        item_description_text = (TextView) findViewById(R.id.item_description_text);
        item_location = (TextView) findViewById(R.id.item_location);
        item_expire_duration = (TextView) findViewById(R.id.item_expire_duration);
        seller_name = (TextView) findViewById(R.id.seller_name);

        setItemInfo(itemIndex);

        pass_button = (Button) findViewById(R.id.pass_button);
        pass_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemIndex == 0){
                    itemIndex = 1;
                } else {
                    itemIndex = 0;
                }

                setItemInfo(itemIndex);
            }
        });

        like_button = (Button) findViewById(R.id.like_button);
        like_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemIndex == 0){
                    itemIndex = 1;
                } else {
                    itemIndex = 0;
                }

                setItemInfo(itemIndex);
            }
        });

        buy_button = (Button) findViewById(R.id.buy_button);
        buy_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = Receipt_ListingAcknowledge_Page.newIntent(ItemPage.this, imageName_holder[itemIndex], "receipt");
                startActivity(i);
            }
        });
    }

    private void setItemInfo(int targetItemIndex){
        item_photo.setImageResource(item_photo_holder[targetItemIndex]);
        item_name.setText(item_name_holder[targetItemIndex]);
        item_asking_price.setText(item_asking_price_holder[targetItemIndex]);
        item_description_text.setText(item_description_text_holder[targetItemIndex]);
        item_location.setText(item_location_holder[targetItemIndex]);
        item_expire_duration.setText(item_expire_duration_holder[targetItemIndex]);
        seller_name.setText(seller_name_holder[targetItemIndex]);
    }
}
