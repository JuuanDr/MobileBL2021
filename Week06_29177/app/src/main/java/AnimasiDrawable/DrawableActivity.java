package AnimasiDrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.week06_29177.R;

public class DrawableActivity extends AppCompatActivity {
    AnimationDrawable adKuda;
    ImageView ivKuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        ivKuda = findViewById(R.id.ivKudaLari);
        ivKuda.setBackgroundResource(R.drawable.kudalari);
        adKuda = (AnimationDrawable) ivKuda.getBackground();
        adKuda.start();
    }
}