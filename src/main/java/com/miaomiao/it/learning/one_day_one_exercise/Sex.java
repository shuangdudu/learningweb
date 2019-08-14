package com.miaomiao.it.learning.one_day_one_exercise;

import java.util.Map;

public enum Sex {
    Man(1){
        @Override
                void draw(){
            System.out.println("i am a man");
        }
    },
    Woman(2){
        @Override
        void draw() {
            System.out.println("i am a woman");
        }
    };

    private int type;
    private String str = "";

    abstract void draw();

    Sex(int type){
        this.type = type;
    }
    public int getType(){
        return type;
    }

    public static Map<Integer,Sex> map;
        static{
            for(Sex test: Sex.values()){
                map.put(test.getType(),test);
            }
        }

}
