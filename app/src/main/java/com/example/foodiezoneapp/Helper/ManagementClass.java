package com.example.foodiezoneapp.Helper;


import android.content.Context;
import android.widget.Toast;

import com.example.foodiezoneapp.Domain.FoodDomain;
import com.example.foodiezoneapp.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementClass {
    private Context context;
    private TinyDB tinyDB;

    public ManagementClass(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;

        for(int i=0; i<listFood.size(); i++) {
            if(listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if(existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }
        else {
            listFood.add(item);
        }

        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to Cart!", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if(listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        }
        else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }

        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<FoodDomain> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getFee()*listfood2.get(i).getNumberInCart());
        }

        return fee;
    }
}