package com.h2kresearch.iepread;

import android.app.Fragment;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ResultActivity extends AppCompatActivity
    implements MenuleftFragment.OnFragmentInteractionListener, Contents2Fragment.OnGradeListener,
    MenutopFragment.OnFragmentInteractionListener, Menutop2Fragment.OnFragmentInteractionListener, Menutop3Fragment.OnFragmentInteractionListener,
    ContentsFragment.OnFragmentInteractionListener, Contents2Fragment.OnFragmentInteractionListener, Contents3Fragment.OnFragmentInteractionListener, Contents4Fragment.OnFragmentInteractionListener, ContentsMonthFragment.OnFragmentInteractionListener, ContentsWeekFragment.OnFragmentInteractionListener {

  MenutopFragment menutopFragment;
  Menutop2Fragment menutop2Fragment;
  Menutop3Fragment menutop3Fragment;

  ContentsFragment contentsFragment;
  Contents2Fragment contents2Fragment;
  Contents3Fragment contents3Fragment;
  Contents4Fragment contents4Fragment;
  ContentsMonthFragment contentsMFragment;
  ContentsWeekFragment contentsWFragment;

  int month = 3;

  // 주관식 채점 결과 수신
  int[] grades;

  //FragmentTransaction ft;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    menutopFragment = (MenutopFragment)getSupportFragmentManager().findFragmentById(R.id.fragment9);
    menutop2Fragment = new Menutop2Fragment();
    menutop3Fragment = new Menutop3Fragment();

    contents2Fragment = (Contents2Fragment)getSupportFragmentManager().findFragmentById(R.id.fragment10);
    contentsFragment = new ContentsFragment();
    contents3Fragment = new Contents3Fragment();
    contents4Fragment = new Contents4Fragment();
    contentsMFragment = new ContentsMonthFragment();
    contentsWFragment = new ContentsWeekFragment();

    //ft = getSupportFragmentManager().beginTransaction();
  }

  public void onMenutopFragmentChanged(int index) {
    if(index == 1){ // 주관식 채점하기
      getSupportFragmentManager().beginTransaction().replace(R.id.topMenuContainer, menutopFragment).commit();  // 주관식 채점하기 메뉴
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contents2Fragment).commit(); // 의미/무의미 단어 읽기 내용
    } else if(index == 2) { // 채점결과 학인하기
      getSupportFragmentManager().beginTransaction().replace(R.id.topMenuContainer, menutop2Fragment).commit(); // 채점결과 확인하기 메뉴
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contents3Fragment).commit(); // 객관식 채점결과 내용
    } else if(index == 3) { // IEP 확인하기
      getSupportFragmentManager().beginTransaction().replace(R.id.topMenuContainer, menutop3Fragment).commit(); // IEP 확인하기 메뉴
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contents4Fragment).commit(); // 학기별 교육내용 내용
    }
  }

  public void onContentsFragmentChanged(int index) {
    if(index == 1){ // 의미/무의미 단어 읽기
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contents2Fragment).commit();
    } else if(index == 2) { // 앍기 유창성 검사
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contentsFragment).commit();
    } else if(index == 3) { // 채점 결과 확인하기

    } else if(index == 4) { // 학기별 교육 내용
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contents4Fragment).commit();
    } else if(index == 5) { // 월별 교육 내용
      Bundle bundle = new Bundle();
      bundle.putInt("month", month);
      if (contentsMFragment.getArguments() == null){
        contentsMFragment.setArguments(bundle);
      } else {
        contentsMFragment.getArguments().putAll(bundle);
      }
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contentsMFragment).commit();
    } else if(index == 6) { // 주별 교육 내용
      Bundle bundle = new Bundle();
      bundle.putInt("month", month);
      if (contentsWFragment.getArguments() == null){
        contentsWFragment.setArguments(bundle);
      } else {
        contentsWFragment.getArguments().putAll(bundle);
      }
      getSupportFragmentManager().beginTransaction().replace(R.id.contentsContainer, contentsWFragment).commit();
    }

  }

  @Override
  public void onFragmentInteraction(Uri uri){

  }

  @Override
  public void onGradeSet(int[] gradeResults){
    // 주관식 채점 결과 수신
    grades = gradeResults;
    Log.d("grades length", "length: "+grades.length+" sample grades[0]: "+grades[0]+" sample grades[1]: "+grades[1]);
  }
}
