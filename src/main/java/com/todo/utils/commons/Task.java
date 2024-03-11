package com.todo.utils.commons;

public enum Task {
    MY_DAY("My_Day"),
    IMPORTANT("Important"),
    ALL("All"),
    COMPLETED("Completed"),
    PLANNED("Planned"),
    ASSIGNED_TO_ME("Assigned_To_Me"),
    TASKS("Tasks");
    public final String code;

    Task(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
