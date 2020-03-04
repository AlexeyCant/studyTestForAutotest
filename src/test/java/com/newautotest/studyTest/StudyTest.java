package com.newautotest.studyTest;


import org.junit.Test;


import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class StudyTest {

    @Test
    public void taskOneFirstVariant() {
        open("http://todomvc.com/examples/emberjs/");
        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();
        elements("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));
        elements("#todo-list>li").findBy(exactText("b")).find(".toggle").click();
        elements("#todo-list>li").filterBy(cssClass("completed"))
                .shouldHave(exactTexts("b"));
        elements("#todo-list>li").filterBy(not(cssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }

    @Test
    public void completesTask() {

        // open TodoMVC page
        open("http://todomvc.com/examples/emberjs/");
        // add tasks: "a", "b", "c"
        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();
        // tasks should be "a", "b", "c"
        elements("#todo-list li").shouldHave(exactTexts("a", "b", "c"));
        // toggle b
        element("#todo-list li:nth-of-type(2) .toggle").click();
        // completed tasks should be b
        // active tasks should be a, c

    }

}
