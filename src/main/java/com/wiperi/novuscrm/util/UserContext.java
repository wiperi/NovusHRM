package com.wiperi.novuscrm.util;

public class UserContext {

    private static final ThreadLocal<Integer> USER_CONTEXT = new ThreadLocal<>();

    public static void setUser(Integer empId) {
        USER_CONTEXT.set(empId);
    }

    public static Integer getUserId() {
        return USER_CONTEXT.get();
    }

    public static void clear() {
        USER_CONTEXT.remove();
    }
}
