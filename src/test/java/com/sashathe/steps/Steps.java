package com.sashathe.steps;

import com.sashathe.hooks.Hooks;
import com.sashathe.pages.TodoMainPage;
import io.cucumber.java.en.*;

public class Steps {

    private TodoMainPage page;

    @Given("the app is launched")
    public void the_app_is_launched() {
        page = new TodoMainPage((io.appium.java_client.android.AndroidDriver) Hooks.driver);
    }

    @Then("^verify NOTES page$")
    public void verify_NOTES_page() {
        page.verifyNotesPage();
    }

    @When("^user taps the ADD NOTES button$")
    public void user_taps_the_ADD_NOTES_button() {
        page.tapAddNotesButton();
    }

    @Then("^ADD NOTES page is open$")
    public void ADD_NOTES_page_is_open() {
        page.verifyAddNotesPage();
    }

    @When("^user enters a title in the ENTER TITLE HERE field$")
    public void user_enters_a_title_in_the_enter_title_here_field() {
        page.enterTitle("Buy milk");
    }

    @And("^user enters text in the TAKE NOTES field$")
    public void user_enters_text_in_the_take_notes_field() {
        page.enterNoteText("2 liters of milk");
    }

    @And("^user taps the SAVE button$")
    public void user_taps_the_save_button() {
        page.tapSaveButton();
    }

    @And("^user taps the BACK button$")
    public void user_taps_the_back_button() {
        page.tapBackButton();
    }

    @And("^user taps the MORE OPTIONS button$")
    public void user_taps_the_more_options_button() {
        page.tapMoreOptionsButton();
    }

    @And("^user taps the DISCARD button$")
    public void user_taps_the_discard_button() {
        page.tapDiscardButton();
    }

    @And("^user taps the DELETE ALL button$")
    public void user_taps_the_DELETE_ALL_button() {
        page.tapDeleteAllButton();
    }

    @Then("^user is redirected to the NOTES page$")
    public void user_is_redirected_to_the_notes_page() {
        page.verifyNotesPage();
    }

    @And("^user sees the newly created note in the list$")
    public void user_sees_the_newly_created_note_in_the_list() {
        page.verifyCreatedNoteVisible("Buy milk");
    }

    @When("^user taps on the NOTE to edit$")
    public void user_taps_on_the_NOTE_to_edit() {
        page.tapEditNote("Buy milk");
    }

    @When("^user taps on the already edit NOTE$")
    public void user_taps_on_the_already_edit_NOTE() {
        page.tapAlreadyEditNote("Buy one milk");
    }

    @Then("^NOTE to edit is open$")
    public void NOTE_to_edit_is_open() {
        page.verifyNotePage();
    }

    @When("^user add text to the title in the ENTER TITLE HERE field$")
    public void user_add_text_to_the_title_in_the_enter_title_here_field() {
        page.addTitle("Buy one milk");
    }

    @Then("^user sees that chosen NOTE is not change$")
    public void user_sees_that_chosen_NOTE_is_not_change() {
        page.verifyNoteNotChanged("Buy milk");
    }

    @Then("^user sees on NOTES page that chosen NOTE is changed$")
    public void user_sees_on_NOTES_page_that_chosen_NOTE_is_changed() {
        page.verifyNoteChangedOnNotesPage("Buy one milk");
    }

    @Then("^user sees on NOTE to edit page that chosen NOTE is changed to \"([^\"]*)\"$")
    public void user_sees_on_NOTE_to_edit_page_that_chosen_NOTE_is_changed_to(String expectedText) {
        page.verifyNoteChangedOnNoteToEditPage(expectedText);
    }

    @Then("^error message is displayed$")
    public void error_message_is_displayed() {
        page.verifyErrorMessage();
    }

    @When("^user long clicks on the NOTE to delete$")
    public void user_long_clicks_on_the_note_to_delete() {
        page.longClicksNote("Buy one milk");
    }

    @Then("^DO YOU DELETE THIS NOTE message appears$")
    public void do_you_delete_this_note_message_appears() {
        page.verifyDeleteNoteMessage();
    }

    @When("^user taps NOPE button$")
    public void user_taps_nope_button() {
        page.tapNopeButton();
    }

    @When("^user taps DELETE NOW button$")
    public void user_taps_delete_now_button() {
        page.tapDeleteButton();
    }

    @Then("^the selected NOTE is deleted$")
    public void the_selected_NOTE_is_deleted() {
        page.verifyNoteDeleted("Buy milk");
    }

    @When("^user taps the TASKS button$")
    public void user_taps_the_TASKS_button() {
        page.tapTasksButton();
    }

    @Then("^TASKS page is open$")
    public void TASKS_page_is_open() {
        page.verifyTasksPage();
    }

    @When("^user taps the ADD TASK button$")
    public void user_taps_the_ADD_TASK_button() {
        page.tapAddTaskButton();
    }

    @Then("^ADD NEW TASK popup appears$")
    public void ADD_NEW_TASK_popup_appears() {
        page.verifyAddTaskPopup();
    }

    @And("^user taps the system BACK button$")
    public void user_taps_the_system_back_button() {
        page.tapSystemBackButton();
    }

    @Then("^user is redirected to the TASKS page$")
    public void user_is_redirected_to_the_tasks_page() {
        page.verifyTasksPage();
    }

    @When("^user taps outside the popup$")
    public void user_taps_outside_the_popup() {
        page.tapOutsidePopup();
    }

    @When("^user enters a task name in the ENTER TASK NAME HERE field$")
    public void user_enters_a_task_name_in_the_ENTER_TASK_NAME_HERE_field() {
        page.enterTaskName("Tomorrow Task");
    }

    @And("^user taps the ADD NEW button$")
    public void user_taps_the_ADD_NEW_button() {
        page.tapAddNewButton();
    }

    @And("^user sees the newly created TASK in the list$")
    public void user_sees_the_newly_created_TASK_in_the_list() {
        page.verifyCreatedTaskVisible("Tomorrow Task");
    }

    @When("^user taps on the TASK to edit$")
    public void user_taps_on_the_TASK_to_edit() {
        page.tapEditTask("Tomorrow Task");
    }

    @Then("^TASK to edit is open$")
    public void TASK_to_edit_is_open() {
        page.verifyTaskPage();
    }

    @When("^user taps the EDIT button$")
    public void user_taps_the_EDIT_button() {
        page.tapEditButton();
    }

    @Then("^EDIT TASK message appears$")
    public void EDIT_TASK_this_note_message_appears() {
        page.verifyEditTaskMessage();
    }

    @When("^user edit task name text in the EDIT TASK field$")
    public void user_edit_task_name_text_in_the_EDIT_TASK_field() {
        page.addTaskTitle("Tomorrow Task n1");
    }

    @Then("^user sees that chosen TASK is not change$")
    public void user_sees_that_chosen_TASK_is_not_change() {
        page.verifyTaskNotChanged("Tomorrow Task");
    }

    @And("^user taps UPDATE button$")
    public void user_taps_UPDATE_button() {
        page.tapUpdateButton();
    }

    @Then("user sees that task title is changed")
    public void user_sees_that_task_title_is_changed() {
        page.verifyTaskTitleIsChanged();
    }

    @When("^user add a task in the ADD YOR TASKS field$")
    public void user_add_a_task_in_the_ADD_YOR_TASKS_field() {
        page.addTask("Eat");
    }

    @When("^user add first task in the ADD YOR TASKS field$")
    public void user_add_first_task_in_the_ADD_YOR_TASKS_field() {
        page.addFirstTask("1");
    }

    @When("^user add second task in the ADD YOR TASKS field$")
    public void user_add_second_task_in_the_ADD_YOR_TASKS_field() {
        page.addSecondTask("2");
    }

    @And("^user taps the ADD NEW TASK button$")
    public void user_taps_the_ADD_NEW_TASK_button() {
        page.tapAddNewTaskButton();
    }

    @And("^user sees the newly created TASK in the task list$")
    public void user_sees_the_newly_created_TASK_in_the_task_list() {
        page.verifyCreatedTaskInTaskList("Eat");
    }

    @And("^user sees the newly created first TASK in the task list$")
    public void user_sees_the_newly_created_first_TASK_in_the_task_list() {
        page.verifyCreatedFirstTaskInTaskList("1");
    }

    @And("^user sees the newly created second TASK in the task list$")
    public void user_sees_the_newly_created_second_TASK_in_the_task_list() {
        page.verifyCreatedSecondTaskInTaskList("2");
    }

    @Then("^user sees that the task list is empty$")
    public void user_sees_that_the_task_list_is_empty() {
        page.verifyTaskListIsEmpty();
    }

    @When("^user long clicks on the TASK to delete$")
    public void user_long_clicks_on_the_TASK_to_delete() {
        page.longClicksTask("Tomorrow Task n1");
    }

    @When("^user long clicks on the TASK IN TASK to delete$")
    public void user_long_clicks_on_the_TASK_IN_TASK_to_delete() {
        page.longClicksTaskInTask("Eat");
    }

    @Then("^DO YOU DELETE THIS LIST message appears$")
    public void do_you_delete_this_LIST_message_appears() {
        page.verifyDeleteListMessage();
    }

    @Then("^the selected TASK IN TASK is deleted$")
    public void the_selected_TASK_IN_TASK_is_deleted() {
        page.verifyTaskInTaskDeleted("Eat");
    }

    @Then("^the selected TASK is deleted$")
    public void the_selected_TASK_is_deleted() {
        page.verifyTaskDeleted("Tomorrow Task n1");
    }

    @Then("^DO YOU DELETE THIS TASK message appears$")
    public void do_you_delete_this_TASK_message_appears() {
        page.verifyDeleteTaskMessage();
    }




}



