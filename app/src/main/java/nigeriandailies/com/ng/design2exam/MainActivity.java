package nigeriandailies.com.ng.design2exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Basics Components");
        mCoordinatorLayout = findViewById(R.id.coordinatorlayout);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showSimpleSnackBar(View view) {
        Snackbar.make(mCoordinatorLayout, "Simple snackBar", Snackbar.LENGTH_LONG).show();
    }

    public void showSnackBarWithActionCallBack(View view) {
       Snackbar snackbar = Snackbar.make(mCoordinatorLayout, "Error Loading File", Snackbar.LENGTH_LONG);
       snackbar.setAction("RETRY", new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Snackbar.make(mCoordinatorLayout, "File Loaded Successfully", Snackbar.LENGTH_SHORT).show();
           }
       });
       snackbar.show();

    }

    public void showSnackBarWithColoredText(View view) {
        Snackbar snackbar = Snackbar.make(mCoordinatorLayout, "Download Failed", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Do something
                    }
                });

        View snackbarLayout = snackbar.getView();
        snackbarLayout.setBackgroundColor(Color.BLUE);

        // SnackBar Message Text color
        TextView textView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);

        // Changing Action Button Text Color - METHOD 1
//        snackbar.setActionTextColor(Color.RED);

        // OR Change Action Button Text Color - METHOD 2
		Button btn = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_action);
		btn.setTextColor(Color.RED);

        snackbar.show();

    }
}