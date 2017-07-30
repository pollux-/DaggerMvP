package pollux.myra.order.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import javax.inject.Inject;

import pollux.myra.MyraApp;
import pollux.myra.R;
import pollux.myra.order.contract.OrderContract;
import pollux.myra.order.di.DaggerOrderComponet;

public class MainActivity extends AppCompatActivity implements OrderContract.View {
    private static final String TAG = "MainActivity";
    private FrameLayout mContainer;
    @Inject
    OrderContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (FrameLayout) findViewById(R.id.action_container);
        handleListener();

        DaggerOrderComponet.builder().
                applicationComponent(((MyraApp) getApplicationContext())
                        .getApplicationComponent()).build().inject(this);

        mPresenter.subscribe(this);
        mPresenter.updateOrder();
    }

    /**
     * Place the View based on the position of the touch coordinate
     */
    private void handleListener() {

        mContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.img_view, mContainer, false);
                ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(inflate.getLayoutParams());
                marginParams.leftMargin = (int) event.getX();
                marginParams.topMargin = (int) event.getY();
                inflate.setLayoutParams(marginParams);
                mContainer.addView(inflate);
                return false;
            }
        });

    }

    /**
     * Update order Success callback
     */
    @Override
    public void updateOrderSuccess() {
        Log.d(TAG, "Update success");

    }

    /**
     * Update failed callback
     */
    @Override
    public void updateOderFailed() {
        Log.d(TAG, "Update success");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.cleanup();
    }
}
