package com.jmedeisis.example.draglinearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class ScrollByDragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_to_drag);

        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
        // set all children draggable except the first (the header)
        for(int i = 1; i < dragLinearLayout.getChildCount(); i++){
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child); // the child is its own drag handle
        }
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        dragLinearLayout.setContainerScrollView(scrollView);
        dragLinearLayout.setHoldingMsToDrag(200);
        dragLinearLayout.setDragStateListener(new DragLinearLayout.DragStateListener() {
            @Override
            public void onStartDrag(View view) {
                scrollView.setScrollY(10);
            }

            @Override
            public void onFinishDrag(View view) {

            }
        });
    }

}
