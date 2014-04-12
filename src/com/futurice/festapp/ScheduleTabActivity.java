package com.futurice.festapp;

import java.util.Date;

import com.futurice.festapp.dao.GigDAO;
import com.futurice.festapp.domain.to.FestivalDay;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.futurice.festapp.R;

/**
 * TabActivity for the Festival Schedule.
 * 
 * Contains tabs for Friday, Saturday and Sunday.
 * 
 * @author Pyry-Samuli Lahti / Futurice
 */

public class ScheduleTabActivity extends Activity {
	
	public class ScheduleTabListener<T extends Fragment> implements ActionBar.TabListener {
	    private Fragment mFragment;
	    private final Activity mActivity;
	    private final String mTag;
	    private final Class<T> mClass;

	    /** Constructor used each time a new tab is created.
	      * @param activity  The host Activity, used to instantiate the fragment
	      * @param tag  The identifier tag for the fragment
	      * @param clz  The fragment's Class, used to instantiate the fragment
	      */
	    
	    public ScheduleTabListener(Activity activity, String tag, Class<T> clz) {
	        mActivity = activity;
	        mTag = tag;
	        mClass = clz;
	    }

	    @Override
	    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	        // Check if the fragment is already initialized
	        if (mFragment == null) {
	            // If not, instantiate and add it to the activity
	            mFragment = Fragment.instantiate(mActivity, mClass.getName());
	            ft.add(android.R.id.content, mFragment, mTag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(mFragment);
	        }
	    }

	    @Override
	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	        if (mFragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(mFragment);
	        }
	    }

	    @Override
	    public void onTabReselected(Tab tab, FragmentTransaction ft) {
	        // User selected the already selected tab. Usually do nothing.
	    }
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(false);

	    addActionTab(actionBar, FestivalDay.MONDAY);
	    addActionTab(actionBar, FestivalDay.TUESDAY);
	    addActionTab(actionBar, FestivalDay.WEDNESDAY);
	    addActionTab(actionBar, FestivalDay.THURSDAY);
	    addActionTab(actionBar, FestivalDay.FRIDAY);
	    addActionTab(actionBar, FestivalDay.SATURDAY);
	    addActionTab(actionBar, FestivalDay.SUNDAY);
	    
	    /*
		FestivalDay day = GigDAO.getFestivalDay(new Date());
		if (day == null) {
			day = FestivalDay.FRIDAY;
		}
		tabHost.setCurrentTabByTag(day.name());
		*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	private void addActionTab(ActionBar actionBar, FestivalDay festivalDay) {
	    Tab tab = actionBar.newTab()
                		   .setText(festivalDay.getLocalName(this))
                		   .setTabListener(new ScheduleTabListener<TimelineFragment>(this, festivalDay.name(), TimelineFragment.class));
	    actionBar.addTab(tab);
		
	}
}
