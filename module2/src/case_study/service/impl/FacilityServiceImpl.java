package case_study.service.impl;

import case_study.models.facility.Villa;
import case_study.service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);

    static Map<Villa, Integer> villaList =new LinkedHashMap<>();
    @Override
    public void addNew() {
        int choice;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n");
            System.out.println("input your choice :");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("villa new ");
                    addNewVilla();
                    break;
                case 2:
                    System.out.println("house new ");
                    addNewHouse();
                    break;
                case 3:
                    System.out.println("room new ");
                    addNewRoom();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please input from 1 to 4");
            }
        }while (choice<1 ||choice>4);
    }


    @Override
    public void addNewVilla() {

    }

    @Override
    public void addNewHouse() {

    }

    @Override
    public void addNewRoom() {

    }

    @Override
    public void display() {

    }
}
