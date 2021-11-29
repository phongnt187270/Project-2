package vn.edu.hust.sis.phong.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout expandableView1;
    CardView cardView1;

    ConstraintLayout expandableView_dose1;
    CardView cardView_dose1;

    ConstraintLayout expandableView_dose2;
    CardView cardView_dose2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableView1 = findViewById(R.id.expandableView1);
        cardView1 = findViewById(R.id.cardView1);

        expandableView_dose1 = findViewById(R.id.expandableView_dose1);
        cardView_dose1 = findViewById(R.id.cardView_dose1);

        expandableView_dose2 = findViewById(R.id.expandableView_dose2);
        cardView_dose2 = findViewById(R.id.cardView_dose2);

    }

    public void expandClick_patitent(View view) {
        if (expandableView1.getVisibility() == View.GONE) {
            TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
            expandableView1.setVisibility(View.VISIBLE);
        } else {
            TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
            expandableView1.setVisibility(View.GONE);
        }
    }

    public void expandClick_does1(View view) {
        if (expandableView_dose1.getVisibility() == View.GONE) {
            TransitionManager.beginDelayedTransition(cardView_dose1, new AutoTransition());
            expandableView_dose1.setVisibility(View.VISIBLE);
        } else {
            TransitionManager.beginDelayedTransition(cardView_dose1, new AutoTransition());
            expandableView_dose1.setVisibility(View.GONE);
        }
    }

    public void expandClick_dose2(View view) {
        if(expandableView_dose2.getVisibility() == View.GONE) {
            TransitionManager.beginDelayedTransition(cardView_dose2, new AutoTransition());
            expandableView_dose2.setVisibility(View.VISIBLE);
        }
        else{
            TransitionManager.beginDelayedTransition(cardView_dose2, new AutoTransition());
            expandableView_dose2.setVisibility(View.GONE);
        }
    }
}