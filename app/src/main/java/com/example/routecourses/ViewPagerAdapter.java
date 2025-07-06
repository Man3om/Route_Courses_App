package com.example.routecourses;// ViewPagerAdapter.java
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a new Fragment based on the position
        switch (position) {
            case 0:
                return new Fragments.AndroidScreen();
            case 1:
                return new Fragments.IOSScreen();
            case 2:
                return new Fragments.FullStackScreen();
            default:
                // Handle unexpected position gracefully, or throw an exception
                // For example, return a default/empty fragment or throw an error
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        // Return the total number of screens/fragments
        return 3;
    }
}