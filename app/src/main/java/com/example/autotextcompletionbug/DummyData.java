package com.example.autotextcompletionbug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyData {
    public ArrayList<SampleData> dummyDataList = new ArrayList<>() ;
    public ArrayList<SampleData> getData(){
        SampleData s1 = new SampleData();
        s1.setName("John");
        s1.setEmail("john@com");
        s1.setDesignation("Student");

        SampleData s2 = new SampleData();
        s2.setName("Adam");
        s2.setEmail("adam@com");
        s2.setDesignation("Student");

        SampleData s3 = new SampleData();
        s3.setName("Ava");
        s3.setEmail("Ava@com");
        s3.setDesignation("Student");

        SampleData s4 = new SampleData();
        s4.setName("Tom");
        s4.setEmail("tom@com");
        s4.setDesignation("Student");

        SampleData s5 = new SampleData();
        s5.setName("Conner");
        s5.setEmail("Conner@com");
        s5.setDesignation("Student");

        dummyDataList.add(s1);
        dummyDataList.add(s2);
        dummyDataList.add(s3);
        dummyDataList.add(s4);
        dummyDataList.add(s5);

        return dummyDataList;
    }
}
