package com.nyan.paginationexample;

import java.util.ArrayList;
import java.util.List;

public class GGModel {

  private String title;

  public GGModel(String s) {
    this.title = s;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private static int lastItemId = 0;
  public static List<GGModel> createList(int numItem, int offset) {
    List<GGModel> ggmodel = new ArrayList<GGModel>();

    for (int i = 0; i <= numItem; i++) {
      ggmodel.add(new GGModel("Tit " + i));
    }

    return ggmodel;
  }

}
