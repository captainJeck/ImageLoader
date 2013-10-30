package com.novoda.imageloader.acceptance;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.AbsListView;

import com.jayway.android.robotium.solo.Solo;
import com.novoda.imageloader.demo.activity.ImageLongList;
import com.novoda.imageloader.demo.R;

public class ImageLoaderDemoActivityTest extends ActivityInstrumentationTestCase2<ImageLongList> {
    private Solo solo;

    public ImageLoaderDemoActivityTest() {
        super("com.novoda.imageloader.demo", ImageLongList.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testOpenTheActivity() {
        assertNotNull(solo);
    }

    public void testScrollingThroughList() {
        AbsListView list = (AbsListView) solo.getView(R.id.list_view);
        
        for (int i = 0; i < Math.max(2, list.getCount()); i++) {
            solo.scrollDown();
        }
        
        assertEquals(list.getLastVisiblePosition(), list.getSelectedItemPosition());
    }
}
