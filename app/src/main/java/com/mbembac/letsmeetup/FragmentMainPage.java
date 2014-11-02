package com.mbembac.letsmeetup;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Typeface;

public class FragmentMainPage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getActionBar();
        int titleId = getResources().getIdentifier("action_bar_title", "id",
                "android");
        TextView yourTextView = (TextView) findViewById(titleId);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "Chi-TownNF.ttf");
        yourTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        yourTextView.setTypeface(customFont);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tabA = actionBar.newTab();
        tabA.setText("Home");
        tabA.setTabListener(new TabListener<Welcome>(this, "Tag A", Welcome.class));
        actionBar.addTab(tabA);

        Tab tabB = actionBar.newTab();
        tabB.setText("Friends");
        tabB.setTabListener(new TabListener<FriendActivity>(this, "Tag B", FriendActivity.class));
        actionBar.addTab(tabB);

        Tab tabC = actionBar.newTab();
        tabC.setText("Questions");
        tabC.setTabListener(new TabListener<QAActivity>(this, "Tag C", QAActivity.class));
        actionBar.addTab(tabC);

        if (savedInstanceState != null) {
            int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
            getActionBar().setSelectedNavigationItem(savedIndex);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putInt("SAVED_INDEX", getActionBar().getSelectedNavigationIndex());
    }

    public static class TabListener<T extends Fragment>
            implements ActionBar.TabListener{

        private final Activity myActivity;
        private final String myTag;
        private final Class<T> myClass;

        public TabListener(Activity activity, String tag, Class<T> cls) {
            myActivity = activity;
            myTag = tag;
            myClass = cls;
        }

        @Override
        public void onTabSelected(Tab tab, FragmentTransaction ft) {

            Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);

            // Check if the fragment is already initialized
            if (myFragment == null) {
                // If not, instantiate and add it to the activity
                myFragment = Fragment.instantiate(myActivity, myClass.getName());
                ft.add(android.R.id.content, myFragment, myTag);
            } else {
                // If it exists, simply attach it in order to show it
                ft.attach(myFragment);
            }

        }

        @Override
        public void onTabUnselected(Tab tab, FragmentTransaction ft) {

            Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);

            if (myFragment != null) {
                // Detach the fragment, because another one is being attached
                ft.detach(myFragment);
            }

        }

        @Override
        public void onTabReselected(Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub

        }

    }
}