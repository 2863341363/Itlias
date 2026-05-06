package com.yangzhong.itlias.util;

public class Thread {
    private static  ThreadLocal threadLocal = new ThreadLocal<>();
    private static ThreadLocal threadLocal1 = new ThreadLocal();
    public static void setCurrentId(Integer empId){
        threadLocal.set(empId);
    }
    public static Integer getCurrentId(){
        return (Integer)threadLocal.get();
    }

    public static void removeId(){
        threadLocal.remove();
    }

    public static void setCurrentEmpName(String empName){
        threadLocal1.set(empName);
    }
    public static String getCurrentEmpName(){
        return (String)threadLocal1.get();
    }
    public static void removeName(){
        threadLocal.remove();
    }
}
