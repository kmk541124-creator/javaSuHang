package entity.scene;

import entity.interact.Interact;
import service.DialogBoxService;

import java.util.ArrayList;
import java.util.Scanner;

public class Sence {

    public Scanner scanner = new Scanner(System.in);
    public DialogBoxService dialogBoxService = new DialogBoxService(scanner);
    public Boolean first = false;

    public String getName(){
        return  null;
    }

    public String getSeance(){
        return null;
    }

    public Boolean move(){
        return true;
    }

    public ArrayList<Interact> interacts(){
        return null;
    }

    public void reset(){

    }

    public void first(){

    }

    public void openRest(){

    }
    public void openApex(){

    }

    public void openBlock(){

    }

    public void openLab(){}
}
