package com.example.todolist;

import java.util.ArrayList;

public class Utils {

    private static ArrayList<studyItems> studyItem;
    private static ArrayList<Plan> plans;

    public static void initList () {

        if(null == studyItem){
            studyItem = new ArrayList<>();
        }

        studyItems Coding = new studyItems("Coding", "Coding must be done atleast once a day", "By coding everyday the logical skills of a person is expected to increase and it is having a very high demand in the present day society and lot of people are involved in coding everyday","https://newhorizons.com.sg/wp-content/uploads/2016/03/Coding-512.png",1);
        studyItem.add(Coding);

        studyItems Bhagavad_Gita = new studyItems("Bhagavad Geetha", "For the improvement of a person's character, they have to study Bhagavad Geetha.","Lots of people have read Bhagavah Geetha and reached heights no one could imagine. Be the best version of yourself by reading Geetha. It helps you keep your concentration away from unwanted things and teaches you how to master your mind.", "https://vediccosmos.com/wp-content/uploads/2018/09/section-5-a1-min.png",2);
        studyItem.add(Bhagavad_Gita);

        studyItems AppDev = new studyItems("App Development","One of your key skills.","App development in java is extremely rare and useful. It helps you in mastering object oriented programming . Also helps you to visualize the written code in a graphical form. It is one of the market demands from a programmer. It can be tiring at times but don't leave it mid-way because you will be lost somewhere where there is no return.\nHey i am Charan Kotturi,\n I am just checking if the scroll bar is working or not\n.Thank you\n.","https://www.egrovesys.com/wp-content/uploads/2019/07/mobile-app-development-img.png",3);
        studyItem.add(AppDev);

    }

    public static ArrayList<studyItems> getStudyItem() {
        return studyItem;
    }

    public static ArrayList<Plan> getPlans() {
        return plans;
    }

    public static boolean addPlan(Plan plan){
        if(null == plans){
            plans = new ArrayList<>();
        }
        return plans.add(plan);
    }
}
