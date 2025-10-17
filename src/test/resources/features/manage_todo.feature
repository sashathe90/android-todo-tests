Feature: Manage To-Do tasks
    # This feature file verifies that the user can manage notes and tasks — add, edit, delete, and validate error cases.

  Background:
    Given the app is launched

  @AddNote
    # Verify that the user can create a new note by entering a title and note text.
  Scenario: User adds a new note with title and notes
    Then verify NOTES page
    When user taps the ADD NOTES button
    Then ADD NOTES page is open
    When user taps the system BACK button
    Then user is redirected to the NOTES page
    When user taps the ADD NOTES button
    Then ADD NOTES page is open
    When user taps the BACK button
    Then user is redirected to the NOTES page
    When user taps the ADD NOTES button
    Then ADD NOTES page is open
    When user taps the MORE OPTIONS button
    And user taps the DISCARD button
    Then user is redirected to the NOTES page
    When user taps the ADD NOTES button
    Then ADD NOTES page is open
    When user enters a title in the ENTER TITLE HERE field
    And user enters text in the TAKE NOTES field
    And user taps the SAVE button
    Then user is redirected to the NOTES page
    And user sees the newly created note in the list

  @EditNote
    # Verify that the user can edit an existing note, save changes, and see them reflected in the note list.
  Scenario: User add text to the title in notes
    Then verify NOTES page
    When user taps on the NOTE to edit
    Then NOTE to edit is open
    When user add text to the title in the ENTER TITLE HERE field
    And user taps the system BACK button
    And user is redirected to the NOTES page
    And user taps on the NOTE to edit
    And NOTE to edit is open
    Then user sees that chosen NOTE is not change
    When user add text to the title in the ENTER TITLE HERE field
    And user taps the BACK button
    And user is redirected to the NOTES page
    And user taps on the NOTE to edit
    And NOTE to edit is open
    Then user sees that chosen NOTE is not change
    When user add text to the title in the ENTER TITLE HERE field
    And user taps the MORE OPTIONS button
    And user taps the DISCARD button
    And user is redirected to the NOTES page
    And user taps on the NOTE to edit
    And NOTE to edit is open
    Then user sees that chosen NOTE is not change
    When user add text to the title in the ENTER TITLE HERE field
    And user taps the SAVE button
    And user is redirected to the NOTES page
    Then user sees on NOTES page that chosen NOTE is changed
    When user taps on the already edit NOTE
    And NOTE to edit is open
    Then user sees on NOTE to edit page that chosen NOTE is changed to "Buy one milk"
    And user taps the system BACK button
    And user is redirected to the NOTES page

  @EmptyNote
    # Validate that the app shows an error message when the user tries to create an empty note.
  Scenario: User tries to create an empty note
    Then verify NOTES page
    When user taps the ADD NOTES button
    Then ADD NOTES page is open
    And user taps the SAVE button
    Then error message is displayed

  @DeleteNote
    # Verify that the user can delete an existing note through the confirmation dialog.
  Scenario: User deletes a note
    Then verify NOTES page
    When user long clicks on the NOTE to delete
    Then DO YOU DELETE THIS NOTE message appears
    When user taps NOPE button
    Then user is redirected to the NOTES page
    When user long clicks on the NOTE to delete
    Then DO YOU DELETE THIS NOTE message appears
    When user taps DELETE NOW button
    Then the selected NOTE is deleted
    And user is redirected to the NOTES page

  @AddTask
    # Verify that the user can add a new task with a task name.
  Scenario: User adds a new task with task name
    Then verify NOTES page
    When user taps the TASKS button
    Then TASKS page is open
    When user taps the ADD TASK button
    Then ADD NEW TASK popup appears
    When user taps the system BACK button
    Then user is redirected to the TASKS page
    When user taps the ADD TASK button
    Then ADD NEW TASK popup appears
    When user taps outside the popup
    Then user is redirected to the TASKS page
    When user taps the ADD TASK button
    Then ADD NEW TASK popup appears
    When user enters a task name in the ENTER TASK NAME HERE field
    And user taps the ADD NEW button
    Then user is redirected to the TASKS page
    And user sees the newly created TASK in the list

  @AddTaskInTask
    # Verify that the user can add sub-tasks within an existing task.
  Scenario: User adds a new task in task
    Then TASKS page is open
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user add a task in the ADD YOR TASKS field
    And user taps the system BACK button
    Then user is redirected to the TASKS page
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user add a task in the ADD YOR TASKS field
    And user taps the BACK button
    Then user is redirected to the TASKS page
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user add a task in the ADD YOR TASKS field
    And user taps the ADD NEW TASK button
    Then user sees the newly created TASK in the task list
    When user taps the BACK button

  @DeleteTaskInTask
    # Verify that the user can delete a sub-task from an existing task through confirmation dialog.
  Scenario: User deletes a task in task
    Then TASKS page is open
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user long clicks on the TASK IN TASK to delete
    Then DO YOU DELETE THIS LIST message appears
    When user taps NOPE button
    Then TASK to edit is open
    When user long clicks on the TASK IN TASK to delete
    Then DO YOU DELETE THIS LIST message appears
    When user taps DELETE NOW button
    Then the selected TASK IN TASK is deleted
    And TASK to edit is open
    When user taps the BACK button

  @DeleteAllTasksInTask
    # Verify that the user can delete all sub-tasks at once using the DELETE ALL option.
  Scenario: User deletes all tasks in task
    Then TASKS page is open
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user add first task in the ADD YOR TASKS field
    And user taps the ADD NEW TASK button
    Then user sees the newly created first TASK in the task list
    When user add second task in the ADD YOR TASKS field
    And user taps the ADD NEW TASK button
    Then user sees the newly created second TASK in the task list
    When user taps the MORE OPTIONS button
    And user taps the DELETE ALL button
    Then user sees that the task list is empty
    When user taps the BACK button

  @EditTask
    # Verify that the user can edit the task name, save updates, and see the change reflected.
  Scenario: User edit task name text in the task
    Then TASKS page is open
    When user taps on the TASK to edit
    Then TASK to edit is open
    When user taps the EDIT button
    Then EDIT TASK message appears
    When user edit task name text in the EDIT TASK field
    And user taps the system BACK button
    And TASK to edit is open
    Then user sees that chosen TASK is not change
    When user taps the EDIT button
    Then EDIT TASK message appears
    When user edit task name text in the EDIT TASK field
    And user taps outside the popup
    And TASK to edit is open
    Then user sees that chosen TASK is not change
    When user taps the EDIT button
    Then EDIT TASK message appears
    When user edit task name text in the EDIT TASK field
    And user taps UPDATE button
    Then user sees that task title is changed
    When user taps the BACK button

  @EmptyTask
    # Validate that the app shows an error message when the user tries to create an empty task.
  Scenario: User tries to create an empty task
    Then TASKS page is open
    When user taps the ADD TASK button
    Then ADD NEW TASK popup appears
    And user taps the ADD NEW button
    Then error message is displayed

  @DeleteTask
    # Verify that the user can delete a task through confirmation dialog and that it disappears from the list.
  Scenario: User deletes a task
    Then TASKS page is open
    When user long clicks on the TASK to delete
    Then DO YOU DELETE THIS TASK message appears
    When user taps NOPE button
    Then TASKS page is open
    When user long clicks on the TASK to delete
    Then DO YOU DELETE THIS TASK message appears
    When user taps DELETE NOW button
    Then the selected TASK is deleted
    And TASKS page is open






