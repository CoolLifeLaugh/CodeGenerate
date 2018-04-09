package com.jianchi;


/**
 * Created by fulushou on 2017/5/28.
 */
public class GetSetGenerate {

    public static void main(String args[]){
        doAll(AppTest.class,"xx","bb");
        set(AppTest.class);
        get(AppTest.class);
    }

    private static String getLowerFirst(String name){
        return name.substring(0,1).toLowerCase() + name.substring(1);
    }

    public static void set(Class clazz){
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for(java.lang.reflect.Field field : fields){
            field.setAccessible(true);
            System.out.print(setCaptureName(field.getName(),getLowerFirst(clazz.getSimpleName())) +field.getName() + ");"); ;
            System.out.println();
        }
    }

    public static void get(Class clazz){
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for(java.lang.reflect.Field field : fields){
            field.setAccessible(true);
            System.out.print(getCaptureName(field.getName(),getLowerFirst(clazz.getSimpleName()))); ;
            System.out.println();
        }
    }
    public static void doAll(Class clazz,String setname,String getname){
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for(java.lang.reflect.Field field : fields){
            field.setAccessible(true);
            System.out.print(fromAtoa(field,setname,getname)); ;
            System.out.println();
        }
    }

    public static String  fromAtoa(java.lang.reflect.Field field,String set,String get){
       return setCaptureName(field.getName(),set) + getCaptureName(field.getName(),get) + ");";
    }

    public static String setCaptureName(String name,String obj) {
        name = obj + ".set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(";
        return  name;

    }

    public static String getCaptureName(String name,String obj) {
        name = obj  + ".get" + name.substring(0, 1).toUpperCase() + name.substring(1) + "()";
        return  name;

    }
}
