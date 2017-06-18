package nicerack.com.nicerack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import actionPackages.OnSwipeTouchListener;

public class MainPage extends AppCompatActivity {
    private int[] imageNameHolder = {R.drawable.second_hand_luxury_watch,
            R.drawable.bracelets_ad_banners, R.drawable.pens_ad_banner};

    private int currentAdsBannerIndex = 0;

    private ImageView adsBanners;
    private ImageView itemMightLike1EarPhone;
    private ImageView itemMightLike2Book;
    private Button add_item;
    private Button nearby_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Load the animation like this
        final Animation animSlide_left = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left);
        final Animation animSlide_right = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_right);

        adsBanners = (ImageView) findViewById(R.id.ads_banner);
        adsBanners.setOnTouchListener(new OnSwipeTouchListener(MainPage.this) {
            public void onSwipeLeft() {
                // change the image in the imageview
                currentAdsBannerIndex -= 1;

                if (currentAdsBannerIndex < 0){
                    currentAdsBannerIndex = imageNameHolder.length - 1;
                }

                adsBanners.startAnimation(animSlide_left);
                adsBanners.setImageResource(imageNameHolder[currentAdsBannerIndex]);
            }

            public void onSwipeRight() {
                currentAdsBannerIndex += 1;

                if (currentAdsBannerIndex > (imageNameHolder.length - 1)){
                    currentAdsBannerIndex = 0;
                }

                adsBanners.startAnimation(animSlide_right);
                adsBanners.setImageResource(imageNameHolder[currentAdsBannerIndex]);
            }
        });

        itemMightLike1EarPhone = (ImageView) findViewById(R.id.you_might_like_1_earphone);
        itemMightLike1EarPhone.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start ItemPage
                String imageTarget = "Razer_Hammerhead_Pro_EarPhone";
                Intent i = ItemPage.newIntent(MainPage.this, imageTarget);
                startActivity(i);
            }
        });

        itemMightLike2Book = (ImageView) findViewById(R.id.you_might_like_2_book);
        itemMightLike2Book.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start ItemPage
                String imageTarget = "Inside_Strategy";
                Intent i = ItemPage.newIntent(MainPage.this, imageTarget);
                startActivity(i);
            }
        });

        add_item = (Button) findViewById(R.id.add_item);
        add_item.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = AddSellingItemPage.newIntent(MainPage.this);
                startActivity(i);
            }
        });

        nearby_button = (Button) findViewById(R.id.nearby_button);
        nearby_button.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start ItemPage
                String imageTarget = "Razer_Hammerhead_Pro_EarPhone";
                Intent i = ItemPage.newIntent(MainPage.this, imageTarget);
                startActivity(i);
            }
        });
    }
}
