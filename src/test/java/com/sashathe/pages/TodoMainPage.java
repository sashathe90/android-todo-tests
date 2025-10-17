package com.sashathe.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import static org.testng.Assert.*;


public class TodoMainPage extends BasePage {

    public TodoMainPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NOTES']")
    public WebElement notesTitle;

    public TodoMainPage verifyNotesPage() {
        waitForVisibility(notesTitle);
        assertTrue(notesTitle.isDisplayed(), "Notes page is not open!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/fab")
    public WebElement notesButton;

    public TodoMainPage tapAddNotesButton() {
            click(notesButton);
            return this;
        }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ToDo List']")
    public WebElement addNotesTitleField;

    public TodoMainPage verifyAddNotesPage() {
        waitForVisibility(addNotesTitleField);
        assertTrue(addNotesTitleField.isDisplayed(), "Add Notes page is not open!");
        return this;
    }

    // --- Поле ввода заголовка ---
    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/title_notes")
    public WebElement titleField;

    public TodoMainPage enterTitle(String title) {
        titleField.clear();
        titleField.sendKeys(title);
        return this;
    }

    // --- Поле ввода текста заметки ---
    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/body_notes")
    public WebElement notesField;

    public TodoMainPage enterNoteText(String text) {
        notesField.clear();
        notesField.sendKeys(text);
        return this;
    }

    // --- Кнопка "Сохранить" ---
    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/save")
    public WebElement saveButton;

    public TodoMainPage tapSaveButton() {
        saveButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public WebElement backButton;

    public TodoMainPage tapBackButton() {
        backButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    public WebElement moreOptionsButton;

    public TodoMainPage tapMoreOptionsButton() {
        moreOptionsButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.sanjay.udacity.todolist:id/content']")
    public WebElement discardButton;

    public TodoMainPage tapDiscardButton() {
        discardButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title' and @text='Delete all']")
    public WebElement deleteAllButton;

    public TodoMainPage tapDeleteAllButton() {
        deleteAllButton.click();
        return this;
    }

    // --- Проверка, что заметка создана ---
    public TodoMainPage verifyCreatedNoteVisible(String expectedTitle) {
        WebElement createdNoteTitle = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + expectedTitle + "']"
        ));
        waitForVisibility(createdNoteTitle);
        assertTrue(createdNoteTitle.isDisplayed(), "Created note is not visible!");
        assertEquals(createdNoteTitle.getText(), expectedTitle, "Note title does not match expected text!");
        return this;
    }

//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Buy milk']")
//    public WebElement createdNoteTitle;
//
//    public TodoMainPage verifyCreatedNoteVisible(String expectedTitle) {
//        assertTrue(createdNoteTitle.isDisplayed(), "Created note is not visible!");
//        assertTrue(createdNoteTitle.getText().equals(expectedTitle),
//                "Note title does not match expected text!");
//        return this;
//    }

    public TodoMainPage tapEditNote(String noteTitle) {
        WebElement editNote = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + noteTitle + "']"
        ));
        click(editNote);
        return this;
    }

    public TodoMainPage tapAlreadyEditNote(String noteTitle) {
        WebElement editNote = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + noteTitle + "']"
        ));
        click(editNote);
        return this;
    }

//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Buy milk']")
//    public WebElement editNote;
//
//    public TodoMainPage tapEditNote() {
//        click(editNote);
//        return this;
//    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/title_notes")
    public WebElement noteTitleField;

    public TodoMainPage verifyNotePage() {
        waitForVisibility(noteTitleField);
        assertTrue(noteTitleField.isDisplayed(), "Note page is not open!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/title_notes")
    public WebElement addTitleField;

    public TodoMainPage addTitle(String addTitle) {
        addTitleField.clear();
        addTitleField.sendKeys(addTitle);
        return this;
    }

    public TodoMainPage verifyNoteNotChanged(String expectedText) {
        sleep(1000);

        WebElement noteTitleAfterEdit = driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@resource-id='com.sanjay.udacity.todolist:id/title_notes']"
        ));

        waitForVisibility(noteTitleAfterEdit);

        String actualText = noteTitleAfterEdit.getText().trim();

        assertEquals(actualText, expectedText,
                "Expected note text '" + expectedText + "', but found '" + actualText + "'");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Buy one milk']")
    public WebElement noteTitleAfterEditOnNotesPage;

    public TodoMainPage verifyNoteChangedOnNotesPage(String expectedTitle) {
        waitForVisibility(noteTitleAfterEditOnNotesPage);
        String actualTitle = noteTitleAfterEditOnNotesPage.getText();
        assertTrue(actualTitle.equals(expectedTitle), "Note title has no change!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/title_notes")
    public WebElement noteTitleAfterEditOnNoteToEditPage;

    public TodoMainPage verifyNoteChangedOnNoteToEditPage(String expectedText) {
        try {
            Thread.sleep(2000); // 👈 короткая пауза перед поиском
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitForVisibility(noteTitleAfterEditOnNoteToEditPage);

        String actualText = noteTitleAfterEditOnNoteToEditPage.getText().trim();
        assertTrue(actualText.equals(expectedText),
                "Expected note text '" + expectedText + "', but found '" + actualText + "'");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter title']")
    public WebElement errorMessage;

    public TodoMainPage verifyErrorMessage() {
        waitForVisibility(errorMessage);
        assertTrue(errorMessage.isDisplayed(), "Error message not displayed!");
        return this;
    }

    public TodoMainPage longClicksNote(String noteTitle) {
        WebElement noteToDelete = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + noteTitle + "']"
        ));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point location = noteToDelete.getLocation();
        Dimension size = noteToDelete.getSize();
        int centerX = location.getX() + size.getWidth() / 2;
        int centerY = location.getY() + size.getHeight() / 2;

        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(longPress));
        return this;
    }


//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Buy milk']")
//    public WebElement noteToDelete;
//
//    public TodoMainPage longClicksNote() {
//        // создаём touch input (палец)
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//
//        // получаем координаты элемента
//        Point location = noteToDelete.getLocation();
//        Dimension size = noteToDelete.getSize();
//
//        int centerX = location.getX() + size.getWidth() / 2;
//        int centerY = location.getY() + size.getHeight() / 2;
//
//        // создаём «долгое нажатие»
//        Sequence longPress = new Sequence(finger, 1)
//                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
//                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(new Pause(finger, Duration.ofSeconds(2))) // удерживаем 2 секунды
//                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        driver.perform(Arrays.asList(longPress));
//        return this;
//    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement deleteNoteMessageTitle;

    public TodoMainPage verifyDeleteNoteMessage() {
        waitForVisibility(deleteNoteMessageTitle);
        assertTrue(deleteNoteMessageTitle.isDisplayed(), "Delete Note message is not appear!");
        return this;
    }

    @AndroidFindBy(id = "android:id/button2")
    public WebElement nopeButton;

    public TodoMainPage tapNopeButton() {
        click(nopeButton);
        return this;
    }

    @AndroidFindBy(id = "android:id/button1")
    public WebElement deleteButton;

    public TodoMainPage tapDeleteButton() {
        click(deleteButton);
        return this;
    }

    public boolean isNotePresent(String noteTitle) {
        List<WebElement> notes = driver.findElements(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Buy milk']")
        );
        return !notes.isEmpty(); // true, if element founded
    }

    public TodoMainPage verifyNoteDeleted(String noteTitle) {
        boolean noteStillExists = isNotePresent(noteTitle);
        assertFalse(noteStillExists, "The note '" + noteTitle + "' was not deleted!");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TASKS']")
    public WebElement tasksButton;

    public TodoMainPage tapTasksButton() {
        click(tasksButton);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TASKS']")
    public WebElement tasksTitleField;

    public TodoMainPage verifyTasksPage() {
        waitForVisibility(tasksTitleField);
        assertTrue(tasksTitleField.isDisplayed(), "Tasks page is not open!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/fab")
    public WebElement addTaskButton;

    public TodoMainPage tapAddTaskButton() {
        click(addTaskButton);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter task name here']")
    public WebElement addTaskPopup;

    public TodoMainPage verifyAddTaskPopup() {
        waitForVisibility(addTaskPopup);
        assertTrue(addTaskPopup.isDisplayed(), "Add new Task popup is not open!");
        return this;
    }

    public TodoMainPage tapSystemBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        return this;
    }

    public TodoMainPage tapOutsidePopup() {
        Dimension screenSize = driver.manage().window().getSize();
        int width = screenSize.width;
        int height = screenSize.height;

        int tapX = width / 2;
        int tapY = (int) (height * 0.9);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), tapX, tapY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));

        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter task name here']")
    public WebElement taskNameField;

    public TodoMainPage enterTaskName(String title) {
        taskNameField.clear();
        taskNameField.sendKeys(title);
        return this;
    }

    @AndroidFindBy(id = "android:id/button1")
    public WebElement addNewButton;

    public TodoMainPage tapAddNewButton() {
        addNewButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Tomorrow Task']")
    public WebElement createdTaskTitle;

    public TodoMainPage verifyCreatedTaskVisible(String expectedTitle) {
        assertTrue(createdTaskTitle.isDisplayed(), "Created task is not visible!");
        assertTrue(createdTaskTitle.getText().equals(expectedTitle),
                "Task title does not match expected text!");
        return this;
    }

    public TodoMainPage tapEditTask(String taskTitle) {
        WebElement editNote = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + taskTitle + "']"
        ));
        click(editNote);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tomorrow Task']")
    public WebElement taskTitleField;

    public TodoMainPage verifyTaskPage() {
        waitForVisibility(taskTitleField);
        assertTrue(taskTitleField.isDisplayed(), "Task page is not open!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/edit_task")
    public WebElement editButton;

    public TodoMainPage tapEditButton() {
        editButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement editTaskMessageTitle;

    public TodoMainPage verifyEditTaskMessage() {
        waitForVisibility(editTaskMessageTitle);
        assertTrue(editTaskMessageTitle.isDisplayed(), "Edit Task message is not appear!");
        return this;
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement addTaskTitleField;

    public TodoMainPage addTaskTitle(String addTaskTitle) {
        addTaskTitleField.clear();
        addTaskTitleField.sendKeys(addTaskTitle);
        return this;
    }

    public TodoMainPage verifyTaskNotChanged(String expectedText) {
        sleep(1000);

        WebElement taskTitleAfterEdit = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Tomorrow Task']"
        ));

        waitForVisibility(taskTitleAfterEdit);

        String actualText = taskTitleAfterEdit.getText().trim();

        assertEquals(actualText, expectedText,
                "Expected task text '" + expectedText + "', but found '" + actualText + "'");
        return this;
    }

    @AndroidFindBy(id = "android:id/button1")
    public WebElement updateButton;

    public TodoMainPage tapUpdateButton() {
        click(updateButton);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tomorrow Task n1']")
    public WebElement taskTitleAfterEdit;

    public TodoMainPage verifyTaskTitleIsChanged() {
        String actualTitle = taskTitleAfterEdit.getText();
        Assert.assertEquals(actualTitle, "Tomorrow Task n1",
                "Task title did not change correctly!");
        System.out.println("Task title is now: " + actualTitle);
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/list_name")
    public WebElement taskField;

    public TodoMainPage addTask(String title) {
        taskField.clear();
        taskField.sendKeys(title);
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/list_name")
    public WebElement firstTaskField;

    public TodoMainPage addFirstTask(String title) {
        firstTaskField.clear();
        firstTaskField.sendKeys(title);
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/list_name")
    public WebElement secondTaskField;

    public TodoMainPage addSecondTask(String title) {
        secondTaskField.clear();
        secondTaskField.sendKeys(title);
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/add_button")
    public WebElement addNewTaskButton;

    public TodoMainPage tapAddNewTaskButton() {
        addNewTaskButton.click();
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='Eat']")
    public WebElement createdTaskInTaskList;

    public TodoMainPage verifyCreatedTaskInTaskList(String expectedTitle) {
        assertTrue(createdTaskInTaskList.isDisplayed(), "Created task is not visible!");
        assertTrue(createdTaskInTaskList.getText().equals(expectedTitle),
                "Task title does not match expected text!");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='1']")
    public WebElement createdFirstTaskInTaskList;

    public TodoMainPage verifyCreatedFirstTaskInTaskList(String expectedTitle) {
        assertTrue(createdFirstTaskInTaskList.isDisplayed(), "Created first task is not visible!");
        assertTrue(createdFirstTaskInTaskList.getText().equals(expectedTitle),
                "Task title does not match expected text!");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='2']")
    public WebElement createdSecondTaskInTaskList;

    public TodoMainPage verifyCreatedSecondTaskInTaskList(String expectedTitle) {
        assertTrue(createdSecondTaskInTaskList.isDisplayed(), "Created second task is not visible!");
        assertTrue(createdSecondTaskInTaskList.getText().equals(expectedTitle),
                "Task title does not match expected text!");
        return this;
    }

    @AndroidFindBy(id = "com.sanjay.udacity.todolist:id/title_notes")
    public List<WebElement> allTasksInList;

    public TodoMainPage verifyTaskListIsEmpty() {
        if (allTasksInList.isEmpty()) {
            System.out.println("Task list is empty!");
        } else {
            String existingTasks = allTasksInList.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.joining(", "));
            Assert.fail("Task list is not empty. Found tasks: " + existingTasks);
        }

        return this;
    }

    public TodoMainPage longClicksTask(String taskTitle) {
        WebElement noteToDelete = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + taskTitle + "']"
        ));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point location = noteToDelete.getLocation();
        Dimension size = noteToDelete.getSize();
        int centerX = location.getX() + size.getWidth() / 2;
        int centerY = location.getY() + size.getHeight() / 2;

        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(longPress));
        return this;
    }

    public TodoMainPage longClicksTaskInTask(String taskInTaskTitle) {
        WebElement noteToDelete = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.sanjay.udacity.todolist:id/title_notes' and @text='" + taskInTaskTitle + "']"
        ));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point location = noteToDelete.getLocation();
        Dimension size = noteToDelete.getSize();
        int centerX = location.getX() + size.getWidth() / 2;
        int centerY = location.getY() + size.getHeight() / 2;

        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(2)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(longPress));
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement deleteListMessageTitle;

    public TodoMainPage verifyDeleteListMessage() {
        waitForVisibility(deleteListMessageTitle);
        assertTrue(deleteListMessageTitle.isDisplayed(), "Delete List message is not appear!");
        return this;
    }

    public TodoMainPage verifyTaskInTaskDeleted(String taskInTaskTitle) {
        boolean noteStillExists = isNotePresent(taskInTaskTitle);
        assertFalse(noteStillExists, "The note '" + taskInTaskTitle + "' was not deleted!");
        return this;
    }

    public TodoMainPage verifyTaskDeleted(String taskTitle) {
        boolean noteStillExists = isNotePresent(taskTitle);
        assertFalse(noteStillExists, "The note '" + taskTitle + "' was not deleted!");
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
    public WebElement deleteTaskMessageTitle;

    public TodoMainPage verifyDeleteTaskMessage() {
        waitForVisibility(deleteTaskMessageTitle);
        assertTrue(deleteTaskMessageTitle.isDisplayed(), "Delete Task message is not appear!");
        return this;
    }



}
