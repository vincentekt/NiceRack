package nicerack.com.nicerack;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Receipt_ListingAcknowledge_Page extends AppCompatActivity {
    private static final String YOU_MIGHT_LIKE_IMAGE_TARGET_PAGEPURPOSE = "nicerack.youMightLikeImageTarget.pagepurpose";
    private static final String PAGE_PURPOSE = "nicerack.page.purpose";

    private String imageTarget;
    private String pagePurpose;

    private ImageView receipt_item_photo;
    private TextView receipt_item_name;
    private TextView receipt_item_id;
    private TextView receipt_seller_name;
    private TextView receipt_datetime;
    private TextView receipt_item_price;
    private TextView receipt_item_location;
    private TextView receipt_item_cabinet_location;
    private TextView receipt_item_pickup_expiry;
    private TextView receipt_item_expiry_warning;
    private TextView receipt_item_pickup_otp;

    private int itemIndex;
    private int[] item_photo_holder = {R.drawable.razer_hammerhead_pro_earphones_original, R.drawable.book, R.drawable.bracelet_sell_item};
    private int[] item_name_holder = {R.string.receipt_item_name_razer_hammerhead, R.string.receipt_item_name_book, R.string.bracelet_sell_item};
    private int[] item_id_holder = {R.string.receipt_item_id_razer_hammerhead, R.string.receipt_item_id_book, R.string.receipt_item_id_bracelet_sell_item};
    private int[] seller_name_holder = {R.string.receipt_seller_name_razer_hammerhead, R.string.receipt_seller_name_book};
    private int[] datetime_holder = {R.string.receipt_datetime_razer_hammerhead, R.string.receipt_datetime_book, R.string.datetime_bracelet_sell_item};
    private int[] item_price_holder = {R.string.receipt_price_razer_hammerhead, R.string.receipt_price_book, R.string.price_bracelet_sell_item};
    private int[] item_location_holder = {R.string.location_razer_hammerhead, R.string.location_book, R.string.location_bracelet_sell_item};
    private int[] receipt_item_cabinet_location_holder = {R.string.cabinet_location_razer_hammerhead, R.string.cabinet_location_book, R.string.cabinet_location_bracelet_sell_item};
    private int[] item_pickup_expiry_holder = {R.string.pickup_expiry_razer_hammerhead, R.string.pickup_expiry_book, R.string.period_bracelet_sell_item};
    private int[] item_pickup_otp_holder = {R.string.pickup_otp_razer_hammerhead, R.string.pickup_otp_book, R.string.cost_bracelet_sell_item};

    public static Intent newIntent(Context packageContext, String imageTarget, String pagePurpose){
        Intent i = new Intent(packageContext, Receipt_ListingAcknowledge_Page.class);
        i.putExtra(YOU_MIGHT_LIKE_IMAGE_TARGET_PAGEPURPOSE, imageTarget);
        i.putExtra(PAGE_PURPOSE, pagePurpose);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt__listing_acknowledge__page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageTarget = getIntent().getStringExtra(YOU_MIGHT_LIKE_IMAGE_TARGET_PAGEPURPOSE);
        pagePurpose = getIntent().getStringExtra(PAGE_PURPOSE);

        if (imageTarget.equals("Razer_Hammerhead_Pro_EarPhone")){
            itemIndex = 0;
        } else if (imageTarget.equals("Inside_Strategy")) {
            itemIndex = 1;
        } else {
            itemIndex = 2;
        }

        // set the text on the action bar
        if (pagePurpose.equals("receipt")){
            getSupportActionBar().setTitle(R.string.receipt_page_title);
        } else {
            getSupportActionBar().setTitle(R.string.listing_acknowledgement_page_title);
        }

        receipt_item_photo = (ImageView) findViewById(R.id.receipt_item_photo);
        receipt_item_name = (TextView) findViewById(R.id.receipt_item_name);
        receipt_item_id = (TextView) findViewById(R.id.receipt_item_id);
        receipt_seller_name = (TextView) findViewById(R.id.receipt_seller_name);
        receipt_datetime = (TextView) findViewById(R.id.receipt_datetime);
        receipt_item_price = (TextView) findViewById(R.id.receipt_item_price);
        receipt_item_location = (TextView) findViewById(R.id.receipt_item_location);
        receipt_item_cabinet_location = (TextView) findViewById(R.id.receipt_item_cabinet_location);
        receipt_item_pickup_expiry = (TextView) findViewById(R.id.receipt_item_pickup_expiry);
        receipt_item_expiry_warning = (TextView) findViewById(R.id.receipt_item_expiry_warning);
        receipt_item_pickup_otp = (TextView) findViewById(R.id.receipt_item_pickup_otp);

        setItemInfo(itemIndex);
    }

    private void setItemInfo(int targetItemIndex){
        receipt_item_photo.setImageResource(item_photo_holder[targetItemIndex]);
        receipt_item_name.setText(item_name_holder[targetItemIndex]);
        receipt_item_id.setText(item_id_holder[targetItemIndex]);

        if (targetItemIndex != 2){
            receipt_item_expiry_warning.setVisibility(View.VISIBLE);
            receipt_seller_name.setVisibility(View.VISIBLE);
            receipt_seller_name.setText(seller_name_holder[targetItemIndex]);
            receipt_item_pickup_otp.setTextColor(Color.RED);
        } else {
            receipt_seller_name.setVisibility(View.GONE);
            receipt_item_expiry_warning.setVisibility(View.GONE);
            receipt_item_pickup_otp.setTextColor(Color.BLACK);
        }

        receipt_datetime.setText(datetime_holder[targetItemIndex]);
        receipt_item_price.setText(item_price_holder[targetItemIndex]);
        receipt_item_location.setText(item_location_holder[targetItemIndex]);
        receipt_item_cabinet_location.setText(receipt_item_cabinet_location_holder[targetItemIndex]);
        receipt_item_pickup_expiry.setText(item_pickup_expiry_holder[targetItemIndex]);
        receipt_item_pickup_otp.setText(item_pickup_otp_holder[targetItemIndex]);
    }
}
