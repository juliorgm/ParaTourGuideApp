package br.com.juliorgm.paratourguideapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import br.com.juliorgm.paratourguideapp.fragments.CidadeFragment;
import br.com.juliorgm.paratourguideapp.fragments.CulturaFragment;
import br.com.juliorgm.paratourguideapp.fragments.MaisVisitadosFragment;
import br.com.juliorgm.paratourguideapp.fragments.NaturezaFragment;

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter  mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager (ViewPager viewPager){
        mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(new CidadeFragment(),getApplicationContext().getString(R.string.tab_cidade));
        mSectionsPagerAdapter.addFragment(new MaisVisitadosFragment(),getApplicationContext().getString(R.string.tab_mais_visitados));
        mSectionsPagerAdapter.addFragment(new CulturaFragment(),getApplicationContext().getString(R.string.tab_cultura));
        mSectionsPagerAdapter.addFragment(new NaturezaFragment(),getApplicationContext().getString(R.string.tab_natureza));
        viewPager.setAdapter(mSectionsPagerAdapter);
    }

    public class SectionsPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> listaFragment = new ArrayList<>();
        private final List<String> listaTituloFragment = new ArrayList<>();

        private void addFragment(Fragment fragment, String title){
            listaFragment.add(fragment);
            listaTituloFragment.add(title);
        }

        private SectionsPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return listaTituloFragment.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return listaFragment.get(position);
        }

        @Override
        public int getCount() {
            return listaFragment.size();
        }
    }
}
