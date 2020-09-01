package za.co.programme.gauri.orderdetails;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button track;
    ImageView pinknotch;
    ImageView food;
    ImageView blacknotch;
    ImageView loc;
    TextView orderdeatils;
    TextView items;
    TextView seedeatils;
    TextView OrderD;
    View View;
    TextView Pymode;
    TextView Phone;
    TextView address;
    TextView address2;
    HorizontalStepView step_view;
    TextView Prep;
    TextView arrival;
    TextView time;
    TextView office;
    Button report;







    @SuppressLint("CutPasteId")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        track=findViewById(R.id.track);
        pinknotch=findViewById(R.id.pinknotch);
        food=findViewById(R.id.food);
        blacknotch=findViewById(R.id.blacknotch);
        loc=findViewById(R.id.loc);
        orderdeatils=findViewById(R.id.orderdetails);
        items=findViewById(R.id.items);
        seedeatils=findViewById(R.id.seedetails);
        OrderD=findViewById(R.id.OrderD);
        time=findViewById(R.id.time);
        //View=findViewById(R.id.View);
        Pymode=findViewById(R.id.Pymode);
        Phone=findViewById(R.id.Phone);
        address2=findViewById(R.id.address2);
        address=findViewById(R.id.address);
        office=findViewById(R.id.office);
        step_view=findViewById(R.id.step_view);
        Prep=findViewById(R.id.Prep);
        arrival=findViewById(R.id.arrival);
        report=findViewById(R.id.report);
        report.setEnabled(false);



        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Toffice=office.getText().toString().trim();
                DisplayTrack(Toffice);
            }
        });
        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException e){}
        HorizontalStepView setpview = (HorizontalStepView) findViewById(R.id.step_view);
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("Cooking",1);
        StepBean stepBean1 = new StepBean("Picked",0);
        StepBean stepBean2 = new StepBean("On way",0);
        StepBean stepBean3 = new StepBean("Delivered",0);
        StepBean stepBean4 = new StepBean("Done",-1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);
        setpview
                .setStepViewTexts(stepsBeanList)//总步骤
                .setTextSize(12)//set textSize

                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent))//设置StepsViewIndicator未完成线的颜色
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent))//设置StepsViewIndicator完成线的颜色

                .setStepViewComplectedTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.black))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.black))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.cooking))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.default_icon))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.default_icon));//设置StepsViewIndicator DefaultIcon


    }

    private void DisplayTrack(String Toffice) {
        try {
            Uri uri= Uri.parse("https://www.google.co.in/maps/dir/"+  Toffice);
            Intent intent =new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){

            Uri uri= Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}