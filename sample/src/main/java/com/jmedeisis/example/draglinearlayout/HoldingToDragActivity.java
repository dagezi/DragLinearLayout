package com.jmedeisis.example.draglinearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class HoldingToDragActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_to_drag);

        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
        // set all children draggable except the first (the header)
        for(int i = 1; i < dragLinearLayout.getChildCount(); i++){
            View child = dragLinearLayout.getChildAt(i);
            if (child.getId() == R.id.border) {
                dragLinearLayout.setViewMovable(child);
            } else {
                dragLinearLayout.setViewDraggable(child, child);
            }
        }

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        dragLinearLayout.setContainerScrollView(scrollView);
        dragLinearLayout.setHoldingMsToDrag(500);
        dragLinearLayout.setZoomRateOnDrag(0.8f);
        dragLinearLayout.showDragShadow(false);

        dragLinearLayout.setDragStateListener(new DragLinearLayout.DragStateListener() {
            @Override
            public void onStartDrag(View view) {
                Log.d("DragTest", "onStartDrag: " + ((TextView) view).getText());
            }

            @Override
            public void onFinishDrag(View view) {
                Log.d("DragTest", "onFinishDrag: " + ((TextView) view).getText());
            }
        });
    }
}
